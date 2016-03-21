package com.jpmc.sssm.calc;

import java.math.BigDecimal;
import java.util.List;

import com.jpmc.sssm.domain.Stock;
import com.jpmc.sssm.exception.SimpleStockMarketBusinessException;
import com.jpmc.sssm.exception.TechnicalFailureException;

public interface ICalculateStrategy {
	public BigDecimal calculate(List<BigDecimal> priceList, List<Stock> stockList) throws SimpleStockMarketBusinessException, TechnicalFailureException;
}
