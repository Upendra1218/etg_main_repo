package com.RegUserWith_GcAndPaypal;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.providio.commonfunctionality.Gc__CC_Paypal;
import com.providio.commonfunctionality.addtoCartValidation;
import com.providio.commonfunctionality.validatingInstock;
import com.providio.pageObjects.ProductSetFromExcel;
import com.providio.pageObjects.SizeSelectionForProductSet;
import com.providio.paymentProccess.tc__MinicartViewCartProcess;
import com.providio.paymentProccess.tc__MinicartViewCartProcessByPayPal;
import com.providio.paymentProccess.tc__CreditCardPaymentProcess;
import com.providio.testcases.baseClass;
public class tc__ProductSetForReg_InGcAndPaypal extends baseClass{
	SoftAssert softAssert = new SoftAssert();
	 
	 @Test(dependsOnMethods = {"com.providio.testcases.tc__LoginSc.verifySuccessfulLogin"}, alwaysRun = true)
	public void productSet() throws InterruptedException {

		 if(isLoggedIn) {     
			 	//searching the product set from excel sheet
				ProductSetFromExcel fromExcel= new ProductSetFromExcel();
				fromExcel.performRandomOperations(driver);	
				logger.info("Searched for a productset");
				
				
				//selecting size for product
				SizeSelectionForProductSet set =new SizeSelectionForProductSet();
				set.sizeSelection(driver);
				logger.info("Selected size and added to cart");
				
				//validating the product is instock and adding to the cart
				  validatingInstock.inStockValidation();
				  
				//validating the product is add to the cart
		 	    addtoCartValidation.validatingProductisAddtoCart(driver);
		 	    
		    //checkoutProcess		        
				tc__MinicartViewCartProcess cp = new tc__MinicartViewCartProcess();	         
	            cp.checkoutprocess();
	            
	          //gc and paypal
				  Gc__CC_Paypal gcAndPaypal = new Gc__CC_Paypal();
				  gcAndPaypal.paymentProccessByGCandPaypal();
		 }else {
		   	 Assert.fail("User not logged in");
		   }
	        } 
}

