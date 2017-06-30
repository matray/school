# Lecture 3

## Circuits in series
* A -> C1 -> C2 -> ...-> Cn -> B
* ....   P(1) P(2) ...        P(n)
* P(failure) = P(#1 U #2 U #3...)
* When it is going to work is only if all are working at the same time
* P(failure^) -> (1-P1)(1-P2)...(1-Pn)

## Circuits in parallel
* P(failure) is P1*P2*P3...Pn

## Probability
* P(A) = P(A|B_1)P(B_1)+ P(A|B_2)P(B_2)...
* = P(AB_1)+P(AB_2)
* P(A|B_1)P(B_1)
* in above it is split: conditional probability|priori probability, or a probability we know
* In notes online [notes](https://learn.dcollege.net/bbcswebdav/pid-5510853-dt-content-rid-28597375_1/courses/34746.201635/week%232_summary_notes_shankar.pdf)

## Types of probability
* Marginal
* conditional
* Joint
* Priori
* Posteriori

## Network transmission example
* P(transmit0) = 0.7
* P(transmit1) = 0.3
* P(R_0|T_0) = 0.95
* P(R_1|T_1) = 0.75
* P(receive0) = P(R_0|T_0)P(T_0) + P(R_0|T_1)P(T_1)
* P(receive1) = P(R_1|T_0)P(T_0) + P(R_1|T_1)P(T_1)

title||title|title||title
-|-|-|-|-|-
P(R_0) | =|P(R_0\|T_0)|P(R_0\|T_1)| *| P(T_0)
P(R_1)| =|P(R_1\|T_0)|P(R_1\|T_1)|*|P(T_1)

|||||||||
-|-|-|-|-|-|-|-|-
[P(R_0)]|=|[0.95|0.25]|*|[0.7]|=|[0.74]
[P(R_1)]|=|[0.05|0.75]|*|[0.3]|=|[0.26]

* P(T_1|R_1) = P(R_1|T_1)P(T_1)/P(R_1)

## Book shelf example
* 10 books
* how many ways can you shelve them?
* A: 10!
* remember 1!=1; 0!=1
* Lets say 10 books -> 3 chem, 3 phys, 2 math, 2 history
* How may ways can we shelve these?
* NOT 10!
* A: 4!(3!3!2!2!)
* The 4! at the beginning is because the order doesn't matter, you can go through the orders of all 4 genres 4! times

## Coin example
* n tosses of a Coin
* find heads: rheads
* find tails: (n-r)tails
* Independence:
* hhttt

## Doing some HW problems? emailed problems? IDK
* Going from A->B in a circuit
* There are2 lines of 2 capacitors in series and then those two lines are in parallel between A->B
* These two lines are not mutually exclusive
* Need to find probability of each line (B^2)
* Joint probability is simply P^4
* A^2 + B^2 - P^4 = probability it works
* Independence and total probability rules came into play here
### Given:
* P(A) = 0.4
* P(A U B) = 0.7
* P(B) = ?
### Find:
* ? = 0.3
* Know mutually exclusive, so no intersection here to worry about in subtraction of the normal union formula

## Students prepared example
* 0.8 student is prepared
* 0.2 student is unprepared
* U -> up-to-date
* B -> behind
* How do you express this given our nomenclature?
* T = [P(U_k+1|U_k) | P(U_k+1|B_k)]
* . . . .   [P(B_k+1|U_k) | P(B_k+1|B_k)]

### What does student is up to date mean
* T = [0.8 0.4; 0.2 0.6]
* P(U_0)=1
* P(B_0)=0

### What can we get from that?
* [P(U_1); P(B_1)] = [0.8 0.4; 0.2 0.6] * [1;0] = [0.8;0.2]

### Week 2?
* [P(U_2); P(B_2)] = [0.8 0.4; 0.2 0.6] * [0.8; 0.2] =

### Week 3? Simplier way
* [P(U_3); P(B_3)] = [0.8 0.4; 0.2 0.6]^3 [1;0]
