---
header-includes:
- \usepackage[american]{circuitikz}
- \usetikzlibrary{snakes,arrows,shapes}
- \usepackage{amsmath}
---
# Lecture 1

# ECES 301 - Chapter 1
* If a function is finite to infinite, it has finite area under the curve
* If a function is infinite to infinite, it has infinite area under the curve
* Consult lecture notes in this folder
* Can you be a power signal and an energy signal? It needs to be finite in energy and power. Yes, you can. A square pulse is a good example of this.
* If a signal is periodic, can it be an energy signal, no it cannot. It can only be a power signal.
* KNOW TIME SHIFTING
* The sum of periodic signals will always be a periodic signal with a period that can be the same as the longest period or the least common multiple

# Lecture 2

* Consult Chapter 1 notes starting at page 58

## Exponential Signals

* Euler's conclusion $e^{j\theta} = \cos(\theta) + j\sin(\theta)$
* $Ae^{j\theta} \rightarrow A\angle\theta$
* think if $t$ as continuous and $n$ as discrete when looking at functions for this class
* The delta function (unit step function) $\delta$ is where the function is 0 everywhere but one place
* It is important to realize that at 0, the unit step function is undefined
* We define the approximation of the delta function as the derivative of the unit step function
* As the function approaches zero, the area under it's curve is 1
* The delta function is actually called a functional, not a function
* Know the properties of the delta function
* The ramp function is just the unit step function times $t$

## Properties of Systems

* Imagine:
$$
\begin{circuitikz}
\draw
	(0,0) to [short] (5,0)
	(4,0) to [R,l=$R_1$] (4,2)
	(4,2) to [short] (0,2)
	(0,2) to [V, l=$V$] (0,0)
	(4,2) to [short] (5,2);
\end{circuitikz}
$$
* This perfectly resistive circuit is memoryless

### Non-Invertible System

* An example of this is $\sqrt{x}$, this can go in one value and get an output, but the output cannot go back
* The value is positive or negative on output so it cannot go in the output and come out as it was

### Causal Systems

* Causal if and only if the system uses only past and present values of the input signal

### Non-Causal Systems

* Can use future values

### Anti-Causal

* Uses only future values

## Time-Invariance

* It doesn't matter when the signal starts, if delays in input cause delays in output
* There are easy ways to test for this, see diagram in Chapter 1.pdf
* Look over testing examples for time-invariance and linear testing examples

## Various Tests

* We want linear systems because it allows us to break up signals (periodic) to individual components, put them through a system, and add it up

# Purpose of this class

* Decomposing a signal
* Look at examples

# QUIZ:

* Explain what linear and time invariant mean
* Look over testing examples for time-invariance and linear testing examples

# Recitation 1
* *  
