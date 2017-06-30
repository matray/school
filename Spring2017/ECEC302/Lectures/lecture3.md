# Lecture 3

* Synchronous circuit
* Process with Clock fence
* Code for a flip-flip
```VHDL
if ck = '1' and ck'event then
  if reset = '1' then
    ...
  else
    ...
  end if
end if
```

## Recap
* Process(ck)
* Begin
  * clock fence
    * reset fence
* End Process

## Logic circuit
* Asynch
* events would happen an unpredictable times and it would be difficult to manage

## Registers
* Works on clock beats
* Needs a storage declaration

## FPGA implementation
* For this we need to assign output

## VHDL Examples
```VHDL
library ieee;
use ieee.std_logic_1164.all;
Entity reg is
generic(in: natural);
Port(x:in_std_logic_vector(n-1 downto 0);
Z, LD: in std_logic);
End reg;

architecture beh of reg is
signal temp: std_logic_vector(n-1 downto 0);
Begin
Process(ck)
Begin
if ck='1' and ck'event then
  if LD = '1' then
    temp <= x;
  end if;
end if;
end process;
z <= temp;
end beh;
```

```VHDL
library ieee;
use ieee.std_logic_1164.all;
Entity reg_4 is
Port(x : in std_logic_vector(3 downto 0);
z : out std_locig_vector(3 downto 0);
ck, ld : in std_logic);
End reg_4;

architecture struc of reg_4 is
component reg
generic (n : natural);
Port(X : in std_logic_vector(n-1 downto 0);
Z : out std_logic_vector(n-1 downto 0);
OK, LD : in std_logic);
End component;

Begin
U: reg generic map(4) port map (x, z, ck, ld);
end struc;

# association of signal ports can also be done:
# port map( ck => ck, x=> x, ld => ld, z => z);
# called name association
# formal => actual
# component => instantiated

# name association is preferred, but the example in the code is faster
```

* Don't forget to also alter the constraints file for this crap
* Going over notes in [Introduction to Digital Systems](http://www.ece.drexel.edu/courses/ECE-C302/notes/Introduction/Introduction.pdf)
---------
# Protocol
* All computer software is just one big state machine
## State Machine + Memory
* State: Not_ready
  * ck_step <='0'
  * transition to next: buttonReady = '1'
* State: Ready
  * ck_step <= '0'
  * transition to next: buttonReady = '1'
* State: Pulse
  * ck_step <= '1'
  * transition to next: None needed, happens automatically to go to state: Not_ready

```VHDL
# in linked above doc on page 7
```

## Signed numbers
* 1001 is negative 7
* 1 at beginning-> -2^3 + 1 at the end is -7
* to put into 64 bit just append 1s at the beginning
* 111111111111111111111111001 or however many ones are necessary


## Clock Example?
* No clue what happened here

Hardware|ck1|ck2|ck3|ck4|ck5|ck6|ck7|ck8
--|--|--|-|-|-|-|-|-|-|-
ck_step|0|0|0|1|0|0|1|0|0
sw|0|0|0|-1|-1|2|3|1
rx/ry|*|*|*|*|*|-1|-1|2
z|*|*|*|*|*|*|*|-1

* In HW, don't forget to assign variable to temp if you have the black box problem
