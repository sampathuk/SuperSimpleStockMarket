package com.jpmc.sssm.calc;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.jpmc.sssm.domain.Stock;
import com.jpmc.sssm.domain.Stocks;
import com.jpmc.sssm.exception.SimpleStockMarketBusinessException;
import com.jpmc.sssm.exception.TechnicalFailureException;

import junit.framework.Assert;

public class CalculateVolumeWeightedStockPriceTest {

	ICalculateStrategy calculateStrategy;

	CalculateContext calculateContext;

	Stocks stocks;

	@Before
	public void setup() throws SimpleStockMarketBusinessException {

		stocks = new Stocks();
		calculateStrategy = new CalculateVolumeWeightedStockPrice();
		calculateContext = new CalculateContext(calculateStrategy);
	}

	@Test
	public void calculateVolumeWeightedStockPriceForTeaTest() throws SimpleStockMarketBusinessException, TechnicalFailureException {

		Stocks stocks = new Stocks();
		List<Stock> stockList = new ArrayList<Stock>();
		stockList.add(stocks.getStockMap().get("TEA"));
		Assert.assertEquals(new BigDecimal("260.8696"), calculateContext.executeStrategy(null, stockList));
	}
	
	@Test
	public void calculateVolumeWeightedStockPriceForPopTest() throws SimpleStockMarketBusinessException, TechnicalFailureException {

		Stocks stocks = new Stocks();
		List<Stock> stockList = new ArrayList<Stock>();
		stockList.add(stocks.getStockMap().get("POP"));
		Assert.assertEquals(new BigDecimal("260.0000"), calculateContext.executeStrategy(null, stockList));
	}
	
	@Test
	public void calculateVolumeWeightedStockPriceForAleTest() throws SimpleStockMarketBusinessException, TechnicalFailureException {

		Stocks stocks = new Stocks();
		List<Stock> stockList = new ArrayList<Stock>();
		stockList.add(stocks.getStockMap().get("ALE"));
		Assert.assertEquals(new BigDecimal("259.2593"), calculateContext.executeStrategy(null, stockList));
	}

	@Test
	public void calculateVolumeWeightedStockPriceForGinTest() throws SimpleStockMarketBusinessException, TechnicalFailureException {

		Stocks stocks = new Stocks();
		List<Stock> stockList = new ArrayList<Stock>();
		stockList.add(stocks.getStockMap().get("GIN"));
		Assert.assertEquals(new BigDecimal("258.6207"), calculateContext.executeStrategy(null, stockList));
	}

	@Test
	public void calculateVolumeWeightedStockPriceForJoeTest() throws SimpleStockMarketBusinessException, TechnicalFailureException {

		Stocks stocks = new Stocks();
		List<Stock> stockList = new ArrayList<Stock>();
		stockList.add(stocks.getStockMap().get("JOE"));
		Assert.assertEquals(new BigDecimal("258.0645"), calculateContext.executeStrategy(null, stockList));
	}
}
