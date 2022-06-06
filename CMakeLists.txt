cmake_minimum_required(VERSION 3.21)
project(PRM2T C)

set(CMAKE_C_STANDARD 11)

add_executable(factorial
        src/pl/edu/pw/elka/prm2t/cw6/factorial.c)

add_executable(ackf
        src/pl/edu/pw/elka/prm2t/cw7/ackf.c)

add_executable(zad1
        src/pl/edu/pw/elka/prm2t/lab7/zad1.c)

add_executable(zad2
        src/pl/edu/pw/elka/prm2t/lab7/zad2.c)

add_executable(zad3
        src/pl/edu/pw/elka/prm2t/lab7/zad3.c)
        
