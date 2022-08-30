#include<iostream>
using namespace std;
int main()
{
	int n,count=0,j=1;
	cin>>n;
	while(n>=j)
	{
		if(n%j==0)
		{
			count++;
		}
		j++;
	}
	if(count==2)
	{
		cout<<"prime number"<<endl;
	
	}
	else
	{
		cout<<"non prime number"<<endl;
	}
	return 0;
}
