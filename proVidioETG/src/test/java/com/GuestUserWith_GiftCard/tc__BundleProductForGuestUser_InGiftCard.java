package com.GuestUserWith_GiftCard;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.providio.Scenarios.BundleProduct;
import com.providio.commonfunctionality.Gc__CC_Paypal;
import com.providio.commonfunctionality.addtoCartValidation;
import com.providio.commonfunctionality.validatingInstock;
import com.providio.launchingbrowser.launchBrowsering;
import com.providio.pageObjects.BundleProductFromEXcel;
import com.providio.paymentProccess.tc__MinicartViewCartProcess;
import com.providio.testcases.baseClass;

public class tc__BundleProductForGuestUser_InGiftCard  extends baseClass{
	 
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
			  tc__MinicartViewCartProcess cp = new tc__MinicartViewCartProcess();	         
              cp.checkoutprocess();
              
             //gc payment 
			   Gc__CC_Paypal gc = new Gc__CC_Paypal ();
			   gc.paymentByGiftCard();
			   
				}	 
}
