// 구현체(implementor) - 인터페이스(사용규칙)에 따라 만든 클래스 
package com.eomcs.oop.ex09.a.practice.after;

//문법
//=> class 클래스명 implements 인터페이스명, 인터페이스명, ... {...}
public class BlueWorker implements Worker {

	@Override
	public void execute() {
		System.out.println("육체 노동자가 일을 합니다.");
	}
}
