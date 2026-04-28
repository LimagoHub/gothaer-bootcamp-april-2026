#include <stdio.h>

typedef int(*MFptr)();
typedef double(*Op)(double,double);

int sinnDesLebens() {
    return 42;
}

double add(double a, double b) {
    return a + b;
}

int main(void) {
    MFptr a = sinnDesLebens;
    Op b = add;


    return 0;
}