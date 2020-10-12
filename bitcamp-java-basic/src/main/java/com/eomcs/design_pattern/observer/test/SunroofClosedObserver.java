package com.eomcs.design_pattern.observer.test;

public class SunroofClosedObserver extends AbstractCarObserver {

	@Override
	public void carStarted() {

	}

	@Override
	public void carStopped() {
		System.out.println("선루프를 닫습니다.");

	}


}
