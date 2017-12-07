import math
import numpy

def find_factors(n):
	outarr = []
	for i in range(1, n+1):
		if n% i ==0:
			outarr.append(i)
	return outarr

def is_prime(num):
	return all(num% i for i in xrange(2, num))

def get_prime_factor_set(inarr):
	for i in range(len(inarr)):
		if is_prime(inarr[i]):
			return [inarr[i], inarr[len(inarr)-1-i]]

def fftany(complexarr, n):
	fftarr = []
	if is_prime(n):
		for i in range(n):
			sumval = 0
			for j in range(n):
				 sumval+=complexarr[j]*((math.e**(2*math.pi*1j/n))**(i*j))
			fftarr.append(sumval)
	else:
		factors = find_factors(n)
		primefactors = get_prime_factor_set(factors)
		a_k = []
		for i in range(primefactors[0]):
			a_k.append(fftany(complexarr[i::primefactors[0]], primefactors[1]))
		for i in range(n):
			sumval = 0
			for j in range(primefactors[0]):
				sumval+=a_k[j%primefactors[1]]*((math.e**(2*math.pi*1j/n))**(i*j))
			fftarr.append(sumval)
	return fftarr

inarr = [0, 1, 2, 3, 4, 5, 6]

print "The expected numpy fft:"
val1 = numpy.fft.fft(inarr)
print val1
print
print "The calculated fft:"
val2 = fftany(inarr, len(inarr))
print val2
