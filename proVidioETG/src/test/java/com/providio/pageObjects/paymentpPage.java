package com.providio.pageObjects;

import java.time.Duration;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.github.javafaker.Faker;
import com.providio.Validations.Checkout_Validation;
import com.providio.testcases.baseClass;

public class paymentpPage extends baseClass {
	
WebDriver lDriver;
	
	public paymentpPage(WebDriver rDriver ){
		
		lDriver=rDriver;
		PageFactory.initElements(rDriver, this);
	}
	
	// edit the customer
		@FindBy(xpath = "(//button[@class='edit-button pull-right'])[1]")
		WebElement editCustomerElement;
		@FindBy(xpath = "//input[@id='email-guest']")
		WebElement guestEmailElement;
		@FindBy(xpath = "//button[@class='btn btn-primary btn-block submit-customer']")
		WebElement continueAsGuest;
		@FindBy(xpath = "//button[@name ='submit' and @class ='btn btn-primary btn-block submit-shipping']")
		WebElement nextPaymentButton;

		public void editCustomer(String guestEmail,WebDriver driver) throws InterruptedException {
			editCustomerElement.click();
			guestEmailElement.clear();
			guestEmailElement.sendKeys(guestEmail);
			continueAsGuest.click();
			Thread.sleep(4000);
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].click();", nextPaymentButton);
			
		}

		// edit shipping address
		@FindBy(xpath = "//button[@aria-label='Edit Shipping']")
		WebElement editShippingElement;
		// shipping method

		public void editShippingMethod(WebDriver driver) throws InterruptedException {
			Thread.sleep(5000);
			editShippingElement.click();
			List <WebElement> editShippingMethod=driver.findElements(By.xpath("(//div[@class='row leading-lines shipping-method-list'])[1]//input[@class='form-check-input']"));
			int  countShippingMethod = editShippingMethod.size();
			

			Random random = new Random();
			int randomRadioButton = random.nextInt(countShippingMethod) + 1;
			WebElement selectShippingMethod =driver.findElement(By.xpath("((//div[@class='row leading-lines shipping-method-list'])[1]//input[@class='form-check-input'])["+randomRadioButton+"]"));
			selectShippingMethod.click();
		}
		//to update the shipping address
		public void updateShippingAddress(WebDriver driver) {
		  // Initialize Faker object
		 Faker faker = new Faker();

		// Generate a random number to select the field to update (1 for name, 2 for address, 3 for phone number)
	     int fieldToUpdate = faker.random().nextInt(1, 4);
		
	  // Update the selected field randomly
	     switch (fieldToUpdate) {
	         case 1:
	        	 updateFirstName(driver, faker);
	             break;
	         case 2:
	        	 updateLastName(driver, faker);
	             break;
	         case 3:
	        	 updateAddress(driver, faker);
	             break;
	         case 4:
	        	 updateCity(driver, faker);
	             break;
	         case 5:
	        	 updateZipCode(driver, faker);
	             break;   
	         default:
	             System.out.println("Invalid field selection");
	     }
	     JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", nextPaymentButton);
			
		}
	     private static void updateFirstName(WebDriver driver, Faker faker) {
	         WebElement nameField = driver.findElement(By.xpath("//input[@id='shippingFirstNamedefault']"));
	         nameField.clear();
	         nameField.sendKeys(faker.name().firstName());
	     }
	     private static void updateLastName(WebDriver driver, Faker faker) {
	         WebElement nameField = driver.findElement(By.xpath("//input[@id='shippingLastNamedefault']"));
	         nameField.clear();
	         nameField.sendKeys(faker.name().lastName());
	     }
	     private static void updateAddress(WebDriver driver, Faker faker) {
	         WebElement nameField = driver.findElement(By.xpath("//input[@id='shippingAddressOnedefault']"));
	         nameField.clear();
	         nameField.sendKeys(faker.address().fullAddress());
	     }
	     private static void updateCity(WebDriver driver, Faker faker) {
	         WebElement nameField = driver.findElement(By.xpath("//input[@id ='shippingAddressCitydefault']"));
	         nameField.clear();
	         nameField.sendKeys(faker.address().city());
	     }
	     private static void updateZipCode(WebDriver driver,Faker faker) {
	    	 WebElement nameField = driver.findElement(By.xpath("//input[@id='shippingZipCodedefault']"));
	         nameField.clear();
	         nameField.sendKeys(faker.address().zipCode());
	    	 
	}
	     
	     //to upadate the billing address
	     @FindBy(xpath="//button[@class='text-center btn-show-details btn mr-2']")
	     WebElement updateAddress;
	     
	     public void updateBillingAddress(WebDriver driver) {
	    	 updateAddress.click();
	   	  // Initialize Faker object
	   	 Faker faker = new Faker();

	   	// Generate a random number to select the field to update (1 for name, 2 for address, 3 for phone number)
	        int fieldToUpdate = faker.random().nextInt(1, 4);
	   	
	     // Update the selected field randomly
	        switch (fieldToUpdate) {
	            case 1:
	           	 updateFirstName1(driver, faker);
	                break;
	            case 2:
	           	 updateLastName1(driver, faker);
	                break;
	            case 3:
	           	 updateAddress1(driver, faker);
	                break;
	            case 4:
	           	 updateCity1(driver, faker);
	                break;
	            case 5:
	           	 updateZipCode1(driver, faker);
	                break;   
	            default:
	                System.out.println("Invalid field selection");
	        }
	        JavascriptExecutor js = (JavascriptExecutor) driver;
	   	js.executeScript("arguments[0].click();", nextPaymentButton);
	   		
	   	}
	        private static void updateFirstName1(WebDriver driver, Faker faker) {
	            WebElement nameField = driver.findElement(By.xpath("//input[@id='billingFirstName']"));
	            nameField.clear();
	            nameField.sendKeys(faker.name().firstName());
	        }
	        private static void updateLastName1(WebDriver driver, Faker faker) {
	            WebElement nameField = driver.findElement(By.xpath("//input[@id='billingLastName']"));
	            nameField.clear();
	            nameField.sendKeys(faker.name().lastName());
	        }
	        private static void updateAddress1(WebDriver driver, Faker faker) {
	            WebElement nameField = driver.findElement(By.xpath("//input[@id='billingAddressOne']"));
	            nameField.clear();
	            nameField.sendKeys(faker.address().fullAddress());
	        }
	        private static void updateCity1(WebDriver driver, Faker faker) {
	            WebElement nameField = driver.findElement(By.xpath("//input[@id='billingAddressCity']"));
	            nameField.clear();
	            nameField.sendKeys(faker.address().city());
	        }
	        private static void updateZipCode1(WebDriver driver,Faker faker) {
	       	 WebElement nameField = driver.findElement(By.xpath("//input[@id='billingZipCode']"));
	            nameField.clear();
	            nameField.sendKeys(faker.address().zipCode());
	       	 
	   }
	        //add new address
	     @FindBy(xpath = "(//button[@class='text-center btn-add-new btn mx-2'])[3]")
	     WebElement newAddress;
	     //billing first name
	     @FindBy(xpath = "//input[@id='billingFirstName']")
	     WebElement billingFirstName;
	     //billing last name
	     @FindBy(xpath = "//input[@id='billingLastName']")
	     WebElement billingLastName;
	     //billing address
	     @FindBy(xpath = "//input[@id='billingAddressOne']")
	     WebElement billingAdresss;
	     //billing city
	     @FindBy(xpath = "//input[@id='billingAddressCity']")
	     WebElement billingCity;
	     //billing zipcode
	     @FindBy(xpath = "//input[@id='billingZipCode']")
	     WebElement billingZipcode;
	  // Phone number
	 	@FindBy(xpath = "(//input[@id='phoneNumber'])[1]")
	 	WebElement billingPhoneNumber;
	   
	     public void newAddress(WebDriver driver,String fName,String lName,String address1,String city,String zipcode,String phoneNumber) {
	    	 //click on new address in billing
	    	 newAddress.click();
	    	 billingFirstName.sendKeys(lName);
	    	 billingLastName.sendKeys(lName);
	    	 billingAdresss.sendKeys(address1);
	    	 billingCity.sendKeys(city);
	    	 billingZipcode.sendKeys(zipcode);
	    	 billingPhoneNumber.sendKeys(phoneNumber);
	    	 JavascriptExecutor js = (JavascriptExecutor) driver;
	    	 js.executeScript("window.scrollBy(0, 500)");
		}
	  // Country
	 	@FindBy(xpath = "//select[@id='billingCountry']")
	 	WebElement Country;

	 	public void setCountry1() {
			Select countrySelect = new Select(Country);
	 		countrySelect.selectByIndex(1);
	 		
		}
	 	
	 // Province
	 	@FindBy(xpath = "//select[@id='billingState']")
	 	WebElement Province;

	 	public void setProvince1() {
	 		Select ProvinceSelect = new Select(Province);
	 		ProvinceSelect.selectByIndex(5);
	 	}
		
		
	 	//gift card 
	 	
	 	@FindBy(xpath="//input[@id='giftCert']")
	 	WebElement giftcertificate;
	 	
	 	//to apply gift card
	 	@FindBy(xpath = "//button[@value='submit-gifrcert']")
	 	WebElement applyGiftCard;
	 	//check gift card bal 
	 	@FindBy(xpath = "//button[@value='gift-cert-balance']")
	 	WebElement checkGiftcardbal;
	 	
	 	public void applyGiftCertifiate(String giftcard) {
			giftcertificate.sendKeys(giftcard);
			applyGiftCard.click();
		}

	
	       //newcarddropdown
			@FindBy(xpath ="//select[@id='braintreeCreditCardList']")
	        WebElement newcard;
			public void selectnewcardindropdown() throws InterruptedException {
	        Select newcardselect = new Select(newcard);
	        newcardselect.selectByIndex(0);
	        Thread.sleep(3000);
		    
			}
			
			//cardname
			@FindBy(xpath ="//input[@id = 'cardholder-name']")
			WebElement entercname;
		    public void setcardholdername(WebDriver driver) throws InterruptedException {	    	
		    	driver.switchTo().frame("braintree-hosted-field-cardholderName");
		    	((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", entercname);
		    	entercname.sendKeys("Test123");
		    	driver.switchTo().defaultContent();
		    }
		    //cardnumber
			@FindBy(xpath ="//input[@id = 'credit-card-number']")
			WebElement entercnumber;
		    public void setcardnumber(WebDriver driver) throws InterruptedException {	    	
		    	driver.switchTo().frame("braintree-hosted-field-number");
		    	((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", entercnumber);
		    	entercnumber.sendKeys("4111 1111 1111 1111");
		    	driver.switchTo().defaultContent();
		    }
		    //cvv
			@FindBy(xpath ="//input[@id = 'cvv']")
			WebElement entercvv;
		    public void setcardcvv(WebDriver driver) throws InterruptedException {	    	
		    	driver.switchTo().frame("braintree-hosted-field-cvv");
		    	((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",  entercvv);
		    	entercvv.sendKeys("789");
		    	driver.switchTo().defaultContent();
		    }
		    //exp
			@FindBy(xpath ="//input[@id = 'expiration']")
			WebElement enterexp;
		    public void setcardexp(WebDriver driver) throws InterruptedException {	    	
		    	driver.switchTo().frame("braintree-hosted-field-expirationDate");
		    	((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",enterexp);
		    	enterexp.sendKeys("1230");
		    	driver.switchTo().defaultContent();
		    }
		    
		    //savecardbutton
			@FindBy(xpath ="//input[@id='braintreeSaveCreditCard']")
			WebElement savebutton;
		    public void unchecksavecard(WebDriver driver) throws InterruptedException {	    	
		    	JavascriptExecutor js = (JavascriptExecutor) driver;
		    	js.executeScript("arguments[0].click();", savebutton);	
		    }
		    //clickonrevieworder
		    @FindBy(xpath ="//button[@class='btn btn-primary btn-block submit-payment'  and @value='submit-payment']")
			WebElement revieworder;
		    @FindBy(xpath ="//button[@class='btn btn-primary btn-block submit-payment'  and @value='submit-payment']")
			List<WebElement> revieworderList;
		    public void clickonrevieworder(WebDriver driver) throws InterruptedException {	
		    	if(revieworderList.size()>0) {
			    	//((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", revieworder);			    	
			    	Thread.sleep(5000);
			    	JavascriptExecutor js = (JavascriptExecutor) driver;
			    	js.executeScript("arguments[0].click();", revieworder);
			    	Thread.sleep(3000);
			    	if(revieworder.isDisplayed()) {
			    		 Thread.sleep(3000);
				    	revieworder.click();	
				       
			        }
		    	}
		    }
		    
		    
		    //latest creditcard
		    @FindBy(xpath ="//input[@id ='cardNumber']")
		    WebElement newCreditcard;
		    public void latestcardnumber(WebDriver driver) throws InterruptedException {	    	
//		    	JavascriptExecutor js = (JavascriptExecutor) driver;
//		    	js.executeScript("arguments[0].click();", revieworder);
		    	newCreditcard.sendKeys("4111111111111111");

		        Thread.sleep(2000);
		    }
		    
		    @FindBy(xpath ="//select[@id ='expirationMonth']")
		    WebElement newExpmonth;
		    public void latestExpDate(WebDriver driver) throws InterruptedException {
		    	
		    	Select newcardselect = new Select(newExpmonth);
		        newcardselect.selectByIndex(9);
		        Thread.sleep(3000);
		    	
//		    	JavascriptExecutor js = (JavascriptExecutor) driver;
//		    	js.executeScript("arguments[0].click();", revieworder);
//		    	newCreditcard.sendKeys("4111111111111111");
//
//		        Thread.sleep(2000);
		    }
		    
		    @FindBy(xpath ="//select[@id ='expirationYear']")
		    WebElement newExpYear;
		    public void latestExpYear(WebDriver driver) throws InterruptedException {	
		    	
		    	Select newcardselect = new Select(newExpYear);
		        newcardselect.selectByIndex(7);
		        Thread.sleep(3000);
		    	
//		    	JavascriptExecutor js = (JavascriptExecutor) driver;
//		    	js.executeScript("arguments[0].click();", revieworder);
//		    	newCreditcard.sendKeys("4111111111111111");
//
//		        Thread.sleep(2000);
		    }
		    
		    @FindBy(xpath ="//input[@id ='securityCode']")
		    WebElement newSceuritycode;
		    public void latestSceuritycode(WebDriver driver) throws InterruptedException {	  
		    	
//		    	JavascriptExecutor js = (JavascriptExecutor) driver;
//		    	js.executeScript("arguments[0].click();", revieworder);
		    	
		    	newSceuritycode.sendKeys("789");

		        Thread.sleep(2000);
		    }
		    
		    //Update button
		    
		    

		    @FindBy(xpath ="//button[@class ='text-center btn-show-details btn mr-2']")
		    WebElement updatebutton;
		    public void updatebutton(WebDriver driver) throws InterruptedException {	  
		    	
//		    	JavascriptExecutor js = (JavascriptExecutor) driver;
//		    	js.executeScript("arguments[0].click();", revieworder);
		    	
		    	updatebutton.click();

		        Thread.sleep(2000);
		    }
		    
		    
		    @FindBy(xpath ="//button[@class ='btn btn-block add-payment btn-outline-primary']")
		    WebElement addPayment;
		    public void addPaymentButton(WebDriver driver) throws InterruptedException {	  
		    	
		    	JavascriptExecutor js = (JavascriptExecutor) driver;
	    	 js.executeScript("arguments[0].click();", addPayment);
		    	
		    	//addPayment.click();

		        Thread.sleep(2000);
		    }
		    
		 /*   
		    @FindBy(xpath = "//img[@alt='PayPal Credit']")
            WebElement paypal;

            @FindBy(xpath = "//div[@aria-label='PayPal Checkout']")
            WebElement  paypalCheckout;

            @FindBy(xpath = "//input[@name='login_email']")
            WebElement emailLogin;

            @FindBy(xpath = "//button[contains(text(), 'Next')]")
            WebElement nextButton;
 
            @FindBy(xpath = "//input[@id='password']")
            WebElement password;

            @FindBy(xpath = "//button[contains(text(), 'Log In')]")
            WebElement loginbutton;
            
            @FindBy(xpath = "(//div[@class='FundingInstrument_item_3lQ2z'])[3]")
            WebElement cardParentDiv;
            
            @FindBy(xpath = "//div[contains(@class,'CheckoutButton')]")
            List<WebElement> reviewOrderButton;

            @FindBy(xpath = "//button[contains(text(), 'Save and Continue')]")
            WebElement saveAndContinue;
*/
            //braintreee paypal
            public void braintreePaypal(WebDriver driver) throws InterruptedException {
                //Thread.sleep(3000);

                // Create an instance of Actions class
                JavascriptExecutor js = (JavascriptExecutor) driver;
                js.executeScript("window.scrollBy(0,700)", "");
                              
                js.executeScript("arguments[0].click();", paypal);
                System.out.println("Clicked on paypal icon");
               // Thread.sleep(2000);
            }
            public void brainTreeAfterClick(WebDriver driver) throws InterruptedException {
            	
                 WebElement parentDiv= driver.findElement(By.xpath("//a[contains(@class, 'paypal-tab active')]"));               
                 WebElement regPaypalCheckoutText=parentDiv.findElement(By.xpath("//label[contains(text(),'Select a PayPal account')]"));
                 if(regPaypalCheckoutText.isDisplayed()) {                	 
                	  
                	 
                 }else { 
	                 JavascriptExecutor js = (JavascriptExecutor) driver;  
	                 WebElement paypalCheckout=driver.findElement(By.xpath("//div[@class='js_braintree_paypal_billing_button']")); 
	                 if(paypalCheckout.isDisplayed()) {
	                	 js.executeScript("arguments[0].click();", paypalCheckout);                	
	                     Thread.sleep(1000);
	                     	if(paypalCheckout.isDisplayed()) {
	                     		//((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",  paypalCheckout);
	                     		paypalCheckout.click();
	                     }
	                 	}	                 
	                 }                 
            }
               
          
            
            //salesforce paypal
            public void salesforcePaypalCheckout(WebDriver driver) throws InterruptedException {
                WebElement parentDiv= driver.findElement(By.xpath("//div[contains(@class,'sfpp-payment-method-header-paypal')]"));
                Thread.sleep(4000);
                WebElement paypalCheckout=parentDiv.findElement(By.xpath("//div[contains(text(),'Pay with PayPal')]"));
                
                JavascriptExecutor js = (JavascriptExecutor) driver;
                js.executeScript("window.scrollBy(0,700)", "");
                js.executeScript("arguments[0].click();", paypalCheckout);
               
                Thread.sleep(3000);
               // paypalCheckout.click();
               // Thread.sleep(10000);
                
                List<WebElement> salesforcePaypalCheckout=parentDiv.findElements(By.xpath("//div[contains(@class,'paypal-buttons-context-iframe paypal-buttons-label-paypal')]"));  
                if(salesforcePaypalCheckout.size()>0) {
	                WebElement salesforcePaypalCheckout1=parentDiv.findElement(By.xpath("(//iframe[@title='PayPal'])[2]"));
	              if(salesforcePaypalCheckout1.isDisplayed()) {
	            	  	 Thread.sleep(3000);
	                	 salesforcePaypalCheckout1.click();
	                	 System.out.println("First click");
	              }if(salesforcePaypalCheckout1.isDisplayed()) {    
	                  js.executeScript("arguments[0].click();", salesforcePaypalCheckout1);
	                 
	              }
	                	
                }
            }
            
            @FindBy(xpath = "//img[@alt='PayPal Credit']")
            WebElement paypal;

            @FindBy(xpath = "//div[@aria-label='PayPal Checkout']")
            WebElement  paypalCheckout;

            @FindBy(xpath = "//input[@name='login_email']")
            List<WebElement> emailLogin;

            @FindBy(css = "#btnNext")
            List<WebElement> nextButton;

            @FindBy(xpath = "//input[@id='password']")
            List<WebElement> password;

            @FindBy(xpath = "//button[contains(text(), 'Log In')]")
            List<WebElement> loginbutton;

            @FindBy(xpath = "(//div[@class='FundingInstrument_item_3lQ2z'])[3]")
            WebElement cardParentDiv;
            
            @FindBy(xpath = "changeShippingAddress")
            List<WebElement> changeTheAddressList;

            @FindBy(id = "payment-submit-btn")
            List<WebElement> reviewOrderButton;

 

            @FindBy(xpath = "//button[contains(text(), 'Save and Continue')]")
            List<WebElement> saveAndContinue;
            
            public void paypalPopup(WebDriver driver) throws InterruptedException {
            	
                String mainWindowHandle = driver.getWindowHandle();
                // Switch to the new window by iterating over all available window handles
                for (String handle : driver.getWindowHandles()) {
                    if (!handle.equals(mainWindowHandle)) {
                        driver.switchTo().window(handle);
                        break;
                    }
                }
                // test.info("Entered into paypal window");
             //	List<WebElement> paypalPage = driver.findElements(By.id("headerText"));
            //	System.out.println("The url for payapal is " + paypalPage.size());
                
                 Thread.sleep(3000);
                 if(emailLogin.size()>0) {
                	
                	 WebElement  emailLogin1=driver.findElement(By.xpath("//input[@name='login_email']")); 
                	 emailLogin1.clear();
                	 emailLogin1.sendKeys("rahulnaik@etisbew.com");
                	 test.info("Entered username");
                 }
                 Thread.sleep(3000);
                 if(nextButton.size()>0) {
                	 WebElement nextButton1=driver.findElement(By.cssSelector("#btnNext"));
	                 nextButton1.click();
	                 Thread.sleep(1000);
                 }
                 if(password.size()>0) {
                	 WebElement password1=driver.findElement(By.xpath("//input[@id='password']"));
                	// password1.clear();
	                 password1.sendKeys("Etgsfcc245@");
	                 test.info("Entered password");
	                 Thread.sleep(1000);
                 }
                 if(loginbutton.size()>0) {
                	 WebElement loginbutton1=driver.findElement(By.xpath("//button[contains(text(), 'Log In')]"));
	                 loginbutton1.click();
	                 Thread.sleep(1000);
                 }
                 /*
                 WebElement visaCard=cardParentDiv.findElement(By.xpath("(//input[@class='ppvx_radio__input___2-11-1'])[3]"));
                 JavascriptExecutor js = (JavascriptExecutor) driver;
                 js.executeScript("window.scrollBy(0,100)", "");
                 Thread.sleep(2000);
                 js.executeScript("arguments[0].click();", visaCard);
                 */
                 Thread.sleep(2000);
                 /*
                 if(changeTheAddressList.size()>0) {
                	 WebElement changeTheAddress=driver.findElement(By.xpath("//button[@id='changeShippingAddress']"));
                	 changeTheAddress.click();
                	 
                	// Find all the address list items
                     List<WebElement> addressListItems = driver.findElements(By.cssSelector(".SelectShippingSidebar__sidebarListItem--7i3hP"));
                     System.out.println("Total number of address in paypal "+ addressListItems);
                     if(addressListItems.size()>0) {
	                     // Generate a random index to select an address randomly
	                     Random random = new Random();
	                     int randomIndex = random.nextInt(addressListItems.size());
	
	                     // Click on the randomly selected address
	                     WebElement randomAddressButton = addressListItems.get(randomIndex).findElement(By.tagName("button"));
	                     randomAddressButton.click();
                     }
                 }*/
                 Thread.sleep(2000);
                 if(reviewOrderButton.size()>0) {
                	WebElement reviewOrder=driver.findElement(By.id("payment-submit-btn"));
                	reviewOrder.click();
                	Thread.sleep(7000);
                	if(reviewOrder.isDisplayed()) {
                	      JavascriptExecutor js = (JavascriptExecutor) driver;                       
                          js.executeScript("arguments[0].click();", reviewOrder);
                         
                	}
                	
                	
                	//reviewOrder.click();
                	                	
                 }else {
                	 if(saveAndContinue.size()>0) {
                		 WebElement saveAndContinue1=driver.findElement(By.xpath("//button[contains(text(), 'Save and Continue')]"));
                		 saveAndContinue1.click();
                	 }
                 }                 
                 
                 driver.switchTo().window(mainWindowHandle);
                 Thread.sleep(1000);
                 
              }
            
            //salesfoce creditcard
            
            //
		    @FindBy(xpath ="//input[@autocomplete='cc-number' and @inputmode='numeric']")
		    WebElement cardNumber;
		    public void cardNumber(WebDriver driver) throws InterruptedException {	
		    	
		    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.cssSelector("iframe[title='Secure card number input frame']")));
		    	
		    	
		       // driver.switchTo().frame("Secure card number input frame");

		        Thread.sleep(2000);
		    	cardNumber.sendKeys("4111111111111111");

		        Thread.sleep(2000);
		        driver.switchTo().defaultContent();
		    }
		    
		    //exp
		    @FindBy(xpath ="//input[@autocomplete='cc-exp' and @inputmode='numeric']")
		    WebElement expiryDate;
		    public void expiryDate(WebDriver driver) throws InterruptedException {		    	
		    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.cssSelector("iframe[title='Secure expiration date input frame']")));
		    	expiryDate.sendKeys("1225");
		        Thread.sleep(2000);
		        driver.switchTo().defaultContent();
		    }
		    //cvv
		    @FindBy(xpath ="//input[@autocomplete='cc-csc' and @inputmode='numeric']")
		    WebElement cvc;
		    public void cvc(WebDriver driver) throws InterruptedException {	  
		    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.cssSelector("iframe[title='Secure CVC input frame']")));
		    	 cvc.sendKeys("123");
		        Thread.sleep(2000);
		        driver.switchTo().defaultContent();
		    }
		    
		    
		    //stripe  paymnet
		    @FindBy(xpath="//input[@autocomplete='cc-number' and @inputmode='numeric']")
		    WebElement newCardNumber;
		    public void cardNum(WebDriver driver) {
		    	
		    	
		    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.cssSelector("iframe[title='Secure card payment input frame']")));
		    	newCardNumber.sendKeys("4111111111111111");
		    	 driver.switchTo().defaultContent();
		    }
		    
		    @FindBy(xpath="//input[@autocomplete='cc-exp' and @inputmode='numeric']")
		    WebElement expDate;
		    public void expDate(WebDriver driver) {
		    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.cssSelector("iframe[title='Secure card payment input frame']")));
		    	newCardNumber.sendKeys("11 33");
		    }
		    
		    @FindBy(xpath="//input[@autocomplete='cc-csc' and @inputmode='numeric']")
		    WebElement cvv;
		    public void cvv(WebDriver driver) {
		    	
		    	//WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		        //wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.cssSelector("iframe[title='Secure card payment input frame']")));
		    	newCardNumber.sendKeys("987");
		    }

		    @FindBy(name="postal")
		    WebElement postalCode;
		    public void postalCode() {
		    	newCardNumber.sendKeys("765439877");
		    	driver.switchTo().defaultContent();
		    }
		    
		    
		    @FindBy(xpath ="//button[@class='btn btn-primary btn-block place-order' and @name='submit' and contains(text(), 'Place Order')]")
		    WebElement placetheOrder;
		    public void placetheOrder(WebDriver driver) throws InterruptedException {	  

		    	
		    	
		    	JavascriptExecutor js = (JavascriptExecutor) driver;
                js.executeScript("arguments[0].click();", placetheOrder);
		    	//placetheOrder.click();

		        Thread.sleep(2000);
		    }
            
            
            
		    
}
