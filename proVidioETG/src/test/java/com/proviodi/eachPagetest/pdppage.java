package com.proviodi.eachPagetest;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import com.providio.commonfunctionality.allAttributesinOneFile;
import com.providio.commonfunctionality.selectingFilterFromPlp;
import com.providio.pageObjects.productListingPage;
import com.providio.testcases.baseClass;
import com.providio.utilities.attributesSelection;

public class pdppage extends baseClass{
	@Test
	public void testing() throws InterruptedException {
		driver.get("https://zzqi-002.dx.commercecloud.salesforce.com/s/RefArch/charcoal-flat-front-athletic-fit-shadow-striped-wool-suit/25686395M.html?lang=en_US");
	   Thread.sleep(5000);
	   
		List <WebElement> mainDiv= driver.findElements(By.xpath("//div[@class='attributes px-0']"));
		System.out.println("The total number of size division are " +mainDiv.size());
	   
		
	    	 
			//WebElement attributeSize = driver.findElement(By.xpath("(//div[@class='attributes px-0'])[" + i + "]//select[contains(@class,'select-size')]"));
 		// Create a Select object and select the first enabled size
			List<WebElement> widthdropdown= driver.findElements(By.xpath("//select[contains(@class,'select-width')]"));
			logger.info(widthdropdown.size());
			for(int i=1; i<=widthdropdown.size();i++) {
			WebElement width = driver.findElement(By.xpath("(//select[contains(@class,'select-width')])[" + i + "]"));

		    Select colorElement = new Select(width);
		    List<WebElement> options = colorElement.getOptions();
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
		                Thread.sleep(5000);
		                break; 				                
		            }
		        }

		    	 optionIndex++;
		    }

	     }
	   
	
	}
	

}
