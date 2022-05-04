package org.tektutor;

public class FacadePattern {
	public static void main(String[] args) {


	    TravelPackageFacade travelPackageFacade=new TravelPackageFacadeImpl();
	    


	    TravelPackageFacade travelPackageFacade = new TravelPackageFacadeImpl(); //created the object

	    travelPackageFacade.book();
	  }
}
