#include<stdio.h>
int generator(int x)
{
	for (int i = 1; i <= x; i++)
	{
		int a,b=0, c;
		a = i;
		while (a != 0)
		{
			b = b + a%10;
			a = a / 10;
		}
		c = b + i;
		if (c == x)
		{
			return x;
		}
	}
	
}
int main(void)
{
	int x;
	for (x = 1;x<=10000; x++)
	{
		if (generator(x) != x)
		{
			printf("%d\n", x);
		}
	}
    return 0;
}