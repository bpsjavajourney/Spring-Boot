package com.app.bps.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.app.bps.model.ErrorResponse;

/**
 * AppExceptionHandler
 * 
 * @author bpsaradi
 *
 */
@ControllerAdvice
public class AppExceptionHandler {
	
	private final Logger logger=LoggerFactory.getLogger(AppExceptionHandler.class);

	@ExceptionHandler(AppException.class)
	public ResponseEntity<ErrorResponse> recordNotFound(AppException e) {
		logger.info("In AppExceptionHandler--recordNotFound:"+e);
		
		return new ResponseEntity<ErrorResponse>(
				ErrorResponse.builder().errorMessage(e.getMessage()).errorCode(e.getErrorCode()).build(),
				HttpStatus.NOT_FOUND);
	}

}
