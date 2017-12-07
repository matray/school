%% Equation 3
omega = logspace(0, 5, 1000);
eqn = 20*log10(0.00006) + 20*log10(omega/2 + 1) + 20*log10(omega/100 + 1) - 20*log10(omega/1000 +1) - 20*log10(omega/10000 + 1);
semilogx(omega, eqn, '-*');
grid on;
title('Equation 3: H(s)');
xlabel('Frequency(Hz)');
ylabel('H(s) = Gain(dB)');
print('equation3db', '-dpng');