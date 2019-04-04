def linear_regression(x, y, fit=False):
    n = len(x)
    x_sum = sum(x)
    y_sum = sum(y)
    product = sum([x[i]*y[i] for i in range(n)])
    x_bar = x_sum/n
    y_bar = y_sum/n
    x_squared_sum = sum([x[i]*x[i] for i in range(n)])
    a_1 = ((n*product) - (y_sum * x_sum))/((n*x_squared_sum) - (x_sum)**2)
    if fit:
        a_0 = 0
    else:
        a_0 = y_bar - a_1*x_bar
    #S_r = sum([(y[i] - a_0 - a_1*x[i])**2 for i in range(n)])
    print(a_1)
    print(a_0)
    fitted = [a_1 * x[i] + a_0 for i in range(n)]
    #print(S_r)
    SS_R = sum([(y[i] - fitted[i])**2 for i in range(n)])
    SS_T = sum([(y[i] - y_bar)**2 for i in range(n)])
    R2 = 1 - (SS_R/SS_T)
    print(R2)


x = [1, 2, 3, 4, 5, 6, 7]
y = [0.6, 2.4, 2.1, 3.9, 3.6, 6.1, 6.5]

linear_regression(x, y)
linear_regression(x, y, True)
