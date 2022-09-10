#include<iostream>
#include<queue>
using namespace std;
int main()
{
	queue<string>q;
	q.push("cat");
	q.push("dog");
	cout<<"size:: "<<q.size()<<endl;
	cout<<"Queue: ";
	while(!q.empty())
	{
		cout<<q.front()<<" ,";
		q.pop();
	}
	
	cout<<endl;
	return 0;
}
