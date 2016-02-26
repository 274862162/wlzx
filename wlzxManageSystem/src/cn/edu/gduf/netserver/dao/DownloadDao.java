package cn.edu.gduf.netserver.dao;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.http.HttpServletResponse;

import cn.edu.gduf.netserver.util.DbUtil;

public class DownloadDao {
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	StringBuffer sql;
	
	public String getPath(int fileID){
		String path = "";
		sql= new StringBuffer("SELECT path FROM material WHERE id=?");
		try{
			conn = DbUtil.getCon();
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setInt(1,fileID);
			rs = pstmt.executeQuery();
			while(rs.next()){
				path=rs.getString("path");
			}
			
		}catch(SQLException e){
			e.printStackTrace();
		}
		return path;
	}
	public String getFileName(int fileID){
		String fileName = "";
		sql= new StringBuffer("SELECT fileName FROM material WHERE id=?");
		try{
			conn = DbUtil.getCon();
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setInt(1,fileID);
			rs = pstmt.executeQuery();
			while(rs.next()){
				fileName=rs.getString("fileName");
			}
			rs.close();
			pstmt.close();
			conn.close();
		}catch(SQLException e){
			e.printStackTrace();
		}
		return fileName;
	}
	public String download(HttpServletResponse response,String fileName,String path){
		String message = "";
		try{
			File file=new File(path);//创建要下载的文件   
	        if(file.exists()){
	            InputStream ins=new FileInputStream(path);//创建读取文件的IO流对象
	            BufferedInputStream bins=new BufferedInputStream(ins);//放到缓冲流里面
	            OutputStream outs=response.getOutputStream();//获取文件输出IO流
	            BufferedOutputStream bouts=new BufferedOutputStream(outs);
	            response.setContentType("application/octet-stream");//设置response内容的类型
	            response.setHeader("Content-disposition","attachment;filename="+new String(fileName.replaceAll(" ", "").getBytes("utf-8"),"iso8859-1"));//设置头部信息
	            int bytesRead = 0;
	            byte[] buffer = new byte[8192];
	            //开始向网络传输文件流
	            while ((bytesRead = bins.read(buffer, 0, 8192)) != -1) {
	                bouts.write(buffer, 0, bytesRead);
	            }
	            bouts.flush();
	            ins.close();
	            bins.close();
	            outs.close();
	            bouts.close();
	            message = "上传成功";
	        }else{
	        	message = "下载文件不存在";
	            System.out.println("下载的文件不存在");
	        }
		}catch(IOException e){
			message = "下载失败";
			e.printStackTrace();
		}
		return message;
	}
}
