package com.eomcs.design_pattern.observer.test;

public class LightoffObserver extends AbstractCarObserver {

	@Override
	public void carStarted() {
		// TODO Auto-generated method stub

	}

	@Override
	public void carStopped() {
		System.out.println("전조등을 끄장!");

	}

}
