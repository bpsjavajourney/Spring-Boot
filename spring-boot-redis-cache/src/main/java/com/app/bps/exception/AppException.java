package com.app.bps.exception;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * AppException is a application level exception
 * 
 * @author parth
 *
 */
@Getter
@Setter
@NoArgsConstructor
public class AppException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;
	
	private String errorCode;

	public AppException(String errorMessage, String errorCode) {
		super(errorMessage);
		this.errorCode = errorCode;
		
	}

}
