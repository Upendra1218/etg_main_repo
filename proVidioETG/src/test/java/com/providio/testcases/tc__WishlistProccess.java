package com.providio.testcases;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.providio.commonfunctionality.allAttributesinOneFile;

import com.providio.pageObjects.homePage;
import com.providio.pageObjects.navigationPage;
import com.providio.pageObjects.productListingPage;

public class tc__WishlistProccess extends baseClass {

	
	public void wishlistPage(WebDriver driver) throws InterruptedException {
	 navigationPage navPage= new navigationPage(driver);
     
     navPage.selectRandomMenu(driver);
     logger.info("Selected random menu");
     
     productListingPage plp = new productListingPage(driver);
     plp.selecttheWishlist();
     logger.info("Added product to wishlist");
    
     homePage hp=new homePage(driver);
     Thread.sleep(3000);
     hp.clickOnWishlist(driver);
	 logger.info("clicked on  wishlist");
	 
	 
	

	 Thread.sleep(10000);

	


			}
	
	}


	

