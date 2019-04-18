package com.altenchallenge.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class NotValidCustomerException extends Exception {

	private static final long serialVersionUID = 3323604126476148872L;

	public NotValidCustomerException() {
		super();
	}

	public NotValidCustomerException(String message, Throwable cause) {
		super(message, cause);
	}

	public NotValidCustomerException(String message) {
		super(message);
	}

	public NotValidCustomerException(Throwable cause) {
		super(cause);
	}
}