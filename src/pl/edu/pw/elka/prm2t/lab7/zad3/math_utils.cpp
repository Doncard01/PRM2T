#include "math_utils.h"

bool is_divisor(int d, int n) {
    return (n / d) * d == n;
}

int max(int a, int b) {
    return a > b ? a : b;
}

int least_common_multiple(int a, int b) {
    for (int m = max(a, b); ; m ++) {
        if (is_divisor(a, m) && is_divisor(b, m))
            return m;
    }
}