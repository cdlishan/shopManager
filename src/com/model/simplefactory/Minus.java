package com.model.simplefactory;

public class Minus implements ICalculate {

	@Override
	public int count(int a, int b) {
		// TODO Auto-generated method stub
		System.out.println("进入减法类");
		return a-b;
	}

}
