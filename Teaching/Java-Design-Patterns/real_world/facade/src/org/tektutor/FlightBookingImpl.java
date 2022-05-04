package org.tektutor;

public class FlightBookingImpl implements FlightBooking {

	@Override
	public void book() {
		System.out.println("Flight Booking -> Booked");
		flightArrived() ;
	}	
	
	private void flightArrived() {
		System.out.println("Your flight is arrived");
		welcomeMessage();
	}
	
	private void welcomeMessage() {
		System.out.println("Welcome and have a great journey!");
	}

}
