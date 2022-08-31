package org.tektutor;

public class CabBookingImpl implements CabBooking {


	public void book() {
		System.out.println("Request for the cab booking is made.");
		cabArrived();
	}
	

	private void cabArrived() {
		System.out.println(" TEAM 1 says BYE to team3 ");
		welcomeMessage();
	}
	
	private void welcomeMessage() {
		System.out.println("Welcome and have a great journey!");
	}
	
}
