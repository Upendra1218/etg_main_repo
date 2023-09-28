package com.GuestUserWith_Checkout_Paypal;

import org.testng.asserts.SoftAssert;

import com.providio.commonfunctionality.addtoCartValidation;
import com.providio.commonfunctionality.allAttributesinOneFile;
import com.providio.commonfunctionality.validatingInstock;
import com.providio.pageObjects.ProductSetFromExcel;
import com.providio.pageObjects.SizeSelectionForProductSet;
import com.providio.paymentProccess.tc__MinicartViewCartProcess;
import com.providio.paymentProccess.tc__MinicartViewCartProcessByPayPal;
import com.providio.testcases.baseClass;
public class tc__ProductSetForGuestUser_InCheckoutPaypal extends baseClass{
	SoftAssert softAssert = new SoftAssert();
	 
	//@Test 
	public void productSet() throws InterruptedException {
		
            //launching the browser and passing the url into it
		 	driver.get(baseURL);
		 	logger.info("Entered into url");
		 	
		 	//searching the product set from excel sheet
			ProductSetFromExcel fromExcel= new ProductSetFromExcel();
			fromExcel.performRandomOperations(driver);	
			logger.info("Searched for a productset");
			
			
			//selecting size for product
			allAttributesinOneFile.allAttributes();
//			SizeSelectionForProductSet set =new SizeSelectionForProductSet();
//			set.sizeSelection(driver);
//			logger.info("Selected size and added to cart");
			
			//validating the product is instock and adding to the cart
			  validatingInstock.inStockValidation();
			  
			//validating the product is add to the cart
	 	    addtoCartValidation.validatingProductisAddtoCart(driver);
			
		    //checkoutProcess		        
				tc__MinicartViewCartProcess cp = new tc__MinicartViewCartProcess();	         
	            cp.checkoutprocess();
	            
	            
    		//paypal process from checkout page
    			 tc__MinicartViewCartProcessByPayPal cpp = new tc__MinicartViewCartProcessByPayPal();
    			 cpp.checkoutprocessFromCheckout();
	        } 
}

