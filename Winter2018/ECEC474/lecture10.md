# Clock tree synthesis
* The process of distributing clock signals to clock pins based on physical/layout information
* Dubbed the "santa claus" problem by Tasking
* Having all clock pins driven by a single clock source
* Skew = d1 - d2
* Zero skew = d1 = d2
* Useful skew = d1


# Clock tree general concepts
* Look at the fancy slide: Clock tree: General concepts

# Clock skew variations
* Cross sectional view and top-level view of transisitor
* Clock skew types
* Global - global skew is recommended - fastest
* Local - longer runtime
* Useful - used to fix small violations where local or global failed
* Useful skew allows you to do more when their are timing violations by speeding up elsewhere
* A buffer tree is built to balance the loads and minimize the skew

* Final question: Where does the clock tree begin and end?
* Begins at SDC-defined clock source "create_clock"
* Clock tree ends at "sinks" where sinks can be pins (stop/float) or exclude pins (ignore pins)
* if you clock root is a macro cell or something weird, you can force it to change

# Stop, Float, and Exclude pins
* STOP Pins - CTS optimizes for DRC and clock tree targets (skew, insertion delay)
* FLOAT Pins - Like STOP pins, but with delays on clock pin
* EXCLUDE PINS - CTS optimizes for DRC only (ignores clock tree targets)

# Clock Tree Synthesis
* Tries to move gates, add buffers, moving other non-clock cells, inserting clock trees, etc.
* Gate sizing and delay insertion can intentionally slow things down

# Voltage domains
* High voltage - high performance (ususally)
* Low voltage - low performance (ususally)
* Different domains to split up performance
* Clock tree synthesis needs to be aware of the domains
* It can be done, but it is a little hard

#



