#include <iostream>


void primeFactorization(int n) {
	for (int i = 2; i*i <= n; i++) {
		int count = 0;
		if (n % i == 0) {
			while (n % i == 0) {
				count++;
				n /= i;
			}
			std::cout << i << "^" << count << " ";
		}
	}
	if (n > 1) {
		std::cout << n << "^" << 1 << " ";
	}
	std::cout << std::endl;
}


int main() {
	primeFactorization(2*2*3*3*5*5*7*13*17);
	
	return 0;
}