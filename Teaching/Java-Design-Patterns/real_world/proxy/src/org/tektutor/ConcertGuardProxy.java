package org.tektutor;

import org.omg.CORBA.DynAnyPackage.TypeMismatch;

public class ConcertGuardProxy implements ConcertGuardInterface {
	
	private ConcertSeating concertSeating = new ConcertSeating();

	@Override
	public void allowVisitor(int ticketId) throws TypeMismatch {
		if (ticketId == 1) {
		   System.out.println("Ticket is Valid");
		   concertSeating.allowVisitor(ticketId);
		} else {
			System.out.println("Ticket is not Valid, Please check your Ticket");
		}
	}
}
