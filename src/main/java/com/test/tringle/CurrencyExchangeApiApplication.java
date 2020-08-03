package com.test.tringle;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import com.test.tringle.entity.Rate;
import com.test.tringle.repository.RateRepository;

/**
 * @author Jagasan
 * @createdOn 1-Aug-2020
 */

@SpringBootApplication
public class CurrencyExchangeApiApplication implements CommandLineRunner {

	@Autowired
	RateRepository rateRepository;

	public static void main(String[] args) {
		SpringApplication.run(CurrencyExchangeApiApplication.class, args);
	}

	@Bean
	RestTemplate restTemplate() {
		return new RestTemplate();

	}

	public void run(String... args) throws Exception {

		saveDummyRate();

	}

	private void saveDummyRate() {
		Rate r1 = null;
		r1 = rateRepository.findByCurrencyCode("INR1");
		if (r1 == null)
			r1 = new Rate();
		r1.setCurrencyCode("INR1");
		r1.setValue(12.3456d);
		rateRepository.save(r1);

		Rate r2 = null;
		r2 = rateRepository.findByCurrencyCode("IRR1");
		if (r2 == null)
			r2 = new Rate();
		r2.setCurrencyCode("IRR1");
		r2.setValue(23.3456d);
		rateRepository.save(r2);

		Rate r3 = null;
		r3 = rateRepository.findByCurrencyCode("IMM1");
		if (r3 == null)
			r3 = new Rate();
		r3.setCurrencyCode("IMM1");
		r3.setValue(88.3456d);
		rateRepository.save(r3);

	};

}
