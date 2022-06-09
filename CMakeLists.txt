cmake_minimum_required(VERSION 3.21)
project(PRM2T C CXX)

set(CMAKE_C_STANDARD 11)
set(CMAKE_CXX_STANDARD 17)

add_executable(factorial
        src/pl/edu/pw/elka/prm2t/cw6/factorial.c)

add_executable(ackf
        src/pl/edu/pw/elka/prm2t/cw7/ackf.c)

add_executable(zad1
        src/pl/edu/pw/elka/prm2t/lab7/zad1/zad1.c)

add_executable(zad2
        src/pl/edu/pw/elka/prm2t/lab7/zad2/zad2.cpp)

add_executable(Fraction
        src/pl/edu/pw/elka/prm2t/lab7/zad3/Fraction.cpp)

add_executable(math_utils
        src/pl/edu/pw/elka/prm2t/lab7/zad3/math_utils.cpp)
        
