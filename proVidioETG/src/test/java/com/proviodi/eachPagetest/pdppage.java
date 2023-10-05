package com.proviodi.eachPagetest;

import org.testng.annotations.Test;

import com.providio.commonfunctionality.allAttributesinOneFile;
import com.providio.commonfunctionality.selectingFilterFromPlp;
import com.providio.pageObjects.productListingPage;
import com.providio.testcases.baseClass;

public class pdppage extends baseClass{
	@Test
	public void testing() throws InterruptedException {
		driver.get("https://zzqi-002.dx.commercecloud.salesforce.com/s/RefArch/electronics/ipod%20%26%20mp3%20players/?lang=en_US");

	   Thread.sleep(5000);
	   selectingFilterFromPlp.selectingFilterisFormplp();
	   
	   
	   Thread.sleep(13000);
	
	}
	

}
