package com.jpmc.sssm.calc;

import java.math.BigDecimal;
import java.util.List;

import com.jpmc.sssm.constants.IApplicationConstants;
import com.jpmc.sssm.domain.Stock;
import com.jpmc.sssm.exception.SimpleStockMarketBusinessException;
import com.jpmc.sssm.exception.TechnicalFailureException;

public class CalculatePeRatio extends CalculateDividendYield implements ICalculateStrategy, IApplicationConstants {

	public BigDecimal calculate(List<BigDecimal> priceList, List<Stock> stockList)
			throws SimpleStockMarketBusinessException, TechnicalFailureException {

		BigDecimal dividend = super.calculate(priceList, stockList);

		BigDecimal peRatio = new BigDecimal(0);

		BigDecimal price = priceList.get(0);

		try {

			peRatio = price.divide(dividend);
		} catch (ArithmeticException ae) {
			throw new TechnicalFailureException(ae.getMessage(), TECHNICAL_ERROR_EXCEPTION_CODE_500, ae);
		}

		return peRatio;
	}

}
