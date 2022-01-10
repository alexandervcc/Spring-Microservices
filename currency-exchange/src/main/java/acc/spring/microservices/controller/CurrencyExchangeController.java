package acc.spring.microservices.controller;

import java.math.BigDecimal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import acc.spring.microservices.domain.CurrencyExchange;
import acc.spring.microservices.repository.CurrencyExchangeRepository; 	

@RestController
public class CurrencyExchangeController {
	
	@Autowired
	private CurrencyExchangeRepository repoCuEx;
	
	//import org.springframework.core.env.Environment;
	@Autowired
	private Environment environment; 
	
	private Logger logger = LoggerFactory.getLogger(CurrencyExchange.class);
	
	
	@GetMapping("/currency-exchange/from/{from}/to/{to}")
	public CurrencyExchange retrieveEnchangeValue(
			@PathVariable String from, @PathVariable String to	
	) {
		
		logger.info("-------------------retrieveExchangeValues from={} to={}",from,to);
		
		//CurrencyExchange ce = new CurrencyExchange(1000L,from,to,BigDecimal.valueOf(50));
		CurrencyExchange ce = repoCuEx.findByFromAndTo(from, to);
		
		if(ce==null) {
			throw new RuntimeException("Unable to find data for the passed values");
		}
		
		String port = environment.getProperty("local.server.port");
		ce.setEnvironment(port);
		
				
		return ce;
	}
	
}
