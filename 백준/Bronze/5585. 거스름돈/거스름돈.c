#include <stdio.h>
int main()
{
	int money = 0;
	int last = 0;
	scanf("%d", &money);
	if (money < 0 || money>1000)
		printf("잘못된 액수입니다.");
	else
	{
		last += (1000 - money) / 500;
		money = (1000 - money) % 500;
		last += money / 100;
		money = money % 100;
		last += money / 50;
		money = money % 50;
		last += money / 10;
		money = money % 10;
		last += money / 5;
		money = money % 5;
		last += money / 1;
		money = money % 1;
	}
	printf("%d", last);
}