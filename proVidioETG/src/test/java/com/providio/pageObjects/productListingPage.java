package com.providio.pageObjects;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.providio.testcases.baseClass;

public class productListingPage extends baseClass{
WebDriver lDriver;


	public productListingPage(WebDriver rDriver ){
		lDriver=rDriver;
		PageFactory.initElements(rDriver, this);
	}
	
	
	//Filters
	//display and hide features of filters
	
	@FindBy(xpath ="//i[@class='fa fa-sliders']")
	WebElement HideandDisplayofFilters;
	public void filtersHideandDisplay(WebDriver driver) throws InterruptedException{
		HideandDisplayofFilters.click();
    	Thread.sleep(3000);
	}
	
	//Category
	@FindBy(xpath ="//h6[text()='Category']")
	WebElement Category;
	public void category(WebDriver driver) throws InterruptedException{
		Category.click();
    	Thread.sleep(3000);
	}
	//color
	@FindBy(xpath ="//h6[text()='Color']")
	WebElement Color;
	public void color(WebDriver driver) throws InterruptedException{
		Color.click();
    	Thread.sleep(3000);
	}
	
	//select a color randomly from avaliable colors
	public void selectColorFormAvaliableColors() {
		// Find all color buttons that are enabled
        List<WebElement> enabledColorButtons = driver.findElements(By.xpath("//li[@class='color-attribute ']//button"));
        // Count how many are enabled
        int enabledColorCount = enabledColorButtons.size();
        logger.info("Total enabled colors: " + enabledColorCount);
        if (enabledColorCount > 0) {
            // Generate a random index to select a color
            Random random = new Random();
            int randomIndex = random.nextInt(enabledColorCount);
            // Click on a randomly selected color button
            WebElement selectedColorButton = enabledColorButtons.get(randomIndex);
            JavascriptExecutor js = (JavascriptExecutor) driver; 
            js.executeScript("arguments[0].click();", selectedColorButton);
            //selectedColorButton.click();
            // You have now selected a random enabled color
        } else {
            logger.info("No enabled colors found.");
        }

	}
	//select a random size form the page
	public void selectSizeformAvaliableSize() throws InterruptedException {
	// Find all size buttons
    List<WebElement> sizeButtons = driver.findElements(By.xpath("//span[@class='size-btn']"));
    // Count how many sizes are available
    int sizeCount = sizeButtons.size();
    logger.info("Total available sizes: " + sizeCount);
    if (sizeCount > 0) {
        // Generate a random index to select a size
        Random random = new Random();
        int randomIndex = random.nextInt(sizeCount);
        // Click on the randomly selected size button
        WebElement selectedSizeButton = sizeButtons.get(randomIndex);
        Thread.sleep(2000);
        JavascriptExecutor js = (JavascriptExecutor) driver; 
        js.executeScript("arguments[0].click();", selectedSizeButton);
        //selectedSizeButton.click();
        // You have now selected a random size
    } else {
        logger.info("No available sizes found.");
    }

	}
	
	//select a radom price range form the page
	public void selectPriceformAvlaiablePriceRange() {
		// Find all price range buttons
        List<WebElement> priceRangeButtons = driver.findElements(By.xpath("//div[@id='refinement-price']//button"));
        // Count how many price ranges are available
        int priceRangeCount = priceRangeButtons.size();
        logger.info("Total available price ranges: " + priceRangeCount);
        if (priceRangeCount > 0) {
            // Generate a random index to select a price range
            Random random = new Random();
            int randomIndex = random.nextInt(priceRangeCount);
            // Click on the randomly selected price range button
            WebElement selectedPriceRangeButton = priceRangeButtons.get(randomIndex);
            JavascriptExecutor js = (JavascriptExecutor) driver; 
            js.executeScript("arguments[0].click();", selectedPriceRangeButton);
            //selectedPriceRangeButton.click();
            // You have now selected a random price range
        } else {
            logger.info("No available price ranges found.");
        }

	}
	
