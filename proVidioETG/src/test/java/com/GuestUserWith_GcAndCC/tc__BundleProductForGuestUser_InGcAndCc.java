package com.GuestUserWith_GcAndCC;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.providio.commonfunctionality.Gc__CC_Paypal;
import com.providio.commonfunctionality.addtoCartValidation;
import com.providio.commonfunctionality.validatingInstock;
import com.providio.pageObjects.BundleProductFromEXcel;
import com.providio.paymentProccess.tc__MinicartViewCartProcess;
import com.providio.testcases.baseClass;

public class tc__BundleProductForGuestUser_InGcAndCc  extends baseClass{
	 
		SoftAssert softAssert = new SoftAssert();

		 @Test
		public void bundleProduct() throws InterruptedException {

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
				
	         //checkoutProcess		        
			  tc__MinicartViewCartProcess cp = new tc__MinicartViewCartProcess();	         
              cp.checkoutprocess();
              
            //semi gc and cc 
			  Gc__CC_Paypal gCandCC = new Gc__CC_Paypal();
			  gCandCC.paymentProccessByGCandCC(driver);
			  
		}	 
}
