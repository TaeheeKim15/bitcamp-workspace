package com.eomcs.oop.practice.ex01;

// 클래스 사용 : 2) 메서드 활용

public class Exam0111 {
	public static void main(String[] args) {
		String name;
		int kor;
		int eng;
		int  math;
		int sum;
		float aver;

		name = "홍길동";
		kor = 100;
		eng = 90;
		math = 85;

		// 메서드 추출
		// - 학생 정보를 출력하는 명령어를 별도의 블록으로 뺐다
		// - 유지보수를 위해 성적을 출력하는 명령어를 별도의 블록으로 뺀다
		// - 출력형식 바꾸고 싶으면 그 블록으로 가서 변경하자
		//
		printScore(name, kor, eng, math);

	}

	static void printScore(String name, int kor, int eng, int math) {
		int sum = kor + eng + math;
		float aver = sum / 3f;
		System.out.printf("%s: %d, %d, %d, %d, %.1f\n", name, kor, eng, math, sum, aver);
	}

	// 만일 과목이 여러개라면??
	// 메서드 파라미터가 많아져서 메서드 선언할 때 복잡해질것
	// 이 성적 데이터를 한 봉다리에 담을 수 있는 방법은 없을까?
	//
	// 자바는 모든 경우 고려해 다양한 종류의 값을 담을 수 있는 변수 제공 X
	// 대신 여러 종류의 데이터를 묶어 새로운 형태의 데이터 타입을 만들 수 있는 문법을 제공하지
	// 그게 바로 클래스
	//
	// 클래스?
	// - 개발자가 자신이 개발하는 프로그램에서 사용할 특별한 형식의 데이터를 다룰 수 있는
	//  새로운 데이터 타입을 정의해주는 문법
	// - 즉  byte, short, int, long, float, double, boolean, char 외에
	// 새 형식의 새로운 메모리 구조를 갖는 데이터 타입을 정의할 수 있다
	// - 이렇게 정의한 새 데이터 타입을
	// 사용자 정의 데이터 타입(user defined data type)이라고 한다
	//
	// 여기서 사용자란 자바 언어를 사용하는 개발자를 일컫는다.
	//
	// 클래스 문법의 활용
	// 1) 사용자 정의 데이터 타입과 그 타입의 값을 다루는 연산자를 정의할 때 사용한다
	// 2) 서로 관련된 일을 하는 메서드를 관리하기 쉽게 분류하여 묶는 용도로 사용한다

}
















