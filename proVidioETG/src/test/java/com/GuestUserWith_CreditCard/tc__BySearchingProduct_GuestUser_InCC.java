

package com.GuestUserWith_CreditCard;

import com.providio.Scenarios.SearchingProduct;
import com.providio.Validations.validationpopupMessages;
import com.providio.launchingbrowser.launchBrowsering;
import com.providio.paymentProccess.MinicartViewCartProcess;
import com.providio.paymentProccess.CreditCardPaymentProcess;
import com.providio.testcases.baseClass;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class tc__BySearchingProduct_GuestUser_InCC extends baseClass {
	 
	SoftAssert softAssert = new SoftAssert();

	@Test//(dependsOnMethods = {"com.providio.testcases.tc__LoginSc.verifySuccessfulLogin"}, alwaysRun = true)
    public void bySearchingProduct() throws InterruptedException {
		
		//launching the browser and passing the url into it
		launchBrowsering lb = new launchBrowsering();
		lb.chromeBrowser();
			
        //searching a product 
		
		SearchingProduct sp = new SearchingProduct();
		sp.searchingProduct();

		  
	   //validating the product is add to the cart
       validationpopupMessages.validatingProductisAddtoCart(driver);
	        
       //checkoutProcess	        
        MinicartViewCartProcess cp = new MinicartViewCartProcess();            
        cp.checkoutprocess();
        
        //payment by credit card
	     CreditCardPaymentProcess cc = new CreditCardPaymentProcess();	     
	     cc.paymentByCreditCard();
    }
}