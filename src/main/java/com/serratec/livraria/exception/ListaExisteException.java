package com.serratec.livraria.exception;

public class ListaExisteException extends Exception {

private String message;
	
	public ListaExisteException(String message) {
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
