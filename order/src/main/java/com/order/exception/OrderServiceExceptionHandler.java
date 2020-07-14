package com.order.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.netflix.hystrix.exception.HystrixRuntimeException;

@ControllerAdvice
public class OrderServiceExceptionHandler {

	/*Exception has to enter this block*/
	@ExceptionHandler(ProductNotFoundException.class)
    public @ResponseBody ResponseEntity<ErrorDetails> invalidRequestException(ProductNotFoundException ex) {
		ErrorDetails errorDetails = new ErrorDetails(ex.getErrorMessage(), ex.getErrorCode());
        return new ResponseEntity<>(errorDetails, HttpStatus.EXPECTATION_FAILED);
    }
	
	/*Should not enter this block*/
//	@ExceptionHandler(HystrixRuntimeException.class)
//    public @ResponseBody ResponseEntity<String> hystrix(HystrixRuntimeException ex) {
//        return new ResponseEntity<>("Hystrix bloc", HttpStatus.CONFLICT);
//    }
}
