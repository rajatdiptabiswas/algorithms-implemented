#include <iostream>
#include <vector>

const int MAX = 10000;
std::vector<int> sieve(MAX+1, -1);


void makeSieve() {
	for (int i = 2; i <= MAX; i++) {
		if (sieve[i] == -1) {
			for (int j = i; j <= MAX; j += i) {
				if (sieve[j] == -1) {
					sieve[j] = i;
				}
			}
		}
	}
}


void primeFactorizationSieve(int n) {
	int i = n;
	while (i != 1) {
		std::cout << sieve[i] << " ";
		i /= sieve[i];
	}
	std::cout << std::endl;
}


int main() {
	makeSieve();
	primeFactorizationSieve(2*2*3*3*5*13);
	return 0;
}