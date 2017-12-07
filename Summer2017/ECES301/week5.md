# Consider the following circuit
* CR circuit, 0.1 F and 100 $\Omega$s

* Voltage is from 3 to 7 with a 10 step pulse width

## Determine the steady state output for the resistor?
1. Fourier!
2. Calculate the Frequency Response $H(\omega)$
3. Calculate the Fourier series of the input signal
4. Multiply $H(k\omega_0)$ by respective coefficients
5. Reconstruct to get output signal

## Apply steps

### 1. Calculate Frequency Response

$$
H(\omega) = \frac{V_{out}}{V_{in}} = \frac{Z_R}{Z_R + Z_C} = \frac{R}{R+\frac{1}{j\omega C}} = \frac{j\omega RC}{1 + j\omega R C} =
$$

* This is a high pass
* Capacitor in DC is short circuited as time goes to $\infty$

### 2. Calculate Fourier Series of the Input Signal
* find DC component $a_0$
* $a_0 = \frac{1}{T} \int x(t)\,dt$
* Period ($T_0$)is 20

$$
a_0 = \frac{1}{20} \int_{0}^{10} 7 \,dt + \int_{10}^{20} 3\,dt
$$

$$
a_0 = \frac{1}{20} (70+30) = 5
$$

* find $a_k$

$$
a_k = \frac{1}{T} \int_{T} x(t) e^{-j k \omega_0 t} \, dt
$$

$$
\frac{1}{T} ( \int_{0}^{10} 7 e^{-jk\omega_0 t} \,dt + \int_{10}^{20} 3 e^{-jk\omega_0 t \,dt})
$$

$$
\frac{1}{T} ( 7( -\frac{1}{jk\omega_0} e^{-jk \omega_0t})from0toT/2 + 3(- \frac{1}{jk\omega_0} e^{-jk \omega_0 t})fromT/2toT)
$$

$$
\frac{1}{jk \omega_0 t} (7( 1 - e^{-jk\omega_0 \frac{T}{2}} ) + 3( e^{-jk\omega_0\frac{T}{2}} - e^{-jk\omega_0 T}))
$$

$$
\frac{1}{jk 2 \pi} (7(1-e^{-jk\pi}) + 3(e^{-jk\pi}-e^{-jk2\pi}))
$$

* $-jk\pi$ means in unit circle go clockwise, allows for simplification

$$
\frac{1}{jk2\pi} (7(1-(-1^k)) - 3((-1^k)-1))
$$

$$
\frac{1}{jk2\pi} ( 4-4(-1)^k ) = \frac{2}{j\pi k} (1-(-1)^k)
$$

$$
a_k = 0, k_{even}
$$

$$
a_k = \frac{4}{j\pi k}, k_{odd}
$$

* recall $a_0 = 5$
* as a goes up, amplitude decreases
* is $a_k$ conjugate symmetric
* does $a_k=conjugate(a_{-k})$
* it is conjugate symmetric
* purely imaginary 
* means it is an odd function
* if you remove the DC component, it becomes a square wave from -2 to 2, and
* square wave is odd. This justifies that our answer makes sense

$$
H(\omega) = \frac{j\omega 10}{1 + j\omega 10}
$$

* evaluate $0, \omega_0, 3\omega_0, 5\omega_0$
* $H(0) = 0$
* makes sense because capacitor is a DC blocker
* $\omega_o = \frac{2\pi}{T} = \frac{\pi}{10}$
* $H(\omega_0) = \frac{j(\frac{\pi}{10})10}{1+j\frac{\pi}{10} 10} = \frac{j\pi}{1+j\pi}$
* magnitude of the numerator divided by the magnitude of the denomenator
* $H(\omega) = \frac{\pi}{sqrt{1^2 + \pi^2}}$
* $H(\omega) = 0.95$

------------------------------------------------------------------------------------------------------------
k		$H(\omega)$		$\angle H(\omega)$		$|a_k |$		$\angle a_k$		output mg		output $a_k$
--		-----------		------------------		--------		-----------			---------		------------
0		0				0						0				$-\pi/2$			0				$-\pi/2$
1		0.95			-2.83					1.27			$-\pi/2$			1.21			-4.4
3		0.99			-3.04					0.42			$-\pi/2$			0.42			-4.6
5		0.998			-3.08					0.25			$-\pi/2$			0.25			-4.65
------------------------------------------------------------------------------------------------------------


* find angle

$$
\frac{j\omega 10}{1 + j\omega 10} +? \frac{1-j\omega10}{1-j\omega10}
$$

$$
\frac{j\omega10 + \omega^2 100}{1^2 + 100\omega^2}
$$

$$
\angle H(\omega) = \tan^-1 (\frac{\omega10}{\omega^2 100})
$$

$$
\tan^-1 (\frac{1}{k\pi})
$$

$$
V_R = 1.21\cos(\frac{\pi}{10} t - 4.4) + 0.42 \cos(\frac{3\pi}{10} t -4.6) + 0.25 \cos(\frac{5\pi}{10} t-4.65)
$$

# Recitation

## Fourier Series
* 
