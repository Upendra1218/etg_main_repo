package com.providio.Scenarios;

import com.providio.pageObjects.GiftCertificate;
import com.providio.testcases.baseClass;

public class GiftCard extends baseClass{
	
	public void giftCards() throws InterruptedException {
		 
		 //gift certificates adding to the cart
		 for(int i=1; i<=1;i++) {
			 GiftCertificate gc= new  GiftCertificate(driver);
			 gc.clickOnGiftCard(driver);
			 test.info("Gift card added to cart");
		 }
	}

}
