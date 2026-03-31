#include <iostream>
#include <algorithm>
using namespace std;

int main(void)
{
	int n,p[1001],result=0,step=0;
	cin >> n;
	for (int i = 0; i < n; i++)
	{
		cin >> p[i];
	}
	sort(p, p + n);
	for (int i = 0; i < n; i++)
	{
		step += p[i];
		result += step;
	}
	cout << result;
	return 0;
}