package org.tektutor;

public class InternetOrder extends PosterTemplate {

	@Override
	public void doSelect() {
		System.out.println("Poster added to cart"); 
        System.out.println("Custom Edit Poster as your wish");  
	}

	@Override
	public void doPayment() {
		System.out.println("Payment through UPI, card or Paytm");
	}

	@Override
	public void doPrint() {
		System.out.println("Poster will print"); 
	}
	
}
