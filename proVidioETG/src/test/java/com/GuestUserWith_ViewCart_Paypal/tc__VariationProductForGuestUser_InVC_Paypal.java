package com.GuestUserWith_ViewCart_Paypal;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.providio.commonfunctionality.Gc__CC_Paypal;
import com.providio.commonfunctionality.addtoCartValidation;
import com.providio.commonfunctionality.attributesSelection;
import com.providio.commonfunctionality.validatingInstock;
import com.providio.pageObjects.VariationProductFromExcel;
import com.providio.paymentProccess.tc__MinicartViewCartProcess;
import com.providio.paymentProccess.tc__MinicartViewCartProcessByPayPal;
import com.providio.testcases.baseClass;


public class tc__VariationProductForGuestUser_InVC_Paypal extends baseClass{
	SoftAssert softAssert = new SoftAssert();
	 
	 @Test
	public void variationProduct() throws InterruptedException {
		//launching the browser and passing the url into it
		 driver.get(baseURL);
		 logger.info("Entered into url");
		 logger.info("Placing the order as guest user");
		  
		 //searched for variation product
		 VariationProductFromExcel fromExcel = new VariationProductFromExcel();
		 fromExcel.performRandomOperations(driver);
		 logger.info("searched for Variation product");

		    attributesSelection.colorSelection();
   	    	Thread.sleep(3000);
   	    	//select the size
   	    	attributesSelection.sizeSelction();
   	    	Thread.sleep(3000);
   	        //validate the product is instock or not
   	    	validatingInstock.inStockValidation();

  		  
  		//validating the product is add to the cart
   	    addtoCartValidation.validatingProductisAddtoCart(driver);
   	    
      //paypal checkout form view cart page
 	    tc__MinicartViewCartProcessByPayPal paypal= new tc__MinicartViewCartProcessByPayPal();	         
 	    paypal.checkoutprocessFromViewCart();
	 }
}

