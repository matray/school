# Examples

## Coin Flip Twice Experiment

* Sample Space = {heads, tails} or is it {HH, HT, TH, TT}?
* The second one is correct, you encounter all events

### Given:

* P[H_1, H_2] = 0.3
* P[H_1, T_2] = 0.3

### Find H_1

* P[H_1] = 0.5?
* P[H_1] = 0.3+0.3=0.6?

First Flip | Second Flip
-----------|------------
H_1	   | H_2
T_1	   | T-2

* P[H_1 intersect H_2] = 0.3
* P[H_1 intersect T_2] = 0.3

* P[H_1] = P[H_1 intersect H_2] + P[H_1 intersect T_2] = 0.6

## Circle Problem

* You have a circle with a perfect equillateral triangle within
* Now imagine another circle where you draw a random chord, determine what is the probability it is the length of equillateral

* Sample size = [0, R], also written as {0<=x<=R}
* For the sake of just saying it, let's makr R=1
* If you take the equillateral angle and cut it in half, you get 30 degrees
* The sine of that gives you the distance. sind(30) is 0.5 and since R is one, length is 0.5
* P[chord is shorter than equillateral line] = P[distanct to the chord > 0.5]

### Now consider it as angles instead of just distances

* Sample is degrees [0, 90] or {0<=x<=90}
* P[angle greater than 30] makes it's length smaller
* P[angle less than 30] makes it's length greater

* P[chord smaller] = 60/90 = 2/3 or 0.66666666666666666666666666666->inf

