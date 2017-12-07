%% Equation 2
omega = logspace(0, 5, 1000);
eqn = 20*log10(1) + 20*log10(1) - 20*log10(omega/500 +1);
semilogx(omega, eqn, '-*');
grid on;
title('Equation 2: H(s)');
xlabel('Frequency(Hz)');
ylabel('H(s) = Gain(dB)');
print('equation2db', '-dpng');