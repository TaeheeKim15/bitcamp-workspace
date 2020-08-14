package com.eomcs.corelib.ex03.trash;

// 클래스가 로딩된다고?
public class MyArrayListTest2 {
  public static void main(String[] args) {
    MyArrayList.add("aaa"); // aaa
    print();
    MyArrayList.add("bbb"); // bbb, ccc
    print();
    MyArrayList.add("ccc"); // aaa, bbb, ccc
    print();
    MyArrayList.add("ddd"); // aaa, bbb, ccc, ddd
    print();
    MyArrayList.add("eee");// aaa, bbb, ccc, ddd, eee
    print();
    MyArrayList.add("fff");// aaa, bbb, ccc, ddd, eee, fff
    print();
    MyArrayList.add("ggg");// aaa, bbb, ccc, ddd, eee, fff
    print();
    MyArrayList.add("hhh");// aaa, bbb, ccc, ddd, eee, fff
    print();

    MyArrayList.add(8, "iii");// aaa, bbb, ccc, ddd, eee, fff, ggg, hhh, iii
    print();

    MyArrayList.add("jjj");// aaa, bbb, ccc, ddd, eee, fff, ggg, hhh, iii
    print();

    System.out.println(MyArrayList.get(9));
  }

  static void print() {
    for (int i = 0; i < MyArrayList.size; i++) {
      String str = (String) MyArrayList.get(i);
      System.out.print(str + ",");
    }
    System.out.println();
  }


}
