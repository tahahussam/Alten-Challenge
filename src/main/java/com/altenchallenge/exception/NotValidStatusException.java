package com.altenchallenge.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class NotValidStatusException extends Exception {

	private static final long serialVersionUID = 3323604126476148872L;

	public NotValidStatusException() {
		super();
	}

	public NotValidStatusException(String message, Throwable cause) {
		super(message, cause);
	}

	public NotValidStatusException(String message) {
		super(message);
	}

	public NotValidStatusException(Throwable cause) {
		super(cause);
	}
}