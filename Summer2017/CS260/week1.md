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
