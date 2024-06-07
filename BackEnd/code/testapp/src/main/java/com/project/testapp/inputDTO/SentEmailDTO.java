package com.project.testapp.inputDTO;

public class SentEmailDTO {
	
	private String recepientEmail;
	private String emailContent;
	
	// constructor 
	
	public SentEmailDTO(String recepientEmail, String emailContent) {
		super();
		this.recepientEmail = recepientEmail;
		this.emailContent = emailContent;
	}
	
	// getters and setters

	public String getRecepientEmail() {
		return recepientEmail;
	}

	public void setRecepientEmail(String recepientEmail) {
		this.recepientEmail = recepientEmail;
	}

	public String getEmailContent() {
		return emailContent;
	}

	public void setEmailContent(String emailContent) {
		this.emailContent = emailContent;
	}
	
}
