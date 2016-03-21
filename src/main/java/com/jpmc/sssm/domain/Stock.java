package com.jpmc.sssm.domain;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Stock {

	StockTypeEnum stockType;
	String stockSymbol;
	BigDecimal lastDividend;
	BigDecimal fixedDividend;
	Integer parValue;

	List<Trade> tradeList;

	public BigDecimal getLastDividend() {
		return lastDividend;
	}

	public void setLastDividend(BigDecimal lastDividend) {
		this.lastDividend = lastDividend;
	}

	public BigDecimal getFixedDividend() {
		return fixedDividend;
	}

	public void setFixedDividend(BigDecimal fixedDividend) {
		this.fixedDividend = fixedDividend;
	}

	public Integer getParValue() {
		return parValue;
	}

	public void setParValue(Integer parValue) {
		this.parValue = parValue;
	}


	public String getStockSymbol() {
		return stockSymbol;
	}

	public void setStockSymbol(String stockSymbol) {
		this.stockSymbol = stockSymbol;
	}

	public StockTypeEnum getStockType() {
		return stockType;
	}

	public void setStockType(StockTypeEnum stockType) {
		this.stockType = stockType;
	}

	public Stock(StockTypeEnum stockType, String stockSymbol, BigDecimal lastDividend, BigDecimal fixedDividend,
			Integer parValue) {
		super();
		this.stockType = stockType;
		this.stockSymbol = stockSymbol;
		this.lastDividend = lastDividend;
		this.fixedDividend = fixedDividend;
		this.parValue = parValue;
	}

	public Stock(StockTypeEnum stockType, String stockSymbol, Integer parValue) {
		super();
		this.stockType = stockType;
		this.stockSymbol = stockSymbol;
		this.parValue = parValue;
	}

	public Stock(StockTypeEnum stockType, String stockSymbol, BigDecimal fixedDividend, Integer parValue) {
		super();
		this.stockType = stockType;
		this.stockSymbol = stockSymbol;
		this.fixedDividend = fixedDividend;
		this.parValue = parValue;
	}

	public Stock(StockTypeEnum stockType, String stockSymbol, Integer parValue, BigDecimal lastDividend) {
		super();
		this.stockType = stockType;
		this.stockSymbol = stockSymbol;
		this.lastDividend = lastDividend;
		this.parValue = parValue;
	}

	public List<Trade> getTradeList() {
		return tradeList;
	}

	public void addTrade(Trade trade) {
		if (tradeList == null) {
			tradeList = new ArrayList<Trade>();
		}
		if (trade != null) {
			this.tradeList.add(trade);
		}

	}

	public void setTradeList(List<Trade> tradeList) {
		this.tradeList = tradeList;
	}

	@Override
	public String toString() {
		return "Stock [tradeType=" + stockType + ", stockSymbol=" + stockSymbol + ", lastDividend=" + lastDividend
				+ ", fixedDividend=" + fixedDividend + ", parValue=" + parValue + "]";
	}

}