	//select a random brand from the page
	public void selectbrandfromAvaliableBrand() {
		// Find all brand buttons
        List<WebElement> brandButtons = driver.findElements(By.xpath("//div[@id='refinement-brand']//button"));
        // Count how many brands are available
        int brandCount = brandButtons.size();
        logger.info("Total available brands: " + brandCount);
        if (brandCount > 0) {
            // Generate a random index to select a brand
            Random random = new Random();
            int randomIndex = random.nextInt(brandCount);
            // Click on the randomly selected brand button
            WebElement selectedBrandButton = brandButtons.get(randomIndex);
            JavascriptExecutor js = (JavascriptExecutor) driver; 
            js.executeScript("arguments[0].click();", selectedBrandButton);
            //selectedBrandButton.click();
            // You have now selected a random brand
        } else {
            logger.info("No available brands found.");
        }
	}
	
	//select a random  type formt the page
	public void selectTypeformAvaliableType() {
		// Find all type buttons
        List<WebElement> typeButtons = driver.findElements(By.xpath("//div[@id='refinement-type']//button"));
        // Count how many types are available
        int typeCount = typeButtons.size();
        logger.info("Total available types: " + typeCount);
        if (typeCount > 0) {
            // Generate a random index to select a type
            Random random = new Random();
            int randomIndex = random.nextInt(typeCount);
            // Click on the randomly selected type button
            WebElement selectedTypeButton = typeButtons.get(randomIndex);
            JavascriptExecutor js = (JavascriptExecutor) driver; 
            js.executeScript("arguments[0].click();", selectedTypeButton);
           // selectedTypeButton.click();
            // You have now selected a random type
        } else {
            logger.info("No available types found.");
        }
		
	}
	
	//select a random  type formt the page
	public void selectGpsTypeformAvaliableType() {
		// Find all GPS type buttons
        List<WebElement> gpsTypeButtons = driver.findElements(By.xpath("//div[@id='refinement-gps-type']//button"));
        // Count how many GPS types are available
        int gpsTypeCount = gpsTypeButtons.size();
        logger.info("Total available GPS types: " + gpsTypeCount);
        if (gpsTypeCount > 0) {
            // Generate a random index to select a GPS type
            Random random = new Random();
            int randomIndex = random.nextInt(gpsTypeCount);
            // Click on the randomly selected GPS type button
            WebElement selectedGPSTypeButton = gpsTypeButtons.get(randomIndex);
            JavascriptExecutor js = (JavascriptExecutor) driver; 
            js.executeScript("arguments[0].click();", selectedGPSTypeButton);
            //selectedGPSTypeButton.click();
            // You have now selected a random GPS type
        } else {
            logger.info("No available GPS types found.");
        }
		
	}
	
	//select a random features form the page
	public void selectFeaturesformAvaliableFeatures() {
		// Find all GPS feature buttons
        List<WebElement> gpsFeatureButtons = driver.findElements(By.xpath("//div[@id='refinement-features']//button"));
        // Count how many GPS features are available
        int gpsFeatureCount = gpsFeatureButtons.size();
        logger.info("Total available GPS features: " + gpsFeatureCount);
        if (gpsFeatureCount > 0) {
            // Generate a random index to select a GPS feature
            Random random = new Random();
            int randomIndex = random.nextInt(gpsFeatureCount);
            // Click on the randomly selected GPS feature button
            WebElement selectedGPSFeatureButton = gpsFeatureButtons.get(randomIndex);
            JavascriptExecutor js = (JavascriptExecutor) driver; 
            js.executeScript("arguments[0].click();", selectedGPSFeatureButton);
            //selectedGPSFeatureButton.click();
            // You have now selected a random GPS feature
        } else {
            logger.info("No available GPS features found.");
        }
	}
	
