package br.com.playlist.error;

import java.util.ArrayList;

public class Error {
	private String message;
	private String domain;
	private String reason;
	public Error(String message, String domain, String reason) {
		super();
		this.message = message;
		this.domain = domain;
		this.reason = reason;
	}
	
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getDomain() {
		return domain;
	}
	public void setDomain(String domain) {
		this.domain = domain;
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	
	
}
