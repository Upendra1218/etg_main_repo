package com.providio.testcases;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.providio.pageObjects.homePage;
import com.providio.paymentProccess.tc__CreditCardPaymentProcess;
import com.providio.paymentProccess.tc__MinicartViewCartProcess;

public class tc__WishListtoAddtoCart extends baseClass {
	
	SoftAssert softAssert = new SoftAssert();

	@Test(dependsOnMethods = {"com.providio.login.tc__Login.loginTest"}, alwaysRun = true)
    public void wishListtoCart() throws InterruptedException {

    	tc__WishlistProccess wsh = new tc__WishlistProccess();
    	
    	wsh.wishlistPage(driver);
    	
        //checkout process
    	Thread.sleep(5000);
    	
    	tc__MinicartViewCartProcess cp = new tc__MinicartViewCartProcess();
        
        cp.checkoutprocess();
        
        //payment process
        
        tc__CreditCardPaymentProcess cc = new tc__CreditCardPaymentProcess();
        
        cc.paymentByCreditCard(); 
    	
    }
	
}