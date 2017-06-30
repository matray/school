# Lecture 7

## Poisson distribution
* P{x=k} = lambda^k * e^(-lambda) /k!, k=0,1,2,3...
* Mean = lambda
* var = lambda

## Binomial distribution
* P{x=k} = nCk * p^k * q^(n-k), k=0,1,2...
* n, p, q = 
* q = 1-p
* Mean = n*p
* Var = n*p*q

## Back to problem set
### Problem 3
* [find problems here](https://learn.dcollege.net/bbcswebdav/pid-5527383-dt-content-rid-28852376_1/courses/34746.201635/new_examples_set_week4%281%29.pdf)
* F_x(x) = [1-e^(-x/5)]
* P(x <=x|x<=8) = F_x(x)/F_x(8)

### Problem 4
* f_x(x) = 1/2*pi, -pi <= x<= pi
* A = 2cos(x)
* B = 3sin(x)
* Trying to find mean, need to first find expected value of A
* E{A} = integral of( A f_x(x) ) = E{2 *cos(x)} = 2E{cos(x)} = 0
* E{B} = 0
* If mean is 0, variance is the second moment?
* Variance of A = E{A^2}
* Variance of B = E{B^2}
* E{A^2} = E{4cos^2(x)} = 4E{cos^2(x)} = 2
* E{B^2} = var{B} = 9/2?

* GENERAL IDEA: cos(2*theta) = 2cos^2(theta)-1

### Problem 6
* Noise is uniform
* Change -5, X<-5 to A
* Change 2, -5<X<5 to B
* Change 5, X>5 to C
* E{V} = integral of ( V f_x(X) dx ) = 1/20 integral of ( V dx )
* E{V} = 1/20 [integral from -10 to -5 of (A dx) + integral from -5 to 5 of( B dx) + integral from 5 to 10 of (C dx)]
* E{V^2} = 1/20 [integral from -10 to -5 of (A^2 dx) + integral from -5 to 5 of (B^2 dx) + integral from 5 to 10 of (C^2 dx) ]


### Problem 7
* DON'T INTEGRATE
* Power = 5x^2, if x is the current
* E{P} = E{5x^2} = 5*E{x^2} = 5*27
* GENERAL: E{x^2} = Var{x} + Mean^2
* P{P^2} = 25E{x^4}
* E{x^4} = [E{x}]^4 + 6[E{x}]^2 * var{x} + 3(var{x})^2

### Problem 8
* x is rayleigh distribution = x/b^2 * e^(-x^2 / 2b^2) * U(X)
* Average power is 5 mW
* E{x^2} = 2b^2 = 5
* CDF = 1-e^(-x^2/2b) = 1-e^(-x^2/5)
* P{x^2 > 8} = P{x>sqrt(8)}
* =e^(-8/5)
* Recall P{x=k} = (lambda^k * e^-lambda)/k! = (4^k * e^-4)/k!
* P{x >8} = 1- sum(k-0, 8){(4^k * e^-4)/k!}
* P{x=k} = 4Ck * p^k (1-p)^(4-k), k = 0, 1, 2, 3, 4
* = (1/2)^4 * 4Ck
* Mean = np

---------------------MIDTERM GOES TO HERE, NO NEED TO COVER GAUSIAN SHIT----------------------


