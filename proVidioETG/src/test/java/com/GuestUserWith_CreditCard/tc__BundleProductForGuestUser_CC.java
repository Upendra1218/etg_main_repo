package com.GuestUserWith_CreditCard;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.providio.Scenarios.BundleProduct;
import com.providio.launchingbrowser.launchBrowsering;
import com.providio.paymentProccess.tc__CreditCardPaymentProcess;
import com.providio.paymentProccess.tc__MiniCartChekoutButton;
import com.providio.testcases.baseClass;

public class tc__BundleProductForGuestUser_CC  extends baseClass{
	
		SoftAssert softAssert = new SoftAssert();

		 @Test
		public void bundleProduct() throws InterruptedException {
			 
			//launching the browser and passing the url into it
			launchBrowsering lb = new launchBrowsering();
			lb.chromeBrowser();
			 
			 //searching the bundle product from excel sheet
		    BundleProduct bp = new BundleProduct();
		    bp.bundleproduct();
				
	         //checkoutProcess		        
	        tc__MiniCartChekoutButton cp = new tc__MiniCartChekoutButton();         
			cp.checkoutprocess();
      
		 //payment process
          tc__CreditCardPaymentProcess tc = new tc__CreditCardPaymentProcess();			              
          tc.paymentByCreditCard();
              
		}

		 
}
