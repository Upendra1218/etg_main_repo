package com.providio.Validations;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.providio.pageObjects.homePage;
import com.providio.pageObjects.productDescriptionPage;
import com.providio.pageObjects.productListingPage;
import com.providio.testcases.baseClass;

public class preValidationCheck extends baseClass{
	
	public static void prevalidationHome() throws InterruptedException {
		
		//validation 
		homePage hm = new homePage(driver);
		//menus
		hm.menus(driver);
		//logo
		hm.logo(driver);
		//search
		hm.search(driver);
		//mini cart
		hm.minicart(driver);
		//wishlist 
		hm.wishlist(driver);
		//profile
		hm.profile(driver);
		//footer
		hm.footer(driver);
		
	}
	
	public static void prevalidationPLP() throws InterruptedException {
		productListingPage plp = new productListingPage(driver);
		//Name
		plp.name(driver);
		//BreadCreamps
		plp.BreadCramps(driver);
		//filters
		plp.Filters(driver);
		//products
		plp.Products(driver);

	}
	
	public static void preValidationPDP() {
		productDescriptionPage pdp = new productDescriptionPage(driver);
		
		//product name
		pdp.productNameValidation(driver);
		//prouct Image
		pdp.productImageValidation(driver);
		//Addtocart button
		pdp.productAddtocartButtonValidation(driver);
		//review button
		pdp.productReviewLinkValidation(driver);
		//Details 
		pdp.productSepecificationsValidation(driver);
	}
	
	//validate the payment page
		public static void validatePaymentButtonClk() {
			
			//validate the payment page
		    WebElement paymentPage = driver.findElement(By.xpath("//label[contains(text(), 'Payment Method')]"));
		    if( paymentPage.isDisplayed()) {
			    String ActualTitleofpaymentPage = paymentPage.getText();
			    String ExpectedTitlepaymentPage = "Payment Method";
			    logger.info(paymentPage.getText());
			    
			    if (ActualTitleofpaymentPage.equals(ExpectedTitlepaymentPage)) {
			    	test.info("Verify that shipping address added");
			    	 test.pass("Successfully added the shipping address");
			    	 test.info("Verify the payment button is clicked");
			        test.pass("Successfully clicked on the Payment button");
			        logger.info("Successfully clicked on the Payment button");
			    } else {
			        test.fail( "The page Title does not match expected " + ExpectedTitlepaymentPage + " " + "  but found" + " " + ActualTitleofpaymentPage + " ");
			        logger.info("Click failed");
			    }
		    }
		    
		//  //soft assertions payment page
		//  
		//  softAssert.assertEquals(ActualTitleofpaymentPage, ExpectedTitlepaymentPage, "Page title does not match expected value");
		//  
		//  //Hard assertions payment page
		//  
		//  Assert.assertEquals(ActualTitleofpaymentPage, ExpectedTitlepaymentPage, "Page title does not match expected value");
		
		   
			
		}
	
}
