package com.RegUserWith_CreditCard;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.providio.commonfunctionality.addtoCartValidation;
import com.providio.commonfunctionality.validatingInstock;
import com.providio.pageObjects.BundleProductFromEXcel;
import com.providio.pageObjects.GiftCertificate;
import com.providio.pageObjects.SimpleProductFromExcel;
import com.providio.paymentProccess.tc__MinicartViewCartProcess;
import com.providio.paymentProccess.tc__CreditCardPaymentProcess;
import com.providio.testcases.baseClass;

public class tc__SimpleProductsAndBundle_Gc_InCC extends baseClass {
	 
	@Test(dependsOnMethods = {"com.providio.testcases.tc__LoginSc.verifySuccessfulLogin"}, alwaysRun = true)
	public void simpleProducts_Bundle_Gc() throws InterruptedException {
		
		if(isLoggedIn) {

	 		 //adding simple product into cart
			 SimpleProductFromExcel  simpleProduct = new SimpleProductFromExcel();	
			 simpleProduct.performRandomOperations(driver);
			 test.info("Searched for  simple product");
			 
			//validating the product is instock and adding to the cart
			  validatingInstock.inStockValidation();
			  
			//validating the product is add to the cart
		    addtoCartValidation.validatingProductisAddtoCart(driver);
			 
			 //adding GC into cart
			 for(int i=1; i<=1;i++) {
				 GiftCertificate gc= new  GiftCertificate(driver);
				 gc.clickOnGiftCard(driver);
				 test.info("Gift card added to cart");
			 }
		
		 //checkoutProcess				        
	     tc__MinicartViewCartProcess cp = new tc__MinicartViewCartProcess();				     
	     cp.checkoutprocess();
	     
	     //credit card
		 tc__CreditCardPaymentProcess cc = new tc__CreditCardPaymentProcess();			     
		 cc.paymentByCreditCard();
		}else {
		        Assert.fail("User not logged in");
		    }
		}
}
