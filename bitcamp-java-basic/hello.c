#include <stdio.h>
#include <stdlib.h>

// function prototype (함수를 미리 소개합니다~)
void f1(int);
void f2(int*);
int main() {
  int a = 200;

  f1(a);

  printf("a = %d\n", a);

f2(&a);

printf("a = %d\n", a);


 return 0;

}

void f1(int a) {
  a = 100;
}

// main에서의 a와 void f1에서의 a는 다른 변수~~

void f2(int* p) {
  *p = 100;
}