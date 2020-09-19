package com.eomcs.oop.practice.ex01;

// 클래스 사용 : 4) 메서드 활용

public class Exam0113 {

	// 여러 메서드에서 클래스를 사용한다면
	// 이렇게 메서드 밖에 선언해야 한다.
	// => static 메서드에서 사용할 수 있게 클래스도 static으로 선언한다.
	static class Score {
		String name;
		int kor;
		int eng;
		int  math;
		int sum;
		float aver;
	}

	public static void main(String[] args) {

		Score s = new Score();

		s.name = "홍길동"; // s에 저장된 주소로 찾아가서 name 항목에 값 저장
		s.kor = 100; // s에 저장된 주소로 찾아가서 kor 항목에 값 저장
		s.eng = 90; 
		s.math = 85;

		// 성적 데이터를 클래스로 묶어 놓으면 값을 다루기가 편하다
		// => 다음과 같이 성적 데이터를 한 번에 넘길 수 있다
		printScore(s);

	}

	static void printScore(Score s) {
		s.sum = s.kor + s.eng + s.math;
		s.aver = s.sum / 3;
		System.out.printf("%s: %d, %d, %d, %d, %.1f\n",
				s.name, s.kor, s.eng, s.math, s.sum, s.aver);
	}
}
















