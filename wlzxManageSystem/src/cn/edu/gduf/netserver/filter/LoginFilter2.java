package cn.edu.gduf.netserver.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginFilter2 implements Filter   { 
	
	public void init(FilterConfig filterConfig) throws ServletException{
		
	}  

	public void doFilter(ServletRequest request, ServletResponse response, 
                                          FilterChain chain) throws IOException, ServletException{  
	    HttpServletRequest req = (HttpServletRequest) request;  
	    HttpServletResponse res = (HttpServletResponse) response;  
	    String url = req.getRequestURI();
	    //如果当前页面是登录页面，不进行跳转
	    if(url.indexOf("login.jsp")>=0){
	    	chain.doFilter(request,response);
	    }else{
	    	HttpSession session = req.getSession(true);
		    //从session里取的用户名信息  
		    String username = (String) session.getAttribute("userName"); 
		    //判断如果没有取到用户信息,就跳转到登陆页面  
		    if(username == null || "".equals(username)){  
		        //跳转到登陆页面  
		        res.sendRedirect("login.jsp");  
		    }  
		    else{  
		        //已经登陆,继续此次请求  
		        chain.doFilter(request,response);  
		    }  
	    }
	    
	}  

	public void destroy() {
		
	}   
}
