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

import freemarker.log.Logger;

public class productDescriptionPage extends baseClass{

    WebDriver ldriver;

    public productDescriptionPage(WebDriver rdriver ){   
        ldriver=rdriver;
        PageFactory.initElements(rdriver, this);
    }

    // WebElement for selecting product 1
    @FindBy(xpath = "//img[@alt='Washable Wool Classic Straight Skirt']")
    WebElement product1;

    // Method to click on product 1
    public void clickOnProduct1() throws InterruptedException{    
        Thread.sleep(2000);
        product1.click();
        Thread.sleep(2000);
    }

    // WebElement for navigating through breadcrumbs
    @FindBy(xpath = "(//ol[@class='breadcrumb mb-0']//a[contains(text(),'Womens')])[1]")
    WebElement allBreadCrumbs;

    // Method to click on breadcrumbs
    public void clickOnBreadCrumbs(WebDriver driver) throws InterruptedException{
        Actions actions = new Actions(driver);
        actions.moveToElement(allBreadCrumbs);
        allBreadCrumbs.click();
    }

    // WebElement for left carousel button
    @FindBy(xpath = "//button[@class='slick-prev slick-arrow']")
    WebElement leftCarousel;

    // Method to click on the left carousel button
    public void clickOnLeftCarousel(WebDriver driver) throws InterruptedException{
        for(int i=1; i<=2; i++){
            leftCarousel.click();
        }
        Thread.sleep(2000);
    }

    // WebElement for right carousel button
    @FindBy(xpath = "//button[@class='slick-next slick-arrow']")
    WebElement rightCarousel;

    // Method to click on the right carousel button
    public void clickOnRightCarousel(WebDriver driver) throws InterruptedException {
        for(int i=1; i<=2; i++){
            rightCarousel.click();
        }
        Thread.sleep(2000);
    }

    // List of WebElement for "Write a Review" links at the top
    @FindBy(xpath = "(//a[@class='pr-snippet-write-review-link pr-underline'])[1]")
    List<WebElement> writeAReviewAtTop;

    // Method to click on the "Write a Review" link at the top
    public void clickOnWriteAReviewAtTop(WebDriver driver) throws InterruptedException {
        if(writeAReviewAtTop.size() > 0) {
            Thread.sleep(2000);
            WebElement writeAReview = driver.findElement(By.xpath("(//a[@class='pr-snippet-write-review-link pr-underline'])[1]"));
            writeAReview.click();
            Thread.sleep(3000);
        } else {
            System.out.println("Write A Review is not found");
        }
    }

    // List of WebElement for ratings
    @FindBy(xpath = "//span[contains(@class, 'pr-accessible-text')]")
    List<WebElement> rating1;

    // Method to click on a rating
    public void clickOnRating(WebDriver driver) throws InterruptedException {
        if (rating1.size() > 0) {
            WebElement rating = driver.findElement(By.xpath("//span[contains(@class, 'pr-accessible-text')]"));
            JavascriptExecutor js = (JavascriptExecutor)driver;
            js.executeScript("arguments[0].click();", rating);
        } else {
            System.out.println("Element is disabled");
        }
    }

    // WebElement for review headline
    @FindBy(xpath = "//input[@name='Review Headline']")
    List<WebElement> reviewHeadline;

    // Method to enter a review headline
    public void clickOnReviewHeadline(WebDriver driver, String headline) throws InterruptedException {
        if(reviewHeadline.size() > 0) {
            WebElement reviewHeadline = driver.findElement(By.xpath("//input[@name='Review Headline']"));
            JavascriptExecutor js = (JavascriptExecutor)driver;
            js.executeScript("arguments[0].click();", reviewHeadline);
            reviewHeadline.sendKeys(headline);
            Thread.sleep(3000);
        }
    }

    // WebElement for comments
    @FindBy(xpath = "//textarea[@id='pr-comments-input']")
    WebElement comments;

    // Method to enter comments
    public void clickOnComments(String comment) throws InterruptedException {
        comments.sendKeys(comment);
        Thread.sleep(3000);
    }

    // WebElement for "Yes" option
    @FindBy(xpath = "//label[text()='Yes, I would recommend this to a friend']")
    WebElement forYes;

    // Method to click on "Yes" option
    public void clickOnYes() throws InterruptedException {
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("arguments[0].click();", forYes);
        Thread.sleep(2000);
    }

    // WebElement for "No" option
    @FindBy(xpath = "//input[@id='pr-plF1ZjMbk-PpfQ1jg06AR1']")
    WebElement forNo;

