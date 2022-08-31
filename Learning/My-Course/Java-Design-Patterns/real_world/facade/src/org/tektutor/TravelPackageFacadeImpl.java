package org.tektutor;

public class TravelPackageFacadeImpl implements TravelPackageFacade {

	@Override
	public void book() {
		 CabBooking cabBooking=new CabBookingImpl();
		 cabBooking.book();
		    
		 HotelBooking hotelBooking=new HotelBookingImpl();
		 hotelBooking.book();
		    
		 FlightBooking flightBooking=new FlightBookingImpl();
		 flightBooking.book();
		    
		 System.out.println("Travel package booked successfully");
	}

}
