package com.test.tringle.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author Jagasan
 * @createdOn 1-Aug-2020
 */
@Component
public class PropertiesConfig {

	@Value("${forex.access.key}")
	private String forextAccesskey;
	@Value("${forex.url}")
	private String forexUrl;
	@Value("${forex.base}")
	private String forexBase;

	public String getForextAccesskey() {
		return forextAccesskey;
	}

	public void setForextAccesskey(String forextAccesskey) {
		this.forextAccesskey = forextAccesskey;
	}

	public String getForexUrl() {
		return forexUrl;
	}

	public void setForexUrl(String forexUrl) {
		this.forexUrl = forexUrl;
	}

	public String getForexBase() {
		return forexBase;
	}

	public void setForexBase(String forexBase) {
		this.forexBase = forexBase;
	}

}
