#include<iostream>
using namespace std;
int main()
{
	string str;
	int i;
	cin>>str;
	
	int len=str.size();
	for(i=0;i<len;++i)
	{
		if(!((str[i]>='a' && str[i]<='z') || (str[i]>='A' && str[i]<='Z')))
		 {
			str[i]='\0';
		 } 
	}
	cout<<"\n"<<str<<endl;
	return 0;
}
