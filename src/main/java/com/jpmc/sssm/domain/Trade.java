package com.jpmc.sssm.domain;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;

public class Trade {

	Date tradeTimestamp;
	BigInteger tradeQuantity;
	TradeDirectionEnum tradeDirection;
	BigDecimal tradePrice;
	String stockSymbol;

	public Date getTradeTimestamp() {
		return tradeTimestamp;
	}

	public void setTradeTimestamp(Date tradeTimestamp) {
		this.tradeTimestamp = tradeTimestamp;
	}

	public BigInteger getTradeQuantity() {
		return tradeQuantity;
	}

	public void setTradeQuantity(BigInteger tradeQuantity) {
		this.tradeQuantity = tradeQuantity;
	}

	public TradeDirectionEnum getTradeDirection() {
		return tradeDirection;
	}

	public void setTradeDirection(TradeDirectionEnum tradeDirection) {
		this.tradeDirection = tradeDirection;
	}

	public BigDecimal getTradePrice() {
		return tradePrice;
	}

	public void setTradePrice(BigDecimal tradePrice) {
		this.tradePrice = tradePrice;
	}

	public String getStockSymbol() {
		return stockSymbol;
	}

	public void setStockSymbol(String stockSymbol) {
		this.stockSymbol = stockSymbol;
	}

	public Trade(Date tradeTimestamp, BigInteger tradeQuantity, TradeDirectionEnum tradeDirection,
			BigDecimal tradePrice, String stockSymbol) {
		super();
		this.tradeTimestamp = tradeTimestamp;
		this.tradeQuantity = tradeQuantity;
		this.tradeDirection = tradeDirection;
		this.tradePrice = tradePrice;
		this.stockSymbol = stockSymbol;
	}

	@Override
	public String toString() {
		return "Trade [tradeTimestamp=" + tradeTimestamp + ", tradeQuantity=" + tradeQuantity + ", tradeDirection="
				+ tradeDirection + ", tradePrice=" + tradePrice + "]";
	}

}
