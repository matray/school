# Lecture 11?
* x - > uniform [-1, 3]
* What is the pdf?
* Non-monotonic function
* y = 1/x^2
* 1/9 <=y<=1 <=> 1<=x<=3 => monotonic
* 1<=y<=inf <=> -1<=x<=1 => nonmonotonic
* f_y(y) = 1/8y^(3/2), 1/9 <=y<=1
* Find cdf
* F_y(y) = integral from 1/9 to y for 1/8x^(3/2) dx
* first evaluate from 1/9 to 1, which is 1/2
* Then evaluate 1 to y
* F_y(y) = 1/2 + integral from 1 to y for 1/4x^(3/2) dx
* = 1-1/2sqrt(y), for y>1

# Two random variables
* P(AB) = P(A)*P(B)y - x and y are independent
* A = (x<=x)
* B = y<=y
* P(x<=x, y<=y) = F_x,y(x,y)
* F_x,y = F_x(x) * F_y(y) if x and y are independent
* f_x,y(x,y) = d^2/dxdy [F(x,y)] = f_x(x) * f_y(y)
* F(-inf, -inf)=0
* F(-inf, y)
* F(x, -inf)
* F(x,y) = integral from -inf to x, integral from -inf to y of f_x,y(x,y)dxdy
* F(inf, inf)=1 =>means integral from -inf to inf integral from -inf to inf of f(x,y)dxdy = 1
* You find the volume with the double integral
* (e^-(x^2 + y^2)/2*sigma^2) / ((sqrt(2*pi*sigma^2))*sqrt(2*pi*sigma^2))
## Let's think
* F(x,inf) = F_x(x) = integral from -inf to x integral -inf to inf f(u, v)dudv
* F(y) = integral from -inf to inf integral from -inf to y f(u,v)dudv
## Let's think2
* F(x,y) = sum(n=1 to N) sum(m=1 to M) P(x_n, y_m)U(x-x_n)U(y-y_m)
* f(x,y) = sum sum P(x_n,y_m)cirac(x-x_n)cirac(y-y_m)
## General notes
* P(A|B) = P(AB)/P(B)
* f(x|y) = f(x,y)/f(y)
* f(y|x) = f(x,y)/f_x(x) = f_x(x)*f_y(y)/f_x(x)
* Two stage experiment
* Stage 1 -> x=> f_x(x) = x^e^x U(x)
* Stage 2 -> y=> f(y|x) = 1/x, 0<=y<=x
* f(x,y) = f(y|x)*f_x(x)
* = e^-x from 0<=y<=x<=inf

