package com.test.tringle;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit4.SpringRunner;

import com.test.tringle.bean.GenericResponse;
import com.test.tringle.constent.BasicConstent;
import com.test.tringle.entity.Rate;
import com.test.tringle.repository.RateRepository;
import com.test.tringle.serviceImpl.ForexServiceImpl;

@RunWith(SpringRunner.class)
public class ForexServiceTest {

	@InjectMocks
	ForexServiceImpl forexService;
	@Mock
	RateRepository rateRepository;

	@Test
	public void exchangeCurrencyTest() {

		when(rateRepository.findByCurrencyCodeIgnoreCase("INR")).thenReturn(getRateData());
		GenericResponse response = forexService.exchangeCurrency("USD", "INR", 200d);
		assertEquals(response.message, BasicConstent.SUCCESS_EXCHANGE);

	}

	@Test
	public void exchangeCurrencyNotFoundTest() {

		when(rateRepository.findByCurrencyCodeIgnoreCase("INR")).thenReturn(getRateData());
		GenericResponse response = forexService.exchangeCurrency("INR", "USD", 200d);
		assertEquals(response.message, BasicConstent.RECORD_NOT_FOUNT);

	}

	private Rate getRateData() {
		Rate rate = new Rate();
		rate.setCurrencyCode("INR");
		rate.setValue(88.1234d);
		return rate;
	}

}
