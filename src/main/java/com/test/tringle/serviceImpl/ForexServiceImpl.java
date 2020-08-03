package com.test.tringle.serviceImpl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.test.tringle.bean.ExchangeBean;
import com.test.tringle.bean.GenericResponse;
import com.test.tringle.constent.BasicConstent;
import com.test.tringle.entity.Rate;
import com.test.tringle.repository.RateRepository;
import com.test.tringle.service.ForexService;

/**
 * @author Jagasan
 * @createdOn 1-Aug-2020
 */
@Service
public class ForexServiceImpl implements ForexService {

	@Autowired
	RateRepository rateRepository;

	public GenericResponse saveForexData(String response) throws JsonMappingException, JsonProcessingException {

		System.out.println(response);
		ObjectMapper mapper = new ObjectMapper();
		Map<String, Object> map = mapper.readValue(response, new TypeReference<Map<String, Object>>() {
		});
		if (map.get("success").toString().equals("true")) {
			Object obj = map.get("rates");
			Map<String, Object> m = mapper.convertValue(obj, Map.class);
			Set<Entry<String, Object>> set = m.entrySet();
			saveRate(set);
			return new GenericResponse(BasicConstent.SUCCESS);
		} else {
			return new GenericResponse(map, BasicConstent.FAIL);
		}
	}

	private void saveRate(Set<Entry<String, Object>> set) {
		Iterator<Entry<String, Object>> itr = set.iterator();
		List<Rate> rates = new ArrayList<Rate>();
		while (itr.hasNext()) {
			Rate rate = null;
			Entry<String, Object> entry = itr.next();
			rate = rateRepository.findByCurrencyCode(entry.getKey().trim());
			if (rate == null)
				rate = new Rate();
			rate.setCurrencyCode(entry.getKey().trim());
			rate.setValue(Double.parseDouble(entry.getValue().toString()));
			rates.add(rate);
		}
		rateRepository.saveAll(rates);

	}

	public GenericResponse exchangeCurrency(String from, String to, Double amount) {
		if (to == null || to.isEmpty() || amount == null || amount <= 0) {
			return new GenericResponse(BasicConstent.INVALID_INPUT);
		} else {
			Rate rate = rateRepository.findByCurrencyCodeIgnoreCase(to.trim());
			if (rate == null) {
				return new GenericResponse(BasicConstent.RECORD_NOT_FOUNT);
			} else {
				ExchangeBean bean = new ExchangeBean();
				bean.setFrom(from);
				bean.setTo(to);
				bean.setAmount((amount * rate.getValue()));
				return new GenericResponse(bean, BasicConstent.SUCCESS_EXCHANGE);

			}
		}
	}
}