	//select a random resolution form the page
	public void selectResolutionformAvaliableResolution() {
		// Find all resolution buttons
        List<WebElement> resolutionButtons = driver.findElements(By.xpath("//div[@id='refinement-resolution']//li/button"));
        // Count how many resolutions are available
        int resolutionCount = resolutionButtons.size();
        logger.info("Total available resolutions: " + resolutionCount);
        if (resolutionCount > 0) {
            // Generate a random index to select a resolution
            Random random = new Random();
            int randomIndex = random.nextInt(resolutionCount);
            // Click on the randomly selected resolution button
            WebElement selectedResolutionButton = resolutionButtons.get(randomIndex);
            JavascriptExecutor js = (JavascriptExecutor) driver; 
            js.executeScript("arguments[0].click();", selectedResolutionButton);
            //selectedResolutionButton.click();
            // You have now selected a random resolution
        } else {
            logger.info("No available resolutions found.");
        }
	}
	
	//select a random display size from the page
	public void selectDisplaySizeformAvaliableDisplaySizes() {
		// Find all display size buttons
        List<WebElement> displaySizeButtons = driver.findElements(By.xpath("//div[@id='refinement-resolution']//button"));
        // Count how many display sizes are available
        int displaySizeCount = displaySizeButtons.size();
        logger.info("Total available display sizes: " + displaySizeCount);
        if (displaySizeCount > 0) {
            // Generate a random index to select a display size
            Random random = new Random();
            int randomIndex = random.nextInt(displaySizeCount);
            // Click on the randomly selected display size button
            WebElement selectedDisplaySizeButton = displaySizeButtons.get(randomIndex);
            JavascriptExecutor js = (JavascriptExecutor) driver; 
            js.executeScript("arguments[0].click();", selectedDisplaySizeButton);
            //selectedDisplaySizeButton.click();
            // You have now selected a random display size
        } else {
            logger.info("No available display sizes found.");
        }
		
	}
	
	//select a random display size from the page
	public void selectPixelsformAvaliablePixels() {
		// Find all pixel resolution buttons
        List<WebElement> pixelResolutionButtons = driver.findElements(By.xpath("//div[@id='refinement-pixels']//button"));
        // Count how many pixel resolutions are available
        int pixelResolutionCount = pixelResolutionButtons.size();
        logger.info("Total available pixel resolutions: " + pixelResolutionCount);
        if (pixelResolutionCount > 0) {
            // Generate a random index to select a pixel resolution
            Random random = new Random();
            int randomIndex = random.nextInt(pixelResolutionCount);
            // Click on the randomly selected pixel resolution button
            WebElement selectedPixelResolutionButton = pixelResolutionButtons.get(randomIndex);
            JavascriptExecutor js = (JavascriptExecutor) driver; 
            js.executeScript("arguments[0].click();", selectedPixelResolutionButton);
           // selectedPixelResolutionButton.click();
            // You have now selected a random pixel resolution
        } else {
            logger.info("No available pixel resolutions found.");
        }
		
	}
	
	//select a random newArrival from the page
	public void selectNewArrivalsformAvaliableNewArrivals() {
		// Find all pixel newArrival buttons
        List<WebElement> newArrival = driver.findElements(By.xpath("//div[@id='refinement-new-arrival']//button"));
        // Count how many pixel resolutions are available
        int newArrivalCount = newArrival.size();
        logger.info("Total available pixel resolutions: " + newArrivalCount);
        if (newArrivalCount > 0) {
            // Generate a random index to select a newArrival
            Random random = new Random();
            int randomIndex = random.nextInt(newArrivalCount);
            // Click on the randomly selected newArrival button
            WebElement selectedPixelResolutionButton = newArrival.get(randomIndex);
            JavascriptExecutor js = (JavascriptExecutor) driver; 
            js.executeScript("arguments[0].click();", selectedPixelResolutionButton);
            //selectedPixelResolutionButton.click();
            // You have now selected a random pixel resolution
        } else {
            logger.info("No available newArrival found.");
        }
		
	}
	
