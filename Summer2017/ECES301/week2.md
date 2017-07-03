---
header-includes:
- \usepackage[american]{circuitikz}
- \usetikzlibrary{snakes,arrows,shapes}
- \usepackage{amsmath}
---
# Week 2

## Chapter - Linear Time - Invariant Systems
* There is an impulse, it can be applied to another system
* The output of this system is called the impulse response
* If an impulse creates an impulse response, what does a sum of shifted and  weighted input signals give you? 
* It gives you information about the entire system, you can now predict the output

## Conversation
* $x[n] = \sum_{k=0}^{\infty} x[h]h[n-h]$
* Convolution is basically an idea to add two signals together
* But it's not nearly that simple
* You are charging up the system and eventually discharge
* The length of x[n] plus the length of h[n] minus 1 gives you the number of required points
* Multiply the two vectors together
* $[1,-2,1,3] * [1,2,-1] = [1, 0, -4, 7, 5, -3]$
* This is also our desired output from Method 2: Direct Computation
* Polynomial multiplication is convolution!

### Convolution
* Method 3: Flip, shift, and multiply/sum
* For example we want to shift the value so the index becomes 0
* We are lining up these values, multiplying the values and summing while moving down the line 
* Why do we care so much about the input response?
* It is a characteristic of the system, it allows us to predict output

## Continuous-Time Systems
* $\int_{-\infty}^{\infty} \delta(t) dt = 1$
* $x(t) = \int_{-\infty}^{\infty} x(\tau)\delta(t-\tau) d\tau$
### Convolution integral
* $y(t) = x(t) * h(t) =$ above integral
* Sum of the two lengths (not minus one)
* Make sure you define them over the same length
* Know high pass and low pass filters

### Real-World Example
* $R=50\Omega$
* $C=2mF$
* How do we solve this low pass filter example?
* $h_c = 10e^{-10t}u(t)$
* Find the convolution now
* We need to do this to $h_c$ with that signal
* Now what if we want to know the voltage over the resistor?
* $V_R = V_{in}-V_C = V_{in} - conv(V_{in} * h_C (t) )$
* Any function convolved around the delta function is itself
* $=conv(V_{in} * \delta(t)) - conv(V_{in} * h_C (t))$
* $V_{in} * conv(\dealta(t) - h_C(t))$