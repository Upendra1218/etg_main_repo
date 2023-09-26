package com.GuestUserWith_Checkout_Paypal;

import org.testng.annotations.Test;

import com.providio.pageObjects.GiftCertificate;
import com.providio.paymentProccess.tc__MinicartViewCartProcess;
import com.providio.paymentProccess.tc__MinicartViewCartProcessByPayPal;
import com.providio.testcases.baseClass;

public class tc__OnlyGiftCards extends baseClass{
	int minicartCountValue ;
	@Test
	public void OnlyGiftCards() throws InterruptedException {
		 driver.get(baseURL);
		 logger.info("Entered into url");
		 logger.info("Placing the order as guest user");
		 
		 
		 //gift certificates adding to the cart
		 for(int i=1; i<=1;i++) {
			 GiftCertificate gc= new  GiftCertificate(driver);
			 gc.clickOnGiftCard(driver);
			 test.info("Gift card added to cart");
		 }
		
		 //checkoutProcess
		 tc__MinicartViewCartProcess cp = new tc__MinicartViewCartProcess();				     
	     cp.checkoutprocess();
			     
	    //paypal process from checkout page
		 tc__MinicartViewCartProcessByPayPal cpp = new tc__MinicartViewCartProcessByPayPal();
		 cpp.checkoutprocessFromCheckout();
	}
}
