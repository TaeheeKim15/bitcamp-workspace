#include <stdio.h>
#include <stdlib.h>

int main() {
    
    int* p = malloc(4);
    *p = 200;
    printf("i = %d\n", *p);
    return 0;
}

//point?pointer? 변수 -> 장소를 지정해주자