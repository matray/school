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
