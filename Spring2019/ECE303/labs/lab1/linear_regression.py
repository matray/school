import numpy as np

def linear_regression(x, y, fit_to_origin=False):
    # Least squares
    x_sum = sum(x)
    y_sum = sum(y)
    x_squared_sum = sum([1.0*x_i*x_i for x_i in x])
    y_squared_sum = sum([1.0*y_i*y_i for y_i in y])
    x_bar = x_sum * 1.0 / len(x)
    y_bar = y_sum * 1.0 / len(y)
    product = 0
    for i in range(len(x)):
        product = product + (x[i] * y[i])

    a_1 = ( (1.0 * len(x) * product) - (1.0 * x_sum * y_sum) )/ ((1.0 * len(x) * x_squared_sum) - (1.0*x_sum*x_sum))
    a_0 = y_bar - (a_1*x_bar)
    SST = x_sum * (y)

def linear_regression2(x, y, fit_to_origin=False):
    if fit_to_origin:
        product = 0
        for i in range(len(x)):
            product = product + (x[i] * y[i])
        x_squared_sum = sum([1.0*x_i*x_i for x_i in x])
        coeffs = [product/x_squared_sum]
    else:
        coeffs = np.polyfit(x, y, 1)
    p = np.poly1d(coeffs)
    yhat = p(x)
    ybar = np.sum(y)/len(y)
    ssreg = np.sum((yhat-ybar)**2)
    sstot = np.sum((y-ybar)**2)
    return (coeffs, (ssreg/sstot))

import matplotlib.pyplot as plt

x = [1, 2, 3, 4, 5, 6, 7]
y = [0.5, 2.5, 2.0, 4.0, 3.5, 6.0, 5.5]

reg = linear_regression2(x, y)
a_1 = reg[0][0]
a_0 = reg[0][1]
r2 = reg[1]
print(reg)
plt.plot(x, y)
y_fitted = []
for x_i in x:
    y_fitted.append((a_1 * x_i) + a_0)
plt.plot(x, y_fitted)

reg_2 = linear_regression2(x, y, True)
a_1_2 = reg_2[0][0]
r2_2 = reg_2[1]
print(reg_2)
y_fitted_2 = []
for x_i in x:
    y_fitted_2.append(a_1_2*x_i)
print(y_fitted_2)
plt.plot(x, y_fitted_2)
plt.show()

