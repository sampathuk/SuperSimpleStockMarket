package com.jpmc.sssm.calc;

import java.math.BigDecimal;
import java.util.List;

import com.jpmc.sssm.domain.Stock;
import com.jpmc.sssm.exception.SimpleStockMarketBusinessException;
import com.jpmc.sssm.exception.TechnicalFailureException;

public class CalculateContext {

	private ICalculateStrategy calculateStrategy;
	
	public CalculateContext (ICalculateStrategy calculateStrategy) {
		this.calculateStrategy = calculateStrategy;
	}
	
	public BigDecimal executeStrategy(List<BigDecimal> priceList, List<Stock> stockList) throws SimpleStockMarketBusinessException, TechnicalFailureException {
		return calculateStrategy.calculate(priceList, stockList);
		
	}
}
