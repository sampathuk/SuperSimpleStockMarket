package com.jpmc.sssm.calc;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.List;

import com.jpmc.sssm.constants.IApplicationConstants;
import com.jpmc.sssm.domain.Stock;
import com.jpmc.sssm.domain.Trade;
import com.jpmc.sssm.exception.SimpleStockMarketBusinessException;
import com.jpmc.sssm.exception.TechnicalFailureException;

public class CalculateGeometricMean extends CalculateDividendYield
		implements ICalculateStrategy, IApplicationConstants {

	public BigDecimal calculate(List<BigDecimal> priceList, List<Stock> stockList)
			throws SimpleStockMarketBusinessException, TechnicalFailureException {

		BigDecimal geometricMean = new BigDecimal(0);

		BigDecimal productOfPrice = new BigDecimal(1);

		int numberOfTransaction = 0;

		try {

			if (stockList != null && stockList.size() > 0) {
				for (Stock stock : stockList) {

					for (Trade trade : stock.getTradeList()) {

						productOfPrice = productOfPrice.multiply(trade.getTradePrice());
						numberOfTransaction++;

					}

				}

				if (numberOfTransaction > 0) {
					MathContext mc = new MathContext(10, RoundingMode.HALF_UP);
					Double raiseToPower = new Double(1) / new Double(numberOfTransaction);

					geometricMean = new BigDecimal(Math.pow(productOfPrice.doubleValue(), raiseToPower), mc);
				}
			}

		} catch (ArithmeticException ae) {
			throw new TechnicalFailureException(ae.getMessage(), TECHNICAL_ERROR_EXCEPTION_CODE_500, ae);
		}

		return geometricMean;
	}

}
