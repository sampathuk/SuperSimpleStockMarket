package com.jpmc.sssm.transaction;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;

import org.junit.Before;
import org.junit.Test;

import com.jpmc.sssm.domain.Trade;
import com.jpmc.sssm.domain.TradeDirectionEnum;
import com.jpmc.sssm.exception.SimpleStockMarketBusinessException;

import junit.framework.Assert;

public class CreateTradeTest {

	CreateTrade createTrade;

	@Before
	public void setup() {

		createTrade = new CreateTrade();
	}

	@Test
	public void createNewBuyTradeTest() throws SimpleStockMarketBusinessException {
		createTrade.addTrade(new Date(), new BigInteger("10"), TradeDirectionEnum.BUY, new BigDecimal(100.0), "TEA");
		Assert.assertEquals(1, createTrade.getTradeList().size());

		for (Trade trade : createTrade.getTradeList()) {
			Assert.assertEquals("TEA", trade.getStockSymbol());
			Assert.assertEquals(new BigInteger("10"), trade.getTradeQuantity());
			Assert.assertEquals(new BigDecimal(100.0), trade.getTradePrice());
			Assert.assertEquals(TradeDirectionEnum.BUY, trade.getTradeDirection());
		}
	}

	@Test
	public void createNewSellTradeTest() throws SimpleStockMarketBusinessException {
		createTrade.addTrade(new Date(), new BigInteger("10"), TradeDirectionEnum.SELL, new BigDecimal(100.0), "TEA");
		Assert.assertEquals(1, createTrade.getTradeList().size());

		for (Trade trade : createTrade.getTradeList()) {
			Assert.assertEquals("TEA", trade.getStockSymbol());
			Assert.assertEquals(new BigInteger("10"), trade.getTradeQuantity());
			Assert.assertEquals(new BigDecimal(100.0), trade.getTradePrice());
			Assert.assertEquals(TradeDirectionEnum.SELL, trade.getTradeDirection());
		}
	}

	@Test(expected = SimpleStockMarketBusinessException.class)
	public void createNewSellTradeWithDateAsNullTest() throws SimpleStockMarketBusinessException {
		createTrade.addTrade(null, new BigInteger("10"), TradeDirectionEnum.SELL, new BigDecimal(100.0), "TEA");

	}

	@Test(expected = SimpleStockMarketBusinessException.class)
	public void createNewSellTradeWithTradeQuantityAsNullTest() throws SimpleStockMarketBusinessException {
		createTrade.addTrade(new Date(), null, TradeDirectionEnum.SELL, new BigDecimal(100.0), "TEA");

	}

	@Test(expected = SimpleStockMarketBusinessException.class)
	public void createNewSellTradeWithTradeDirectionAsNullTest() throws SimpleStockMarketBusinessException {
		createTrade.addTrade(new Date(), new BigInteger("10"), null, new BigDecimal(100.0), "TEA");
	}

	@Test(expected = SimpleStockMarketBusinessException.class)
	public void createNewSellTradeWithTradePriceAsNullTest() throws SimpleStockMarketBusinessException {
		createTrade.addTrade(new Date(), new BigInteger("10"), null, new BigDecimal(100.0), "TEA");
	}

	@Test(expected = SimpleStockMarketBusinessException.class)
	public void createNewSellTradeWithStockSymbolAsNullTest() throws SimpleStockMarketBusinessException {
		createTrade.addTrade(new Date(), new BigInteger("10"), null, new BigDecimal(100.0), "TEA");
	}

	@Test(expected = SimpleStockMarketBusinessException.class)
	public void createNewSellTradeWithEverythingAsNullTest() throws SimpleStockMarketBusinessException {
		createTrade.addTrade(null, null, null, null, null);
	}

}
