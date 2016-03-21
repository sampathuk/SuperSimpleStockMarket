package com.jpmc.sssm.calc;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.jpmc.sssm.domain.Stock;
import com.jpmc.sssm.domain.Stocks;
import com.jpmc.sssm.exception.SimpleStockMarketBusinessException;
import com.jpmc.sssm.exception.TechnicalFailureException;

import junit.framework.Assert;

public class CalculateGeometricMeanTest {

	ICalculateStrategy calculateStrategy;

	CalculateContext calculateContext;

	Stocks stocks;

	@Before
	public void setup() throws SimpleStockMarketBusinessException {

		stocks = new Stocks();
		calculateStrategy = new CalculateGeometricMean();
		calculateContext = new CalculateContext(calculateStrategy);
	}

	@Test
	public void calculateGeometricForAllStock() throws SimpleStockMarketBusinessException, TechnicalFailureException {

		List<Stock> stockList = new ArrayList<Stock>();
		stockList.add(stocks.getStockMap().get("TEA"));
		stockList.add(stocks.getStockMap().get("POP"));
		stockList.add(stocks.getStockMap().get("ALE"));
		stockList.add(stocks.getStockMap().get("GIN"));
		stockList.add(stocks.getStockMap().get("JOE"));

		MathContext mc = new MathContext(10, RoundingMode.HALF_UP);
		Assert.assertEquals(new BigDecimal(260.5171085, mc), calculateContext.executeStrategy(null, stockList));

	}

	@Test
	public void calculateGeometricForTeaStock() throws SimpleStockMarketBusinessException, TechnicalFailureException {

		List<Stock> stockList = new ArrayList<Stock>();
		stockList.add(stocks.getStockMap().get("TEA"));

		MathContext mc = new MathContext(10, RoundingMode.HALF_UP);
		Assert.assertEquals(new BigDecimal(260.5171085, mc), calculateContext.executeStrategy(null, stockList));

	}

	@Test
	public void calculateGeometricForNullStock() throws SimpleStockMarketBusinessException, TechnicalFailureException {

		List<Stock> stockList = null;

		Assert.assertEquals(new BigDecimal(0), calculateContext.executeStrategy(null, stockList));

	}

	@Test
	public void calculateGeometricForZeroStock() throws SimpleStockMarketBusinessException, TechnicalFailureException {

		List<Stock> stockList = new ArrayList<Stock>();

		Assert.assertEquals(new BigDecimal(0), calculateContext.executeStrategy(null, stockList));

	}

}
