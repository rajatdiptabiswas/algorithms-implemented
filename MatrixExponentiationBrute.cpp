#include <iostream>

const int N = 100;


// A = A * B
void matrixMultiply(int A[][N], int B[][N], int dim) {
	// result = A * B
	int result[N][N];
	for (int i = 0; i < dim; i++) {
		for (int j = 0; j < dim; j++) {
			result[i][j] = 0;
			for (int k = 0; k < dim; k++) {
				result[i][j] += A[i][k] * B[k][j];
			}
		}
	}

	// A = result
	for (int i = 0; i < dim; i++) {
		for (int j = 0; j < dim; j++) {
			A[i][j] = result[i][j];
		}
	}
}


// A = A ^ n
void matrixExponentiation(int A[][N], int dim, int n) {
	// Create identity matrix
	int I[N][N];
	for (int i = 0; i < dim; i++) {
		for (int j = 0; j < dim; j++) {
			if (i == j) {
				I[i][j] = 1;
			} else {
				I[i][j] = 0;
			}
		}
	}

	// Perform matrix exponentiation
	// I = I * A
	for (int i = 0; i < n; i++) {
		matrixMultiply(I, A, dim);
	}

	// Print answer
	for (int i = 0; i < dim; i++) {
		for (int j = 0; j < dim; j++) {
			std::cout << I[i][j] << " ";
		}
		std::cout << std::endl;
	}
}


int main() {
	// Take inputs
	int dim, n;
	std::cin >> dim >> n;

	int M[N][N];
	for (int i = 0; i < dim; i++) {
		for (int j = 0; j < dim; j++) {
			std::cin >> M[i][j];
		}
	}

	matrixExponentiation(M, dim, n);
}