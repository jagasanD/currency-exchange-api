package com.test.tringle.bean;

import org.springframework.stereotype.Component;

/**
 * @author Jagasan
 * @createdOn 1-Aug-2020
 */

@Component
public class ExchangeBean {

	private String from;
	private String to;
	private Double amount;

	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

}
