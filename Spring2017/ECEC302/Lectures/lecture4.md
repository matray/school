# Lecture 4
* Arrived late... like halfway through
* [NOTES FOR TODAY](http://www.ece.drexel.edu/courses/ECE-C302/notes/StateMachines/StateMachineHDL.pdf)
* state machines - making a sequence detector

```VHDL
library IEEE;
use IEEE.STD_LOGIC_1164.ALL:
entity seqdet110 is
Port( x, ck, reset : in std_logic;
  z: out std_logic);
end seqdet110;

architecture Behavioral of seqdet110 is
type my_state is (s0, s1, s2, s3);
signal n_s : my_State;

begin
process(ck)
begin
if ck='1' and ck'event then
  if reset = '1' then
    n_s <= s0;z<='0';
  else
    case n_s is
      when s0 =>
        if x='1' then n_s <= s1; end if;
        z<='0';
      when s1 =>
        if x='1' then n_s <= s2;
        else n_s <= s0; end if;
        z<='0';
      when s2 =>
        if x='0' then n_s <= s3;
        z<='1'; else z<='0';
        end if;
      when s3 =>
        if x='1' then n_s <= s1;
        else n_s <= s0; end if;
        z<='0';
    end case;
  end if;
end if;
end process;

--- put here the code for pulsing the clock using two buttons
--- make sure to define the buttons and the enable bit and all that
```
*  Implementing a state machine for led speeds, blinking fast and blinking slow
* Maybe you have two drivers, one slow and one fast (e.g. two different clocks or clock divs)
* Then you can MUX it depending on the buttons
* Then you need a state machine to remember which button is active
* All should be connected to a master reset (maybe put it to slow for the state machine for example)
