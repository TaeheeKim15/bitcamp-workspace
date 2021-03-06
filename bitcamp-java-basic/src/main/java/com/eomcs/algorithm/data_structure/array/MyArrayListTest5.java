package com.eomcs.algorithm.data_structure.array;

import java.util.ArrayList;

public class MyArrayListTest5 {

  public static void main(String[] args) {
    // aaa,bbb,ccc,ddd,eee
    MyArrayList<String> list1 = new MyArrayList<>();
    list1.add("aaa");
    list1.add("bbb");
    list1.add("ccc");
    list1.add("ddd");
    list1.add("eee");
    list1.add("fff");
    list1.add("ggg");
    list1.add(1, "fff"); // aaa,fff,bbb,ccc,ddd,eee
    list1.set(3, "ggg"); // aaa,fff,bbb,ggg,ddd,eee
    print(list1);
    System.out.println("------------------------");
  }

  static void print(MyArrayList<String> list) {
    for (int i = 0; i < list.size(); i++) {
      String str = (String) list.get(i);
      System.out.print(str + ",");
    }
    System.out.println();
  }
}
