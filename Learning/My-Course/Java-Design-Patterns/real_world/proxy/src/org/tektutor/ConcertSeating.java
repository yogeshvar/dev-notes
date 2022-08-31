package org.tektutor;

import org.omg.CORBA.DynAnyPackage.TypeMismatch;

public class ConcertSeating implements ConcertGuardInterface {

	@Override
	public void allowVisitor(int ticketId) throws TypeMismatch {
		if(ticketId == 1) {
			System.out.println("Visitor is allowed to enter the concert arena");
			this.getSeat();
		} else {
			System.out.println("Visitor is not allowed to enter the concert arena");
		}
	}

	void getSeat() {
		System.out.println("Visitor can take your seat");
	}
}
