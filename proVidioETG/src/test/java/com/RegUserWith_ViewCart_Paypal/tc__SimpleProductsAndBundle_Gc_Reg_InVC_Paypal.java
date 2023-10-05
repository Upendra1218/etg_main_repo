// Import necessary packages and classes
package com.RegUserWith_ViewCart_Paypal;

import org.testng.Assert;
import org.testng.annotations.Test;

// Import various classes and methods from other packages
import com.providio.Scenarios.SimpleProductsAndBundle_Gc;
import com.providio.paymentProccess.tc__MinicartViewCartProcessByPayPal;
import com.providio.testcases.baseClass;

// Define a test class named "tc__SimpleProductsAndBundle_Gc_Reg_InVC_Paypal"
public class tc__SimpleProductsAndBundle_Gc_Reg_InVC_Paypal extends baseClass {
	
	// Define a test method named "simpleProducts_Bundle_Gc"
	@Test(dependsOnMethods = {"com.providio.testcases.tc__LoginSc.verifySuccessfulLogin"}, alwaysRun = true)
	public void simpleProducts_Bundle_Gc() throws InterruptedException {
		
		// Check if the user is logged in
		if(isLoggedIn) {
			
			// Create an instance of the "SimpleProductsAndBundle_Gc" class
			SimpleProductsAndBundle_Gc spb = new SimpleProductsAndBundle_Gc();
			
			// Call the "simpleProductsAndBundle_Gc" method to perform certain actions
			spb.simpleProductsAndBundle_Gc();
		    
			// Create an instance of the "tc__MinicartViewCartProcessByPayPal" class
			tc__MinicartViewCartProcessByPayPal paypal = new tc__MinicartViewCartProcessByPayPal();
			
			// Call the "checkoutprocessFromViewCart" method to perform PayPal checkout from the View Cart page
			paypal.checkoutprocessFromViewCart();   
		} else {
			// If the user is not logged in, fail the test with a message
		    Assert.fail("User not logged in");
		}
	}
}
