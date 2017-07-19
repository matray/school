---
header-includes:
- \usepackage[american]{circuitikz}
- \usetikzlibrary{snakes,arrows,shapes}
- \usepackage{amsmath}
---
# Week 3 Notes

## Complex Numbers
* $z=a+jb$ or $z=a+ib$
* $e^{j\theta}$ is 1 at any angle
* Positive angles go counter clockwise
* Negative angles go clockwise
* Polar phasor representation is great, simple as fuck

### Vector representation
* The spectrum is another way of looking at the signal, picture on slide 19
* Brush up on row reduced echelon form
* If a matrix is invertible, it is linearly independent
* We are going to use $\sin$ and $\cos$ as basis sets for other representations
* If your signal is not in that span, the basis set is not complete
* Errata marker signals (page 39)
* Can only represent $\sin$ as a vector if the components are harmonics (scalar multiples) of the original $\sin$

## Input-Output Relationships of Continuous LTI Systems 
* Relationship from x(t) -> y(t) is that -> is the input response
* You find y(t) with convolution
* $x(t)=e^{st}$
* $y(t)=\int_{- \infty}^{\infty} e^{t-\tau} h(T)\,d\tau = e^{st} (eigenvector) \int_{-\infty}^{\infty}h(\tau)e^{s\tau}\,d\tau (eigenvalue)$

## Discrete
* $z^n$ is your eigenfunction

## Transfer functions
* $Ae^{st}$ = $Ae^{(\sigma + j\omega)t}$
* sigma is amplitude of sin
* $j\omega$ is the actual sin
* if sigma is negative, it is a decreasing function
* if sigma is positive, it is an increasing function
* if there is a j in your transfer function, you probably are shifting
* if given an input and an output and between the two you find a frequency that wasn't there before, you know it is not a linear system.

## Example pg 20
* we have magnitude and phase for each

## Important trig identities
* MEMORIZE THESE, LOOK THEM UP ON PAGE 23

## Basic Periodic Signals
* Fundamental frequency is $\omega_0 = \frac{2\pi}{T}$
* Break down into sines and cosines
* You always have the fundamental frequency and then frequencies that are multiples of the fundamental frequency
* Any signal can be made out of weighted, scaled, and shifted sins
* "The FCC they won't let me be"
* Any real signal can be made up of a bunch of cosines
* If a signal is purely imaginary, it can be made up of ???????

## Fourier Series Examples
* T=10
* A=5
* Purely even
* Coefficients must be conjugrate symmetric
* $\frac{1}{10} \int_{-2}^{8} x(t)e^{-jk\omega_0 t} dt$
* could also go from -2 to 2 because it is zero elsewhere, then you can do
* $\frac{1}{10} \int_{-2}^{2} 5e^{-jk\omega_0 t} dt$
* $a_k = \frac{1}{2} \int_{-2}^{2} e^{-jk\omega_0 t} dt$
* $a_0 = \frac{1}{2} \int_{-2}^{2} 1 dt = 2$
* $a_k = \frac{1}{T} \int_{0}^{T} x(t)e^{-jk\omega_0 t} dt$
* $a_k = \frac{1}{2} \int_{-2}^{2} e^{-jk\omega_0 t} dt$
* $a_k = \frac{1}{2} [-\frac{1}{jk\omega_0} e^{-jk\omega_0 t}] from -2 to 2$
* $a_k = \frac{1}{2jk\omega_0}[e^{2k\omega_0 t}-e^{?????}]$
* Using Euler's method, and realizing what parts are real or not:
* $=2j \sin(\omega_0) blah blah$
* Full workout is on page 36
* Know L'Hopital's rule?
* Read about the sync function

# Recitation
* Go over notes basically, know linear algebra! That's gonna get ya
* u1 = [2 1 1]
* u2 = [-3 2 4]
* u3 = [1 -1 2]
* v = [3 1 2]
* couldn't solve on quiz

# Midterm Studying
*  Consider: $x(t) = \delta(t+2) - \delta(t-2)$
* Find  $y(t) = \int_{-\infty}^{t} x(\tau)d\tau$. Remind students that
* integration is linear and that $\int_{-\infty}^{t} \delta(\tau)d\tau =  u(t)$

$$
y(t) = \int_{-\infty}^{t} x(\tau)d\tau
$$

* look in notes for full breakdown
* Look at circuit examples that use KVL

