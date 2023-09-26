package com.proviodi.eachPagetest;

import org.testng.annotations.Test;

import com.providio.commonfunctionality.allAttributesinOneFile;
import com.providio.testcases.baseClass;

public class pdppage extends baseClass{
	@Test
	public void testing() throws InterruptedException {
		driver.get("https://zzqi-002.dx.commercecloud.salesforce.com/s/RefArch/charcoal-flat-front-athletic-fit-shadow-striped-wool-suit/25686395M.html?lang=en_US");

	   Thread.sleep(5000);
	   
	   allAttributesinOneFile.selectTheAttributesInPdp(driver);
	
	}
	

}
