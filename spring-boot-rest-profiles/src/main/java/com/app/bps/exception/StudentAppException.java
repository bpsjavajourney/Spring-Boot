package com.app.bps.exception;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * StudentAppException is a application level exception
 * 
 * @author parth
 *
 */
@Getter
@Setter
@NoArgsConstructor
public class StudentAppException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;
	
	private String errorCode;

	public StudentAppException(String errorMessage, String errorCode) {
		super(errorMessage);
		this.errorCode = errorCode;
		
	}

}
