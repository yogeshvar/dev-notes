package org.tektutor;

abstract class PosterTemplate {
	public boolean isPoster; 
	  
    public abstract void doSelect(); 
  
    public abstract void doPayment(); 
  
    public final void createPoster() 
    { 
        try { 
            System.out.println("Poster creation -> successfull"); 
        } 
        catch (Exception e) { 
            System.out.println("Poster creation -> unsuccessful"); 
        } 
    } 
  
    public abstract void doPrint(); 
  
    public final int processOrder(boolean isPoster) 
    { 
        doSelect(); 
        doPayment(); 
        if (isPoster) { 
        	createPoster(); 
        } 
        doPrint(); 
        
        return 0;
    } 
}	
