#include<stdio.h>
int main()
{
	int i = 0, n = 0, k = 0; //별의 가로줄, 세로줄, 반복횟수를 저장할 변수 선언
	scanf("%d", &n);
	for (i = n; i >= 1; i--)//세로줄은 n만큼 반복함
	{
        int j = 0;
		while (j <= n - i - 1)//각 숫자들 앞의 공백을 담당할 반복문
		{
			printf(" ");//공백을 출력
			j++;
		}
		for (k = i; k >= 1; k--)//가로줄은 n-i+1만큼 반복함
		{
			printf("*");//별을 출력
		}
		printf("\n");//줄넘김
	}
}