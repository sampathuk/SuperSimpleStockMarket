package com.jpmc.sssm.constants;

/**
*
* Interface to maintain the application constants
*
* @author Sampath
* @version 16.00, 16 Mar 2016
* 
*/
public interface IApplicationConstants {

	String PRICE_VALIDATION_ERROR_MESSAGE = "Validation Error: Price must be present in the input";
	
	String ONLY_ONE_PRICE_VALIDATION_ERROR_MESSAGE = "Validation Error: Only one price must be present in the input";
	
	String TRADE_DATE_VALIDATION_ERROR_MESSAGE = "Validation Error: Trade Date cannot be null";
	
	String TRADE_QUANTITY_VALIDATION_ERROR_MESSAGE = "Validation Error: Trade Quantity cannot be null";
	
	String TRADE_DIRECTION_VALIDATION_ERROR_MESSAGE = "Validation Error: Trade Direction cannot be null";
	
	String TRADE_PRICE_VALIDATION_ERROR_MESSAGE = "Validation Error: Trade Price cannot be null";
	
	String TRADE_STOCK_SYMBOL_VALIDATION_ERROR_MESSAGE = "Validation Error: Trade stock symbol cannot be null";
	
	String STOCK_VALIDATION_ERROR_MESSAGE = "Validation Error: Stock must be present in the input";
	
	String ONLY_ONE_STOCK_VALIDATION_ERROR_MESSAGE = "Validation Error: Only one stock must be present in the input";
	
	//Technical Exception 
	String TECHNICAL_ERROR_EXCEPTION_CODE_500 = "500";
	
	//Validation error
	String VALIDATION_ERROR_EXCEPTION_CODE_204 = "204";

}
