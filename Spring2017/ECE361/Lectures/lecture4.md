# Lecture 4
## Example - continuation of the previous lecture's example
* Finding out odds people do well in the class based on the week

ign|ign|ign|ign|ign|ign|ign
---|---|---|---|----|-|-
[P(U_3)]|=|[ 0.8 0.4]^3|*|[1]|=|[0.688]
[P(B_3)]|=|[ 0.2 0.6]|*|[0]|=|[0.312]

## Example number 5 [link here](https://learn.dcollege.net/bbcswebdav/pid-5512763-dt-content-rid-28615612_1/courses/34746.201635/examples_week%232_shankar%281%29.pdf)
* P(incorrect) = 0.15
* P(all incorrect) = 0.15^3
* 1-15^3 = probability worked

## Example number 6
* P(A) = 0.3
* P(B) = 0.1
* P(C) = 0.2
* P(healthy) = 0.94
* U = symptom
* P(U|A) = 0.85
* P(U|B) = 0.92
* P(U|C) = 0.8
* Using Bayes Rule:
* P(U) = P(U|A)P(A)+P(U|B)P(B)+P(U|C)P(C)+P(U|H)P(H)
* Note: P(U|H) is 0
* Want P(A|U) which is = P(U|A)*P(A)/P(U)
* P(U) = 0.0507

## Example 8
* A = person has the disease
* B = test suggests that disease is present
* A^ = person has no disease
* B^ = test comes back negative
* P(A) = 0.001
* P(A^) = 1-0.001 = 0.999
* P(B|A) = 0.95
* P(B^|A^) = 0.95
* P(B) = P(B|A)*P(A)+P(B|A^)P(A^)
* P(B|A^) = 0.05
* Numbers are given to plug in as we get
* P(B) = 0.0509
* We want to know P(A|B) = P(B|A)P(A)/P(B)
* = 0.0187
* 2% of the time you will get cut open for no reason, this is unacceptably low
* Because the change of the population having it is so low, you need really precise measurements to be accurate in diagnosing it


## Example 10
* What method do we want?
* Background for nums is the Brunolii Principle
* We want the probability of a person passing
* You need 60% to pass
* You need 3 or more questions right to pass as there are only 5 questions
* We are going to use their mutually exclusivity to solve this
* Sum up 3 correct, 4 correct, 5 correct to determine probability of passing
* P(Pass) = P(5 correct) + P(4 correct) + P(3 correct)
* p = q = 1/2 is the Brunolii Principle
* 5C5 (1/2)^5 + 5C4 (1/2)^5 + 5C3 (1/2)^5
* 5C5 = 1

## Example 11
* You have 100 items, 20 are defective you analyze 2 at a time, without replacement
* A = first is defective
* B = second is defective
* P(A) = 20/100
* For part b, P(A intersect B) is the solution
* P(A intersect B) = P(B|A)*P(A) = (19/99)*(1/5)
* Want to find P(B)
* Have to use total probability principle to find P(B)
* P(B) = P(B|A)P(A) + P(B|A^)P(A^)
* P(B) = (1/5) * (19/99) + (20/99) * (80/100)

## Example 13
* 5 good and 2 defective
* Each one is tested
* Find probability that the failure is only found in the 3rd test
* Furloin way
* G_1, D_2, D_3
* D_1, G_2, D_3
* Above are the possible solutions for having found the error in the third test
* Sum up the probabilities of those two events
* Remember: P(AB) = P(A)P(B|A)
* P(ABC) = P(AB)P(C|AB)
* P(A)*P(B|A)*P(C|AB)
* Solving:
* = P(G_1) * P(D_2|G_1) * P(D_3|G_1D_2) + P(D_1)P(G_2|D_1)*P(D_3|G_2D_1)
* = (5/7 * 2/6 * 1/5) + (2/7 * 5/6 * 1/5) = 2/21

## Class Example
* 5 darts are thrown into a circular target
* There is a square in the middle that touches the circle perfectly
* This makes the circle divided into 5 parts
* The center square is part 1
* Radius is 1
* Probability of part 1 being hit is Area of square/Ares of circle = 2/pi
* Probability it lands on any other region = 1-(2/pi)
* For individual parts = (1-(2/pi))/4
* What is the probability that all 5 land in the same zone
* P(above) = (2/pi)^5+4(*(1-2/pi)/4)^5

## Class Example 2
* You are generating numbers from 0-1
* You have two generators x and y that operate independently
* P(x+y >= 1/2)
* P(x*y <= 1/4)
* Draw sample space
* for the first one, its a line from .5 to .5 on the axises
* P(x+y>=1/2) = 7/8
* for the second one, draw parabola line from 1/2 and 1/2 on the outside axies for both axises
* Need to integrate
* Need to break it down
* Easier to find x*y >1/4
* integral of(integral of(dxdy)from 1/4y to 1)from 1/4 to 1
* = 0.4034
* so answer is 1-0.4034 = 0.5966
