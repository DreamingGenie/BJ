#include<stdio.h>
int main()
{
	int a,b,c;
	scanf("%d %d %d", &a,&b,&c);
	if (a >= b && b >= c || c >= b && b >= a)
	{
		printf("%d", b);
	}
	else if (c >= a && a >= b || b >= a && a >= c)
	{
		printf("%d", a);
	}
	else if (a>= c && c >= b || b >= c && c >= a)
	{
		printf("%d", c);
	}
}