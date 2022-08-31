package org.tektutor;

public class TemplatePattern {
	public static void main(String[] args) 
    { 
        PosterTemplate internetOrder = new InternetOrder(); 
        internetOrder.processOrder(true); 
        System.out.println(); 
        PosterTemplate directOrder = new DirectOrder(); 
        directOrder.processOrder(true); 

    } 
}	
