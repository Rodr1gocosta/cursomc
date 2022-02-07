package com.rodrigocosta.cursojava1.resources.exception;

import java.io.Serializable;

public class FieldMessage implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private String fielname;
	private String message;

	public FieldMessage() {
	}

	public FieldMessage(String fielname, String message) {
		super();
		this.fielname = fielname;
		this.message = message;
	}

	public String getFielname() {
		return fielname;
	}

	public void setFielname(String fielname) {
		this.fielname = fielname;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	
}
