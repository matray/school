---
header-includes:
- \usepackage[american]{circuitikz}
- \usetikzlibrary{snakes,arrows,shapes}
- \usepackage{amsmath}
---
# Week 1

## Lecture 1
* Syllabus class

## Lecture 2
* Keep in mind programming assignments
* Review notes on slide The Order of Growth

### Proof below:

$f_3 (n)$ is not $O(f_1(n))$

Proof by contradiction

Assume $f_3(n)$ is $Of_1(n)$

$f_3(n) \leq cf_1(n), n \geq n_0$

$n^3 \leq cn^2, n \geq n_0, n even$

$n \leq cn^2, n \geq n_0, n even$

$n \leq c, n \geq n_0, n even$

* Contradiction, there are arbitrary even numbers

### Calculating the Running Time of Bubble Sort
* (3-6) O(1)
* (2-6) O(n-i)
* (1-6) $\sum_{n=1}^{n-i} = \frac{n-1+1}{2} (n-1) = \frac{n}{2} (n-1)$
* Review other time comparison and calculation examples

# Lecture 3
## Textbook problem 1.12d
```Pascal
Function fact(n:integer) : integer;
	begin
		if n<=1 then
			return 1
		else
			return n* fact(n-1)
	end; {fact}
```
* Operates in linear time

```Pascal
function F(n:integer):integer;
	begin
		if n<= 1 then
			return 1
		else
			return F(n-1) + F(n-1)
	end; {F}
```
* Operates in exponential time
* For this, it is the sum of $2^{n+1}-1$ from $j=0$ to $N$

## Analysis of Merge Sort
* Skipped note-taking for this part

# Reading Notes
## Wilf Chapter 0-1
* $f(x) = O(g(x))$ means that f(x) certainly doesn't grow at a faster rate than g. It might grow at the same rate or it might grow more slowly.
* Formally:
$$
f(x) = O(g(x)) (x \rightarrow \infty) if \exists C, x_0 s.t. |f(x)| < C g(x)
(\forall x > x_0)
$$
* We say that $f(x)=\theta (g(x))$ if there are constants $c_1 > 0, c_2 >0,x_0 s.t. \forall x>x_0$ it is true that $c_1 g(x) < f(x) < c_2 g(x)$
* We say that $f(x) = \Omega (g(x))$ if there is a $C >0$ and a sequence $x_1, x_2, x_3, .. \rightarrow \infty s.t. \forall j : | f(x_j)| > cg(x_j)$

## DSA 1.1-1.7
* $T(n)$ is defined as the worst case running time
* $T_{avg}(n)$ is the average time over all inputs of size n
* $O(n)$ means that there are positive constants $c$ and $n_0$ such that for $n \geq n_0$, we have $T(n) \leq cn$
* $O(f(x))$ means $f(x)$ is an upper bound on the growth of $T(n)$
* $\Omega (n)$ is the lower bound of the growth rate of $T(n)$

``` Pascal
procedure bubble (var A: array [1..n] of integer);
{bubble sorts array A into increasing order}
var
i,j,temp : integer;
begin
(1)	for i:=1 to n-1 do
(2)		for j:=n downto i+1 do
(3)			if A[j-1] > A[j] then begin
				{swap A[j-1] and A[j]}
(4)				temp:=A[j-1];
(5)				A[j-1]:=A[j];
(6)				A[j]:=temp
			end
end; {bubble}
```

* Lines 4, 5, and 6 are each O(1), by the sum rule, that is O(max(1,1,1)) = O(1)
* Lines 3,4,5,6 take O(1) time
* Outward to the for-loop from (2)-(6), this operates in O(n-1)
* Outward to the for-loop from (1)-(6), this is executed n-1 times
$$
\sum_{i=1}^{n-1} (n-i) = \frac{n(n-1)}{2} = \frac{n^2 - n}{2}
$$
* This comes out to operate $O(n^2)$

### Recursion
* Using the example below, for some constants c and d,
$$
T(n) = \left\{
		\begin{array}{ll}
			c + T(n-1) & \quad n >1 \\
			d & \quad n \leq 1
		\end{array}
		\right.
$$

```Pascal
function fact (n : integer): integer;
{fact(n) computes n!}
begin
(1)	if n<= then
(2)		fact:=1
	else
(3)		fact:=n*fact(n-1)
end; {fact}
```

* The running time for lines 1 and 2 is O(1), and for line 3 it is O(1) + T(n-1)
* This is where we get the above function for constants c and d
* Assuming n>2, we can expand T(n-1) to
$$
T(n)=2c+T(n-2) if n>2
$$
* T(n-1) = c + T(n-2) as can be seen by substituting n-1 for n in our above T(n) equation
* T(n) = 3c + T(n-3) if n>3
* In general:
$$
T(n) = ic + T(n-1) if n>i
$$
* When i=n-1, we get:
$$
T(n) = c(n-1) + T(1) = c(n-1)+d
$$


## DSA 9.1-9.2
* It's dirty daddy I don't want it
 
# Practice Problems
## 1.3
## 1.7 (reference: 4.1, 4.2 of Wilf)
## 1.10
## 1.11
## 1.12
## 1.13 (reference 1.1)
## 1.14
## 1.16 (reference 1.1)
## 1.17
## 1.18
