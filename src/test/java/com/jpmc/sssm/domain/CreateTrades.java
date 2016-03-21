package com.jpmc.sssm.domain;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Calendar;
import java.util.Date;

import com.jpmc.sssm.exception.SimpleStockMarketBusinessException;
import com.jpmc.sssm.transaction.CreateTrade;

public class CreateTrades {

	private CreateTrade createTrade;
	
	public CreateTrades() throws SimpleStockMarketBusinessException {
		super();
		
		Calendar currentMinusSixteen = Calendar.getInstance();
		
		currentMinusSixteen.add(Calendar.MINUTE, -16);
		
		createTrade = new CreateTrade();
		
		createTrade.addTrade(new Date(), new BigInteger("10"), TradeDirectionEnum.BUY, new BigDecimal(100.0), "TEA");
		createTrade.addTrade(new Date(), new BigInteger("11"), TradeDirectionEnum.SELL, new BigDecimal(200.0), "TEA");
		createTrade.addTrade(new Date(), new BigInteger("12"), TradeDirectionEnum.BUY, new BigDecimal(300.0), "TEA");
		createTrade.addTrade(new Date(), new BigInteger("13"), TradeDirectionEnum.SELL, new BigDecimal(400.0), "TEA");
		createTrade.addTrade(currentMinusSixteen.getTime(), new BigInteger("14"), TradeDirectionEnum.BUY, new BigDecimal(500.0), "TEA");
		

		createTrade.addTrade(new Date(), new BigInteger("11"), TradeDirectionEnum.BUY, new BigDecimal(100.0), "POP");
		createTrade.addTrade(new Date(), new BigInteger("12"), TradeDirectionEnum.SELL, new BigDecimal(200.0), "POP");
		createTrade.addTrade(new Date(), new BigInteger("13"), TradeDirectionEnum.BUY, new BigDecimal(300.0), "POP");
		createTrade.addTrade(new Date(), new BigInteger("14"), TradeDirectionEnum.SELL, new BigDecimal(400.0), "POP");
		createTrade.addTrade(currentMinusSixteen.getTime(), new BigInteger("14"), TradeDirectionEnum.BUY, new BigDecimal(500.0), "POP");
		
		createTrade.addTrade(new Date(), new BigInteger("12"), TradeDirectionEnum.BUY, new BigDecimal(100.0), "ALE");
		createTrade.addTrade(new Date(), new BigInteger("13"), TradeDirectionEnum.SELL, new BigDecimal(200.0), "ALE");
		createTrade.addTrade(new Date(), new BigInteger("14"), TradeDirectionEnum.BUY, new BigDecimal(300.0), "ALE");
		createTrade.addTrade(new Date(), new BigInteger("15"), TradeDirectionEnum.SELL, new BigDecimal(400.0), "ALE");
		createTrade.addTrade(currentMinusSixteen.getTime(), new BigInteger("14"), TradeDirectionEnum.BUY, new BigDecimal(500.0), "ALE");
		
		createTrade.addTrade(new Date(), new BigInteger("13"), TradeDirectionEnum.BUY, new BigDecimal(100.0), "GIN");
		createTrade.addTrade(new Date(), new BigInteger("14"), TradeDirectionEnum.SELL, new BigDecimal(200.0), "GIN");
		createTrade.addTrade(new Date(), new BigInteger("15"), TradeDirectionEnum.BUY, new BigDecimal(300.0), "GIN");
		createTrade.addTrade(new Date(), new BigInteger("16"), TradeDirectionEnum.SELL, new BigDecimal(400.0), "GIN");
		createTrade.addTrade(currentMinusSixteen.getTime(), new BigInteger("14"), TradeDirectionEnum.BUY, new BigDecimal(500.0), "GIN");
		
		createTrade.addTrade(new Date(), new BigInteger("14"), TradeDirectionEnum.BUY, new BigDecimal(100.0), "JOE");
		createTrade.addTrade(new Date(), new BigInteger("15"), TradeDirectionEnum.SELL, new BigDecimal(200.0), "JOE");
		createTrade.addTrade(new Date(), new BigInteger("16"), TradeDirectionEnum.BUY, new BigDecimal(300.0), "JOE");
		createTrade.addTrade(new Date(), new BigInteger("17"), TradeDirectionEnum.SELL, new BigDecimal(400.0), "JOE");
		createTrade.addTrade(currentMinusSixteen.getTime(), new BigInteger("14"), TradeDirectionEnum.BUY, new BigDecimal(500.0), "JOE");
	}

	public CreateTrade getCreateTrade() {
		return createTrade;
	}

	public void setCreateTrade(CreateTrade createTrade) {
		this.createTrade = createTrade;
	}

	

}
