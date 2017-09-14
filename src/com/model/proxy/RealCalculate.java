package com.model.proxy;

public class RealCalculate implements ICalculate {

	@Override
	public void plus(int a, int b) {
		System.out.println("运算加法:a+b="+(a+b));

	}

	@Override
	public void minus(int a, int b) {
		System.out.println("运算减法:a-b="+(a-b));

	}

}
