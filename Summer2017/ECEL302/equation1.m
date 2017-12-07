%% Equation 1
omega = logspace(0, 5, 100);
eqn = -12.0412 + 20*log10(omega/1 + 1) - 20*log10(omega/400 +1);
semilogx(omega, eqn, '-*');
grid on;
title('Equation 1: H(s)');
xlabel('Frequency(Hz)');
ylabel('H(s) = Gain(dB)');
print('equation1db', '-dpng');