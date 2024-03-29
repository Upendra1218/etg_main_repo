package com.RegUserWith_Checkout_Paypal;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.providio.pageObjects.GiftCertificate;
import com.providio.paymentProccess.MinicartViewCartProcess;
import com.providio.paymentProccess.MinicartViewCartProcessByPayPal;
import com.providio.testcases.baseClass;

public class tc__OnlyGiftCards_Checkout_Paypal extends baseClass{
	int minicartCountValue ;
	@Test(dependsOnMethods = {"com.providio.testcases.tc__LoginSc.verifySuccessfulLogin"}, alwaysRun = true)
	public void OnlyGiftCards() throws InterruptedException {
		if(isLoggedIn) {     
		 
		 //count of cart before adding the product
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
		 
		 for(int i=1; i<=1;i++) {
			 GiftCertificate gc= new  GiftCertificate(driver);
			 gc.clickOnGiftCard(driver);
			 test.info("Gift card added to cart");
		 }
		// minicart count after adding products
				 if(minicartcountList.size()>0) {
		          WebElement minicartcountafteradding = driver.findElement(By.xpath("//span[@class ='minicart-quantity ml-1']"));
		          String countOfMinicartafteradding = minicartcountafteradding.getText();
		          int minicartCountValueafteradding = Integer.parseInt(countOfMinicartafteradding);

			      logger.info("The minicart count after adding the product is "+minicartCountValueafteradding);

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
				 MinicartViewCartProcess cp = new MinicartViewCartProcess();				     
			     cp.checkoutprocess();
			     
			    //paypal process from checkout page
				 MinicartViewCartProcessByPayPal cpp = new MinicartViewCartProcessByPayPal();
				 cpp.checkoutprocessFromCheckout();
		}else {
		   	 Assert.fail("User not logged in");
		   }
	}
}
