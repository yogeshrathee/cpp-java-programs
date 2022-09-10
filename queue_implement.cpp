#include<iostream>
#include<conio.h>
#include<stdlib.h>
#define size 5
using namespace std;
int q[size],front=0,rear=0;

int main()
{
	int ch;
	void enqueue();
	void dequeue();
	void display();
	
	while(1)
	{
		cout<<"\n 1. insert element";
		cout<<"\n 2. delete element";
		cout<<"\n 3. display";
		cout<<"\n 4. exit";
		
		cout<<"\nenter the choice::";
		cin>>ch;
		
		switch(ch)
		{
		case 1:
			enqueue();
			break;
		case 2:
			dequeue();
			break;
		case 3:
			display();
			break;
		case 4:
			exit(0);
		default :
			cout<<"invalid input";
		}
	}
}
void enqueue()
{
	int num;
	if(rear==size && front==0)
	{
		cout<<"queue is full";
	}
	else
	{
		cout<<"enter the element:: ";
		cin>>num;
		q[rear]=num;
		
	}
	rear++;
}
void dequeue()
{
	int num;
	if(front==rear)
	{
		cout<<"queue is empty";
	}
	else
	{
		num=q[front];
		front++;
		cout<<"\n"<<num<<" - delete the element";
	}
}
void display()
{
	int i,temp=front;
	if(front==rear)
	{
		cout<<"queue is empty";
	}
	else
	{
		cout<<"elements of queue::";
		for(i=temp;i<rear;i++)
		{
			cout<<q[i]<<" ";
		}
	}
}
