package com.eomcs.oop.ex10.practice.d;

public class Exam01 {

	public static void main(String[] args) {

		Hong s1 = new Hong();
		Kim s2 = new Kim();

		hi(s1);

		System.out.println("=========");

		hi(s2);
	}

	static void hi(Student student) {
		// Student 클래스에 정의된 introduce() 메서드를 호출한다
		// => introduce() 에서는 서브 클래스에서 구현한 greet(), say(), fighting()을 호출한다
		student.introduce();
	}
}
