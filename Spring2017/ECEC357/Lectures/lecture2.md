# Lecture 2

* Really only use the 5 layers:
	1. Application
	2. Transport
	3. Network
	4. Link
	5. Physical

* As you go down the layers you get more headers appended to your message to send
	1. [Message]
	2. [tcp][Message]
	3. [IPv4][tcp][Message]
	4. [eth][IPv4][tcp][Message][error check]
	5. Transmitted
* Then when received, you go up the stack to get the message
* ~86 bytes are in the headers
* Physical Media
	* Unguided (wireless)
		* Satellite
			* Different frequencies
			* GPS
		* Terrestial
			* Tereshap? Microwave
			* Wifi
			* Bluetooth
	* Guided(wired)
		* Copper
			* Coaxial
				* 0.2" diameter
				* 0.4" diameter
			* Twisted
				* CAT3
				* CAT5
				* etc
		* Fiber
			* Multimode (cheapest, has source led)
			* Monomode (best, uses laser source)
			* Graded Index, changes glass grading
* Know how to calculate index of refraction for finder
* Know how to calculate satellite period
* Satellite return message is called downlink
