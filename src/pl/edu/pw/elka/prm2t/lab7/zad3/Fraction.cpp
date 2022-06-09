#include "Fraction.h"
#include "math_utils.h"
#include <iostream>
#include "math_utils.cpp"

Fraction::Fraction() {
    numerator = 0;
    denominator = 1;
}

Fraction::Fraction(int n, int d) {
    numerator = n;
    denominator = d;
}

std::string Fraction::to_string() const {
    return std::to_string(numerator) + "/" + std::to_string(denominator);
}

Fraction Fraction::invert() const {
    auto new_fraction = Fraction(denominator, numerator);
    return new_fraction;
}

Fraction Fraction::add(Fraction other) const {
    int least = least_common_multiple(denominator, other.denominator);
    auto new_fraction = Fraction(numerator * least/denominator + other.numerator * least/other.denominator, least);
    return new_fraction;
}

Fraction Fraction::operator+ (const Fraction other) {
    return add(other);
}

int main() {
    std::cout << "a)" << std::endl;
    auto *f = new Fraction(3,4);
    auto g = f->invert();
    std::cout << g.to_string() << std::endl;
    std::cout << std::endl;

    std::cout << "b)" << std::endl;
    auto *f1 =new Fraction(3, 4);
    auto *f2 =new Fraction(1, 6);
    std::cout<< f1->to_string()<< " + "<< f2->to_string()<< " = ";
    std::cout<< (f1->add(*f2)).to_string()<< std::endl;
    std::cout << std::endl;

    std::cout << "c)" << std::endl;
    std::cout<< f1->to_string()<< " + "<< f2->to_string()<< " = ";
    std::cout<< (*f1+ *f2).to_string()<< std::endl;
    std::cout << std::endl;

    return 0;
}