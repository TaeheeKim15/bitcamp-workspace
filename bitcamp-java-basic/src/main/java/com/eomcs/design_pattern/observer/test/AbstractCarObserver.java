package com.eomcs.design_pattern.observer.test;

// 이 클래스는 CarObserver 구현체를 쉽게 만들 수 있도록
// 서브 클래스에 인터체이스의 메서드를 구현하여 상속해주는 역할만 하기 때문에
// 추상 클래스로 선언한다.
public abstract class AbstractCarObserver implements CarObserver{
	@Override
	public void carStarted() {
		// 서브 클래스가 인터체이스에 정의된 메서드 중에서
		// 원하는 메서드만 오버라이딩할 수 있도록
		// 수퍼 클래스에서 미리 구현한다
		// 단, 아무런 코드를 넣지 않는다.

	}

	public void carStoped() {

	}

}
