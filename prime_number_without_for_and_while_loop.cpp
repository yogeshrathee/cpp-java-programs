#include<iostream>
using namespace std;
int main()
{
	int n;
	cin>>n;
	n%2==0 && cout<<"non prime number"<<endl;
	n%2!=0 && cout<<"prime number"<<endl;
	return 0;
}
