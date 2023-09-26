package com.GuestUserWith_GcAndPaypal;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.providio.Validations.preValidationCheck;
import com.providio.commonfunctionality.Gc__CC_Paypal;
import com.providio.commonfunctionality.addtoCartValidation;
import com.providio.commonfunctionality.validatingInstock;
import com.providio.pageObjects.BundleProductFromEXcel;
import com.providio.pageObjects.GiftCertificate;
import com.providio.pageObjects.SimpleProductFromExcel;
import com.providio.paymentProccess.tc__MinicartViewCartProcess;
import com.providio.paymentProccess.tc__MinicartViewCartProcessByPayPal;
import com.providio.testcases.baseClass;

public class tc__Bundle_GcAndAllPromotions_Guest_InGCAndPaypal extends baseClass{
	 
	@Test
	public void bundle_GcAndAllPromotions() throws InterruptedException {
		
		//launching the browser and passing the url into it
		 driver.get(baseURL);
		 logger.info("Entered into url");
		 logger.info("Placing the order as guest user");
		 
	    //validation Home page
	    preValidationCheck.prevalidationHome();
	 
		 //searching the bundle product from excel sheet
		 BundleProductFromEXcel bundleProduct = new  BundleProductFromEXcel();
		 bundleProduct.performRandomOperations(driver);
		 logger.info("Searched bundle  product");
		 
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
		 Thread.sleep(2000);
		 
		 
		 //all promtions applied to a simple product
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
	
		 
	}
}
