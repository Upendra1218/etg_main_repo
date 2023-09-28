package com.providio.Scenarios;

import com.providio.commonfunctionality.addtoCartValidation;
import com.providio.pageObjects.VariationProductFromExcel;
import com.providio.testcases.baseClass;

public class VariationProduct extends baseClass{

	public void variationProduct() throws InterruptedException {
		
		//launching the browser and passing the url into it
		 driver.get(baseURL);
		 logger.info("Entered into url");
		 logger.info("Placing the order as guest user");
		  
		 //searched for variation product
		 VariationProductFromExcel fromExcel = new VariationProductFromExcel();
		 fromExcel.performRandomOperations(driver);
		 logger.info("searched for Variation product");

 		//validating the product is add to the cart
  	    addtoCartValidation.validatingProductisAddtoCart(driver);

	}

}
