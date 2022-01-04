package acc.spring.microservices.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import acc.spring.microservices.domain.CurrencyConversion;


@FeignClient(name="currency-exchange", url="localhost:8000")
public interface CurrencyExchangeProxy {

	
	@GetMapping("/currency-exchange/from/{from}/to/{to}")
	public CurrencyConversion retrieveEnchangeValue(
			@PathVariable String from, @PathVariable String to
	);
}
