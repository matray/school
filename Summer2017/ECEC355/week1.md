---
header-includes:
- \usepackage[american]{circuitikz}
- \usetikzlibrary{snakes,arrows,shapes}
- \usepackage{amsmath}
---

# Lecture 1

* Form groups
* Odd weeks, no change to wednesday time
* Even weeks, though, only groups 1-3 come 3-4, groups 4-7 come 4-5
* Lecture slides were gone over and in this folder
* This is so fucking painful to sit through
* He is going over the non(?) credit homework and how to do them, really  basic math

# Lecture 2
* Equation sheet given out:

$Performance: \frac{1}{Execution Time}$

$Clock Cycle Time: \frac{1}{Clock Rate}$

$Execution Time1: \frac{Number of Clock Cycles}{Clock Rate}$

$Execution Time2: Number of Clock Cycles * Clock Cycle Time$

$Number of Clock Cycles: Number of Instructions * Average CPI$

$Execution Time3: \frac{Number of Instructions * Average CPI}{Clock Rate}$

$Execution Time4: Number of Instructions * Average CPI * Clock Cycle Time$

$Average CPI: \sum CPI_i * f_i, where i refers to instruction class i$

$SPECRatio: \frac{Reference Time}{Execution Time}$

$MIPSRating: \frac{Clock Rate}{10^6 * AverageCPI}$

$MFLOPSRating: \frac{Clock Rate}{10^6 * CPI_{FP}}$

## Problem Solving

### 1.6

P | Clock |A | B | C | D
--+-------+--+---+---+--
P1 | 2.5GHz | 1 | 2 | 3 | 4
P2| 3GHz | 2 | 2 | 2 | 2

* Number of iterations = $10^6$

* Frequency:

A|B|C|D
-+-+-+-
10|20|50|20
0.1|0.2|0.5|0.2

* Average CPI for P1 =  $1*0.1+2*0.2+3*0.5+3*0.2$ = 2.6
* Average CPI for P2 = $2.0$

* Exec time of P1 = $\frac{2.6*10^6}{2.5*10^9} = 1.04 ms$
* Exec time of P2 = $\frac{2.0*10^6}{3*10^9} = 0.67 ms$

* Performance Ratio = $\frac{Exec Time P1}{Exec Time P2} = \frac{1.04}{0.67} = 1.532$
* P2 is 55.21 faster

### 1.7

Compiler | Number of Instructions| Exec Time
-+-+-
A|$1.0*10^9$|1.1 s
B|$1.2*10^9$|1.5 s

* Clock Cycle Time = 1ns
* ***Use E2***
* Use Execution Time 2 Formula
* 1.1 = $10^9 * CPI_A * 10^{-9}$
* $CPI_A$ = 1.1
* 1.5 = 1.2*$10^9 * CPI_B * 10^{-9}$
* $CPI_B$ = $\frac{1.5}{1.2}$ = 1.25
* ***Use E1***
* $\frac{1.0*10^9*1.1}{ClockRate(P1)} = \frac{1.2*10^9*1.25}{ClockRate(P2)}$
* $\frac{ClockRate(P1)}{ClockRate(P2)} = 0.733$
* Clock Rate of P1 should be 26.7% slower

### SPEC Ratio
* System Performance Evaluation C?

### 1.11
* SPEC CPU2006 Ref = 9650 s
* Exec time = 750 s
* Insreuction Count = $2.389*10^{12}$
* 750 = $2.389*10^{12}$ * CPI * 0.333*$10^{-9}$
* SpecRation = $\frac{9650}{750*whatever value is from above I think}$

### 1.116
* New 2
* Number of instructions = $2.389*10^{12} * 0.85$
* Execution Time = 700 s
* New Rate = 13.2
* $\frac{9650}{700}$ = 13.2
* 700 = $\frac{2.389*10^{12} * 0.85 * CPI}{4*10^9}$
