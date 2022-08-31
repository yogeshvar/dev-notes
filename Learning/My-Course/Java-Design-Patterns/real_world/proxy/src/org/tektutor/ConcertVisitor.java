package org.tektutor;

import java.util.Scanner;

import org.omg.CORBA.DynAnyPackage.TypeMismatch;

public class ConcertVisitor {

		public static void main(String[] args) {
			System.out.println("Welcome to Concert");
			ConcertGuardInterface concertGuard = new ConcertGuardProxy();
			Scanner inputValue = new Scanner(System.in);
			System.out.println("Please enter your ticketNo");
			int ticketId = inputValue.nextInt();
			inputValue.close();
			System.out.println("Visitor has come to concert");
			try {
				concertGuard.allowVisitor(ticketId);	//Allows the visitor only if ticket id is matched
			} catch (TypeMismatch e) {
				e.printStackTrace();
			}
		}
}
