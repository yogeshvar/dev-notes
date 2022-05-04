package org.tektutor;

public interface Iterator {
	public void first();
	public void next();
	public boolean isDone();
	public int currentItem();
}
