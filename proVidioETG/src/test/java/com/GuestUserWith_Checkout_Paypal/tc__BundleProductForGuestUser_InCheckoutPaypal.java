package com.GuestUserWith_Checkout_Paypal;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.providio.Scenarios.BundleProduct;
import com.providio.commonfunctionality.addtoCartValidation;
import com.providio.commonfunctionality.validatingInstock;
import com.providio.launchingbrowser.launchBrowsering;
import com.providio.pageObjects.BundleProductFromEXcel;
import com.providio.paymentProccess.tc__MinicartViewCartProcessByPayPal;
import com.providio.paymentProccess.tc__MiniCartChekoutButton;
import com.providio.testcases.baseClass;

public class tc__BundleProductForGuestUser_InCheckoutPaypal  extends baseClass{
	
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
              
              
      		//paypal process from checkout page
  		   tc__MinicartViewCartProcessByPayPal cpp = new tc__MinicartViewCartProcessByPayPal();
  		   cpp.checkoutprocessFromCheckout();
      		   
		}	 
}
