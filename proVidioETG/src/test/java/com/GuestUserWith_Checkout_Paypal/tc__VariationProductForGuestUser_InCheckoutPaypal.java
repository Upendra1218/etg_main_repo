package com.GuestUserWith_Checkout_Paypal;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.providio.commonfunctionality.attributesSelection;
import com.providio.commonfunctionality.validatingInstock;
import com.providio.pageObjects.VariationProductFromExcel;
import com.providio.paymentProccess.tc__CheckOutProcess;
import com.providio.paymentProccess.tc__CheckOutProcessByPayPal;
import com.providio.paymentProccess.tc__CreditCardPaymentProcess;
import com.providio.testcases.baseClass;


public class tc__VariationProductForGuestUser_InCheckoutPaypal extends baseClass{
	SoftAssert softAssert = new SoftAssert();
	int minicartCountValue;
	 @Test
	public void variationProduct() throws InterruptedException {
		 
		 driver.get(baseURL);
		 logger.info("Entered into url");
		 
		 
		 Thread.sleep(2000);
		 WebElement minicartcount = driver.findElement(By.xpath("//span[@class ='minicart-quantity ml-1']"));
         String countOfMinicart = minicartcount.getText();
         int minicartCountValue = Integer.parseInt(countOfMinicart);	        
         logger.info(minicartCountValue);
          
		 //searched for variation product
		 VariationProductFromExcel fromExcel = new VariationProductFromExcel();
		 fromExcel.performRandomOperations(driver);
		 logger.info("searched for Variation product");

		    attributesSelection.colorSelection();
   	    	Thread.sleep(3000);
   	    	//select the size
   	    	attributesSelection.sizeSelction();
   	    	Thread.sleep(3000);
   	        //validate the product is instock or not
   	    	validatingInstock.inStockValidation();
   	    	
   	    	
		Thread.sleep(3000);
		 
		 WebElement minicartcountafteradding = driver.findElement(By.xpath("//span[@class ='minicart-quantity ml-1']"));
         String countOfMinicartafteradding = minicartcountafteradding.getText();
         int minicartCountValueafteradding = Integer.parseInt(countOfMinicartafteradding);	        
         logger.info(minicartCountValueafteradding);

		//validation for product add to cart
		test.info("Verifying the product is added to cart or not ");

		if( minicartCountValueafteradding!= minicartCountValue) {
			test.pass("Product added to cart");
			logger.info("Product is  added to cart");
		}else {
			test.fail("Product is not added to cart");
			logger.info("Product is not added to cart");
		}
			
		     //checkoutProcess	        
				tc__CheckOutProcess cp = new tc__CheckOutProcess();         
				cp.checkoutprocess();

				//paypal process from checkout page
				tc__CheckOutProcessByPayPal cpp = new tc__CheckOutProcessByPayPal();
				cpp.checkoutprocessFromCheckout();
	 }
}

