#include<stdio.h>
int main()
{
	int sug;
	int bas1,bas2;
	int ij;
	scanf("%d",&sug);
	bas1 = sug / 3;
	bas2 = sug / 5;
	ij = bas1 + bas2 + 1;
	for (int i = 0; i <= bas1; i++)
	{
		for (int j = 0; j <= bas2; j++)
		{
			if (sug == i * 3 + j * 5)
			{
				if (ij > i + j)
				{
					ij = i + j;
				}
			}
		}
	}
	if (ij <= bas1 + bas2)
	{
		printf("%d", ij);
	}
	else
		printf("-1");
}