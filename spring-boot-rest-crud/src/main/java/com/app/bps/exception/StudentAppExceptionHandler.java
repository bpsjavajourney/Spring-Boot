package com.app.bps.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.app.bps.model.ErrorResponse;

/**
 * StudentAppExceptionHandler
 * 
 * @author bpsaradi
 *
 */
@ControllerAdvice
public class StudentAppExceptionHandler {
	
	private final Logger logger=LoggerFactory.getLogger(StudentAppExceptionHandler.class);

	@ExceptionHandler(StudentAppException.class)
	public ResponseEntity<ErrorResponse> recordNotFound(StudentAppException e) {
		logger.info("In StudentAppExceptionHandler--recordNotFound:"+e);
		
		return new ResponseEntity<ErrorResponse>(
				ErrorResponse.builder().errorMessage(e.getMessage()).errorCode(e.getErrorCode()).build(),
				HttpStatus.NOT_FOUND);
	}

}
