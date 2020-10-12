package com.eomcs.design_pattern.observer.test;

public class EnginOilCarObserver extends AbstractCarObserver {

	@Override
	public void carStarted() {
		System.out.println("엔진오일을 갈아용");		
	}



}
