---
header-includes:
- \usepackage[american]{circuitikz}
- \usetikzlibrary{snakes,arrows,shapes}
- \usepackage{amsmath}
---
# Notes
# Fourier Series Example
* Always do DC components first
* Series or shunt capacitors 
* Can make components with infinite impedance
* Page 15 -> Sink function, or $\frac{\sin(x)}{x}$
* as that function of x approaches 0, can use L'Hopital's rule
* This gives $\frac{\cos(x)}{1}$
* Even functions mean purely real, meaning you can use cosine

# Example on Page 59
* RLC circuit - Filter

$$
H(w) = \frac{R}{R + \frac{1}{j\omega C} + j\omegaL}
$$

* Fourier series is only good for steady state of these functions
* Resistor band frequency is maximized when there is basically no complex impedance
* happens when $\omega = \sqrt{\frac{1}{LC}}$

# Notes
* Know the linearity, know the time-shifting of the Fourier series
* Time-Shifting only provides a phase shift (no effect on magnitude)

# Time-Reversal
* Just flips coefficients

# Time-Scaling
* Coefficients do not change
* Only period changes aka new frequency

# Multiplication
* Multiplication of period signals gives you a convolution in the k-domain
* They have to have the same period

# Conjugation
* Flip the coefficients and conjugate them, simple
* If there is conjugate symmetry, then it means the signal is purely real and symmetric, it is cosine

# Differentiation
* We just get another periodic signal
* Differentiation causes a gain at higher frequency
* It is a high pass filter basically

# Integration
* It is like a low pass filter

# Parseval's Equation
* The average power in the time domain is equal to the average power in the spectral domain
