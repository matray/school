# Recitation 2

## More coins
* S = {H_1-H_2, H_1-T_2, T_1-H_2, T_1-T_2}
* Heads event = {H_1-H_2}
* Tails event = {T_1-T_2}
* Can event Heads be statistically independent from Tails
* No is my guess

## Defs
* **statistically independent**: you have events A and B
* If the probability of P(A intersect B) = P(A)P(B)
* **mutually exclusive**: if A intersect B is a null set

## Answer
* Heads intersect Tails is a null set, they are mutually exclusive
* P[Heads intersect Tails] = P[null set] = 0
* Two mutually exclusive events can never be statistically independent if both of their probabilities are non zero

## Bayes Theorem
* P(A|B) = P(A intersect B)/P(B)
* P(B|A) = P(A intersect B)/P(A)
* P(A|B)*P(B) = P(B|A)*P(A)

## Theorem of total probability
* You have an event space: **S**
* There are events E1..En and there is an Event A
* P(A) = P(AE_1)+P(AE_2)+..P(AE_n)

## Example
* You are hit by a cab
* There are only two cab companies

Company | Cabs in town
--|--
Dark Blue|9
Light Blue|3

* Sue dark blue because more likely to be the dark blue company
* Dark Blue finds a witness
* The witness Light Blue did it
* Try to discredit the witness by having the witness name the colors of cars in a similar setting
* Witness is correct 2/3 times
* WLB = Witness said Light Blue
* These are odds witness is correct:
* P(WLB|LB) = 2/3
* P(WDB|DB) = 2/3
* P(WLB|DB) = 1/3
* P(WDB|LB) = 1/3
* We need to find:
* P(LB|WLB) = ?
* P(DB|WLB) = ?
* Logic:
* P(DB|WLB)*P(WLB)=P(WLB|DB)*P(DB)
* P(DB|WLB) = P(WLB|DB)*P(DB)/P(WLB)
* P(WLB) = P(WLB intersect DB) + P(WLB intersect LB)
* P(WLB|DB)P(DB) + P(WLB|LB)P(LB)
* (1/3 * 9/12)/((1/3 * 9/12) + (2/3 * 1/3))
* That is 9/17 which is ~53%
* Convinced jury that Dark Blue did it despite the fact that Light Blue did it
