cmake_minimum_required(VERSION 3.21)
project(PRM2T C)

set(CMAKE_C_STANDARD 11)

add_executable(factorial
        src/pl/edu/pw/elka/prm2t/cw6/factorial.c)

add_executable(ackf
        src/pl/edu/pw/elka/prm2t/cw7/ackf.c)
