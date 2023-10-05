package com.providio.commonfunctionality;

import com.providio.pageObjects.paymentpPage;
import com.providio.testcases.baseClass;

public class paymentMethods extends baseClass{
	
	paymentpPage pp = new paymentpPage(driver);
	
	   //brain tree payment method of guest user
		public  void braintree() throws InterruptedException {
			
			pp.setcardholdername(driver);
			logger.info("entered card name");
			
			pp.setcardnumber(driver);
			logger.info("entered card number");
			
			pp.setcardcvv(driver);
			logger.info("entered cvv");
			
			pp.setcardexp(driver);
			logger.info("entered exp");
			
		}
		
		//register user and select the new card and save the card
		public void brainTreeReguser() throws InterruptedException {

	    	pp.selectnewcardindropdown();  
			logger.info("Selectd the new card");
			
			braintree();
			
		}
		
		//payment of cyber source  of guest user
		public void cyberSourceNewcard() throws InterruptedException {
			
	        pp.latestcardnumber(driver);
	        logger.info("entered card number");
	        pp.latestExpDate(driver);
	        logger.info("entered exp month");
	        pp.latestExpYear(driver);
	        logger.info("entered exp year");
	        pp.latestSceuritycode(driver);
	        logger.info("entered scecode");
			
		}
		
		//payment reg user
		public void cybersourceReguser() throws InterruptedException {
			
			pp.cyberAddpaymentBtn(driver);
			logger.info("clicked on the add payment button");
			
			//cybersource method
			cyberSourceNewcard();
			
		}
		
		//salesforce payment method
		public void salesforcePayment() throws InterruptedException {
			
			pp.cardNumber(driver);
	    	
	    	logger.info("entered card number");
	    	pp.expiryDate(driver);
	    	
	    	logger.info("entered cvv");
	    	pp.cvc(driver);
	    	logger.info("entered exp");
		}
		
		//Reg salesfoce payment
	     public void salesforcePaymentReg() throws InterruptedException {
	    	 
	    	    pp.creditCard(driver);
	    	    //salesforce payment
	    	    salesforcePayment();
				
				
			}
     
	     //stripe payment method
	     public void stripePayment() {
	 		
	 		pp.cardNum(driver);
	 		test.info("entered card number");
	 		pp. expDate(driver);
	 		test.info("entered exp date");		
	 		pp.cvv(driver);
	 		test.info("entered cvv");
	 		pp.postalCode();
	 		test.info("entered postal code");
	 	}
		

}
