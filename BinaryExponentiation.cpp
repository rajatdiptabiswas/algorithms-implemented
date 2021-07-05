#include <iostream>


int binaryExponentiation(int a, int n) {
	int result = 1;
	while (n > 0) {
		if (n % 2 == 1) {
			result *= a;
			n--;
		}
		a *= a;
		n /= 2;
	}
	return result;
}


int main() {
	std::cout << binaryExponentiation(2, 10) << std::endl;
	return 0;
}