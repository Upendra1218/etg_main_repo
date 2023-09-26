package com.RegUserWith_GcAndPaypal;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.providio.commonfunctionality.Gc__CC_Paypal;
import com.providio.commonfunctionality.addtoCartValidation;
import com.providio.commonfunctionality.attributesSelection;
import com.providio.commonfunctionality.validatingInstock;
import com.providio.pageObjects.VariationProductFromExcel;
import com.providio.paymentProccess.tc__MinicartViewCartProcess;
import com.providio.paymentProccess.tc__MinicartViewCartProcessByPayPal;
import com.providio.paymentProccess.tc__CreditCardPaymentProcess;
import com.providio.testcases.baseClass;


public class tc__VariationProductForReg_InGcAndPaypal extends baseClass{
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

