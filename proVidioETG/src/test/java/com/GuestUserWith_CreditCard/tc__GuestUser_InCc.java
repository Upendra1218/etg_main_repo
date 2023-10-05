

package com.GuestUserWith_CreditCard;

import com.providio.commonfunctionality.selectAProduct;
import com.providio.commonfunctionality.size;
import com.providio.pageObjects.navigationPage;
import com.providio.pageObjects.productDescriptionPage;
import com.providio.pageObjects.productListingPage;
import com.providio.paymentProccess.tc__MinicartViewCartProcess;
import com.providio.paymentProccess.tc__CreditCardPaymentProcess;
import com.providio.testcases.baseClass;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class tc__GuestUser_InCc extends baseClass {
	SoftAssert softAssert = new SoftAssert();
	  

    @Test
    public void guestlogin() throws InterruptedException {
    	
    	//select a random product
    	selectAProduct.AddingAProductToCart();
    	
        //check out process
	     tc__MinicartViewCartProcess cp = new tc__MinicartViewCartProcess();			     
	     cp.checkoutprocess();
	     
	     //Payment process		     
	     tc__CreditCardPaymentProcess cc = new tc__CreditCardPaymentProcess();			     
	     cc.paymentByCreditCard();
    }
}