---
header-includes:
- \usepackage[american]{circuitikz}
- \usetikzlibrary{snakes,arrows,shapes}
- \usepackage{amsmath}
---
# Week 6 Notes
* $\phi$ is a basis vector

$$
x[n] = \sum_k a_k \phi_k [n] = \sum_k a_k e^{jk(2\pi /N)n}
$$

# Example

$$
x[n] = \cos(\omega_0 n)
$$

## Finding the spectrum: functional
* Given: $N=4$
* $\cos$ is made up of two complex exponentials

$$
\cos(\omega_0 n) = \frac{e^{j \omega_0 n} + e^{-j \omega_0 n}}{2}
$$

$$
= \frac{e^{j \omega_0 n}}{2} + \frac{e^{-j \omega_0 n}}{2}
$$

* In our spectrum we should see two discrete points at (-1, 1/2) and (1, 1/2)
* Is that the true spectrum? No.
* Because N=4
* this is only k=1, need more k values as it is repeatable every 4 points
* points also exist at (3, 1/2), (5, 1/2), (-3, 1/2), (-5, 1/2)
* Points of interest are (0,N\A), (1, 1/2) and (3, 1/2)

## Finding the spectrum: mathematical
* Expand out the Fourier transform of it for one k, then after getting a basis, you can say it will repeat with that basis for N points

# Properties
## Multiplication
* Multiplication in one domain is convolution in another

$$
x[n]y[n] -> d_k = \sum_{l=<N>} a_l b_{k-l}
$$

## Parseval's Relation

$$
\frac{1}{N} \sum_{n=<N>} |x[n]|^2 = \sum_{k=<N>}|a_k|^2
$$

* TEST WEDNESDAY WILL BE CONTINUOUS STUFF ON FOURIER SERIES
