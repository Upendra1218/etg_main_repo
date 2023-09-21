package com.GuestUserWith_ViewCart_Paypal;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.providio.commonfunctionality.Gc__CC_Paypal;
import com.providio.pageObjects.VariationProductFromExcel;
import com.providio.paymentProccess.tc__MinicartViewCartProcess;
import com.providio.paymentProccess.tc__MinicartViewCartProcessByPayPal;
import com.providio.testcases.baseClass;


public class tc__VariationProductForGuestUser_InVC_Paypal extends baseClass{
	SoftAssert softAssert = new SoftAssert();
	int minicartCountValue;
	 @Test
	public void variationProduct() throws InterruptedException {
		 
			 driver.get(baseURL);
			 logger.info("Entered into url");
			 
			 
				//minicart count
				//The cart value before adding the product to cart			
				  Thread.sleep(2000);
		    		 List<WebElement> minicartcountList = driver.findElements(By.cssSelector(".minicart-quantity"));
		    		 if(minicartcountList.size()>0) {
		    			 WebElement minicartcount = driver.findElement(By.cssSelector(".minicart-quantity"));
		    			 String countOfMinicart = minicartcount.getText();

		             // Check if the string is not empty and contains only digits
		             if (!countOfMinicart.isEmpty() && countOfMinicart.matches("\\d+")) {
		                minicartCountValue = Integer.parseInt(countOfMinicart);
		                 System.out.println("The minicart count before adding the product is " + minicartCountValue);    		
		              }
		    		 }
	         
			 //searched for variation product
			 VariationProductFromExcel fromExcel = new VariationProductFromExcel();
			 fromExcel.performRandomOperations(driver);
			 test.info("searched for Variation product");

			
			 if(minicartcountList.size()>0) {
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
	        
	    		 }
			
 
		      //paypal checkout form view cart page
		 	    tc__MinicartViewCartProcessByPayPal paypal= new tc__MinicartViewCartProcessByPayPal();	         
		 	    paypal.checkoutprocessFromViewCart();
	 }
}

