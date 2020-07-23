#include <stdio.h>
#include <stdlib.h>

int main() {
    int i = 100;
    int* p = malloc(4);
    *p = 200;
    printf("i = %d\n", *p);
    return 0;
}