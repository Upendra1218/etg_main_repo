

package com.RegUserWith_GcAndPaypal;

import com.providio.commonfunctionality.Gc__CC_Paypal;
import com.providio.commonfunctionality.addtoCartValidation;
import com.providio.commonfunctionality.size;
import com.providio.pageObjects.homePage;
import com.providio.pageObjects.productDescriptionPage;
import com.providio.paymentProccess.tc__MinicartViewCartProcess;
import com.providio.paymentProccess.tc__MinicartViewCartProcessByPayPal;
import com.providio.paymentProccess.tc__CreditCardPaymentProcess;
import com.providio.testcases.baseClass;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class tc__BySearchingProduct_Reg_InGcAndPaypal extends baseClass {
	 
	SoftAssert softAssert = new SoftAssert();

	@Test(dependsOnMethods = {"com.providio.testcases.tc__LoginSc.verifySuccessfulLogin"}, alwaysRun = true)
    public void bySearchingProduct() throws InterruptedException {

		if(isLoggedIn) {      
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
    	    
		      //gc and paypal
				  Gc__CC_Paypal gcAndPaypal = new Gc__CC_Paypal();
				  gcAndPaypal.paymentProccessByGCandPaypal();
		 }else {
		   	 Assert.fail("User not logged in");
		   }
    }
}