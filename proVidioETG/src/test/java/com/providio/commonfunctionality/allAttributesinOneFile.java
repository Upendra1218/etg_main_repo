package com.providio.commonfunctionality;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.providio.pageObjects.navigationPage;
import com.providio.pageObjects.productDescriptionPage;
import com.providio.pageObjects.productListingPage;
import com.providio.testcases.baseClass;

public class allAttributesinOneFile extends baseClass{
	
	
	public static void selectTheAttributesInPdp(WebDriver driver) throws InterruptedException {
		
		 
		//selecting attributes
		allAttributes();
	    Thread.sleep(2000);
			
//			//to pick the store in pdp page
//            List  <WebElement> pickUpStore =driver.findElements(By.id("delivery-options-store"));
//            if(pickUpStore.size()>0) {
//                  WebElement pickUpStoreenabled =driver.findElement(By.id("delivery-options-store"));
//                  if(pickUpStoreenabled.isEnabled()) {
//                        js.executeScript("arguments[0].click();",pickUpStoreenabled);
//                        test.info("Selected the pickUp in Store");
//                  }else {
//                        test.info("Pick up store is not available for this product");
//                  }
//            }
			
	     productDescriptionPage pdp = new productDescriptionPage(driver);
	     WebElement cartEnabled =driver.findElement(By.xpath("//button[contains(@class,'add-to-cart')]"));
	     List  <WebElement> inStock =driver.findElements(By.xpath("//div[contains(text(), 'In Stock')]"));
	     if(cartEnabled.isEnabled()&& inStock.size()>0) {
		     pdp.clickcartbutton(driver);

		      
	     }else {
	    	 
	    	 System.out.println("Product is out of stock so searching for new product");

            //selecting a random menu
	    	 navigationPage navPage =new navigationPage(driver);
	    	 navPage.selectRandomMenu(driver);
	    	 
	    	//selecting a random product in the plp page
	    	 productListingPage plp = new productListingPage(driver);
	    	 plp.selectProductRandom(driver);
	
	    	 //Reselecting the all attributes
	    	 selectTheAttributesInPdp(driver);
	    	 
	    	//validating the product is add to the cart
	  	    addtoCartValidation.validatingProductisAddtoCart(driver);
	  	    
	     }
	     
	}

	public static void allAttributes() throws InterruptedException {
		
		List <WebElement> mainDiv= driver.findElements(By.xpath("//div[@class='attributes px-0']"));
		System.out.println("The total number of size division are " +mainDiv.size());
	
		List<WebElement> colorElement = driver.findElements(By.xpath("//span[contains(@class,' non-input-label')]"));
		System.out.println("The colordrop down count is " + colorElement.size());
		
		List<WebElement> sizeElement = driver.findElements(By.xpath("//select[contains(@class,'select-size')]"));
		System.out.println("The size drop down count  is " +  sizeElement.size());
		
		List<WebElement> memoryElement = driver.findElements(By.id("memorySize-null"));
		
		 List<WebElement> widthElements = driver.findElements(By.xpath(".//select[@id='width-null']"));
	     System.out.println(widthElements.size());
	     
	     List<WebElement> showName = driver.findElements(By.xpath("//select[contains(@class,'select-showName')]"));
	     System.out.println(showName.size());
	     
	     //another way of attributes
	     
	     List<WebElement> sizeBox= driver.findElements(By.xpath("//div[contains(@class, 'select-size')]"));
	     	     	 	
	     List<WebElement> colorBox= driver.findElements(By.xpath("//button[contains(@class,'color-attribute')]"));
	     
	     List<WebElement> memoryBox = driver.findElements(By.xpath("//div[contains(@class, 'select-memorySize')]"));
	     
		 List<WebElement> widthBox = driver.findElements(By.xpath("//div[contains(@class, 'select-width')]"));
		
		 List<WebElement> showNameBox= driver.findElements(By.cssSelector(".showName"));
		 
		 List<WebElement> extendedWarranty = driver.findElements(By.className("options-select"));
	     
	     for(int i=1; i<=mainDiv.size();i++) {
	    	 
			if(colorElement.size()>0|| colorBox.size()>0) {
				attributesSelection.colorSelection();
				System.out.println("selected color");
				Thread.sleep(1000);
			}if(sizeElement.size()>0|| sizeBox.size()>0 ) {
				attributesSelection.sizeSelction();
				System.out.println("selected size");
				//Thread.sleep(1000);					
			} if(memoryElement.size()>0||  memoryBox.size()>0) {
				attributesSelection.memorySelection();
				System.out.println("selected memory size");
				//Thread.sleep(1000);
			} if(widthElements.size()>0 || widthBox.size()>0) {	
				attributesSelection.widthSelection();
				System.out.println("selected width");
				//Thread.sleep(1000);
			}if(showName.size()>0 || showNameBox.size()>0) {
				//Thread.sleep(1000);
				attributesSelection.selectShowName();
				System.out.println("Selected show name ");
			}if(extendedWarranty.size()>0) {
				attributesSelection.selectExtendedWarranty();
				System.out.println("Selected extended warranty ");
			}
	     }
	     
		//validating the product is instock and adding to the cart
		  //validatingInstock.inStockValidation();
	     
	}
	
