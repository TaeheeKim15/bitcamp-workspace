package com.eomcs.design_pattern.observer.test;

public class BrakeOilObserver extends AbstractCarObserver {

	@Override
	public void carStarted() {
		System.out.println("브레이크 오일을 검사해용!");

	}

	@Override
	public void carStopped() {

	}

}