	//select a random display size from the page
	public void selectTypeUseformAvaliableTypeUse() {
		// Find all pixel newArrival buttons
        List<WebElement> newArrival = driver.findElements(By.xpath("//div[@id='refinement-type-|-use']//button"));
        // Count how many pixel resolutions are available
        int newArrivalCount = newArrival.size();
        logger.info("Total available pixel resolutions: " + newArrivalCount);
        if (newArrivalCount > 0) {
            // Generate a random index to select a newArrival
            Random random = new Random();
            int randomIndex = random.nextInt(newArrivalCount);
            // Click on the randomly selected newArrival button
            WebElement selectedPixelResolutionButton = newArrival.get(randomIndex);
            JavascriptExecutor js = (JavascriptExecutor) driver; 
            js.executeScript("arguments[0].click();", selectedPixelResolutionButton);
            //selectedPixelResolutionButton.click();
            // You have now selected a random pixel resolution
        } else {
            logger.info("No available newArrival found.");
        }
	}


		//filters
		@FindBy(xpath ="//select[@name = 'sort-order']")
		WebElement Filters;
		public void selecttheFilters(int i, WebDriver driver) throws InterruptedException{		
			Select countrySelect = new Select(Filters);
	        countrySelect.selectByIndex(i);
	        Thread.sleep(1000);
	        JavascriptExecutor js = (JavascriptExecutor) driver; 
			js.executeScript("arguments[0].click();", Filters);
	        
			//Filters.click();
	    	Thread.sleep(3000);
		}
		
		
	
		//FilterResetButton
		@FindBy(xpath ="//button[@class = 'reset btn p-0']")
		WebElement ResetButton;
		public void selecttheResetButton() throws InterruptedException{
			ResetButton.click();
	    	Thread.sleep(3000);
		}
		
		//WishList
		@FindBy(xpath ="(//a[@title= 'Wishlist'])[1]")
		WebElement WishlistPlp;
		public void selecttheWishlist() throws InterruptedException{
			
			for(int i =2;i<=4 ;i++) {
				
				WebElement wishlistPlp = driver.findElement(By.xpath("(//a[@title= 'Wishlist'])["+i+"]"));
				Thread.sleep(4000);
				JavascriptExecutor executor = (JavascriptExecutor) driver;
				executor.executeScript("arguments[0].click();", wishlistPlp);
				
				//wishlistPlp.click();
			}
		}
		
		//quickshop
		@FindBy(xpath ="(//div[@class='d-flex flex-row']/a[@class='quickview hidden-md-down btn btn-outline-primary w-100'])[1]")
		WebElement Quickshop;
		public void selectthequickshope(WebDriver driver) throws InterruptedException{

			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", Quickshop);
			
			JavascriptExecutor executor = (JavascriptExecutor) driver;
			executor.executeScript("arguments[0].click();", Quickshop);
			
	    	//Quickshop.click();
	    	Thread.sleep(3000);
		}

