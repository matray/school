---
header-includes:
- \usepackage[american]{circuitikz}
- \usetikzlibrary{snakes,arrows,shapes}
- \usepackage{amsmath}
---
# Midterm Review
* Know union for sets
* Know hash tables

# 3
* n-1, n-2, .., 1
* place n on the best position

# 4
------------------------------------------
Level	# Calls		# Nodes
-----	-------		-------
0		1			2^0
1		2			2^1
2		3			2^2
3		4			2^3
k-1		k			2^(k-1)
k		k+1			n-2^k + 1
------------------------------------------

* Last value of n-2^k + 1 happens because can be just one sided leafs
* 2^k <= n < 2^k + 1
* log2(of all sides)
* k = log2(n)
* Solution 1. $\sum_{j=0}^{k-1} (j+1)2^j + (k+1) * (n - 2^k + 1)$
* Solution 2. $sum_{j=1}^{n} ((log2(j)) + 1)$

# Number 5?
* mak = k
* min = 0

# Number 6
* Skipped first part in class
* (no infinities occur in D)

# Number 7
* 1: 1
* 2: 12
* 3: 124
* 4: 12
* 5: 125
* 6: 12
* 7: 1
* 8: 13
* 9: 136
* 10:13
* 11:137
* max size k repeated 2^k times
* 1: 1
* 2: 23
* 3: 345
* 4: 4567
* ..:..
* max size 2^k, occurs once (bin 4)
