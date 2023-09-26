package com.RegUserWith_GcAndPaypal;


import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.providio.commonfunctionality.Gc__CC_Paypal;
import com.providio.commonfunctionality.addtoCartValidation;
import com.providio.commonfunctionality.validatingInstock;
import com.providio.pageObjects.SimpleProductFromExcel;
import com.providio.paymentProccess.tc__MinicartViewCartProcess;
import com.providio.paymentProccess.tc__MinicartViewCartProcessByPayPal;
import com.providio.testcases.baseClass;


public class tc__SimpleProductForReg_InGcAndPaypal extends baseClass{
	SoftAssert softAssert = new SoftAssert();
	 
	 @Test(dependsOnMethods = {"com.providio.testcases.tc__LoginSc.verifySuccessfulLogin"}, alwaysRun = true)
	public void simpleProduct() throws InterruptedException {
		 

			if(isLoggedIn) {      

				driver.get(baseURL);
				 logger.info("Entered into url");
				 
			 	 //Search for simple product and select the product
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
           
	        
	      //gc and paypal
			  Gc__CC_Paypal gcAndPaypal = new Gc__CC_Paypal();
			  gcAndPaypal.paymentProccessByGCandPaypal();
			 }else {
			   	 Assert.fail("User not logged in");
			   }
	        } 
}

