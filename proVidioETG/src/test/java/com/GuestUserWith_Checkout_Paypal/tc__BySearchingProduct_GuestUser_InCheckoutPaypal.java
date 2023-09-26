

package com.GuestUserWith_Checkout_Paypal;

import com.providio.commonfunctionality.addtoCartValidation;
import com.providio.commonfunctionality.size;
import com.providio.pageObjects.homePage;
import com.providio.paymentProccess.tc__MinicartViewCartProcess;
import com.providio.paymentProccess.tc__MinicartViewCartProcessByPayPal;
import com.providio.testcases.baseClass;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class tc__BySearchingProduct_GuestUser_InCheckoutPaypal extends baseClass {
	 
	SoftAssert softAssert = new SoftAssert();

	@Test//(dependsOnMethods = {"com.providio.testcases.tc__LoginSc.verifySuccessfulLogin"}, alwaysRun = true)
    public void bySearchingProduct() throws InterruptedException {
		    //step2 1: site url
		    //launching the browser and passing the url into it
			 driver.get(baseURL); 
			 logger.info("Entered into url");
			 logger.info("Placing the order as guest user");
			
        	//searching a product 
            homePage homepage = new homePage(driver);
            homepage.clickOnSearchBar(this.searchBar);
            test.info("searched a product " + this.searchBar);
            
            //clicked on searched product
            homepage.clickOnSearchedProduct();
            test.info("clicked on searched product");
        
			
			 List<WebElement> pdpPage = driver.findElements(By.xpath("//button[contains(@class,'add-to-cart btn btn-primary')]"));
    		 if( pdpPage.size()>0) {
		          size s = new size();
		          s.selectSize(driver);
    		 }
   		  
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