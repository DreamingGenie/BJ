#include<stdio.h>
int generator(int x)
{
	int count = 0;
	if (x < 100)
	{
		return x;
	}
	for (int i = 100; i <= x; i++)
	{
		
		if (i % 10 - (i / 10 - i / 100 * 10) == (i / 10 - i / 100 * 10) - i / 100)
			count++;
	}
	return count+99;
}

int main(void)
{
	int n;
	scanf("%d", &n);
	printf("%d", generator(n));
    return 0;
}