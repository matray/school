# Missed lecture 5

## Going over a problem
* x-> f(x), F(x)
* alpha lise in the range of the validity of x
* h(x) = f(x)/(1-F_x(alpha), x >= alpha
* = 0, x<=alpha
* A = {x<=x}
* B = {x > alpha}
* P(A|B) = P(AB)/P(B) = P(x <=x, x>alpha)/P(x>alpha)
* In general: P(A) = P(x <= x) = F_X(X)
* Know conditional random variables

## Using notes:
* [link here] (https://learn.dcollege.net/bbcswebdav/pid-5521114-dt-content-rid-28731144_1/courses/34746.201635/examples_week%233_9PM.pdf)

## Problem 8
* In terms of Bayes rule, what are we looking for? Conditional probability.
* P(x < 6 | x > 4)
* distribution function = 1-e^(-x/3) = F(x)
* P(x<=6, x>4)/P(x>4)
* Numerator becomes (F(6)-F(4))/(1-F(4))
* = ( e^(-4/3) - e^(-6/3) )/ e^(-4/3)
* Second part of the problem: that it lasts beyond 5 years
* P(x>5)/1-F(4)
* = (1-F(5))/(1-F(4)) = e^(-5/3)/e^(-4/3)

## Problem 9
* A person is picking numbers randomly between 0 and 2
* What is probability that the number picked lies between 1.5 and 1.75
* f(x), x=1/2, 0<=x<=2
* This becomes distribution function: f(x) = x/2 if 0 <=x<= 2, f(X) = 1 if x>2
* Becomes f(1.75)-f(1.5)
* Becomes 1.75/2 - 1.5/2
* Next part: What is probability it is less than 1, knowing that the number picked always is larger than 1/2
* looking for P(x<=1|x>1/2) = P(x<1, x>1/2)/P(x>1/2)
* Find in terms of variables and functions:
* (F(1)-F(1/2))/(1-F(1/2))
* General: P(A|B) will always be larger than P(A), the conditional probability will always be larger

## Problem not typed in examples:
* If x is random in {0,1}, what is P((x/(1+X) > 1/4)?
* What is F_x(x)?
* F_x(x) = 1, 0 <=x <= 1
* F_x(x) = x, 0<=x<=1
* P((x/(1+x)) >1/4) = P(4x > 1+x)
* = P(3x >1)
* = P(x>1/3)

## Problem 4
* = 1/2 + 1/4 * (x-3), 1<=x<=3
* 0 if x>5
* Valid PDF so what is CDF?

## Problem 7
* Integral, lower limit = 10, upperlimit x
* F_x(x) = integral from 10 to x for 10/y^2 dy
* = 1-10/x, x>10
* 3000hours in units of 100hours = 30 units
* P(x>30) = 1/3
* P(x>20) = 10/20 = 1/2

## Problem 11
* Sum, k=6, to 10(10_Choose_k * p^k * q^(10-k))
* P(at most 1 defective) = P(0 defective) + P(1 defective)
* = 0.*95^10 + 10(0.05)(95)^9
* = 0.9139
* p = 0.011

