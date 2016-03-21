package com.jpmc.sssm.domain;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import com.jpmc.sssm.exception.SimpleStockMarketBusinessException;

public class Stocks {

	private Map<String, Stock> stockMap = new HashMap<String, Stock>();

	public Stocks() throws SimpleStockMarketBusinessException {
		super();

		Stock stockTea = new Stock(StockTypeEnum.COMMON, "TEA", 100, new BigDecimal(0));
		Stock stockPop = new Stock(StockTypeEnum.COMMON, "POP", 100, new BigDecimal(8));
		Stock stockAle = new Stock(StockTypeEnum.COMMON, "ALE", 60, new BigDecimal(23));
		Stock stockGin = new Stock(StockTypeEnum.PREFERRED, "GIN", new BigDecimal(8), new BigDecimal(2), 100);
		Stock stockJoe = new Stock(StockTypeEnum.COMMON, "JOE", 250, new BigDecimal(13));

		CreateTrades createTrades = new CreateTrades();

		for (Trade trade : createTrades.getCreateTrade().getTradeList()) {
			if (trade.getStockSymbol().equals("TEA")) {
				stockTea.addTrade(trade);
			} else if (trade.getStockSymbol().equals("POP")) {
				stockPop.addTrade(trade);
			} else if (trade.getStockSymbol().equals("ALE")) {
				stockAle.addTrade(trade);
			} else if (trade.getStockSymbol().equals("GIN")) {
				stockGin.addTrade(trade);
			} else if (trade.getStockSymbol().equals("JOE")) {
				stockJoe.addTrade(trade);
			}
		}

		stockMap.put("TEA", stockTea);
		stockMap.put("POP", stockPop);
		stockMap.put("ALE", stockAle);
		stockMap.put("GIN", stockGin);
		stockMap.put("JOE", stockJoe);

	}

	public Map<String, Stock> getStockMap() {
		return stockMap;
	}

	public void setStockMap(Map<String, Stock> stockMap) {
		this.stockMap = stockMap;
	}
	
	
}
