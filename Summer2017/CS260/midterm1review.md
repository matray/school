# Midterm Review
## 2
* a=4, b=2, d(n)=c_1 n
* a=3, b=2, d(n) = c_2 n
* you can divide the equation by c_1 and c_2, incorporate the rest, the
* start condition will change, making it easier to see
* Example 9.4 Page 302 to go over this procedure
* may assume c_1, c_2 = 1
* a>d(b) in both cases
* d(b) is two in both cases
* in first case a is 4, second case a is 3
* first case order n^(log_2(4)) = n^2
* second n^(log_2(3))
* the second algorithm has a better performance
## cell space example on screen
```Pascal
procedure F(x:elementtype; var L:List);
var
	p:position;
begin;
	p:=First(L);
while???????
```
* maybe in notes????
## question 4
* ops := n+1 during execution
* p<>END iv verified n+1 times
* total time (n+1)(n+1), order from above and below is n^2

## question 5
* F(n)
* G(n) number of calls during completing F(n)
* G(n) = G(n-2) + G(n-1) +1
* G(0) = G(1)=1
* Step 1: Solve the general homogeneous pattern G(n) = G(n-2)+G(n-1)
* assume form is something like a^n = a^(n-2) + a^(n-1)
* a^2 = 1 + a
* quadratic equation, solves to alpha+ = (1+sqrt(5))/2, alpha- =
* (1-sqrt(5))/2
* for both, once you plug it in, you git it figured out
* G(n) = c_1 a+^n + c_2 a-^n
* Step 2 Find a particular solution of the non-homogeneous problem
* G(n) = G(n-2) + G(n-1) +1
* c = c+c+1
* c=-1
* Step 3
* G(n) = c_1 a+^n + c_2 a-^n -1
* G(0) = 1
* G(1) = 1
* c_1 = 1 + (sqrt(5)/5)
* c_2 = 1 - (sqrt(5)/5)

## question 6
* This was done in class
* preorder A(internal node) B(internal node) D(leaf) E(internal node)H(leaf)
* (leaf)I(leaf)J(leaf)C(internal node)F(leaf)G(leaf)
* postorder D(leaf) H (leaf)IJEB(internal node) FGCA(internal node)a
* reference above preorder for postorder notes

