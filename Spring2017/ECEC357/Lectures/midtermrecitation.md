# Midterm Review
* Bring a cheat sheet
* Bring a calcualtor

# Problem 1
* Capacity = Bandwith * log_2(1+(singal/noice))
* 40 db = 10 log_10(S/N)
* S/N = 10000
* Bandwidth = frequency_max - frequency_min
* velocity = frequency * lambda(or wavelength)
* 2*10^8 = f_max * 840*10^-9
* 2*10^8 = f_min * 860*10^-9
* = 238.1*10^12 
* = 238.1 THz - 232.6 THz
* = 5.5 THz
* C = 5.5*log_2(1-10000)
*  = 73.1 Tbps
* Shannons in terms of db=> C = (B/3)(S/N db)


# Problem 2
* L/R = time
* [L_bits / 1Mbps + prop delay (200*10^3m/2*10^8) + L_bits/10*10^6 + 115*10^3/2.3*10^8 + L_bits/2*10^6 + 300*10^3/3*10^8]
* L = (500*10^3)(.0025 + 16L/10^7) = 6250 bits

# Problem 3
* (delay time)(bandwidth) = 8000
* (920*10^3)/speed * 2*10^6 = 8000
* speed = 2.3*10^8 m/s
* 920*10^3/8000 bits = bitwidth
* 920*10^3/(920*10^3

* ????? = S/R???
* Zoned out and missed answer

# Problem 4
* [source port][dest port]
* [length][checksum]
* [data]

* [0960][0050]
* [message header+payload length = 000C][checksum = source+dest+length+data= FBD9+E698=E]
* checksum = 0960+0050+000C+F21D+E698, carry one wraps around = E272 => 1D8D
* [F21D|E698]

# Problem 5
* A		B
* |--pkt0--	|
* | 	--pkt0--|Error receiving
* |	    Ack1|
* |Ack1		|
* |pkt0		|
* |	pkt0	|
* |		|got it
* |	  ack0	|
* |ack0[error]	|
* |pkt0		|
* | 	pkt0	| got it
* |	    ack0|
* |ack0		| got it
* |pkt1		|
* |	pkt1	| got it
* |	    ack1|
* |ack1		| got it
		
