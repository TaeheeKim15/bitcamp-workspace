package com.eomcs.oop.practice.ex01;

import com.eomcs.oop.practice.ex01.sub.Y2;

// import 사용 후

public class Exam0720 {
	public static void main(String[] args) {


		// 다른 패키지의 클래스를 사용할 때 마다
		// 패키지명을 적는 다면 너무 코드가 길어진다
		// 이를 위해 자바는 import라는 명령어를 제공한다
		// 클래스를 사용하기 전에 미리 해당 클래스가 어느 패키지에 있는 지 지정하는 것이다
		// 문법
		// import 패키지명.클래스명
		// 
		Y2 obj;
		obj = new Y2();
	}

}