	public static void quickshopallAttributes() throws InterruptedException {
		//finding the how many size elements are there in the page and after that itterating the how many size elements need to select the each one 
        List<WebElement> countofSizeElement = driver.findElements(By.xpath("//select[contains(@class, 'select-size')]"));
        logger.info("countofSizeElement: "+countofSizeElement.size());
        //if incase size element is not there means need to find the what other element is there on the page and select that one 
        List<WebElement> countofmemorysize = driver.findElements(By.xpath("//select[contains(@class, 'select-memorySize')]"));
        logger.info("countofmemorysize: "+countofmemorysize.size());
        
        //size should be greater than one 
        if(countofSizeElement.size()>0) {
        
        //iterating the size elements more than one
	     for(int p = 1; p <= countofSizeElement.size(); p++) {
	    	 
           //Find the parent div element that contains size and width elements
              WebElement parentDiv = driver.findElement(By.xpath("(//div[@class ='attributes px-0'])["+p+"]"));

          //Verify the presence of size element within the parent div
   	       List<WebElement> sizeElements = driver.findElements(By.xpath("//select[contains(@class, 'select-size')]"));
   	       System.out.println("sizeElements:"+sizeElements.size());
   	       //Verify the presence of width element within the parent div
   	       List<WebElement> widthElements = driver.findElements(By.xpath("//select[contains(@class, 'select-width')]"));
   	       System.out.println("widthElements: "+widthElements.size());
  	       //Verify the presence of color element within the parent div
   	       List<WebElement> colorElement = driver.findElements(By.xpath("//select[contains(@class, 'select-color')]"));
   	       System.out.println("colorElement: "+colorElement.size());
   	       
   	       //validating the all the attributes are present in any pdp
   	       if(sizeElements.size()>0&&widthElements.size()>0&&colorElement.size()>0) {

   	    	//selcting the color   
   	    	attributesSelection.colorSelection();
   	    	Thread.sleep(3000);
   	    	//select the size
   	    	attributesSelection.sizeSelction();
   	    	Thread.sleep(3000);
   	    	//select the width
   	    	attributesSelection.widthSelection();
   	    	Thread.sleep(5000);
   	    	//validate the product is instock or not
   	    	//validatingInstock.inStockValidation();

   	       }else if(sizeElements.size()>0&&colorElement.size()>0) {
   	    	   
   	    	//selecting the color   
   	    	attributesSelection.colorSelection();
   	    	Thread.sleep(3000);
   	    	//select the size
   	    	attributesSelection.sizeSelction();
   	    	Thread.sleep(3000);
   	    	Thread.sleep(5000);
   	    	//validate the product is instock or not
   	    	//validatingInstock.inStockValidation();
   	    	   
   	       }
   	       
	     }
	     //selecting the memory size of the product
        }else if(countofmemorysize.size()>0) {
        	
   	    	attributesSelection.memorySelection();
   	    	Thread.sleep(3000);
   	    	Thread.sleep(5000);
   	    	//validate the product is instock or not
   	    	//validatingInstock.inStockValidation();
        	logger.info("memory size");

        }else {
        	
   	    	//validate the product is instock or not
   	    	//validatingInstock.inStockValidation();
        }
        Thread.sleep(3000);


	}

}
