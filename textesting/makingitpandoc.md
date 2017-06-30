---
header-includes:
- \usepackage{tikz}
- \usetikzlibrary{snakes,arrows,shapes}
- \usepackage{amsmath}
---
# THIS IS A HEADER
$$
\begin{tikzpicture}[>=latex',line join=bevel,]
  \pgfsetlinewidth{1bp}
%%
\begin{scope}
  \pgfsetstrokecolor{black}
  \definecolor{strokecol}{rgb}{1.0,1.0,1.0};
  \pgfsetstrokecolor{strokecol}
  \definecolor{fillcol}{rgb}{1.0,1.0,1.0};
  \pgfsetfillcolor{fillcol}
\end{scope}
  \pgfsetcolor{black}
  % Edge: King Arthur -> Sir Bedevere
  \draw [->] (105.38bp,72.411bp) .. controls (97.328bp,63.606bp) and (87.291bp,52.628bp)  .. (71.603bp,35.47bp);
  % Edge: Sir Bedevere -> Sir Lancelot
  \draw [->] (113.54bp,18.0bp) .. controls (115.84bp,18.0bp) and (118.13bp,18.0bp)  .. (130.46bp,18.0bp);
  % Edge: King Arthur -> Sir Lancelot
  \draw [->] (135.71bp,72.411bp) .. controls (143.76bp,63.606bp) and (153.8bp,52.628bp)  .. (169.49bp,35.47bp);
  % Node: Sir Bedevere
\begin{scope}
  \definecolor{strokecol}{rgb}{0.0,0.0,0.0};
  \pgfsetstrokecolor{strokecol}
  \draw (56.545bp,18.0bp) node {Sir Bedevere};
\end{scope}
  % Node: King Arthur
\begin{scope}
  \definecolor{strokecol}{rgb}{0.0,0.0,0.0};
  \pgfsetstrokecolor{strokecol}
  \draw (120.54bp,90.0bp) node {King Arthur};
\end{scope}
  % Node: Sir Lancelot
\begin{scope}
  \definecolor{strokecol}{rgb}{0.0,0.0,0.0};
  \pgfsetstrokecolor{strokecol}
  \draw (184.54bp,18.0bp) node {Sir Lancelot};
\end{scope}
%
\end{tikzpicture}
$$
