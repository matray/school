# Why multicore?
* Power/Thermal limitations
* Wire delay
    * Need repeaters
    * Need buffers
    * Locally syncronous (clock per core)
* CPU keeps being limited by memory, even though CPUs are getting faster
* Instruction level parallelism limit

# Program pipelining
* MIPS
* IF - instruction fetch
* ID - instruction decode
* IX - instruction execute
* MEM - touch memory
* WB - write back

* IF/ID registers - instruction communication
* CPI - Cycles per instruction is what we want to minimize
* Minimum CPI is 1
* IPS - Instructions per clock cycle
* IPC should be greater than 1

# Hazards
* Data hazards
* Control hazards
* e.g. add, then immediately followed by a sub
* There is a dependency here - read after write
* Destination register is a source register for pipelined commands
* MIPS updates registers at the end of the cpu cycle
* You need to stall the cpu
* Solutions to this forwarding or bypassing
* Instead of waiting for register, just provide it to the appropriate state
* example is feed alu answer back as input for it to handle the second instruction
* Move branching as early as possible in the pipeline

# Class assignments
* P(serial) -> P'(parallel) and results/correctness
* Want to be correct and we want speedups
* Top 5 speedups gets additional points

# Parallel machines
* Flynn's classification
* SISD - Single instruction, single data (single threaded)
* SIMD - Single instruction, multiple data (single threaded)
    * Vector processing
    * We will use GPU as SIMD processor
    * Most cpus also offer SSE (Streaming SIMD Extension)
* MIMD (pthreads, openMP)
* MISD

# SIMD
* Load data for each thread

# Shared Memory & Distributed Memory
* Shared abstractions include pthreads and OpenMP
* Distributed Memory involves giving memory to different machines using some kind of message passing (send and receive)
*
