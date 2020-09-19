package com.eomcs.oop.practice.ex01;

// 클래스 사용 : 1) 일반 변수 사용

public class Exam0110 {

	public static void main(String[] args) {
		// 낱개 변수 사용해 한 사람의 성적 정보 저장하기
		// 식탁에 밥, 국, 반찬1, 반찬2, 반찬3 을 각각 따로 가져오는 상황

		// 학생 정보 다루기
		// 학생 성적 정보는 이름, 국어, 영어, 수학, 합계, 평균값으로 되어있다
		// 자바는 우리가 원하는 형식의 값(성적 데이터)을 저장할 수 있는 메모리 유형 제공 안함
		// 단, 데이터 최소 형식인 byte, short, int, long, float, double, boolean, char, String
		// 등의 값을 담을 수 있는 메모리만 제공
		// 해결
		// - 낱개의 데이터를 저장할 변수를 여러 개 선언하는 수 밖에 없다
		// - 그래서 성적 데이터를 저장할  변수를 다음과 같이 낱개로 선언한다.
		//
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
		sum = kor + eng + math;
		aver = (float) sum / 3;

		System.out.printf("%s: %d, %d, %d, %d, %.1f\n", name, kor, eng, math, sum, aver);
	}

}
