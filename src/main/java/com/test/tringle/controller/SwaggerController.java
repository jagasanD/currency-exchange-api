package com.test.tringle.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import springfox.documentation.annotations.ApiIgnore;

/**
 * @author Jagasan
 * @createdOn 1-Aug-2020
 */
@Controller
@ApiIgnore
public class SwaggerController {

	@GetMapping("/forex")
	public String getSwaggerApi() {
		return "redirect:/swagger-ui.html";
	}

}
