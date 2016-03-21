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

public class CalculatePeRatioTest {
	
	ICalculateStrategy calculateStrategy;
	
	CalculateContext calculateContext;
	
	Stocks stocks;
	
	@Before
	public void setup() throws SimpleStockMarketBusinessException {
		
		stocks = new Stocks();
		calculateStrategy = new CalculatePeRatio();
		calculateContext = new CalculateContext(calculateStrategy);
	}
	
	@Test(expected=TechnicalFailureException.class)
	public void calculatePeRatioForTeaTest () throws SimpleStockMarketBusinessException, TechnicalFailureException {
		
		List<BigDecimal> priceList = new ArrayList<BigDecimal>();
		priceList.add(new BigDecimal(1.0));
		
		List<Stock> stockList = new ArrayList<Stock>();
		stockList.add(stocks.getStockMap().get("TEA"));
		
		calculateContext.executeStrategy(priceList, stockList);
	}
	
	@Test
	public void calculatePeRatioForPopTest () throws SimpleStockMarketBusinessException, TechnicalFailureException {
		
		List<BigDecimal> priceList = new ArrayList<BigDecimal>();
		priceList.add(new BigDecimal(16.0));
		
		List<Stock> stockList = new ArrayList<Stock>();
		stockList.add(stocks.getStockMap().get("POP"));
		
		Assert.assertEquals(new BigDecimal(32), calculateContext.executeStrategy(priceList, stockList));
	}
	
	@Test
	public void calculatePeRatioForAleTest () throws SimpleStockMarketBusinessException, TechnicalFailureException {
		
		List<BigDecimal> priceList = new ArrayList<BigDecimal>();
		priceList.add(new BigDecimal(23.0));
		
		List<Stock> stockList = new ArrayList<Stock>();
		stockList.add(stocks.getStockMap().get("ALE"));
		
		Assert.assertEquals(new BigDecimal(23.0), calculateContext.executeStrategy(priceList, stockList));
	}
	
	@Test
	public void calculatePeRatioForGinTest () throws SimpleStockMarketBusinessException, TechnicalFailureException {
		
		List<BigDecimal> priceList = new ArrayList<BigDecimal>();
		priceList.add(new BigDecimal(200.0));
		
		List<Stock> stockList = new ArrayList<Stock>();
		stockList.add(stocks.getStockMap().get("GIN"));
		
		Assert.assertEquals(new BigDecimal(200.0), calculateContext.executeStrategy(priceList, stockList));
	}
	
	@Test
	public void calculatePeRatioForJoeTest () throws SimpleStockMarketBusinessException, TechnicalFailureException {
		
		List<BigDecimal> priceList = new ArrayList<BigDecimal>();
		priceList.add(new BigDecimal(26.0));
		
		List<Stock> stockList = new ArrayList<Stock>();
		stockList.add(stocks.getStockMap().get("JOE"));
		
		Assert.assertEquals(new BigDecimal(52), calculateContext.executeStrategy(priceList, stockList));
	}
	
	@Test(expected=TechnicalFailureException.class)
	public void calculatePeRatioForTeaDivideByZeroTest () throws SimpleStockMarketBusinessException, TechnicalFailureException {
		
		List<BigDecimal> priceList = new ArrayList<BigDecimal>();
		priceList.add(new BigDecimal(0.0));
		
		List<Stock> stockList = new ArrayList<Stock>();
		stockList.add(stocks.getStockMap().get("TEA"));
		
		calculateContext.executeStrategy(priceList, stockList);
	}
	
	@Test(expected=SimpleStockMarketBusinessException.class)
	public void calculatePeRatioForTeaPriceIsNullTest () throws SimpleStockMarketBusinessException, TechnicalFailureException {
		
		List<BigDecimal> priceList = null;
		
		List<Stock> stockList = new ArrayList<Stock>();
		stockList.add(stocks.getStockMap().get("TEA"));
		
		calculateContext.executeStrategy(priceList, stockList);
	}
	
	@Test(expected=SimpleStockMarketBusinessException.class)
	public void calculatePeRatioForTeaStockIsNullTest () throws SimpleStockMarketBusinessException, TechnicalFailureException {
		
		List<BigDecimal> priceList = new ArrayList<BigDecimal>();
		priceList.add(new BigDecimal(0.0));
		
		calculateContext.executeStrategy(priceList, null);
	}
	
	@Test(expected=SimpleStockMarketBusinessException.class)
	public void calculatePeRatioForTeaMoreThanOnePriceTest () throws SimpleStockMarketBusinessException, TechnicalFailureException {
		
		List<BigDecimal> priceList = new ArrayList<BigDecimal>();
		priceList.add(new BigDecimal(0.0));
		priceList.add(new BigDecimal(1.0));
		
		List<Stock> stockList = new ArrayList<Stock>();
		stockList.add(stocks.getStockMap().get("TEA"));
		
		calculateContext.executeStrategy(priceList, stockList);
	}
	
	@Test(expected=SimpleStockMarketBusinessException.class)
	public void calculatePeRatioForTeaMoreThanOneStockTest () throws SimpleStockMarketBusinessException, TechnicalFailureException {
		
		List<BigDecimal> priceList = new ArrayList<BigDecimal>();
		priceList.add(new BigDecimal(0.0));
		
		List<Stock> stockList = new ArrayList<Stock>();
		stockList.add(stocks.getStockMap().get("TEA"));
		stockList.add(stocks.getStockMap().get("POP"));
		
		calculateContext.executeStrategy(priceList, stockList);
	}

}
