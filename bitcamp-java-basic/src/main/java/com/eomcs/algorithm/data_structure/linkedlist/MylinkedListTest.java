package com.eomcs.algorithm.data_structure.linkedlist;

public class MylinkedListTest {
public static void main(String[] args) {
  MyLinkedList list = new MyLinkedList();

  list.add("aaa");
  list.add("bbb");
  list.add("ccc");
  list.add("ddd");

  System.out.println(list.get(0));
  System.out.println(list.get(1));
  System.out.println(list.get(2));
  System.out.println(list.get(3));
  //System.out.println(list.get(4));
  // System.out.println(list.get(-1));
  System.out.println("--------------");

  print(list); // aaa, bbb, ccc, ddd,

  System.out.println("--------------");

  list.add(2,"eee");// aaa, bbb, eee, ccc, ddd,
  print(list);
  list.add(0, "fff");// fff, aaa, bbb, eee, ccc, ddd,
  print(list);
  list.add(6, "ggg");// fff, aaa, bbb, eee, ccc, ddd, ggg
  print(list);
  list.add("hhh"); // fff, aaa, bbb, eee, ccc, ddd, ggg, hhh
  print(list);

  System.out.println("--------------");

  list.remove(4); // fff, aaa, bbb, eee, ddd, ggg, hhh
  print(list);
  list.remove(0); // aaa,bbb,eee,ddd,ggg,hhh,
  print(list);
  list.remove(5); // aaa,bbb,eee,ddd,ggg,
  print(list);

  System.out.println("------------------");

  System.out.println(list.set(1,"xxx"));
  print(list);


  System.out.println(list.set(4,"yyy"));
  print(list);

  System.out.println(list.set(4,"zzz"));
  print(list);
  System.out.println("------------------");


  print2(list.toArray());
}

static void print(MyLinkedList list) {
  for (int i = 0; i < list.size(); i++) {
    System.out.print(list.get(i) + ",");
  }
  System.out.println();
}


static void print2(Object[] arr) {
  for (Object obj : arr) {
    System.out.print(obj + ",");
  }
  System.out.println();
}

}





























