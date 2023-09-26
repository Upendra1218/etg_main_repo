package com.RegUserWith_ViewCart_Paypal;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.providio.commonfunctionality.addtoCartValidation;
import com.providio.commonfunctionality.attributesSelection;
import com.providio.commonfunctionality.validatingInstock;
import com.providio.pageObjects.SizeSelectioForVariation;
import com.providio.pageObjects.VariationProductFromExcel;
import com.providio.paymentProccess.tc__MinicartViewCartProcess;
import com.providio.paymentProccess.tc__MinicartViewCartProcessByPayPal;
import com.providio.paymentProccess.tc__CreditCardPaymentProcess;
import com.providio.testcases.baseClass;


public class tc__VariationProductReg_InVC_Paypal extends baseClass{
	SoftAssert softAssert = new SoftAssert();
	  
	 @Test(dependsOnMethods = {"com.providio.testcases.tc__LoginSc.verifySuccessfulLogin"}, alwaysRun = true)
	public void variationProduct() throws InterruptedException {
		 
		 if(isLoggedIn) {

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
		 }else {
		        Assert.fail("User not logged in");
		    }
	 }
}

