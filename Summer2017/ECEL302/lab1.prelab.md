---
header-includes:
- \usepackage[american]{circuitikz}
- \usetikzlibrary{snakes,arrows,shapes}
- \usepackage{amsmath}
title:
- "Lab 1 PreLab"
author:
- "Matthew Long"
---
# Background for PreLab

|Num|BJT DC Equations|
|---|----------------|
|1|$V_{BB}=R_BI_B+V_{BE}$|
|2|$V_{CC}=R_CI_C+V_{CE}$|
|3|$I_C= \beta I_B$|
|4|$V_{BE}=0.7 V$|

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
|$r$| $900 \Omega$|
|$r_0$|$50 k\Omega$|
|$V_{CC}$|$20 V$|
|$V_{BB}$|$3.0 V$|
|$V_{in}$|$1 V_{P-P}$|
|$R_C$|$2 k\Omega$|
|$R_B$|$70 k\Omega$|

* Find:
	1. $\beta$
	2. $I_B$(DC), $I_C$(DC), and $V_{CE}$(DV)

### Solving for $\beta$
* $\beta$ = $\frac{\alpha}{(1-\alpha)}$
* $\alpha$ is given as 0.97, making $\beta$ = $32.\overline{3}$

### Solving for currents and voltage

#### $I_B$(DC)
* Using the information from the above solving of $\beta$, $I_B =  \frac{V_{BB}-V_{BE}}{R_B}$
* Putting in variables: $I_B =\frac{3.0V - 0.7 V}{70k\Omega}$
* This solves $I_B = 0.0329 mA$

#### $I_C$(DC)
* Using above information solving for $I_C = \frac{V_{CC}-V_{CE}}{R_C}$
* $I_C = \beta I_B$
* $\beta I_B = 32.\overline{3}*0.0329 mA$
* $I_C = 1.06 mA$

#### $V_{CE}$
* Using the given equations, $V_{CE} = V_{CC}-R_C I_C$
* Plugging back in: $V_{CE} = V_{CC} - R_C * 1.06 mA$
* $V_{CE} = 20V - 2k \Omega * 1.06 mA$
* $V_{CE} = 17.875 V$
