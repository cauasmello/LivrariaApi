package com.serratec.livraria.exception;

public class ListaNotException extends Exception{

private String message;
	
	public ListaNotException(String message) {
		super();
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
