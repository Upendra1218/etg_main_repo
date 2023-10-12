

package com.RegUserWith_CreditCard;

import com.providio.Scenarios.SearchingProduct;
import com.providio.paymentProccess.MinicartViewCartProcess;
import com.providio.paymentProccess.CreditCardPaymentProcess;
import com.providio.testcases.baseClass;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class tc__BySearchingProduct_RegUser_InCC extends baseClass {
	 
	SoftAssert softAssert = new SoftAssert();

	@Test(dependsOnMethods = {"com.providio.testcases.tc__LoginSc.verifySuccessfulLogin"}, alwaysRun = true)
    public void bySearchingProduct() throws InterruptedException {
		if(isLoggedIn) {
			
			//searching a product 
			SearchingProduct sp = new SearchingProduct();
			sp.searchingProduct();
		        
	       //checkoutProcess	        
            MinicartViewCartProcess cp = new MinicartViewCartProcess();            
            cp.checkoutprocess();
            
            //payment by credit card
		     CreditCardPaymentProcess cc = new CreditCardPaymentProcess();	     
		     cc.paymentByCreditCard();
		} else {
	        Assert.fail("User not logged in");
	    }
	 
    }
}