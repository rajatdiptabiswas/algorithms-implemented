#include <iostream>


bool isPrime(int n) {
    if (n == 1)
        return false;

    for (int i = 2; i * i <= n; i++) {
        if (n % i == 0)
            return false;
    }

    return true;
}


int main() {
    int t;
    std::cin >> t;

    while(t--) {
        int n;
        std::cin >> n;

        if (isPrime(n)) {
            std::cout << "yes" << std::endl;
        } else {
            std::cout << "no" << std::endl;
        }

    }

    return 0;
}
