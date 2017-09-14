package com.model.simplefactory;

public class Plus implements ICalculate {

	@Override
	public int count(int a, int b) {
		System.out.println("进入加法类");
		return a+b;

	}

}