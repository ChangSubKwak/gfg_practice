#include <stdio.h>

void factorial(int n) {
	int digit[500];
	
	digit[0] = 1;
	int length = 1;

	for (int i = 2 ; i <= n ; i++) {
		int carry = 0;
		for (int j = 0 ; j < length ; j++) {
			int nextDigit = digit[j] * i + carry;
			digit[j] = nextDigit % 10;
			carry = nextDigit / 10;
		}
		while (carry > 0) {
			digit[length] = carry % 10;
			carry /= 10;
			length++;
		}
	}
	for (int i = length - 1 ; i >= 0 ; i--)
		printf("%d", digit[i]);
	printf("\n");
}

int main() {
	int n;

	printf("숫자를 입력하세요 :");
	scanf_s("%d", &n);
	//printf("%d!의 값은 %d 입니다.\n", n, factorial(n));
	printf("%d!의 값은 ", n);
	factorial(n);
	printf("입니다.\n");

	return 0;
}
