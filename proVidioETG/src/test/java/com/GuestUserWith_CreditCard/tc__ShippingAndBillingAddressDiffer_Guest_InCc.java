package com.GuestUserWith_CreditCard;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.providio.commonfunctionality.addtoCartValidation;
import com.providio.commonfunctionality.validatingInstock;
import com.providio.pageObjects.BundleProductFromEXcel;
import com.providio.pageObjects.GiftCertificate;
import com.providio.pageObjects.SimpleProductFromExcel;
import com.providio.pageObjects.checkOutPage;
import com.providio.paymentProccess.tc__MinicartViewCartProcess;
import com.providio.paymentProccess.tc__CreditCardPaymentProcess;
import com.providio.testcases.baseClass;

public class tc__ShippingAndBillingAddressDiffer_Guest_InCc extends baseClass{
	 
	@Test
	public void shippingAndBillingAddressDiffer_Guest() throws InterruptedException {
		
		//launching the browser and passing the url into it
		 driver.get(baseURL);
		 logger.info("Entered into url");
		 logger.info("Placing the order as guest user");
		 
		//searching the bundle product from excel sheet
		 BundleProductFromEXcel bundleProduct = new  BundleProductFromEXcel();
		 bundleProduct.performRandomOperations(driver);
		 logger.info("Searched bundle  product");
		 
		 //validating the product is instock and adding to the cart
		  validatingInstock.inStockValidation();
		  
		//validating the product is add to the cart
	    addtoCartValidation.validatingProductisAddtoCart(driver);
		  
		 
		 //adding GC into cart
		 for(int i=1; i<=1;i++) {
			 GiftCertificate gc= new  GiftCertificate(driver);
			 gc.clickOnGiftCard(driver);
			 test.info("Gift card added to cart");
		 }
		 Thread.sleep(2000);
		 
		 
		 //all promtions applied to a simple product
		 SimpleProductFromExcel  simpleProduct = new SimpleProductFromExcel();	
		 simpleProduct.performRandomOperations(driver);
		 test.info("Searched for  simple product");
		 
		//validating the product is instock and adding to the cart
		  validatingInstock.inStockValidation();
		  
		//validating the product is add to the cart
	    addtoCartValidation.validatingProductisAddtoCart(driver);
		 
		   //checkoutProcess	        
         tc__MinicartViewCartProcess cp1 = new tc__MinicartViewCartProcess();            
         cp1.checkoutprocess();
         
         //changing the billing address
	     List<WebElement> billingAddress = driver.findElements(By.xpath("//label[contains(text(),'Billing Address')]"));
	     if(billingAddress.size()>0) {
	    	 WebElement addNewAddress = driver.findElement(By.xpath("(//button[contains(@class,'btn-add-new')])[3]"));
	    	 addNewAddress.click();
	    	  tc__MinicartViewCartProcess checkoutProcess = new tc__MinicartViewCartProcess();
	    	  checkOutPage cp = new checkOutPage(driver);
	          // Assuming 'cp' is an instance of the 'checkOutPage' class
	          //checkoutProcess.selectBillingAddress(cp);
	     }
       
	     //Payment process		     
	     tc__CreditCardPaymentProcess cc = new tc__CreditCardPaymentProcess();			     
	     cc.paymentByCreditCard();
	}
	
}
