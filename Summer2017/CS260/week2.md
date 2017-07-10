---
header-includes:
- \usepackage[american]{circuitikz}
- \usetikzlibrary{snakes,arrows,shapes}
- \usepackage{amsmath}
---
# Week 2 Lecture Notes
## Recurrence Relations in the Context of a Divide-and-Conquer Addition Circuit

$$
n=2^k

(i)

D(n) = D(2^k) = D(2^{k-1}) + 3

D(2^{k-2}) + 3 + 3 = D(2^{k-3}) + 3 + 3 + 3

D(2^{k-i}) + 3i = D(1) + 3k = 3+3k

$$

* When $k=log_2(n)$: $3(1+log_2(n))$

## Other examples

$$

G(1) = 9

G(2n) = 2G(n)+6n+6

G(n) = G(2^k) = 2G(2^{k-1}) + 6*2^{k-1} + 6

2(2G(2^{k-2}) + 6*2^{k-2} + 6) + 6*2^{k-1} + 6

2^2 G(2^{k-2}) + 6*2^{k-1} + 6*2^{k-2} + 6(2+1)

2^3 G(2^{k-3}) + 6*2^{k-1} + 6*2^{k-1} + 6(2^2 + 2^1 + 2^0)

$$

$2^i G(2^{k-i}) + i*6*2^{k-1} + 6 * \sum_{j=0}^{i-1} 2^j$


$2^k * G(1) + k * 6 * 2^{k-1} + 6 * \sum_{j=0}^{k-1} 2^j$

$$

9*2^k + 3*k*2^k + 6(2^{k -1}) = 15*2^k + 3 k 2^k = 6

15n + 3 n log_2(n) - 6

$$

## 1.13 (d)

$\sum_{i=1}^n i^k\ is\ O(n^{k+1})\ and\ \omega(n^{k+1})$

$O(n^{k+1}) : \sum_{i=1}^n i^k \leq \sum_{i=1}^n n^k$

## 9.3,9.4 Recurrence question

$$

T(1) = 1

T(n) = aT(\\frac{n}{b}) + d(n) 

T(n) = T(b^k) = aT(b^{k-1}) + d(b^k)

a(aT(b^{k-2}) + d(b^{k-1})) + d(b^k)

a^3 T(b^{k-3}) + a^2 d (b^{k-2}) + ad(b^{k-1}) + d(b^k)

$$

$a^i T(b^{k-i} + \sum_{j=0}^{i-1} ajd(b^{k-j})$

# Friday Class
* T(1) = 1
* T(n) = aT(n/b) + d(n)
* d(n) is the driving function
* Divide up to sub-problems of size n/b
* Merge sort
* a=6=2
* d(n) = $c_2$n
* May assume $c_2$ = 1
* $T(n)=a^k + \sum_{j=0}^{k-1} a^j d (b^{k-j})$
* $T(n)=T(b^k)=a^k + d(b)^k \sum_{j=0}^{k-1} (\frac{a}{d(b)})^j$

## Match?
* $a > d(b) : \frac{a}{d(b) - 1 > 0$,(i) growth of $a^k$
* $a < d(b) : \frac{a}{d(b)} -1 < 0$, (ii) growth of $d(b)^k$
* $a=d(b)$, (iii) growth of $k(d(b))^k$

## Problem 1.12(b)

```Pascal
procedure mystery (n: integer):
var
	i,j,k:integer;
	begin
	for i:=1 to n-1 do
		for j:=i+1 to n do
			for k:=1 to j do
				{some statement requiring O(1) time}
	end; {mystery}
```

### Analysis

$$
\sum_{i=1}^{n-1} \sum_{j=i+1}{n} j
$$

$$
\sum_{j=i+1}{n} j = \frac{n+i+1}{2} (n-i)
$$

$$
\frac(n+2){2} (n-i) \leq \frac{n+i+1}{2} (n-i) \leq \frac{2n}{2}(n-i) = n(n-i), i=1,..,n-
$$

$$
\frac{n+2}{2} \sum_{i=1}^{n-1}(n-i) \leq \sum_{i=1}^{n-1} \sum_{j=i+1}^{n} \leq n \sum_{i=1}^{n-1} (n-i)
$$

$$
internal sum only:\frac{n}{2} (n-1)\leq the middle part sum \leq internal
sum only\frac{n}{2}(n-1)
$$

* Estimate from above: $\frac{n^2}{2} (n-1)$
* Estimate from below: $\frac{n+2}{2}\frac{n}{2} (n-1)$
* f(n) is of order $n^3$ $O(n^3) and \Omega(n^3)$

## Problem 1.13 (e)
* $f(n) = a_k n^k + a_{k-1} n^{k-1} + ... + a_1 n + a_0$
* $a_k > 0$
* f(n) is of order $n^k (O(n^k) and \Omega(n^k))$
* now divide first equation $n^k$
* you get:
* $a_k + \frac{a_{k-1}}{n} + ... + \frac{a_1}{n^{k-1}} + \frac{a_0}{n^k} -> a_k$
* $\frac{a_k}{2} \leq \frac{f(n)}{n^k} \leq 2a_k$
* $\frac{a_k}{2} n^k \leq f(n) \leq 2a_k n^k$
