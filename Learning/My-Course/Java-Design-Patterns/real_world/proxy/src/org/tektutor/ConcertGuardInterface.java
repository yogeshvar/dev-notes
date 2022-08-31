package org.tektutor;

import org.omg.CORBA.DynAnyPackage.TypeMismatch;

public interface ConcertGuardInterface {
	public void allowVisitor(int ticketId) throws TypeMismatch;
}
