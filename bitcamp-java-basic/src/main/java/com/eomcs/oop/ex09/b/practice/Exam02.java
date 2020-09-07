// 인터페이스의 모든 메서드는 public이다. 
package com.eomcs.oop.ex09.b.practice;

public class Exam02 implements A3 {

	// public 보다 좁게 공개 범위를 줄일 수 없다.
	//private void m1() {}  // 컴파일 오류!
	//protected void m1() {} // 컴파일 오류!
	//void m1() {} // 컴파일 오류!
	//void m2() {} // 컴파일 오류!

	// 반드시 public 이어야 한다.
	@Override
	public void m1() {}
	@Override
	public void m2() {}

}
