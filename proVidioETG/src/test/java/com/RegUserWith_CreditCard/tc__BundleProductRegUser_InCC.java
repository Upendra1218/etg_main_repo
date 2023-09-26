package com.RegUserWith_CreditCard;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.providio.commonfunctionality.addtoCartValidation;
import com.providio.commonfunctionality.validatingInstock;
import com.providio.pageObjects.BundleProductFromEXcel;
import com.providio.paymentProccess.tc__MinicartViewCartProcess;
import com.providio.paymentProccess.tc__CreditCardPaymentProcess;
import com.providio.testcases.baseClass;


public class tc__BundleProductRegUser_InCC extends baseClass{
	SoftAssert softAssert = new SoftAssert();
	int  minicartCountValue;
	 @Test(dependsOnMethods = {"com.providio.testcases.tc__LoginSc.verifySuccessfulLogin"}, alwaysRun = true)
	public void bundleProduct() throws InterruptedException {
		
	if(isLoggedIn) {
		//searching the bundle product from excel sheet
		 BundleProductFromEXcel bundleProduct = new  BundleProductFromEXcel();
		 bundleProduct.performRandomOperations(driver);
		 logger.info("Searched a product");
		 
	        //validate the product is instock or not
	    	validatingInstock.inStockValidation();
	    	
	    	//validating the product is add to the cart
	    	addtoCartValidation.validatingProductisAddtoCart(driver);
		 	 //common checkout process
             tc__MinicartViewCartProcess cp = new tc__MinicartViewCartProcess();        
             cp.checkoutprocess();
             
             //payment process             
		     tc__CreditCardPaymentProcess cc = new tc__CreditCardPaymentProcess();		     
		     cc.paymentByCreditCard();

	 } else {
	        Assert.fail("User not logged in");
	    }
	 }
}

