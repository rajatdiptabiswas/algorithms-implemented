#include <vector>
#include <iostream>

const int MAX_N = 1000001;
std::vector<bool> isPrime(MAX_N + 1, true);


void sieve() {
    isPrime[0] = isPrime[1] = false;
    for (int i = 2; i * i <= MAX_N; i++) {
        if (isPrime[i]) {
            for (int j = i * i; j <= MAX_N; j += i) {
                isPrime[j] = false;
            }
        }
    }
}


int main() {
    sieve();

    for (int i = 1; i <= 100; i++) {
        if (isPrime[i]) {
            std::cout << i << std::endl;
        }
    }

    return 0;
}
