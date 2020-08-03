package com.test.tringle.service;

import com.fasterxml.jackson.core.JsonProcessingException;

import com.fasterxml.jackson.databind.JsonMappingException;
import com.test.tringle.bean.GenericResponse;

/**
 * @author Jagasan
 * @createdOn 1-Aug-2020
 */
public interface ForexService {

	GenericResponse saveForexData(String response) throws JsonMappingException, JsonProcessingException;

	GenericResponse exchangeCurrency(String from, String to, Double amount);

}
