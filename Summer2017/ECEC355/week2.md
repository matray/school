---
header-includes:
- \usepackage[american]{circuitikz}
- \usetikzlibrary{snakes,arrows,shapes}
- \usepackage{amsmath}
---
# Week 2 Notes
## R-Format Instruction

Index| 1|2|3|4|5|6
-+-+-+-+-+-+-
Explanation|opcode|rs|rt|rd|shant|funct(20 hex)
Position|0|11|13|22|N/A (0) | hex

* Machine code for adding $rs $rt $rd
* 000000|01011|01101|10110|00000|100000

## I-Format Instruction
* addi $s0, $t0, 6
* $s0 = 1-9 +6
* R[rt] = R[vs] + SignExtendImm

Bits| 6 | 5 | 5 | 16
-+	-	+	-+-+-
Explanation|opcode|rs|rt|imm (-32768<=32767)

* Machine code for the operation:
* 001000|01000|10000|0000000000000110
