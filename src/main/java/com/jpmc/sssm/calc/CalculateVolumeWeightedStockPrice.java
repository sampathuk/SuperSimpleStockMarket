package com.jpmc.sssm.calc;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Calendar;
import java.util.List;

import com.jpmc.sssm.constants.IApplicationConstants;
import com.jpmc.sssm.domain.Stock;
import com.jpmc.sssm.domain.Trade;
import com.jpmc.sssm.exception.SimpleStockMarketBusinessException;
import com.jpmc.sssm.exception.TechnicalFailureException;

public class CalculateVolumeWeightedStockPrice implements ICalculateStrategy, IApplicationConstants {

	public BigDecimal calculate(List<BigDecimal> priceList, List<Stock> stockList)
			throws SimpleStockMarketBusinessException, TechnicalFailureException {

		BigDecimal volumeWeightedStockPrice = new BigDecimal(0);

		validateInput(stockList);

		try {

			BigDecimal productOfPriceAndQuantity = new BigDecimal(0.0);
			BigDecimal sumOfQuantity = new BigDecimal(0.0);

			Calendar currentMinusFifteen = Calendar.getInstance();

			currentMinusFifteen.add(Calendar.MINUTE, -15);

			for (Stock stock : stockList) {
				for (Trade trade : stock.getTradeList()) {
					if (trade.getTradeTimestamp().compareTo(currentMinusFifteen.getTime()) > 0) {

						productOfPriceAndQuantity = productOfPriceAndQuantity
								.add(trade.getTradePrice().multiply(new BigDecimal(trade.getTradeQuantity())));
						sumOfQuantity = sumOfQuantity.add(new BigDecimal(trade.getTradeQuantity()));
					}
				}
			}

			volumeWeightedStockPrice = productOfPriceAndQuantity.divide(sumOfQuantity, 4, RoundingMode.HALF_UP);

		} catch (ArithmeticException ae) {
			throw new TechnicalFailureException(ae.getMessage(), TECHNICAL_ERROR_EXCEPTION_CODE_500, ae);
		}

		return volumeWeightedStockPrice;

	}

	private void validateInput(List<Stock> stockList) throws SimpleStockMarketBusinessException {
		if (stockList == null || stockList.size() == 0) {
			throw new SimpleStockMarketBusinessException(VALIDATION_ERROR_EXCEPTION_CODE_204,
					STOCK_VALIDATION_ERROR_MESSAGE);
		} else if (stockList.size() > 1) {
			throw new SimpleStockMarketBusinessException(VALIDATION_ERROR_EXCEPTION_CODE_204,
					ONLY_ONE_STOCK_VALIDATION_ERROR_MESSAGE);
		}
	}

}
