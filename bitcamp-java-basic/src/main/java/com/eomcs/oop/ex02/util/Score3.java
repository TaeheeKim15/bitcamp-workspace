package com.eomcs.oop.ex02.util;

public class Score3 {

// 특정 데이터 담기 적합한 변수 만들려고 클래스 정의
  public String name;
  public int kor;
  public int eng;
  public int math;
  public int sum;
  public float average;
    // 변수 설계도(Heap에 만들어진다)

    public void compute() {
      this.sum = this.kor + this.eng + this.math;
      this.average = this.sum / 3f;
      // 데이터를 다루는 연산자(Operator)를 정의한다
    }

    public void init(String name, int kor, int eng, int math) {
      this.name = name;
      this.kor = kor;
      this.eng = eng;
      this.math = math;

      this.compute();
    }
  }

// init -> initialize


