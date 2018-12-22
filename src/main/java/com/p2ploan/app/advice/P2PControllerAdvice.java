package com.p2ploan.app.advice;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import com.p2ploan.app.model.P2PExceptionResponse;

@ControllerAdvice
public class P2PControllerAdvice {

	public static final Logger LOG=LogManager.getLogger(P2PControllerAdvice.class);
	
	
	
	@ExceptionHandler({ Exception.class })
    public ResponseEntity<Object> handleAccessDeniedException(
      Exception ex, WebRequest request) {
		
		P2PExceptionResponse errorResponse = new P2PExceptionResponse();
		
		errorResponse.setErrorCode("100001");
		errorResponse.setErrorMessage("unable to process request");
		errorResponse.setErrorDescription(ex.getLocalizedMessage());
		
        return new ResponseEntity<Object>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }
	
	
}
