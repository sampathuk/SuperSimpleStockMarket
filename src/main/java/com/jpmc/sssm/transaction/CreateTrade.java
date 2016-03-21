package com.jpmc.sssm.transaction;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.jpmc.sssm.constants.IApplicationConstants;
import com.jpmc.sssm.domain.Trade;
import com.jpmc.sssm.domain.TradeDirectionEnum;
import com.jpmc.sssm.exception.SimpleStockMarketBusinessException;

public class CreateTrade implements IApplicationConstants {

	private List<Trade> tradeList;

	public List<Trade> getTradeList() {
		return tradeList;
	}

	public void addTrade(Date tradeTimestamp, BigInteger tradeQuantity, TradeDirectionEnum tradeDirection,
			BigDecimal tradePrice, String stockSymbol) throws SimpleStockMarketBusinessException {

		if (validateTrade(tradeTimestamp, tradeQuantity, tradeDirection, tradePrice, stockSymbol)) {
			this.addTrade(new Trade(tradeTimestamp, tradeQuantity, tradeDirection, tradePrice, stockSymbol));	
		}
		
	}

	private void addTrade(Trade trade) {
		
		if (tradeList == null) {
			tradeList = new ArrayList<Trade>();
		}

		this.tradeList.add(trade);
	}

	public Boolean validateTrade(Date tradeTimestamp, BigInteger tradeQuantity, TradeDirectionEnum tradeDirection,
			BigDecimal tradePrice, String stockSymbol) throws SimpleStockMarketBusinessException {

		if (tradeTimestamp == null) {
			throw new SimpleStockMarketBusinessException(TRADE_DATE_VALIDATION_ERROR_MESSAGE,
					VALIDATION_ERROR_EXCEPTION_CODE_204);
		} else if (tradeQuantity == null) {
			throw new SimpleStockMarketBusinessException(TRADE_QUANTITY_VALIDATION_ERROR_MESSAGE,
					VALIDATION_ERROR_EXCEPTION_CODE_204);
		} else if (tradeDirection == null) {
			throw new SimpleStockMarketBusinessException(TRADE_QUANTITY_VALIDATION_ERROR_MESSAGE,
					TRADE_DIRECTION_VALIDATION_ERROR_MESSAGE);
		} else if (tradePrice == null) {
			throw new SimpleStockMarketBusinessException(TRADE_QUANTITY_VALIDATION_ERROR_MESSAGE,
					TRADE_PRICE_VALIDATION_ERROR_MESSAGE);
		} else if (stockSymbol == null) {
			throw new SimpleStockMarketBusinessException(TRADE_QUANTITY_VALIDATION_ERROR_MESSAGE,
					STOCK_VALIDATION_ERROR_MESSAGE);
		}
		
		return true;

	}

}
