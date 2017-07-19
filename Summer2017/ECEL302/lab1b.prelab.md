---
header-includes:
- \usepackage[american]{circuitikz}
- \usetikzlibrary{snakes,arrows,shapes}
- \usepackage{amsmath}
title:
- "Lab 1b PreLab"
author:
- "Matthew Long"
---
# Circuit for PreLab

$$
\begin{circuitikz}
\draw
	(4,4) to [Tnpn,n=npn1] (4,6)
	(npn1.C) to [short, *-*, l=C] (npn1.C)
	(npn1.E) to [short, *-*, l=E] (npn1.E)
	(npn1.B) to [short, *-*, l=B] (npn1.B)
	(6,6) to [short] (4, 6)
	(0,0) to [short] (6,0)
	(0,0) to [short] (0,1)
	(0,1) to [sV, l=$V_{in}$] (0,2)
	(0,2) to [short] (0,3)
	(0,3) to [battery, l=$V_{BB}$] (0,4)
	(0,4) to [short] (0,5)
	(0,5) to [short] (1,5)
	(4,0) to [short] (4,4)
	(1,5) to [R, l=$R_B$] (2,5)
	(2,5) to [short] (3.5,5)
	(6,0) to [short] (6,1)
	(6,1) to [battery, l=$V_{CC}$] (6,2)
	(6,2) to [short] (6,4)
	(6,4) to [R, l=$R_C$] (6,6)
	(6, 5.75) to [short, -*] (7, 5.75)
	(7.25, 5.0) to [short, l=$V_{out}$] (7.25, 5.0)
	(6, 4.25) to [short, -*] (7, 4.25);
\end{circuitikz}
$$

# Obtaining Desired Values

## What is asked
* The NPN BJT in the amplifier circuit above has the parameters:

|Variable|Value|
|--------|-----|
|$\alpha$|0.97|
|$r_{\pi}$| $900 \Omega$|
|$r_0$|$50 k\Omega$|
|$V_{CC}$|$20 V$|
|$V_{BB}$|$3.0 V$|
|$V_{in}$|$1 V_{P-P}$|
|$R_C$|$2 k\Omega$|
|$R_B$|$70 k\Omega$|

* Find:
	1. $I_b (AC)$, $I_c (AC)$, and $V_{ce} AC$
	2. The AC current gain $A_I = I_c / I_b$
	3. The AC voltage gain $A_V = V_{ce} / V_{in}$

# Solving for $I_b (AC)$, $I_c (AC)$, and $V_{ce} AC$

## $I_c$
* From Prelab 1a we know that $\beta$ is 32.3
* $r_{\pi} = 0.025 \beta / I_c$
* $900 = 0.025*32.3/I_C$
* $I_C = 0.897 mA$

## $I_b$
* $V_{in} = 1 = I_b (R_B + r_{\pi}$
* $1 = I_b (70k\Omega + 900\Omega)$
* $I_b = 0.014 mA$

## $V_{ce}$
* $V_{ce} = -(\beta I_b) (r_0 || R_C)$$
* $V_{ce} = -(32.3 * 0.014 mA) (50k\Omega || 2k\Omega)$$
* $V_{ce} = -0.869 V$

# Solving for the AC current gain
* $A_I = I_c / I_b$
* $A_I = 64.071$

# Solving for the AC voltage gain
* $A_V = V_{ce} /V_{in}$
* $A_V = -0.869 V / 1 v$
* $A_V = V_{ce} = -0.869$
