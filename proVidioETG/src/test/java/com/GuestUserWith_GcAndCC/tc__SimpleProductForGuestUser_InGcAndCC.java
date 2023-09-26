package com.GuestUserWith_GcAndCC;


import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.providio.commonfunctionality.Gc__CC_Paypal;
import com.providio.commonfunctionality.addtoCartValidation;
import com.providio.commonfunctionality.validatingInstock;
import com.providio.pageObjects.SimpleProductFromExcel;
import com.providio.pageObjects.productDescriptionPage;
import com.providio.paymentProccess.tc__MinicartViewCartProcess;
import com.providio.paymentProccess.tc__CreditCardPaymentProcess;
import com.providio.testcases.baseClass;


public class tc__SimpleProductForGuestUser_InGcAndCC extends baseClass{
	SoftAssert softAssert = new SoftAssert();
	 
	 @Test
	public void simpleProduct() throws InterruptedException {
		 
		// enters into url
	      driver.get(baseURL);		      
        logger.info("enterd into url");	

		 //adding simple product into cart
		 SimpleProductFromExcel  simpleProduct = new SimpleProductFromExcel();	
		 simpleProduct.performRandomOperations(driver);
		 test.info("Searched for  simple product");
		 
		//validating the product is instock and adding to the cart
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

