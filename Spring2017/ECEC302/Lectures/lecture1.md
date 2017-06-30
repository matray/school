# Digital Systems Projects

* [Course Website](http://www.ece.drexel.edu/courses/ECE-C302/)
* Using Basys 3 board
* Going from Hardware Description Language to FPGA using synthesis and impleementation
* Using ModelSim, Image Filtering, System Generator with MATLAB/Simulink, Vivado HLx WebPACK

## Concepts

* You have a Processor on a Bus that talks to the cores (IPs) and manages them
* Maybe you have a camera being in video signal and it is filtered by one Core and it can go elsewhere
* 100 Mhz clock

## Example 4-way AND

```HDL
variable temp std_logic;
temp=i;
for i in 0 to 3 loop
	temp := x(i);
		and temp;
end loop
Z<= temp
end process;
```

## Actual example (and4)

```VHDL
-------------------------
-- Company: Drexel ECE
-- Engineer: Matthew Long
-- And gate with 4 inputs
-------------------------

library IEEE;
use IEEE.STD_LOGIC_1164.ALL;

entity and4 is
port(x : in std_logic_vector(3 downto 0);
	z: out std_logic
	);

end and4;

architecture Behavioral of and4 is

begin
process()
variables temp: std_logic;
begin

-- init temp to logic '1' for accumulation

temp := '1';
for i in 3 downto 0 loop
temp := temp and x(i);
end loop;

-- assignment of signal (signal <= value)

z <= temp;

end Behavioral;
```

