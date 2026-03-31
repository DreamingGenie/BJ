#include<stdio.h>
int main()
{
	int i = 0, n = 0, k = 0; //별의 가로줄, 세로줄, 반복횟수를 저장할 변수 선언
	scanf("%d", &n);
	for (i = 1; i <= n; i++)//세로줄은 n만큼 반복함
	{
		for (k = 1; k <= i; k++)//가로줄은 n-i+1만큼 반복함
		{
			printf("*");//별을 출력
		}
		printf("\n");//줄넘김
	}
}