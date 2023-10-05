package com.GuestUserWith_CreditCard;

import org.testng.asserts.SoftAssert;

import com.providio.commonfunctionality.addtoCartValidation;
import com.providio.commonfunctionality.validatingInstock;
import com.providio.pageObjects.ProductSetFromExcel;
  
import com.providio.paymentProccess.tc__MinicartViewCartProcess;
import com.providio.paymentProccess.tc__CreditCardPaymentProcess;
import com.providio.testcases.baseClass;
public class tc__ProductSetForGuestUser_InCC extends baseClass{
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
//	      SizeSelectionForProductSet set =new SizeSelectionForProductSet();
//		  set.sizeSelection(driver);
//		logger.info("Selected size and added to cart");
		
		//validating the product is instock and adding to the cart
		  validatingInstock.inStockValidation();
		  
		//validating the product is add to the cart
 	    addtoCartValidation.validatingProductisAddtoCart(driver);
 	    
		    //checkoutProcess		        
				tc__MinicartViewCartProcess cp = new tc__MinicartViewCartProcess();	         
	            cp.checkoutprocess();
	            
            //payment process             
		     tc__CreditCardPaymentProcess cc = new tc__CreditCardPaymentProcess();		     
		     cc.paymentByCreditCard();

	        } 
}

