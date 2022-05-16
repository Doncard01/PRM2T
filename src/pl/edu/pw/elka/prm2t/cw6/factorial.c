#include <stdio.h>


int factorial (int n) {
    if (n==0) {
        return 1;
    } else {
        return n* factorial(n-1);
    }
}

int factorial2 (int n) {
    int res = 1;
    for (int i = 1; i <= n; i++) {
        res *= i;
    }
    return res;
}

int main(int argc, char** argv) {
    short N = 4;
    int result = 1;

    printf("rekurencyjnie, %d! = %d \n", N, factorial(4));
    printf("nierekurencyjnie, %d! = %d", 5, factorial2(5));

}