    // Method to click on "No" option
    public void clickOnNo() throws InterruptedException {
        forYes.click();
        Thread.sleep(2000);
    }

    // WebElement for nickname
    @FindBy(xpath = "//input[@id='pr-name-input']")
    WebElement nickName;

    // Method to enter a nickname
    public void clicknickName(String name) throws InterruptedException {
        nickName.sendKeys(name);
        Thread.sleep(5000);
    }

    // WebElement for location
    @FindBy(xpath = "//input[@id='pr-location-input']")
    WebElement location;

    // Method to enter a location
    public void clickOnLoc(String loc) throws InterruptedException  {
        location.sendKeys(loc);
        Thread.sleep(4000);
    }

    // WebElement for submit review button
    @FindBy(xpath = "//button[@type='submit' and text()='Submit Review']")
    WebElement submitReview;

    // Method to click on the submit review button
    public void clickOnSubmitReview(WebDriver driver) throws InterruptedException {
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("arguments[0].click();", submitReview);
        Thread.sleep(4000);
    }

    // WebElement to decrease the quantity
    @FindBy (xpath="//span[@class='qty-minus']")
    WebElement decreaseTheQunatity;

    // Method to click on decreasing quantity
    public void clickOndecreaseTheQunatity() throws InterruptedException {
        if (decreaseTheQunatity.isEnabled()) {
            for(int i=1; i<=5; i++) {
                decreaseTheQunatity.click();
                Thread.sleep(1000);
            }
        } else {
            System.out.println("decrease quantity is not enabled");
        }
        Thread.sleep(1000);
    }

    // WebElement to increase the quantity
    @FindBy(xpath="//span[@class='qty-plus']")
    WebElement increaseTheQuantity;

    // Method to click on increasing quantity
    public void clickInIncreaseQuantity() throws InterruptedException {
        if (increaseTheQuantity.isEnabled()) {
            for(int i=1; i<=5; i++) {
                increaseTheQuantity.click();
                Thread.sleep(1000);
            }
        } else {
            System.out.println("increase quantity is not enabled");
        }
        Thread.sleep(1000);
    }

    // WebElement for adding to wishlist from PDP
    @FindBy(xpath="//button[@type='submit' and span[text()='Wishlist']]")
    WebElement wishlist;

    // Method to click on adding to wishlist
    public void clickOnWishlist() {
        wishlist.click();
    }

    // WebElement to find a store
    @FindBy(xpath="//span[contains(text(),'Find a Store')]")
    WebElement findAStore;

    // Method to click on finding a store
    public void clickOnStore(WebDriver driver) throws InterruptedException {
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("arguments[0].click();", findAStore);
        Thread.sleep(2000);
    }

    // WebElement for zip code or postal code
    @FindBy(id = "store-postal-code")
    WebElement zipCodeInStore;

    // Method to enter a zip code or postal code
    public void clickOnZipCode(String zipcodeStore) {
        zipCodeInStore.sendKeys(zipcodeStore);
    }

    // WebElement for radius in find a store
    @FindBy(id="radius")
    WebElement radius;

    // Method to select a radius
    public void clickOnRadius() {
        Select selectRadius = new Select(radius);
        selectRadius.selectByIndex(1);
    }

    // WebElement for finding stores
    @FindBy(xpath="//button[contains(text(),'Find Stores')]")
    WebElement findStores;

    // Method to click on finding stores
    public void clickOnFindStores() throws InterruptedException {
        findStores.click();
        Thread.sleep(2000);
    }

    // WebElement for closing the find store modal
    @FindBy(xpath = "//div[@id='findInStoreModal']")
    WebElement closeFindStore;

    // Method to click on closing the find store modal
    public void clickOnCloseFindStore(WebDriver driver ) throws InterruptedException {
        Thread.sleep(2000);
        closeFindStore.click();
    }

    // WebElement for social media - Pinterest
    @FindBy(xpath="//i[@class='fa fa-pinterest']")
    WebElement pinterest;

    // Method to click on Pinterest social media icon
    public void clickOnPinterest() throws InterruptedException {
        Thread.sleep(1000);
        pinterest.click();
    }

    // WebElement for social media - Facebook
    @FindBy(xpath="//i[@class='fa fa-facebook-official']")
    WebElement facebook;

    // Method to click on Facebook social media icon
    public void clickOnFacebook() throws InterruptedException {
        Thread.sleep(1000);
        facebook.click();
    }

    // WebElement for social media - Twitter
    @FindBy(xpath="(//i[@class='fa fa-twitter'])[1]")
    WebElement twitter;

