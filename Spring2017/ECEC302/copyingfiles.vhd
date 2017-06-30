library IEEE;
use IEEE.STD_LOGIC_1164.ALL;

entity reg is
generic (n: natural);
Port( ck, ld_en : in std_logic;
x: in std_logic_vector(n-1 downto 0);
z : out std_logic_vector(n-1 downto 0));
end reg;

architecture Behavioral of reg is
signal temp: std_logic_vector(n-1 downto 0);
begin
process(ck)
begin
if ck='1' and ck'event then
  if ld_en = '1' then
    temp<=x;
  end if;
end if;
end process;
z<=temp;
end Behavioral;

-------------------------------------------
library IEEE;
use IEEE.STD_LOGIC_1164.ALL;

entity reg_4 is
Port(y: in std_logic_vector(3 downto 0);
z: out std_logic_vector(3 downto 0);
ck, en: in std_logic);
end reg_4;

architecture struc of reg_4 is

component reg
generic (n: natural);
Port(ck, ld_en: in std_logic;
x: in std_logic_vector(n-1 downto 0);
z: out std_logic_vector(n-1 downto 0));
end component;

begin
U1: reg generic map(4)
port map(x=>y, z=>z, ck=>ck, ld_en=>en);
end struc;
------------------------------------------
entity bit_reversal_reg is
generic(n: natural);
Port(x: in std_logic_vector(n-1 downto 0);
z: out std_logic_vector(n-1 downto 0);
ck, ld_en: in std_logic);
end bit_reversal_reg;

# put in process loop
for i in 0 to n-1 loop
  temp(i) <= x(n-1-i);
end loop;
-------------------------------------------
library IEEE;
use IEEE.STD_LOGIC_1164.ALL;
entity cascade_reg4 is
port(x: in std_logic_vector(3 downto 0);
z1: out std_logic_vector(3 downto 0);
z2: out std_logic_vector(3 downto 0);
en, ck, btn0, btn1: in std_logic);
end cascade_reg4;
architecture structural of cascade_reg4 is
component reg
generic(n:natural);
port(ck, le_en : in std_logic;
x : in std_logic_vector(n-1 downto 0);
z: out std_logic_vector(n-1 downto 0));
end component;

signal w: std_logic_vector(3 downto 0);
begin
R1: reg generic map(4)
  port map(x=>x, z=>w, ck=>ck, ld_en=>en);
R2: reg generic map(4)
  port map(x=> w, z=>z2, ck=>ck, ld_en=>en);
end structural;
---------------------------------------------
library IEEE;
use IEEE.STD_LOGIC_1164.ALL;

entity step_cascade_reg4 is
port ( x: in std_logic_vector(3 downto 0);
z1 : out std_logic_vector(3 downto 0);
z2: out std_logic_vector(3 downto 0));
end step_cascade_reg4;

architecture structural of step_cascade_reg4 is

component reg
generic(n: natural);
port( ck, ld_en : in std_logic;
x: in stf_logic_vector(n-1 downto 0);
z: out std_logic_vector(n-1 downto 0));
end component;

signal w: std_logic_vector(3 downto 0);
signal ck_step : std_logic;
begin
R1: reg generic map(4)
  port map(x=>x,z=>w,ck=>ck_step,ld_en=>en);
R2: reg generic map(4)
  port map(x=>w, z=>z2,ck=>ck_step,ld_en=>en);
z1<=w;

process(ck)
type state is (not_rdy, rdy, pulse);
variable ns: state;
begin
if ck='1' and ck'event then
  case ns is
    when not_rdy => ck_step <='0';
    if btn1='1' then ns:=rdy; end if;
    when rdy=>ck_step<='0';
    if btn0='1' then ns:=pulse; end if;
    when pulse => ck_step <= '1';
    ns:=not_rdy;
    when others => null;
  end case;
end if;
end process;
end structural;

-----------------------------------------------
entity new_cascading_red is
port(x: in std_logic_vector(3 downto 0);
z1, z2 : out std_logic_vector(3 downto 0);
btn0,btn1,ck : in std_logic);
end new_cascading_reg;

architecture Behavioral of new_cascading_reg is
signal en: std_logic;
signal temp1, temp2 : std_logic_vector(3 downto 0);
begin

process(ck)
type db_state is (not_rdy, rdy, pulse);
variable db_ns := db_state;
begin
if ck='1' and ck'event then
  case db_ns is
    fd
