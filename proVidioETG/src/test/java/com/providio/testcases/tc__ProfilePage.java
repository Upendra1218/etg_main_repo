package com.providio.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class tc__ProfilePage extends baseClass{
	SoftAssert softAssert = new SoftAssert();
	
	 @Test(dependsOnMethods = {"com.providio.testcases.tc__LoginSc.verifySuccessfulLogin"}, alwaysRun = true)
	public void profilePage() throws InterruptedException {
	    // Validate login
	    if (isLoggedIn) {
	    		        
	        } else {
	            Assert.fail("User is not logged in");
	        }

		
        // Assert all the soft assertions
        softAssert.assertAll();
		
   }
	
}