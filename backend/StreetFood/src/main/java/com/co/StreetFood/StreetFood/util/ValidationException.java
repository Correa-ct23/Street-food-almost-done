package com.co.StreetFood.StreetFood.util;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.CONFLICT)
public class ValidationException extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 3849399812086320904L;

	public ValidationException(String mensaje) {
        super(mensaje);
    }
}
