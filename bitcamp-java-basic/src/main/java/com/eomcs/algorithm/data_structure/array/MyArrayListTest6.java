package com.eomcs.algorithm.data_structure.array;

import java.util.ArrayList;

public class MyArrayListTest6 {

  public static void main(String[] args) {
    // aaa,bbb,ccc,ddd,eee,fff,ggg
    MyArrayList<String> list1 = new MyArrayList<>(100);
    list1.add("aaa");
    list1.add("bbb");
    list1.add("ccc");
    list1.add("ddd");
    list1.add("eee");
    list1.add("fff");
    list1.add("ggg");
    print(list1);
    System.out.println("------------------------");
    
    print2(list1);
    System.out.println("------------------------");
  }

  static void print(MyArrayList<String> list) {
    for (int i = 0; i < list.size(); i++) {
      String str = (String) list.get(i);
      System.out.print(str + ",");
    }
    System.out.println();
  }
  
  static void print2(MyArrayList<String> list) {
	  String[] arr = new String[list.size()];
	  String[] arr2 = list.toArray(arr);
	  System.out.println(arr == arr2);
	    for (int i = 0; i < list.size(); i++) {
	      String str = (String) list.get(i);
	      System.out.print(str + ",");
	    }
	    System.out.println();
	  }
}
