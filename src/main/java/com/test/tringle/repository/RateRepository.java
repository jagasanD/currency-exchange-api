
package com.test.tringle.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.test.tringle.entity.Rate;

/**
 * @author Jagasan
 * @createdOn 1-Aug-2020
 */
public interface RateRepository extends MongoRepository<Rate, String> {

	public Rate findByCurrencyCode(String currencyCode);

	public Rate findByCurrencyCodeIgnoreCase(String currencyCode);

}
