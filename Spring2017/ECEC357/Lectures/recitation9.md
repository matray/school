# Midterm 2 Practice
## Q1
* Looking for time it takes to take to send one packet
* 100 km at speed of 2*10^8, 5ms transmission propagation delay
* transmission for one packet 500*8/100*10^6 = 0.04 ms
* 20*10^3 bytes/500 bytes = 40 packets
* (40)*0.04=1.6 ms
* We want to know Round Trip Time tho.
* 2* prop delay (5ms) plus transmission time (0.04) = 10.04 ms
* link utilization = 1.6ms/10.04 = 15.93%
* utilization is measured in terms of one packet

## Q5
* E_RTT (0 ) = 80ms
* D_ev?(0) = 8 ms
* Timeout()=80+4*8 = 112 ms
* S_RTT(1) = 80 + x
* E_RTT(1) = (0.875)(80)+(0.125)(80+x)=80+0.125x
* Dev_RTT(1)=0.75(8) + (0.25)|80+x-80| = 6+0.25x
* Timeout = 112=[80+0.125x]+4[6+0.25x]
* 164+1.125x
* x=7.11ms
* S_RTT(1)=87.11ms
* if SRTT>80, SRTT(1) = 87.11ms
* if SRTT<80, SRTT(1) = 70.86ms, y=9.14ms
* x and y aren't the same, deviation isnt the same

## Q7
* Client server situation
* max={NF/V_S, F/d_min}
* ={4(2Gb)/2000*10^6/5, 2GB/600*10^3b/5}
* = {4000,3333}
* upload limited based on the 4000

## Q4
### i
* A (41, 15)------> B (Ack56)
* A (56, 29)-------> B (ack 81)
* A <----------------B
* A <----------------B

### ii
* A (41, 15)-----x-->       B 
* A (56, 29)--------------> B(ack 41)
* Doesnt matter if timeout is before or after second ack is received
* A <---------------------- B
* A(41, 15)---------------> B (ack 81)
* A <---------------------- B

### iii
* A (41, 15) --------------> B
* A(56, 29)----------------> B
* A            <-----x------ B(ack56)
* A(41, 15)---------------> B
* A <-----------------------B(ack81)
* A <----------------------B (ack 81)

### iv
* A(51, 15)----------------> B
* A(56, 25)----------------> B
* A              <-x-------- B(ack56)
* A <----------------------- B(ack81)
* timeout

### v
* A(51, 15) --------\/------> B
* A(56, 25) --------/\------> B
* they swap
* A <------------------------ B(ack 41)
* A <------------------------ B(ack 81)

