#include <iostream>


int binaryExponentiation(int a, int n, int p) {
	int result = 1;
	while (n > 0) {
		if (n % 2 == 1) {
			result = (result * a) % p;
			n--;
		}
		a = (a * a) % p;
		n /= 2;
	}
	return result;
}


int main() {
	std::cout << binaryExponentiation(2, 10, 7) << std::endl;
	return 0;
}