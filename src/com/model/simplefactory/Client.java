package com.model.simplefactory;

public class Client {

    public static void main(String[] args) {
        ICalculate cal = CalculateFactory.makeCal(Plus.class);
        System.out.println(cal.count(1, 2));
        ICalculate cal1 = CalculateFactory.makeCal(Minus.class);
        System.out.println(cal1.count(1, 2));
    }
}
