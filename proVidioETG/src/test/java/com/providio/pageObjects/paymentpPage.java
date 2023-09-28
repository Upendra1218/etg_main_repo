package com.providio.pageObjects;

import java.time.Duration;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
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
	
	
	//BrainTree credit card  of xpaths, actionMethods and passing card details
	//braintree newcarddropdown 
	@FindBy(xpath ="//select[@id='braintreeCreditCardList']")
    WebElement newcard;
	public void selectnewcardindropdown() throws InterruptedException {
    Select newcardselect = new Select(newcard);
    newcardselect.selectByIndex(0);
    Thread.sleep(3000);
    
	}
	
	//Braintree cardname
	@FindBy(xpath ="//input[@id = 'cardholder-name']")
	WebElement entercname;
    public void setcardholdername(WebDriver driver) throws InterruptedException {	    	
    	driver.switchTo().frame("braintree-hosted-field-cardholderName");
    	((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", entercname);
    	entercname.sendKeys("Test123");
    	driver.switchTo().defaultContent();
    }
    //Braintree cardnumber 
	@FindBy(xpath ="//input[@id = 'credit-card-number']")
	WebElement entercnumber;
    public void setcardnumber(WebDriver driver) throws InterruptedException {	    	
    	driver.switchTo().frame("braintree-hosted-field-number");
    	((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", entercnumber);
    	entercnumber.sendKeys("4111 1111 1111 1111");
    	driver.switchTo().defaultContent();
    }
    //Braintree cvv
	@FindBy(xpath ="//input[@id = 'cvv']")
	WebElement entercvv;
    public void setcardcvv(WebDriver driver) throws InterruptedException {	    	
    	driver.switchTo().frame("braintree-hosted-field-cvv");
    	((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",  entercvv);
    	entercvv.sendKeys("789");
    	driver.switchTo().defaultContent();
    }
    //Braintree exp
	@FindBy(xpath ="//input[@id = 'expiration']")
	WebElement enterexp;
    public void setcardexp(WebDriver driver) throws InterruptedException {	    	
    	driver.switchTo().frame("braintree-hosted-field-expirationDate");
    	((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",enterexp);
    	enterexp.sendKeys("1230");
    	driver.switchTo().defaultContent();
    }
    
    //Braintree savecardbutton
	@FindBy(xpath ="//input[@id='braintreeSaveCreditCard']")
	WebElement savebutton;
    public void unchecksavecard(WebDriver driver) throws InterruptedException {	    	
    	JavascriptExecutor js = (JavascriptExecutor) driver;
    	js.executeScript("arguments[0].click();", savebutton);	
    }
    
    
    //Cybersource credit card Xpaths, actionMethods and passing the card details
    
    //CyberSource cardNumber
    @FindBy(xpath ="//input[@id ='cardNumber']")
    WebElement newCreditcard;
    public void latestcardnumber(WebDriver driver) throws InterruptedException {	    	
    	newCreditcard.sendKeys("4111111111111111");
        Thread.sleep(2000);
    }
    //CyberSource exp month
    @FindBy(xpath ="//select[@id ='expirationMonth']")
    WebElement newExpmonth;
    public void latestExpDate(WebDriver driver) throws InterruptedException {
    	Select newcardselect = new Select(newExpmonth);
        newcardselect.selectByIndex(9);
        Thread.sleep(3000);

    }
    //CyberSource exp year
    @FindBy(xpath ="//select[@id ='expirationYear']")
    WebElement newExpYear;
    public void latestExpYear(WebDriver driver) throws InterruptedException {	
    	Select newcardselect = new Select(newExpYear);
        newcardselect.selectByIndex(7);
        Thread.sleep(3000);
    }
    //CyberSource cvv
    @FindBy(xpath ="//input[@id ='securityCode']")
    WebElement newSceuritycode;
    public void latestSceuritycode(WebDriver driver) throws InterruptedException {	  
    	newSceuritycode.sendKeys("789");
        Thread.sleep(2000);
    }
	
    
   //salesForce CreditCard xpaths, actionMethods and passing the details of the card
    
    //SalesForce credit cardName
    @FindBy(xpath ="//input[@autocomplete='cc-number' and @inputmode='numeric']")
    WebElement cardNumber;
    public void cardNumber(WebDriver driver) throws InterruptedException {	
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.cssSelector("iframe[title='Secure card number input frame']")));
        Thread.sleep(2000);
    	cardNumber.sendKeys("4111111111111111");
        Thread.sleep(2000);
        driver.switchTo().defaultContent();
    }
    
    //SalesForce Exp Date
    @FindBy(xpath ="//input[@autocomplete='cc-exp' and @inputmode='numeric']")
    WebElement expiryDate;
    public void expiryDate(WebDriver driver) throws InterruptedException {		    	
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.cssSelector("iframe[title='Secure expiration date input frame']")));
    	expiryDate.sendKeys("1225");
        Thread.sleep(2000);
        driver.switchTo().defaultContent();
    }
    //SalesFroce cvv
    @FindBy(xpath ="//input[@autocomplete='cc-csc' and @inputmode='numeric']")
    WebElement cvc;
    public void cvc(WebDriver driver) throws InterruptedException {	  
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.cssSelector("iframe[title='Secure CVC input frame']")));
    	 cvc.sendKeys("123");
        Thread.sleep(2000);
        driver.switchTo().defaultContent();
    }
    
    //Stripe credit card of xpaths, actionMethods and passing the card details
    
    //stripe  CardNumber
    @FindBy(xpath="//input[@autocomplete='cc-number' and @inputmode='numeric']")
    WebElement newCardNumber;
    public void cardNum(WebDriver driver) {
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.cssSelector("iframe[title='Secure card payment input frame']")));
    	newCardNumber.sendKeys("4111111111111111");
    	 driver.switchTo().defaultContent();
    }
    //stripe exp date
    @FindBy(xpath="//input[@autocomplete='cc-exp' and @inputmode='numeric']")
    WebElement expDate;
    public void expDate(WebDriver driver) {
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.cssSelector("iframe[title='Secure card payment input frame']")));
    	newCardNumber.sendKeys("11 33");
    }
    //stripe cvv
    @FindBy(xpath="//input[@autocomplete='cc-csc' and @inputmode='numeric']")
    WebElement cvv;
    public void cvv(WebDriver driver) {
    	newCardNumber.sendKeys("987");
    }
    //stripe postal code
    @FindBy(name="postal")
    WebElement postalCode;
    public void postalCode() {
    	newCardNumber.sendKeys("765439877");
    	driver.switchTo().defaultContent();
    }
    
    
    //edit the customer details in the payament page
	@FindBy(xpath = "//div[@class='card customer-summary']//button[contains(@class,'edit-button')]")
	WebElement editCustomerElement;
	@FindBy(xpath = "//input[@id='email-guest']")
	WebElement guestEmailElement;
	@FindBy(xpath = "//button[contains(text(),'Continue as guest')]")
	WebElement continueAsGuest;
	@FindBy(xpath = "//button[contains(@class ,'submit-shipping')]")
	WebElement nextPaymentButton;

	//Excuting method of the edit customer details in the payment page
	public void editCustomer(String guestEmail,WebDriver driver) throws InterruptedException {
		editCustomerElement.click();
		guestEmailElement.clear();
		guestEmailElement.sendKeys(guestEmail);
		continueAsGuest.click();
		Thread.sleep(4000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", nextPaymentButton);
		
	}
	
	//editShipping Method
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
    
    
    //editing the shipping details form the payment page
	@FindBy(xpath = "//div[@class='card shipping-summary']//button[contains(@class,'edit-button')]")
	WebElement editShippingElement;
	
	//Change the shipping address
	public void shippingDetailsChange() throws InterruptedException {
		//click on the edit button of shipping details in the payment page
		editShippingElement.click();
		
		//change the address of the customer
 	
        WebElement Address1 = driver.findElement(By.xpath("//input[@id='shippingAddressOnedefault']"));	
        //Random random = new Random();	
        int randomNumber = 4334; // Generates a random number between 100 and 999	
        address = String.valueOf(randomNumber);	
        Address1.clear();	
        Address1.sendKeys(address);	
        WebElement Address11 = driver.switchTo().activeElement();
        Thread.sleep(1000);	
        Address11.sendKeys(Keys.ARROW_DOWN);	
        Thread.sleep(1000);	
        Address11.sendKeys(Keys.ARROW_DOWN);	
        Address11.sendKeys(Keys.ENTER);	
        Thread.sleep(2000);

	}
	
	
	//updating the billing address
	//to upadate the billing address
    @FindBy(xpath="//button[@class='text-center btn-show-details btn mr-2']")
    WebElement updateAddress;
    
    //change the billing address
    public void billingAddressChnge() throws InterruptedException {
   	 //click on the update address
   	 updateAddress.click();
   	 
   	 //change the billing adddress 
        WebElement Address1 = driver.findElement(By.xpath("//input[@id='billingAddressOne']"));	
        //Random random = new Random();	
        int randomNumber = 4334; // Generates a random number between 100 and 999	
        address = String.valueOf(randomNumber);	
        Address1.clear();	
        Address1.sendKeys(address);	
        WebElement Address11 = driver.switchTo().activeElement();
        Thread.sleep(1000);	
        Address11.sendKeys(Keys.ARROW_DOWN);	
        Thread.sleep(1000);	
        Address11.sendKeys(Keys.ARROW_DOWN);	
        Address11.sendKeys(Keys.ENTER);	
        Thread.sleep(2000);
   	 
    }
    
    //addNew address in the payment page
    //add new address
    @FindBy(xpath = "//div[@class='d-flex mt-2']//button[contains(@class,'add-new')]")
    WebElement newAddress;
    //billing first name
    @FindBy(xpath = "//input[@id='billingFirstName']")
    WebElement billingFirstName;
    //billing last name
    @FindBy(xpath = "//input[@id='billingLastName']")
    WebElement billingLastName;
    //adding the new address
    public void newAddress(WebDriver driver,String fName,String lName) throws InterruptedException {
   	 //click on new address in billing
   	 newAddress.click();
   	 billingFirstName.sendKeys(fName);
   	 billingLastName.sendKeys(lName);
   	 WebElement Address1 = driver.findElement(By.xpath("//input[@id='billingAddressOne']"));	
        //Random random = new Random();	
        int randomNumber = 658; // Generates a random number between 100 and 999	
        address = String.valueOf(randomNumber);	
        Address1.clear();	
        Address1.sendKeys(address);	
        WebElement Address11 = driver.switchTo().activeElement();
        Thread.sleep(1000);	
        Address11.sendKeys(Keys.ARROW_DOWN);	
        Thread.sleep(1000);	
        Address11.sendKeys(Keys.ARROW_DOWN);	
        Address11.sendKeys(Keys.ENTER);	
        Thread.sleep(2000);

   	 JavascriptExecutor js = (JavascriptExecutor) driver;
   	 js.executeScript("window.scrollBy(0, 500)");
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
 	//applying the gift cart
 	public void applyGiftCertifiate(String giftcard) {
		giftcertificate.sendKeys(giftcard);
		applyGiftCard.click();
	}
 	
 	
 	//paypal Braintree payment process
    public void braintreePaypal(WebDriver driver) throws InterruptedException {
        // Create an instance of Actions class
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,700)", "");
                      
        js.executeScript("arguments[0].click();", paypal);
        System.out.println("Clicked on paypal icon");
    }
    
    //After the paypal button click
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
    
   //SalesForce paypal payment page
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
    
    //addpaymentbutton
    @FindBy(xpath ="//button[@class ='btn btn-block add-payment btn-outline-primary']")
    WebElement addPayment;
    public void addPaymentButton(WebDriver driver) throws InterruptedException {	  
    JavascriptExecutor js = (JavascriptExecutor) driver;
	 js.executeScript("arguments[0].click();", addPayment);
    	//addPayment.click
        Thread.sleep(2000);
    }
    
  //click on review order
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
    
    
    //Place the order for salesforce payment process
    @FindBy(xpath ="//button[@class='btn btn-primary btn-block place-order' and @name='submit' and contains(text(), 'Place Order')]")
    WebElement placetheOrder;
    public void placetheOrder(WebDriver driver) throws InterruptedException {	  
    	JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", placetheOrder);
    	//placetheOrder.click();
        Thread.sleep(2000);
    }
    
    //paypal payment details
    
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
        

         Thread.sleep(2000);
         if(reviewOrderButton.size()>0) {
        	WebElement reviewOrder=driver.findElement(By.id("payment-submit-btn"));
        	reviewOrder.click();
        	Thread.sleep(7000);
        /*	if(reviewOrderButton.size()>0 && reviewOrder.isDisplayed()) {
        	      JavascriptExecutor js = (JavascriptExecutor) driver;                       
                  js.executeScript("arguments[0].click();", reviewOrder);
                 
        	}*/
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
		    
}
