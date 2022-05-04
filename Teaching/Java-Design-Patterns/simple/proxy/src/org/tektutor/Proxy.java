package org.tektutor;

public class Proxy implements Subject {
	private final RealSubject subject = new RealSubject();
	  
	@Override
	public void request() {
	  this.subject.request();
	}
}
