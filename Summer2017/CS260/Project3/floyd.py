def floyd(C):
	A = [[0 for x in range(len(C[0]))] for y in range(len(C))]
	for i in range(len(C)):
		for j in range(len(C)):
			A[i][j] = C[i][j]
			if C[i][j] == 0:
				A[i][j] = float("inf")
	for i in range(len(C)):
		A[i][i]=0
	for k in range(len(C)):
		for i in range(len(C)):
			for j in range(len(C)):
				if (A[i][k] + A[k][j]) < A[i][j]:
					A[i][j] = A[i][k]+A[k][j]
	return A

MatArr = [[0 for x in range(7)] for y in range(7)]
MatArr[1-1][2-1] = 4
MatArr[1-1][3-1] = 1
MatArr[1-1][4-1] = 5
MatArr[1-1][5-1] = 8
MatArr[1-1][6-1] = 10
MatArr[3-1][2-1] = 2
MatArr[4-1][5-1] = 2
MatArr[5-1][6-1] = 1
out = floyd(MatArr)
print "Floyd applied to review 2 problem 6"
print 
print out
