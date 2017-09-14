package com.model.simplefactory;

public class CalculateFactory {

	public static ICalculate makeCal(Class c) {
		ICalculate cal = null;
		try {
			//c.getc
			cal = (ICalculate) Class.forName(c.getName()).newInstance();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return cal;
	}
}
