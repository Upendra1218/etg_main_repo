package com.GuestUserWith_GcAndCC;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.providio.commonfunctionality.Gc__CC_Paypal;
import com.providio.pageObjects.BundleProductFromEXcel;
import com.providio.pageObjects.bundleProductAddAllToCart;
import com.providio.paymentProccess.tc__MinicartViewCartProcess;
import com.providio.paymentProccess.tc__CreditCardPaymentProcess;
import com.providio.testcases.baseClass;

public class tc__BundleProductForGuestUser_InGcAndCc  extends baseClass{
	int minicartCountValue;
		SoftAssert softAssert = new SoftAssert();

		 @Test
		public void bundleProduct() throws InterruptedException {

			 driver.get(baseURL);
			 logger.info("Entered into url");
			 logger.info("Placing the order as guest user");
			 
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
	            
			 //searching the bundle product from excel sheet
			 BundleProductFromEXcel bundleProduct = new  BundleProductFromEXcel();
			 bundleProduct.performRandomOperations(driver);
			 logger.info("Searched a product");

			  // cart count after adding the product		 
	            WebElement minicartcountafteradding =driver.findElement(By.cssSelector(".minicart-quantity"));
	            String countOfMinicartafteradding = minicartcountafteradding.getText();
	            int minicartCountValueafteradding = Integer.parseInt(countOfMinicartafteradding);

	            logger.info("The minicart count after adding the product is"+minicartCountValueafteradding);

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
			  tc__MinicartViewCartProcess cp = new tc__MinicartViewCartProcess();	         
              cp.checkoutprocess();
              
            //semi gc and cc 
			  Gc__CC_Paypal gCandCC = new Gc__CC_Paypal();
			  gCandCC.paymentProccessByGCandCC(driver);
			  
		}	 
}
