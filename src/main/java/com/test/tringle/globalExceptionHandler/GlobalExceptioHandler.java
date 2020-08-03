
package com.test.tringle.globalExceptionHandler;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.test.tringle.bean.GenericResponse;

/**
 * @author Jagasan
 * @createdOn 1-Aug-2020
 */
@ControllerAdvice
public class GlobalExceptioHandler {

	@ResponseStatus(value = HttpStatus.BAD_REQUEST)
	@ExceptionHandler(IllegalArgumentException.class)
	public GenericResponse IllegalArgumentExceptionHandler(IllegalArgumentException ex) {
		return new GenericResponse(ex.getMessage(), HttpStatus.BAD_REQUEST.toString());

	}

	@ResponseStatus(value = HttpStatus.CONFLICT)
	@ExceptionHandler(Exception.class)
	public GenericResponse exceptionHandler(Exception ex) {
		ex.printStackTrace();
		return new GenericResponse(ex.getMessage(), HttpStatus.CONFLICT.toString());

	}

}
