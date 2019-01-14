* Lecture 1
* Date: 20190701

# Digital Integrated Circuits

# Moore's Law
* The number of transistors and resistors on a chip doubles every 18 months
* $\frac{dN}{dt} \propto N$ where N=digital estimation of complexity
* Moore's Law was really a commercial pitch, didn't have the data to be right

# Levels of Design Abstraction
* Register-Transfer Layer is what ECE200 was about
* We are going to be in the Register-Transfer/Gate layers

# Design Process of Digital ICs
* ASIC is about planning layout of ICs
* When do I build an integrated circuit instead of an FPGA? It is when you have the volume. If you don't need to go smaller or faster, you put it on an FPGA. Or if you really need that IC performance.
* Samsung is winning in the ARM space?

# IC Cost
* NRE: Non-recurrent Engineering
* US industry is related to "Trusted Fabs"
* As transistors get smaller, costs go up
* Doping Wafer, costs less to buy on the outside of the wafer
* Done because doping spreads less evenly on outside of wafer when spun
* Transistors are cheaper with time, but systems have become more complex

# Yield
* Yield is how many chips can fit on a wafer

$$
Y = \frac{N_g}{N_t} * 100%
$$

$$
C_D = \frac{C_W}{N_t * Y}
$$

$$
N_t = \frac{\pi * (d_w / 2)^2}{A_d} - \frac{\pi * d_w}{\sqrt{2 * A_d}}
$$

* Where $N_t, N_g$ - total number and number of yield ICs on one wafer respectively
* $C_w, C_D$ - wafer and die cost respectively
* $D_w$ - wafer diameter
* $A_d$ - die area
* Defects arise as well which also has it's own slides in the Lecture 1 pdf

# A Simple Processor
* Need to optimize interconnect
* Input/output, control, memory, datapath all rely on interconnect speed

# Impact of Implementation Choices
* The more flexible, the less energy efficient in chip design
* We are using Semicustom design instead of custom design
* semicustom has cell-based and array-based implementations
* Array-based is like an FPGA
* Cell-based is less common, but more powerful (I think)

