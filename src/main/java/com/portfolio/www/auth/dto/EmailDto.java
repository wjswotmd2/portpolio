package com.portfolio.www.auth.dto;

import org.apache.ibatis.type.Alias;

@Alias("EmailDto")
public class EmailDto {
	
	private String from;
	private String receiver;
	private String text;
	private String subject;
	  
	public String getFrom() {
		return from;
	}
	public void setFrom(String from) {
		this.from = from;
	}
	public String getReceiver() {
		return receiver;
	}
	public void setReceiver(String receiver) {
		this.receiver = receiver;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
}