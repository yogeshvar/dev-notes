package org.tektutor.impl;

import org.tektutor.CalculatorService;

import javax.jws.WebService;

@WebService(endpointInterface = "org.tektutor.CalculatorService")
public class CalculatorServiceImpl implements CalculatorService {

	@Override
	 public int add(int a, int b) {
	  return a + b;
	 }

	 @Override
	 public int subtract(int a, int b) {
	  return a - b;
	 }

	 @Override
	 public int multiply(int a, int b) {
	  return a * b;
	 }

	 @Override
	 public int division(int a, int b) {
	  return a/b;
	 }

}
