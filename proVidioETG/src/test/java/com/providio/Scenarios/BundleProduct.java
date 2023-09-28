package com.providio.Scenarios;

import com.providio.commonfunctionality.addtoCartValidation;
import com.providio.commonfunctionality.validatingInstock;
import com.providio.pageObjects.BundleProductFromEXcel;
import com.providio.testcases.baseClass;

public class BundleProduct extends baseClass{
	
	public void bundleproduct() throws InterruptedException {
		
		//launching the browser and passing the url into it
		 driver.get(baseURL); 
		 logger.info("Entered into url");
		 logger.info("Placing the order as guest user");
		 
		 
		 //searching the bundle product from excel sheet
		 BundleProductFromEXcel bundleProduct = new  BundleProductFromEXcel();
		 bundleProduct.performRandomOperations(driver);
		 logger.info("Searched a product");
		 
	        //validate the product is instock or not
	    	validatingInstock.inStockValidation();
	    	
	    	//validating the product is add to the cart
	    	addtoCartValidation.validatingProductisAddtoCart(driver);
		
	}

}
