package org.tektutor;

public class Facade {
	private final SubSystemA subsystemA;
	private final SubSystemB subsystemB;
	private final SubSystemC subsystemC;
	  
	Facade() {
	    this.subsystemA = new SubSystemA();
	    this.subsystemB = new SubSystemB();
	    this.subsystemC = new SubSystemC();
	 }
	  
	 void operation1() {
	    this.subsystemA.suboperation();
	 }
	  
	 void operation2() {
		this.subsystemB.suboperation();
	 }
	 
	 void operation3() {
		this.subsystemC.suboperation();
	 }
}
