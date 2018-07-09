package com.anacleto.socialbooks.model;

public class ErrorDetail {

	private String title;
	private Long status;
	private Long timestanp;
	private String developerMessage;
	
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public Long getStatus() {
		return status;
	}
	
	public void setStatus(Long status) {
		this.status = status;
	}
	
	public Long getTimestanp() {
		return timestanp;
	}
	
	public void setTimestanp(Long timestanp) {
		this.timestanp = timestanp;
	}
	
	public String getDeveloperMessage() {
		return developerMessage;
	}
	
	public void setDeveloperMessage(String developerMessage) {
		this.developerMessage = developerMessage;
	}
}
