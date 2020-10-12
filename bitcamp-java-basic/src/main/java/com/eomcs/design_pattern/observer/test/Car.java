package com.eomcs.design_pattern.observer.test;

import java.util.ArrayList;
import java.util.List;

public class Car {

	List<CarObserver> observers = new ArrayList<>();

	public void addCarObserver(CarObserver observer) {
		observers.add(observer);
	}

	public void remove(CarObserver observer) {
		observers.remove(observer);
	}

	//리팩토링: 메서드 추출 (extract method)
	// - 특정 기능을 수행하는 코드를 이해하기 쉽도록 외부 메서드로 추출하는 것
	public void notifyCarObserverOnStart() {
		for (CarObserver observer : observers) {
			observer.carStarted();
		}
	}

	public void notifyCarObserverOnStop() {
		for (CarObserver observer : observers) {
			observer.carStopped();
		}
	}

	public void start() {
		System.out.println("시동을 건다.");

		notifyCarObserverOnStart();
	}

	public void run() {
		System.out.println("달린다.");
	}

	public void stop() {
		System.out.println("시동을 끈다.");

		notifyCarObserverOnStop();
	}


}


