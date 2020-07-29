#include <stdio.h>
#include <stdlib.h>

int main() {



  int i[3];
  i[0] = 100;
  i[1] = 200;
  i[2] = 300;
  
  printf("%d, %d, %d\n", i[0], i[1], i[2]);
  
  int* p;
  
 
  // p = &i[0];
  p = i;
  printf("%d\n", *(p + 2));

  
  int* p2 = (int*)malloc(sizeof(int) * 3);
  
  *p2= 110;
  *(p2 + 1) = 220;
  *(p2 + 2) = 330;

  printf("%d, %d, %d\n", *p2, *(p2 + 1), *(p2 + 2));
  printf("%d, %d, %d\n", p2[0], p2[1], p2[2]);

  
  printf("%d\n", *(p2 + 3));
  printf("%d\n", p[3]);
  
  
  free(p2);
  
  printf("%d, %d, %d\n", *p2, *(p2 + 1), *(p2 + 2));
  
  return 0; 

}

