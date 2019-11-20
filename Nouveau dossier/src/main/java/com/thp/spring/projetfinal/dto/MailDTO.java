package com.thp.spring.projetfinal.dto;

import java.util.Arrays;

import org.springframework.mail.SimpleMailMessage;

public class MailDTO extends SimpleMailMessage {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String from;

	private String[] to;

	private String subject;

	private String text;

	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	
	public String[] getTo() {
		return to;
	}

	public void setTo(String[] to) {
		this.to = to;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public MailDTO(String from, String[] to, String subject, String text) {
		super();
		this.from = from;
		this.to = to;
		this.subject = subject;
		this.text = text;
	}

	public MailDTO(String[] to, String subject, String text) {
		super();
		this.to = to;
		this.subject = subject;
		this.text = text;
	}

	public MailDTO() {
		super();
	}

	@Override
	public String toString() {
		return "MailDTO [from=" + from + ", to=" + Arrays.toString(to) + ", subject=" + subject + ", text=" + text
				+ "]";
	}


	
	
	

}
