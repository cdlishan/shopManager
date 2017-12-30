package com.leo.callback;

public class Caller {

	private ICalculate ic;
	
	public Caller(ICalculate ic) {
		this.ic = ic;
	}

	public void processCal() {  
        ic.calcute();
    }  
}
