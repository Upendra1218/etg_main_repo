package com.GuestUserWith_CreditCard;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.providio.commonfunctionality.addtoCartValidation;
import com.providio.commonfunctionality.validatingInstock;
import com.providio.pageObjects.BundleProductFromEXcel;
import com.providio.paymentProccess.tc__CreditCardPaymentProcess;
import com.providio.paymentProccess.tc__MiniCartChekoutButton;
import com.providio.paymentProccess.tc__MinicartViewCartProcess;
import com.providio.testcases.baseClass;

public class tc__BundleProductForGuestUser_CC  extends baseClass{
	
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
	        tc__MiniCartChekoutButton cp = new tc__MiniCartChekoutButton();         
			cp.checkoutprocess();
      
			 //payment process
              tc__CreditCardPaymentProcess tc = new tc__CreditCardPaymentProcess();			              
              tc.paymentByCreditCard();
              
				}

		 
}
