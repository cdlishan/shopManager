package com.model.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

public class DynamicProxyImp {

	public static void main(String[] args) {
		ICalculate rcc = new RealCalculate();
		InvocationHandler pi = new ProxyInvocation(rcc);
		ICalculate ic = (ICalculate) Proxy.newProxyInstance(ICalculate.class.getClassLoader(), rcc.getClass().getInterfaces(), pi);
		ic.minus(2,1);
        ic.plus(2,1);
	}

}
