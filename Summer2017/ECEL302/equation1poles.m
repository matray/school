%% Equation 1
x = [-500];
y = [0];
plot(x, y,'x');
hold on;
x = [0];
y = [0];
plot(x, y, 'o');
legend('Poles', 'Zeros');
grid on;
title('Equation 2: Poles and Zeros');
xlabel('real');
ylabel('imaginary');
print('equation2poleszeros', '-dpng');