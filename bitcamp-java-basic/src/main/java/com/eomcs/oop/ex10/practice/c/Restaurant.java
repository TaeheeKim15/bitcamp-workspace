// Build을 상속 받아 템플릿 메서드인 startEffect()와 endEffect()를 구체화시킨다.
package com.eomcs.oop.ex10.practice.c;

public class Restaurant extends Building {


	@Override
	public void startEffect() {
		System.out.println("뚝딱...뚝딱...");
	}

	@Override
	public void endEffect() {
		System.out.println("와우~ 배고픔에서 해방!");
	}
}
