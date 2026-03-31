#include<stdio.h>
int main()
{
	int i = 0, n = 0, k = 0, j = 0;//가로줄, 세로줄, 반복문의 시행 횟수를 저장할 변수 선언
	scanf("%d", &n);
	for (i = 1; i <= n; i++)//세로줄을 위한 반복문
	{
		j = 0;
		while (j <= n - i - 1)//각 숫자들 앞의 공백을 담당할 반복문
		{
			printf(" ");//공백을 출력
			j++;
		}
		for (k = 1; k <= i; k++)//숫자를 입력하는 반복문
		{
			printf("*");//숫자를 출력
		}
		if (i == n)
			break;
		printf("\n");//줄넘김
	}
}