package org.tektutor;
//Template creates many functions
public class DirectOrder extends PosterTemplate {

	@Override
    public void doSelect() 
    { 
        System.out.println("Customer chooses a poster from display book."); 
    } 
  
    @Override
    public void doPayment() 
    { 
        System.out.println("Pays at counter through cash/POS"); 
    } 
  
    @Override
    public void doPrint() 
    { 
        System.out.println("Poster print will be done"); 
    } 

}
