package com.jpmc.sssm.calc;

import java.math.BigDecimal;
import java.util.List;

import com.jpmc.sssm.constants.IApplicationConstants;
import com.jpmc.sssm.domain.Stock;
import com.jpmc.sssm.exception.SimpleStockMarketBusinessException;
import com.jpmc.sssm.exception.TechnicalFailureException;

public class CalculateDividendYield implements ICalculateStrategy, IApplicationConstants {

	public BigDecimal calculate(List<BigDecimal> priceList, List<Stock> stockList)
			throws SimpleStockMarketBusinessException, TechnicalFailureException {

		BigDecimal calculatedYield = new BigDecimal(0);

		validateInput(priceList, stockList);

		BigDecimal price = priceList.get(0);
		Stock stock = stockList.get(0);

		try {

			switch (stock.getStockType()) {
			case COMMON:
				calculatedYield = stock.getLastDividend().divide(price);
				break;
			case PREFERRED:
				calculatedYield = stock.getFixedDividend().multiply(new BigDecimal(stock.getParValue())).divide(price);
				break;

			}
		} catch (ArithmeticException ae) {
			throw new TechnicalFailureException(ae.getMessage(), TECHNICAL_ERROR_EXCEPTION_CODE_500, ae);
		}

		return calculatedYield;
	}

	private void validateInput(List<BigDecimal> priceList, List<Stock> stockList)
			throws SimpleStockMarketBusinessException {
		if (priceList == null || priceList.size() == 0) {
			throw new SimpleStockMarketBusinessException(VALIDATION_ERROR_EXCEPTION_CODE_204,
					PRICE_VALIDATION_ERROR_MESSAGE);
		} else if (stockList == null || stockList.size() == 0) {
			throw new SimpleStockMarketBusinessException(VALIDATION_ERROR_EXCEPTION_CODE_204,
					STOCK_VALIDATION_ERROR_MESSAGE);
		} else if (priceList.size() > 1) {
			throw new SimpleStockMarketBusinessException(VALIDATION_ERROR_EXCEPTION_CODE_204,
					ONLY_ONE_PRICE_VALIDATION_ERROR_MESSAGE);
		} else if (stockList.size() > 1) {
			throw new SimpleStockMarketBusinessException(VALIDATION_ERROR_EXCEPTION_CODE_204,
					ONLY_ONE_STOCK_VALIDATION_ERROR_MESSAGE);
		}
	}

}
