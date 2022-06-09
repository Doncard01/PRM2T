#ifndef __FRACTION_H
#define __FRACTION_H

#include <string>

class Fraction {

private:
    int numerator, denominator;

public:
    Fraction();
    Fraction(int n, int d);
    std::string to_string() const;

    Fraction invert() const;
    Fraction add(Fraction other) const;

    Fraction operator+ (const Fraction other);
};

#endif