    // Method to click on Twitter social media icon
    public void clickOntwitter() throws InterruptedException {
        Thread.sleep(1000);
        twitter.click();
    }

    // WebElement for social media - Link
    @FindBy(xpath="//i[@class='fa fa-link']")
    WebElement link;

    // Method to click on Link social media icon
    public void clickOnLink() throws InterruptedException {
        Thread.sleep(1000);
        link.click();
    }

    // WebElement for "Write a Review" link at the bottom
    @FindBy(xpath="(//a[contains(text(),'Write the First Review')])[2]")
    WebElement writeAReviewAtBottom;

    // Method to click on "Write a Review" link at the bottom
    public void clickOnwriteAReviewAtBottom() {
        writeAReviewAtBottom.click();
    }

    // WebElement for the "Add to Cart" button
    @FindBy(xpath = "//button[contains(@class,'add-to-cart')]")
    WebElement CartButton;

    // Method to click on the "Add to Cart" button
    public void clickcartbutton(WebDriver driver) throws InterruptedException{
        Thread.sleep(5000);
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("arguments[0].click();", CartButton);
        Thread.sleep(2000);
    }

    // WebElement for the "Continue Shopping" link
    @FindBy(xpath = "//a[contains(text(), 'Continue Shopping')]")
    WebElement continueShoppingLink;

    // Method to click on the "Continue Shopping" link
    public void clickOncontinueShoping(WebDriver driver) throws InterruptedException {
        continueShoppingLink.click();
        Thread.sleep(2000);
    }

    // WebElement for the "Buy Now" button in PDP page
    @FindBy(xpath = "//button[@class='buy-now btn btn-primary col-12 col-sm-6 d-none']")
    WebElement buyNowButton;

    // Method to click on the "Buy Now" button in PDP page
    public void clickOnBuyNowButton(WebDriver driver) {
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("arguments[0].click();", buyNowButton);
    }

    // WebElement for the "Paypal Buy Now" button
    @FindBy(xpath = "//div[contains(@class,'salesforce-buynow-element ')]")
    WebElement paypalBuyNow;

    // Method to click on the "Paypal Buy Now" button
    public void clickOnPaypalBuyNow(WebDriver driver) {
        if(paypalBuyNow.isDisplayed()) {
            JavascriptExecutor js = (JavascriptExecutor) driver;
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", paypalBuyNow);
            js.executeScript("arguments[0].click();", paypalBuyNow);
        }
    }

    // Validations for elements on the PDP page

    // Validation for product name
    public  void productNameValidation(WebDriver driver) {
        WebElement productName = driver.findElement(By.xpath("//h1[contains(@class, 'product-name hidden-sm-down')]"));
        if (productName.isDisplayed()) {
            logger.info("Product Name is displayed on the page.");
        } else {
            logger.info("Product Name is not displayed on the page.");
        }
    }

    // Validation for product image
    public  void productImageValidation(WebDriver driver) {
        WebElement productImage = driver.findElement(By.xpath("(//img[@class ='d-block img-fluid'])[1]"));
        if (productImage.isDisplayed()) {
            logger.info("Product Image is displayed on the page.");
        } else {
            logger.info("Product Image is not displayed on the page.");
        }
    }

    // Validation for product review link
    public  void productReviewLinkValidation(WebDriver driver) {
        WebElement productreviewLink = driver.findElement(By.xpath("//a[@class ='pr-snippet-write-review-link pr-underline']"));
        if (productreviewLink.isDisplayed()) {
            logger.info("Product Review Link is displayed on the page.");
        } else {
            logger.info("Product Review Link is not displayed on the page.");
        }
    }

    // Validation for product "Add to Cart" button
    public  void productAddtocartButtonValidation(WebDriver driver) {
        WebElement productAddtoCartButton = driver.findElement(By.xpath("//button[contains(@class, 'add-to-cart')]"));
        if (productAddtoCartButton.isDisplayed()) {
            logger.info("Product 'Add to Cart' button is displayed on the page.");
        } else {
            logger.info("Product 'Add to Cart' button is not displayed on the page.");
        }
    }

    // Validation for product specifications
    public  void productSepecificationsValidation(WebDriver driver) {
        WebElement productSpecs = driver.findElement(By.xpath("//h2[contains(@class, 'title') and text()='Description']"));
        if (productSpecs.isDisplayed()) {
            logger.info("Product Specifications are displayed on the page.");
        } else {
            logger.info("Product Specifications are not displayed on the page.");
        }
    }
}
