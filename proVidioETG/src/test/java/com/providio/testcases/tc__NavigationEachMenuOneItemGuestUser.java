package com.providio.testcases;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.providio.paymentProccess.tc__CreditCardPaymentProcess;
import com.providio.paymentProccess.tc__MinicartViewCartProcess;


public class tc__NavigationEachMenuOneItemGuestUser extends baseClass{
	
	SoftAssert softAssert = new SoftAssert();

    @Test
    public void Navigation() throws InterruptedException {

    	test.info("Open browser");
        // Test Case 0: Open browser
        driver.get(baseURL);
        logger.info("Opened browser");
      
        	
            test.info("Test case for the Navigationmenu of Newarrival Page");
            
            List<WebElement> countofMenus = driver.findElements(By.xpath("//a[@class='nav-link dropdown-toggle text-uppercase font-weight-bold level-1']"));
	        int count = countofMenus.size();

	        Random random = new Random();

	        for(int i = 1; i <= count; ++i) {
	            System.out.println("Menu of number" + i);
	            List<WebElement> noelementsofdrop = driver.findElements(By.xpath("(//li[@class='nav-item dropdown'])[" + i + "]//a[@class='dropdown-link']"));
	            int countdropdown = noelementsofdrop.size();
	            int randomNumbermenuitem = random.nextInt(countdropdown)+1;

	                Thread.sleep(5000);
	                WebElement NavigationMenu = driver.findElement(By.xpath("(//a[@class='nav-link dropdown-toggle text-uppercase font-weight-bold level-1'])[" + i + "]"));
	                String menuname = NavigationMenu.getText();

	                Thread.sleep(5000);
	                Actions action = new Actions(driver);
	                action.moveToElement(NavigationMenu).perform();
	                Thread.sleep(5000L);
	                
	                test.pass ("Successfully Howered on the" + menuname + " ");
	                logger.info("Successfully Howered on the" + menuname + " ");

	                
	                WebElement NavigationMenuitem = driver.findElement(By.xpath("((//a[@class='nav-link dropdown-toggle text-uppercase font-weight-bold level-1'])[" + i + "]/following::a[@role='menuitem'])[" + randomNumbermenuitem + "]"));
	                String submenuName = NavigationMenuitem.getText();
	                System.out.println("Menu name " + submenuName);
	                JavascriptExecutor js = (JavascriptExecutor)driver;
	                js.executeScript("arguments[0].click();", new Object[]{NavigationMenuitem});
	                Thread.sleep(5000L);
	                
	                test.pass( "Successfully clicked on the" + submenuName + " of " + menuname + "");
	                logger.info("Successfully clicked on the" + submenuName + " of " + menuname + "");
	                
	                List<WebElement> products = driver.findElements(By.xpath("//a[@class ='tile-img-contain']"));	    	        
	    	        int totalProductcount = products.size();	    	        
	    	        int randomselectProduct = random.nextInt(totalProductcount) + 1;

	    	        WebElement RandomSelectProductFormPLP = driver.findElement(By.xpath("(//a[@class ='tile-img-contain'])"+"  "+"[" + randomselectProduct + "]"));
	    	       // String productName = RandomSelectProductFormPLP.getText();
	    	        //logger.info(productName);
	    	        js.executeScript("arguments[0].click();",  RandomSelectProductFormPLP);
	    	        
	    	        //logger.info(productName);
	    	        Thread.sleep(5000);
	    	        
		    	    //finding the size elements of the page
	    	        List<WebElement> sizeElementcount = driver.findElements(By.xpath("//select[@class='custom-select form-control select-size']"));
	    	        System.out.println(sizeElementcount.size());
	    	        
	    	        //validating the size element is there or not  
	    	        if(sizeElementcount.size()>0) {
	    	    	   
	    	    	     //iterating the size elements more than one
	    	    	     for(int p = 1; p <= sizeElementcount.size(); p++) {
		    	        	
		    	        	  logger.info("Excuting"); 

		    	               //Find the parent div element that contains size and width elements
		    	               WebElement parentDiv = driver.findElement(By.xpath("(//div[@class ='attributes px-0'])["+p+"]"));

		    	               //Verify the presence of size and width elements within the parent div
				    	       List<WebElement> sizeElements = parentDiv.findElements(By.xpath(".//select[@class='custom-select form-control select-size']"));
				    	       System.out.println(sizeElements.size());
				    	       List<WebElement> widthElements = parentDiv.findElements(By.xpath(".//select[@id='width-null']"));
				    	       System.out.println(widthElements.size());
	
		    	               // Both size and width elements are present within the parent div
			    	           if (!sizeElements.isEmpty() && !widthElements.isEmpty()) {

			    	        	      //size
				        			  WebElement sizeElement = sizeElements.get(0);
				        			  System.out.println("Size element is present on the page.");
				        				Select sizeSelect = new Select(sizeElement);
				        			    List<WebElement> options = sizeSelect.getOptions();
				        			    
				        			    List<String> enabledSizes = new ArrayList<>();
				        			    
				        			    int optionIndex = 0;
				        			    
				        			    System.out.println(options.size());

				        			    for (WebElement option : options) {

				        			    	if (optionIndex > 0 && option.isEnabled()) {
				        			    		
				        			    		String text = option.getText();
				        			    		  //System.out.println(text);

				        			            if (!text.isEmpty()) {      	
				        			            	String value = option.getAttribute("data-attr-value");
				        			                enabledSizes.add(value);
				        			                //System.out.println(value);
				        			                option.click();
				        			                break; 
				        			                // Select the first enabled size and exit the loop
				        			            }
				        			        }
				        			    	else {
				        			    		System.out.println("This size is not avaliable");
				        			    	}
				        			    	
				        			    	 optionIndex++;
				        			  
				        			    }
				        			    
				        			  //width 
				        			  WebElement widthElement = widthElements.get(0);
				        			  System.out.println("width element is present on the page.");
				        			  
				        				Select widthSelect = new Select(widthElement);
				        				
				        				// Get the list of available options
				        			  List<WebElement> availableOptionsofwidth = widthSelect.getOptions();
				        			
				        			  // Create a list to store the indices of enabled options
				        			  List<Integer> enabledIndixes = new ArrayList<>();
				        			
				        			  // Iterate through the available options and store the indices of enabled options
				        			  for (int a = 0; a < availableOptionsofwidth.size(); a++) {
				        			  	
				        			      if (availableOptionsofwidth.get(a).isEnabled()) {
				        			      	enabledIndixes.add(a);
				        			      }
				        			  }
				        			  Integer randomIndexofwidth = enabledIndixes.set(1, 1);
				        			  //logger.info(enabledIndixes);
				        			  System.out.println("total numbers of"+enabledIndixes);

				        			  System.out.println("only width"+enabledIndixes);
				        			  // Select the option at the random index
				        			  widthSelect.selectByIndex(randomIndexofwidth); 
				        			
				        			  Thread.sleep(3000);

					    	    	   String elementXPath = "//div[contains(text(), 'In Stock')]";
					    	    		List<WebElement> Stocksize = driver.findElements(By.xpath(elementXPath));

					    	    	    // Check if the element is present
					    	    	    if (Stocksize.size() > 0) {
					    	    	        System.out.println("The element is present on the PDP.");
					    	    	        // Additional actions when the element is present
					    	    	        
					    	    				        if (driver.findElements(By.xpath("//button[@class ='add-to-cart btn btn-primary flex-grow-1']")).size() != 0) {
					    	    					     		
					    	    							WebElement cartButtonElement = driver.findElement(By.xpath("//button[@class ='add-to-cart btn btn-primary flex-grow-1']"));
					    	    							
					    	    							
					    	    							Thread.sleep(5000);
					    	    							
					    	    							((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", cartButtonElement);
					    	    							
					    	    							js.executeScript("arguments[0].click();", cartButtonElement);
					    	    							Thread.sleep(2000);
					    	    							if (cartButtonElement.isEnabled()) {
					    	    								System.out.println("product added to cart");
					    	    							}
					    	    				
					    	    						}else if (driver.findElements(By.xpath("//button[@class='add-to-cart-global btn btn-primary' ]")).size() != 0) {
					    	    					
					    	    					    			WebElement addAllToCartElement = driver.findElement(By.xpath("//button[@class='add-to-cart-global btn btn-primary' ]"));
					    	    					    			
					    	    					    			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", addAllToCartElement);
					    	    					    			
					    	    					    			js.executeScript("arguments[0].click();", addAllToCartElement);
					    	    					    			
					    	    					    			System.out.println("products added to cart");
					    	    				       } else {
					    	    					               System.out.println("cart button is disabled because is product is out of stock");
					    	    				       }
					    	    	    } else {
					    	    	    	
					    	    	        System.out.println("This item is currently not available");
					    	    	        // Additional actions when the element is not present
					    	    	    }
			        		        

			    	         } else if(!sizeElements.isEmpty()){
			    	        	System.out.println("coming");

			    	             // Either size or width element is missing within the parent div

		    	        	       //size
		    	        		    WebElement sizeElement = sizeElements.get(0);
		    	        		    //System.out.println("Size element is present on the page."+sizeElement);
		    	        		    
		    	        		    Select sizeSelect = new Select(sizeElement);
			        			    List<WebElement> options = sizeSelect.getOptions();
			        			    
			        			    List<String> enabledSizes = new ArrayList<>();
			        			    
			        			    int optionIndex = 0;
			        			    
			        			    System.out.println(options.size());

			        			    for (WebElement option : options) {

			        			    	if (optionIndex > 0 && option.isEnabled()) {
			        			    		
			        			    		String text = option.getText();
			        			    		  //System.out.println(text);

			        			            if (!text.isEmpty()) {      	
			        			            	String value = option.getAttribute("data-attr-value");
			        			                enabledSizes.add(value);
			        			                //System.out.println(value);
			        			                option.click();
			        			                break; 
			        			                // Select the first enabled size and exit the loop
			        			            }
			        			        }
			        			    	else {
			        			    		System.out.println("This size is not avaliable");
			        			    	}
			        			    	
			        			    	 optionIndex++;
			        			  
			        			    }

		    	        		    Thread.sleep(3000);
		    	        		    
		    		    	    	   String elementXPath = "//div[contains(text(), 'In Stock')]";
		    		    	    		List<WebElement> Stocksize = driver.findElements(By.xpath(elementXPath));

		    		    	    	    // Check if the element is present
		    		    	    	    if (Stocksize.size() > 0) {
		    		    	    	        System.out.println("The element is present on the PDP.");
		    		    	    	        // Additional actions when the element is present
		    		    	    	        
		    		    	    				        if (driver.findElements(By.xpath("//button[@class ='add-to-cart btn btn-primary flex-grow-1']")).size() != 0) {
		    		    	    					     		
		    		    	    							WebElement cartButtonElement = driver.findElement(By.xpath("//button[@class ='add-to-cart btn btn-primary flex-grow-1']"));
		    		    	    							Thread.sleep(5000);
		    		    	    							
		    		    	    							((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", cartButtonElement);
		    		    	    							
		    		    	    							js.executeScript("arguments[0].click();", cartButtonElement);
		    		    	    							Thread.sleep(2000);
		    		    	    							if (cartButtonElement.isEnabled()) {
		    		    	    								System.out.println("product added to cart");
		    		    	    							}
		    		    	    				
		    		    	    						}else if (driver.findElements(By.xpath("//button[@class='add-to-cart-global btn btn-primary' ]")).size() != 0) {
		    		    	    					
		    		    	    					    			WebElement addAllToCartElement = driver.findElement(By.xpath("//button[@class='add-to-cart-global btn btn-primary' ]"));
		    		    	    					    			
		    		    	    					    			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", addAllToCartElement);
		    		    	    					    			
		    		    	    					    			js.executeScript("arguments[0].click();", addAllToCartElement);
		    		    	    					    			
		    		    	    					    			System.out.println("products added to cart");
		    		    	    				       } else {
		    		    	    					               System.out.println("cart button is disabled because is product is out of stock");
		    		    	    				       }
		    		    	    	    } else {
		    		    	    	        System.out.println("This item is currently not available");
		    		    	    	        // Additional actions when the element is not present
		    		    	    	    }

			    	         }
			    	           
			    	      }
	    	    	   
	    	       }else {
	    	    	   
	    	    	   String elementXPath = "//div[contains(text(), 'In Stock')]";
	    	    		List<WebElement> Stocksize = driver.findElements(By.xpath(elementXPath));

	    	    	    // Check if the element is present
	    	    	    if (Stocksize.size() > 0) {
	    	    	        System.out.println("The element is present on the PDP.");
	    	    	        // Additional actions when the element is present
	    	    	        
	    	    				        if (driver.findElements(By.xpath("//button[@class ='add-to-cart btn btn-primary flex-grow-1']")).size() != 0) {
	    	    					     		
	    	    							WebElement cartButtonElement = driver.findElement(By.xpath("//button[@class ='add-to-cart btn btn-primary flex-grow-1']"));
	    	    							Thread.sleep(5000);
	    	    							
	    	    							((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", cartButtonElement);
	    	    							
	    	    							js.executeScript("arguments[0].click();", cartButtonElement);
	    	    							Thread.sleep(2000);
	    	    							if (cartButtonElement.isEnabled()) {
	    	    								System.out.println("product added to cart");
	    	    							}
	    	    				
	    	    						}else if (driver.findElements(By.xpath("//button[@class='add-to-cart-global btn btn-primary' ]")).size() != 0) {
	    	    					
	    	    					    			WebElement addAllToCartElement = driver.findElement(By.xpath("//button[@class='add-to-cart-global btn btn-primary' ]"));
	    	    					    			
	    	    					    			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", addAllToCartElement);
	    	    					    			
	    	    					    			js.executeScript("arguments[0].click();", addAllToCartElement);
	    	    					    			
	    	    					    			System.out.println("products added to cart");
	    	    				       } else {
	    	    					               System.out.println("cart button is disabled because is product is out of stock");
	    	    				       }
	    	    				        
	    	    	    } else {
	    	    	        System.out.println("This item is currently not available");
	    	    	        // Additional actions when the element is not present
	    	    	    }
	    	    	   
	    	    	   
	    	       }

	    	        Thread.sleep(5000);

	               
	            }
	        
	        //checkoutProcess
	        
	        tc__MinicartViewCartProcess cp = new tc__MinicartViewCartProcess();
            
            cp.checkoutprocess();
            
            //payment process
            
            tc__CreditCardPaymentProcess cc = new tc__CreditCardPaymentProcess();
            
            cc.paymentByCreditCard();           


        // Assert all the soft assertions
        softAssert.assertAll();

    }

}
