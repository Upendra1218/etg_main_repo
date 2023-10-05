package com.providio.Scenarios;

import com.providio.testcases.baseClass;

public class SimpleProductsAndBundle_Gc extends baseClass{

	public void simpleProductsAndBundle_Gc() throws InterruptedException {
		 
		//simple product
	    SimpleProduct sp = new SimpleProduct();
	    sp.simpleProdcut();
		 
		 //adding GC into cart
	    giftCard gc = new giftCard();
	    gc.giftCards();
	    
		 //searching the bundle product from excel sheet
	    BundleProduct bp = new BundleProduct();
	    bp.bundleproduct();


	}

}
