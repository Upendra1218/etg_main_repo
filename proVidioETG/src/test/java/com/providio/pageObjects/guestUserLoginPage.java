//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.providio.pageObjects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import net.bytebuddy.asm.MemberSubstitution.FieldValue;

public class guestUserLoginPage {
    WebDriver lDriver;
  //pageFactory constructor for this page
    public guestUserLoginPage(WebDriver rDriver) {
        this.lDriver = rDriver;
        PageFactory.initElements(rDriver, this);
    }
   
    //Guest login page of xpaths, actionMethods and passing the data
    
    //guestCheckout button
    @FindBy(xpath = "//button[contains(text(),'Guest Checkout')]")
    WebElement guestCheckOut;
    //actionMethod
    public void clickOnGuestCheckOut() {
        this.guestCheckOut.click();
    }
    //reEntermailguest
    @FindBy( xpath = "//input[@id='email-guest']")
    WebElement reEnterMailInGuest;
    //actionMethod
    public void clickOnEmailClear() {
        reEnterMailInGuest.clear();
       
     }
    //actionMethod
    public void clickOnEmail(String reEnterMail) {
        this.reEnterMailInGuest.sendKeys(new CharSequence[]{reEnterMail});
    } 
    
    //Continue as guest
    @FindBy(xpath = "//button[contains(text(),' Continue as guest')]" )
    WebElement continueAsGuest;
    //actionMethod
    public void clickOnContinueAsGuest() {
        continueAsGuest.click();
    }
    //guest checkout1
   @FindBy(xpath = "//button[contains(@class,'js-cancel-login')]")
    WebElement guestCheckout1;
   //actionMethod
   public void clickOnGuest() {
   	guestCheckout1.click();
   }
   //sign up
   @FindBy(xpath = "(//a[contains(text(),'Sign Up')])[2]")
   WebElement signUp;
   //actionMethod
   public void clickOnSignUp() {
   	signUp.click();
   }
   //sign in
   @FindBy(xpath = "//button[contains(text(),'Sign In')][1]")
   WebElement signIn;
   //actionMethod
   public void clickOnSignIn() {
   	signIn.click();
   }
   //guestmail
   @FindBy( xpath = "//input[@id='email']")
   WebElement guestmail;
   //actionMethod
   public void clickOnGuestMail(String mail) throws InterruptedException {
       guestmail.clear();
   	guestmail.sendKeys( mail);
       Thread.sleep(2000L);
   }
   //guestPassword
   @FindBy( xpath = "//input[@id='password']")
   WebElement guestPassword;
   //actionMethod
   public void clickOnGuestPassword(String pwd ) throws InterruptedException {
       guestPassword.clear();
   	guestPassword.sendKeys(pwd);
       Thread.sleep(2000L);
   }
   //login button
   @FindBy(xpath = "//button[@value='submit-login']")
   WebElement loginButton;
   //actionMethod
   public void clickOnLogin() {
   	loginButton.click();
   }
   //forgot password
   @FindBy(xpath = "//a[@id='password-reset']")
   WebElement forgotPwd;
   //actionMethod
   public void clickOnForgotPwd() {
   	forgotPwd.click();
   }
   //forgot email  pwd
   @FindBy(xpath = "//input[@id='reset-password-email']")
   WebElement emailForgotPwd;
   //actionMethod
   public void enterForgotPwdEmail() {
   	emailForgotPwd.sendKeys("akhila.m@etg.digital");
   }
   //send button
   @FindBy(xpath = "//button[contains(text(),'Send')]")
   WebElement sendButton;
   //actionMethod
   public void clickOnSend(WebDriver driver) {
   	JavascriptExecutor js = (JavascriptExecutor) driver;
       js.executeScript("arguments[0].click();", sendButton);
   	//sendButton.click();
   }
   //login forgot password
   @FindBy(xpath = "(//button[contains(text(),'Login')])[2]")
   WebElement loginForgotPwd;
   //actionMethod
   public void clickOnLoginPwd() {
   	loginForgotPwd.click();
   }
   //back to cart 
   @FindBy(xpath = "//a[@class='back-to-cart']")
   WebElement backToCart;
   //actionMethod
   public void clickOnBackToCart() {
   	backToCart.click();
   }

}
