---
header-includes:
- \usepackage[american]{circuitikz}
---
# Testing to draw a circuit
$$
\begin{circuitikz}
\draw
	(0,0) to [short] (4,0)
	to [R, l=$R_1$] (4, 2)
	to [short] (0,2)
	to [V, l=$V_sin$] (0,0);
\end{circuitikz}
$$