		//select a random product
		public void selectProductRandom(WebDriver driver) throws InterruptedException {
		    // Create a Random object to generate random numbers
		    Random random1 = new Random();
		    
		    // Find all the product elements on the current page
		    List<WebElement> products1 = driver.findElements(By.xpath("//a[@class ='tile-img-contain']"));
		    
		    // Get the total count of products found on the page
		    int totalProductcount1 = products1.size();
		    
		    // Check if there are any products found on the page
		    if (totalProductcount1 > 0) {
		        // Generate a random number within the range of the total product count
		        int randomSelectProduct = random1.nextInt(totalProductcount1) + 1;

		        // Find the randomly selected product element based on the generated random number
		        WebElement randomSelectProductFromPLP = driver.findElement(By.xpath("(//a[@class ='tile-img-contain'])[" + randomSelectProduct + "]"));
		        
		        // Use JavaScript Executor to click on the randomly selected product element
		        JavascriptExecutor js = (JavascriptExecutor)driver;
		        js.executeScript("arguments[0].click();", randomSelectProductFromPLP);
		    }
		    
		    // Pause the execution for 2 seconds (simulating a wait for the page to load)
		    Thread.sleep(2000);
		    
		    // Check if there's an element indicating that the PDP (Product Detail Page) is loading
		    List<WebElement> validatingPdpIsLoading = driver.findElements(By.xpath("//a[contains(@class, 'continue-shopping')]"));
		    
		    // Log the count of elements found for validation
		    logger.info(validatingPdpIsLoading.size());
		    
		    // Check if the PDP validation element is found
		    if (validatingPdpIsLoading.size() > 0) {
		        logger.info("PDP is not validating");
		        
		        // Find and click the "Continue Shopping" button
		        WebElement continueShoppingBtn = driver.findElement(By.xpath("//a[contains(@class, 'continue-shopping')]"));
		        continueShoppingBtn.click();
		        
		        // Pause the execution for 3 seconds (simulating some wait time)
		        Thread.sleep(3000);
		        
		        // Create a navigationPage object to handle navigation-related tasks
		        navigationPage nav = new navigationPage(driver);
		        
		        // Call the selectRandomMenu method from the navigationPage object to select a random menu item
		        nav.selectRandomMenu(driver);
		        
		        // Create a new Random object
		        Random random = new Random();
		        
		        // Find all the product elements on the current page (after navigating)
		        List<WebElement> products = driver.findElements(By.xpath("//a[@class ='tile-img-contain']"));
		        
		        // Get the total count of products found on the page
		        int totalProductcount = products.size();
		        
		        // Check if there are any products found on the page
		        if (totalProductcount > 0) {
		            // Generate a random number within the range of the total product count
		            int randomSelectProduct = random.nextInt(totalProductcount) + 1;

		            // Find the randomly selected product element based on the generated random number
		            WebElement randomSelectProductFromPLP = driver.findElement(By.xpath("(//a[@class ='tile-img-contain'])[" + randomSelectProduct + "]"));
		            
		            // Use JavaScript Executor to click on the randomly selected product element
		            JavascriptExecutor js = (JavascriptExecutor)driver;
		            js.executeScript("arguments[0].click();", randomSelectProductFromPLP);
		        }
		    }
		}

		//validations 
		//Name
		 public  void name(WebDriver driver) throws InterruptedException {
			 WebElement Name = driver.findElement(By.xpath("//h1[contains(@class, 'page-title')]"));
			    if (Name.isEnabled()) {
			    	logger.info("catagory name is displayed on the page");
			    } else {
			    	logger.info("catagory name is not displayed on the page");
			    }
			    Thread.sleep(2000);
		 }
		 
		 //BreadCramps
		 public  void BreadCramps(WebDriver driver) throws InterruptedException {
			 WebElement breadCramps = driver.findElement(By.xpath("//ol[@class='breadcrumb mb-0']"));
			    if (breadCramps.isEnabled()) {
			    	logger.info("BreadCramps are displayed on the page");
			    } else {
			    	logger.info("BreadCramps are not displayed on the page");
			    }
			    Thread.sleep(2000);
		 }
		 
		 //Filters
		 public  void Filters(WebDriver driver) throws InterruptedException {
			 WebElement filters = driver.findElement(By.xpath("//span[@class='hide-title']"));
			    if (filters.isEnabled()) {
			    	logger.info("Filters are displayed on the page");
			    } else {
			    	logger.info("Filters are not displayed on the page");
			    }
			    Thread.sleep(2000);
		 }
		 
		 //products
			public void Products(WebDriver driver) throws InterruptedException {
				List<WebElement> products = driver.findElements(By.xpath("//a[@class='nav-link dropdown-toggle text-uppercase font-weight-bold level-1']"));
			    int count = products.size();
			    if(count>0) {
			    	 logger.info("products are displayed on the page");
			    } else {
			    	logger.info("products are not displayed on the page");
			    }
			    Thread.sleep(2000);
			}

				
}
