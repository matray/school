# Recitation 2
## What would be the channel capacity of a channel with 3KHz analog bandwidth
* W = analog bandwidth = 3KHz
* C = digital bandwidth

### i. if it was noise free using binary signaling
* binary - C=2W
* 6 Kbps
### ii.
* m-ary C=2Wlog_2(m)
* 2(3KHz)log_2(16) = 24Kbps
### iii. if it was noisy with S/N = 30 db
* S/N=30db
* 30db = 10log_10(S/N)
* = 1000
* C = 3KHzlog_2(1000+1)
* = 29.9 Kbps

## Calculate the channel capacity of a fiber optic link operating at a wavelength of 1300 nm with a spread of 10 nm on either side. Assume S/N = 30db
### i. C=?
* wavelength 1290-1310 nm
* v = f*lambda(or wavelength)
* 2*10^8 = f_(1,2) * lambda_(1,2)
* f_1 = 155THz
* f_2 = 152.6 THz
* W = f_1 - f_2 = 2.4THz
* C = Wlog_2(S/N + 1)
* C = 2.4THzlog_2(1000+1)
* 23.91 Tbps
