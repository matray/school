# Lecture 2

## Coin Probability
* Flip a coin N times, get heads n times, Frequency: n/N
* When N-> inf, n/N = probability of an event
* (A+B) means A, or B, or both
* P(A+B) = P(A)+P(B)-P(A intersect B)
* P(A+B) <= P(A)+P(B)

## Two Coins example
* In the case of a coin flip, the events are mutually exclusive
* Imagine you have two coins S={HH, HT, TH, TT}
* The events of two coins are independent
* When there are two independent events, the probability of, say, HH, if the multiplication of their probabilities, or  P(H) * P(H)

## Imagine there is a biased coin
* **Conditional Probability**
* P(A|B) is the probability of event A then event B, it is a conditional probability
* P(A|B) = P(AB)/P(B)
* Use sum of the weighted conditional probabilities
* P(A) = Sum(P(A/B_i) * P(B_i))for i=1 to 1
* Know the Bayes Rules of Probability (or Rayes Rule of Probability?)

## More
* P(B|A) = P(AB)/P(A)

## Resistor example
* A box contains 80 resistors

Number|Ohm
------|----
18|10
12|22
33|27
17|47

* P(10 ohm) = 18/80
* Imagine you pick a 22 ohm out, what is the probability you pick another 22 ohm?
* Now it is 11/79 because of not putting it back
* What about if after the first 22 ohm, you want the probability of a 10 ohm?
* Now it is 18/79

## Example
* P(A)=0.3, P(A^ intersect B) = 0.4, P(A intersect B) = 0.2
* What is:

Probability|Answer Logic|Answer
-----------|------|-----
P(B)| P(A^ intersect B) + P(A intersect B)|0.6
P(A+B)| P(A)+P(B)-P(A intersect B)|0.7
P(A intersect B^)|P(A)-P(A intersect B)|0.1
P(B^)|1-P(B)| 0.4

* Row one events in the Answer Logic are mutually exclusive

## Example2
* 1000 steel rods

Length|Diameter:Thin|Diameter:Ok|Diameter:Thick
--|--|--|--
Short|10|3|5
Correct|38|900|4
Long|2|25|13

* A = {Ok diameter}, B={too long}


## Example3
* Two random number generators operating  0<=V<=1
* Independently and put out V and U, each between 0 and 1
* A= {0<=V<=0.75, 0.5<=U<=1}
* B={0.5<=V<=1, 0<=U<=1}
* GRAPH THIS BAD BOY

Find|Logic|Answer
---|---|---
P(A)||3/8
P(B)||1/2
P(A intersect B)||1/8
P(A+B)|P(A)+P(B)-P(AB)|
P(A\|B)||1/4
P(B\|A)||1/3

## Example3

* Let:
  * A = flaws on the side, P(A)=0.02
  * B = flaws on the top, P(B)=0.03
  * flaws on both, P(AB)=0.1
* Find probability of no flaws
* Use: P(A)+P(B)-P(AB) = 0.04, so probability is 0.96

### Or you can do it with compliments
* P(A^)+P(B^)-P((AB)^) = 0.98+0.97-0.99=0.96

## Example4
* Imagine you have:
* A->Circuit 1->Circuit 2-> Circuit 3-> B
* P_i,i=(1, 2, 3) = probability of failure
* Is different if:
* A->(Circuit 1, 2, 3, in parallel)->B
* In circuit example 1, you can have any combination of failures lead to failure
* In circuit example 2, you need all to fail
