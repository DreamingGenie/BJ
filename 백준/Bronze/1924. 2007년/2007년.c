#include<stdio.h>
int main()
{
	int m, y, a = 0 , b, c;
	scanf("%d %d", &m, &y);
	for (int i = 1; i < m; i++)
	{
		switch (i)
		{
		case 4:
		case 6:
		case 9:
		case 11:
			a = a + 30;
			break;
		case 2:
			a = a + 28;
			break;
		default:
			a = a + 31;
		}
	}
	a = a + y;
	a = a % 7;
	switch (a)
	{
	case 1:
		printf("MON");
		break;
	case 2:
		printf("TUE");
		break;
	case 3:
		printf("WED");
		break;
	case 4:
		printf("THU");
		break;
	case 5:
		printf("FRI");
		break;
	case 6:
		printf("SAT");
		break;
	case 0:
		printf("SUN");
		break;
	}
}