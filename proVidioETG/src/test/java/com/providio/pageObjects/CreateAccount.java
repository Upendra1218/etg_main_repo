package com.providio.pageObjects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateAccount {

	WebDriver lDriver;
	//pageFactory constructor for this page
	public CreateAccount(WebDriver rDriver ){
			lDriver=rDriver;
			PageFactory.initElements(rDriver, this);
	}
	
	//Creating account page xpaths, actionMethods and passing data to create a account
	
	//create account link
	@FindBy(xpath = "//a[contains(text(),'Create Account')]")
	WebElement createAcc;
	//ActionMethod
    public void clickOnCreateAcc(WebDriver driver) throws InterruptedException {
        Thread.sleep(2000);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", createAcc);
    }
    //reg firstName
	@FindBy(id = "registration-form-fname")
	 WebElement firstNameInput;
    //ActionMethod
    public void enterFirstName(String firstName) {
        firstNameInput.clear();
        firstNameInput.sendKeys(firstName);
    }
    //req lastName
    @FindBy(id = "registration-form-lname")
	 WebElement lastNameInput;
    //ActionMethod
    public void enterLastName(String lastName) {
        lastNameInput.clear();
        lastNameInput.sendKeys(lastName);
    }
	//reg Phone number
	@FindBy(id = "registration-form-phone")
	 WebElement phoneInput;
	//ActonMethod
    public void enterPhone(String phone) {
        phoneInput.clear();
        phoneInput.sendKeys(phone);
    }
	//reg email
	@FindBy(id = "registration-form-email")
	 WebElement emailInput;
	//ActonMethod
    public void enterEmail(String email) {
        emailInput.clear();
        emailInput.sendKeys(email);
    }
	//reg conform mail
	@FindBy(id = "registration-form-email-confirm")
	 WebElement confirmEmailInput;
	//ActonMethod
    public void enterConfirmEmail(String confirmEmail) {
        confirmEmailInput.clear();
        confirmEmailInput.sendKeys(confirmEmail);
    }
	//password
	@FindBy(id = "registration-form-password")
	 WebElement passwordInput;
    public void enterPassword(String passwordCreateAcc) {
        passwordInput.clear();
        passwordInput.sendKeys(passwordCreateAcc);
    }
	//confrom password
	@FindBy(id = "registration-form-password-confirm")
	 WebElement confirmPasswordInput;
    public void enterConfirmPassword(String ConfirmPasswordCreateAcc) {
        confirmPasswordInput.clear();
        confirmPasswordInput.sendKeys(ConfirmPasswordCreateAcc);
    }
	//create account button after entering the details
	@FindBy(xpath = "//button[contains(text(), 'Create Account')]")
	 WebElement createAccountButton;
    public void clickCreateAccountButton(WebDriver driver) throws InterruptedException {
        Thread.sleep(2000);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", createAccountButton);
        js.executeScript("arguments[0].click();", createAccountButton);
    }
	
}
