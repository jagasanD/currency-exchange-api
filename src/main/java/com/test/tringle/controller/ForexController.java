package com.test.tringle.controller;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.test.tringle.bean.GenericResponse;
import com.test.tringle.config.PropertiesConfig;
import com.test.tringle.service.ForexService;

import io.swagger.annotations.Api;
/**
 * @author Jagasan
 * @createdOn 1-Aug-2020
 */

@RestController
@Api(value = "Forex Controller", description = " call the forex api and exchange the currency")
public class ForexController {

	@Autowired
	RestTemplate restTemplate;
	@Autowired
	PropertiesConfig propertiesConfig;
	@Autowired
	ForexService forexService;

	@GetMapping("/call-forex-api")
	public GenericResponse callForexApi() throws JsonMappingException, JsonProcessingException {

		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<String> entity = new HttpEntity<String>(headers);
		String url = propertiesConfig.getForexUrl() + "access_key=" + propertiesConfig.getForextAccesskey();
		String response = restTemplate.exchange(url, HttpMethod.GET, entity, String.class).getBody();
		return forexService.saveForexData(response);

	}
	/**
	 * @pathVariable from
	 * @pathVariable to mandatory
	 * @pathVariable amount mandatory
	 * 
	 */

	@GetMapping("/exchange-currency/{from}/{to}/{amount}")
	public GenericResponse exchangeCurrency(@PathVariable String from, @PathVariable String to,
			@PathVariable Double amount) throws RuntimeException {
		return forexService.exchangeCurrency(from, to, amount);

	}

}
