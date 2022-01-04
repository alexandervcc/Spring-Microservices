package acc.spring.microservices.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import acc.spring.microservices.domain.CurrencyExchange;

public interface CurrencyExchangeRepository 
	extends JpaRepository<CurrencyExchange, Long > 
{
	
	public CurrencyExchange findByFromAndTo(String from, String to);
}
