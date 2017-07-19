---
header-includes:
- \usepackage[american]{circuitikz}
- \usetikzlibrary{snakes,arrows,shapes}
- \usepackage{amsmath}
---
# Chapter 1 Notes
## 1.1 Continuous-Time And Discrete-Time Signals
* $(t)$ is continuous time, $[n]$ is discrete time

$$
p(t) = v(t)i(t) = \frac{1}{R} v^2 (t)
$$

* total energy

$$
\int_{t_1}^{t^2} p(t)\,dt = \int_{t_1}^{t_2} \frac{1}{R} v^2(t)\,dt
$$

* average power

$$
\frac{1}{t_2 - t_1} \int_{t_1}^{t_2} p(t)\,dt
$$

## 1.2 Transformation of the Independent Variable
* A periodic continuous-time signal $x(t)$ has the property that there is a negative value of T for which:

$$
x(t) = x(t+T)
$$

* if x(t) is periodic with period T, then:

$$
x(t) = x(t + mT)
$$

* the fundamental period $T_0$ of $x(t)$ is the smallest positive value of $T$ for which the equation 2 above holds true.

* a signal is even if:

$$
x(-t) = x(t)
$$

$$
x[-n] = x[n]
$$

* a signal is off if:

$$
x(-t) = -x(t)
$$

$$
x[-n] = -x[n]
$$

* an important fact is that any signal can be broken into a sum of two signals, one even and one odd.
* Even:

$$
Even(t) = \frac{1}{2} [x(t) + x(-t)]
$$

* Odd:

$$
Odd(t) = \frac{1}{2} [x(t) - x(-t)]
$$

## 1.3 Exponential and Sinusoidal Signals
* The continuous-time complex exponential signal is of the form:

$$
x(t) = Ce^{at}
$$

* In an example where C and a are real, this is an easy exponential
* Consider where we consider a is purely imaginary:

$$
x(t) = e^{j \omega_0 t}
$$

* It is a periodic signal
* Euler's relation:

$$
e^{j \omega_0 t} = \cos \omega_0 t + j \sin \omega_0 t
$$

* We can also go backwards:

$$
A \cos (\omega_0 t + \phi) = \frac{A}{2} e^{ j \phi} e^{ j \omega_0 t} + \frac{A}{2} e^{ -j \phi} e^{-j \omega_0 t}
$$

* We can say that cos is the real component of the function
* sin is thus the imaginary component of the function
* Polar form:

$$
C = |C|e^{j \theta}
$$

* rectangular form:

$$
a = r + j\omega_0
$$

* Using Euler's relation:

$$
Ce^{at} = |C|e^{rt} \cos(\omega_0 t + \theta) + j |C|e^{rt} \sin(\omega_0 t + \theta)
$$

* for r = 0, the real and imaginary parts of a complex exponential are sinusoidal
* for r > 0, there is a growing exponential
* for r < 0, there is a decaying exponential

### In discrete

$$
x[n] = C \alpha^n
$$

* $\alpha$ > 1 is positive exponential behavior
* 0 < $\alpha$ < 1 is negative exponential behavior
* -1 < $\alpha$ < 0 is decaying sinusoidal exponential
* $\alpha$ < -1 is growing sinusoidal exponential

### Important differences

-------------------------------------------------------------------------------
$e^{ j \omega_0 t}$									$e^{j\omega_0 n}$
-----------------               					----------------------------
Distinct signals for distinct values of $\omega_0$	Identical signals for values of $\omega_0$ separated by multiples of 2$\pi$

Periodic for any choice of $\omega_0$				Periodic only is $\omega_0 = 2\pi m / N$ for some integers N>0 and m

Fundamental frequency $\omega_0$					Fundamental frequency (assuming m and N do not have common factors) $\omega_0 /m$

Fundamental period:									Fundamental period:

$\omega_0 = 0: undefined$							$\omega_0 = 0: undefined$

$\omega_0 \neq 0: \frac{2\pi}{\omega_0}$			$\omega_0 \neq 0: m\frac{2\pi}{\omega_0}$

---------------------------------------------------------------------------------

## 1.4 The Unit Impulse Function
## 1.5 Continuous-Time and Discrete-Time Systems
## 1.6 Basic System Properties
## Problems
