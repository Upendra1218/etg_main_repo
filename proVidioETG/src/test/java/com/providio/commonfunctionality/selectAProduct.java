package com.providio.commonfunctionality;

import com.providio.Validations.preValidationCheck;
import com.providio.launchingbrowser.launchBrowsering;
import com.providio.pageObjects.navigationPage;
import com.providio.pageObjects.productListingPage;
import com.providio.testcases.baseClass;

public class selectAProduct extends baseClass{
	
	public static void AddingAProductToCart() throws InterruptedException {
		
		//launching the browser and passing the url into it
		launchBrowsering lb = new launchBrowsering();
		lb.chromeBrowser();
	    
	    //validation Home page
	    preValidationCheck.prevalidationHome();
	    
		navigationPage np = new navigationPage(driver);
		np.selectRandomMenu(driver);
		
		
//	    //validation Home page
//	    preValidationCheck.prevalidationPLP();

		productListingPage plp = new productListingPage(driver);
		plp.selectProductRandom(driver);
		
//		//pdp validation
//		preValidationCheck.preValidationPDP();

	    Thread.sleep(3000);
	    
	    //selecting attributes
	    allAttributesinOneFile.allAttributes(); 
	    Thread.sleep(3000);
	    
        //validate the product is instock or not
    	validatingInstock.inStockValidation();
	    
	    
	    //validating the product is add to the cart
    	addtoCartValidation.validatingProductisAddtoCart(driver);

	}
	
	

}
