package com.test.tringle.bean;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * @author Jagasan
 * @createdOn 1-Aug-2020
 */
@JsonInclude(Include.NON_NULL)
public class GenericResponse {

	public Object payLoad;
	public String statusCode;
	public String message;

	public GenericResponse(String message) {
		this.message = message;

	}

	public GenericResponse(Object payLoad) {
		this.payLoad = payLoad;

	}

	public GenericResponse(Object payLoad, String message) {
		this.payLoad = payLoad;
		this.message = message;
	}

	public GenericResponse(String message, String statusCode) {
		this.message = message;
		this.statusCode = statusCode;

	}

	public GenericResponse(Object payLoad, String statusCode, String message) {
		this.payLoad = payLoad;
		this.message = message;
		this.statusCode = statusCode;
	}

}
