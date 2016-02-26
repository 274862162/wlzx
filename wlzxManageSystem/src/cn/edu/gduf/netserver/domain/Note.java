package cn.edu.gduf.netserver.domain;

import java.util.Date;
/**
 * 值班记事
 * @author cjy
 *
 */
public class Note {
	private int noteID;//ID
	private String fillTime;//填写时间
	private String recorder;//记录人
	private String handler; //处理人
	private String content;//内容
	private boolean status;//处理状态
	private String dealingTime;//处理时间
	private String dealingContent;//处理说明
	private String reserved1;
	private String reserved2;
	public int getNoteID() {
		return noteID;
	}
	public void setNoteID(int noteID) {
		this.noteID = noteID;
	}
	public String getFillTime() {
		return fillTime;
	}
	public void setFillTime(String fillTime) {
		this.fillTime = fillTime;
	}
	public String getRecorder() {
		return recorder;
	}
	public void setRecorder(String recorder) {
		this.recorder = recorder;
	}
	
	public String getHandler() {
		return handler;
	}
	public void setHandler(String handler) {
		this.handler = handler;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	public String getDealingTime() {
		return dealingTime;
	}
	public void setDealingTime(String dealingTime) {
		this.dealingTime = dealingTime;
	}
	
	public String getDealingContent() {
		return dealingContent;
	}
	public void setDealingContent(String dealingContent) {
		this.dealingContent = dealingContent;
	}
	public String getReserved1() {
		return reserved1;
	}
	public void setReserved1(String reserved1) {
		this.reserved1 = reserved1;
	}
	public String getReserved2() {
		return reserved2;
	}
	public void setReserved2(String reserved2) {
		this.reserved2 = reserved2;
	}
	
}
