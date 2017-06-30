# Probability for Engineers Week 1

* Sets
* Venn Diagrams
* Disjoint
* Mutually Exclusive

## Sets

* A = { All natural numbers }
* a = {1, 2, 3}
* B = {1, 2, 3}
* E = {3, 6, 7}
* B is a subset of A
* D = {} = Null Set

* Mutually Exclusive and Disjoint are the same thing

* A = {1, 3, 5, 7}
* B = {1, 2, 3, 4, 5, ... for infinity}
* C = {0.5<=c<=8.5}
* D = {0,0}
* E = {2, 4, 6, 8, 10, 12}
* F = {-0.5 <=f<=1.2}

* A is a subset of B
* A, E, D are mutually exclusive
* E is a subset of B
* A is a subset of C

## Airport Example

At a busy airport, arriving planes land on a first-come, first-server basis.

* A = {At least 5 planes waiting to land}
* B = {At most 3 planes waiting to land}
* D = {Exactly two planes waiting}

* What is the compliment?
* A^ (A compliment) = {Less than 5 planes waiting to land, or planes <=4}
* B^ = {At least four planes, planes >= 4}
* D^ = {not two planes}
* D intersect B = D
* D is a subset of B

_**Identity: if D is a subset of B, D intersect B is D**_

* A intersect B^ is A
* B intersect D^ = {either 0, 1, or 3 planes}

## Probability

* Probability is defined as a numebr from 0 to 1
* Only when events are mutually exclusive do their sums add up to 1 exactly
* Let's consider a case where theres Event A and Event B with slight cross over (not mutually exclusive)
* Probability of A union B in this case is: P(A) + P(B) - P(A intersect B)
* S is the universal Set
* A union A^ is S

## Example Problem

* A, B, C are events of S
* P(A) is 0.5
* P(AC) is 0.2
* P(A intersect B^ intersect C^) = 0.1
* P(ABC) = 0.05

Find P(AB)

P(A) = 0.5
subtract the remaining piece in the venn diagram (P(AC))
P(AC) = 0.2
P(ABS) is 0.05 after you take away the parts you don't need

Answer is 0.25

## More Notes on Sets

* A union B = B union A
* A intersection B = B intersection A

Pick two numbers A and B between 0 and 1

Draw the sample space

If C = (A > 0.5, show the sample space)
If D = (B > 0.5)
IF E = (A > B)

## Another Example

A = {2 <= x <=5}
B = {3 <= x <=6}
C = {-inf<=x<=inf}

AB = {3 <= x <= 5}

(AB)^ = {x<3, x>5}

What is A+B intersect with (AB)^?


