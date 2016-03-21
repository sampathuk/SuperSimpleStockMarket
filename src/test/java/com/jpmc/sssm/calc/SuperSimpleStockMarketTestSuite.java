package com.jpmc.sssm.calc;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import com.jpmc.sssm.transaction.CreateTradeTest;

@RunWith(Suite.class)
@Suite.SuiteClasses({
	   CalculateDividendYieldTest.class,
	   CalculatePeRatioTest.class,
	   CreateTradeTest.class,
	   CalculateGeometricMeanTest.class,
	   CalculateVolumeWeightedStockPriceTest.class
	})
public class SuperSimpleStockMarketTestSuite {

}
