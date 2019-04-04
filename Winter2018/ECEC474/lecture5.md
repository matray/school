#Midterm heads up
* Synthesis steps
* e.g. clock changes
* Know what non recurring engineering costs are

# Class
* VHDL/Verilog/eg are Netlists
* Also known as hardware description language
* Go from high level (netlist) to gate to transistor to polygon (pushing)
* Logic Sysnthesis = Translation + Mapping + Optimization

# Optimization: Constraint-Driven
* Delay v. Area graph, know that these are discrete not actual functions, so this makes it hard
* Timing requirements with clock delay (look for Lecture_2_DC.pdf page 7)
* t1 = time it takes to go from clock cycle to edge of ff1 clock
* t2 = time it takes to go from clock cycle to edge of ff2 clock
* B1 = buffer 1
* B2 = buffer 2
* B3 = buffer 3
* t1 = (B1+B2)
* t2 = (B1+B3)
* Delay for data path = U2 + U3
* There needs to be a hold time added to that as well (th1)
* Arrive time is tA (when arrives at clock register 2 to be read)
* Blue = t1+th1 + Delay(from ff1->ff2)
* Blue = t1 + th1 + U2 + U3
* Red = t2 + T (period) - t(Setup of 2)
* Setup constraint = t1 + th1 + U2 + U3 <= t2 + T - ts2
* Setup time constraints says it needs to arrive before it can be ignored (not caught by ff2)
* Setup time is also called longpath constraint
* Hold constraint is also called slowpath constraint or fastpath constraint
* hold: t1 + th1 + U2 + U3 >= t2 + th2
* th1 and th2 are hold time 1 and hold time 2, respectively
* Why is setup time more important than hold time?
* Because hold time can easily be fixed by adding to delay
* Setup time changes can cause frequency changes which impacts everything

# Library Setup
* search_path = DC will look for .db files during a link
* target_library = technology cell library files
* synthetic_library = library of DesignWare components, macro cells for simulation
* link_library = similar to dynamic library
* define_design_lib = Where DC places intermediate design files
* set_dont_use = Can ignore cells in a target library if wanted

# Functions
* check_design = run before compile to check design
* check_timing = verifies setup is complete, run before and after compile
* report_timing_requirements = reports constraint attributes
* Always understand the warnings and exceptions coming from these programs
* set_operating_conditions = Sets process/voltage/temperature (PVT) conditions that affect timing
* CMOS transistors slow down at high temperatures
* We try in multiple PVT "corners" to find operating conditions

# Net Parasitics
* Understand wireload and how the resistance/capacitance is calculated to understand it's impact
* Default wireloads provided in technology library generally inaccurate
* Custom wireload generated from accurate floorplan of the design gives best results
* Can set driving cell (means simulate as if this was being driven by a NAND gate)

# Optimization Constraints: Input/Output
## Inputs
* set_input_delay
* set_driving_cell
## Outputs
* set_output_delay
* set_load

* Midterm question: What is the importance of set_wire_load, mode, model, set_load, example slide on page 19

# Optimizing Clocks
* Clocks can have jitter/skew
* This adds up to uncertainty
* The virtual clock is better than an ideal clock for simulation. Virtual clock adds latency, uncertainty (jitter + skew), and transition time together.
* Long path becomes: t1 + th1 + jitter1 + U2 + U3 <= t2 - jitter2 + T - ts2
* Hold path becomes: t1 - jitter 1 + th1 + U2 + U3 >= t2 + jitter2 + th2
* set_timing_derate - fuck with all numbers by a percentage because there could be more variation
* Too early to talk about power

# Optimization Constraints: Exceptions
* Static timing analysis
* One of few things that can be paralleled in ASIC design
* Looks at all paths and gets the timing information for them all
* set_multicycle_path - designate timing change to happen on pin
* Do you want to avoid multicycle paths? Yes.
* compile_ultra - Try really hard
* Graduate students told to look at Clock Gating slide
*
