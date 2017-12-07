import math
import numpy

def fftdydaic(n, complexarr):
	fftarr = []
	if (n == 1):
		fftarr.append(complexarr[0])
	else:
		evenarr = complexarr[::2]
		oddarr = complexarr[1::2]
		u = fftdydaic(len(evenarr), evenarr);
		v = fftdydaic(len(oddarr), oddarr);
		for i in range(n):
			tau = math.e**((2*math.pi*i)*1j/n)
			fftarr.append(u[i%(n/2)]+tau*v[i%(n/2)])
	return fftarr

inputarr = [0, 1, 2, 3, 4, 5, 6, 7]
nval = len(inputarr)

print "The expected numpy fft:"
val = numpy.fft.fft(inputarr, n=nval)
print val
print
print "The calculated fft:"
val2 = fftdydaic(nval, inputarr)
print val2
