# Recitation 1

## TCP Header

* [frame][datagram][segment][message]
* [H_l][H_0][H_t][M]

* You go down the layers to send then up them to receive
* Application->Transport->Network->Link->Physical
* Then to router -> network->link->physical
* Then it goes up a switch then to the computer and back up

## Units

* Know Kilo-Exa, Know milli-femto
* 8 bits per byte, duh

## Physical Media

* Velocity of Propagation
	* v = c/sqrt(epi)
	* epi is the dielectric constant of the medium (>1)
	* c is light speed 3*10^8

* Delay Propagation (time it takes to go from sender to receiver)
	* length of link cable/s (which is -2*10^8 m/s)

* Typical velocities:
	
Medium | Speed
-------|------
Copper| 2.3*10^8 m/s
Optical Fiber| 2.0*10^8 m/s

* Hmmmm idk about that
