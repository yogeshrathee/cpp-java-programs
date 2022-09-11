#include<iostream>
#include<stdlib.h>
#include<conio.h>
using namespace std;
#define size 5

int ch,q[size],front=0,rear=0;
	void enqueue(),dequeue(),display();
int main()
{
	
	while(1)
	{
		cout<<"\n 1. insert";
		cout<<"\n 2.delete";
		cout<<"\n 3. display";
		cout<<"\n 4. exit";
		cout<<"\nenter your choice (1 to 4):: ";
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
			break;
		default:
			cout<<"\n invalid input , choose valid input(1 to 4) !";
			
		}
	}
}
	void enqueue() 
	
	{
		int num;
		
		
		if(rear==size-1 && front==0)
		{
			cout<<"queue is full, u dont insert no more element";
			
		}
		else
		{
			cout<<"\n enter the element:: ";
			cin>>num;
			q[rear]=num;
				rear++;
		}
			
	}
	
	void dequeue()

	{ 
		int num;
		if(front==rear)
		{
			cout<<"queue is empty,so u dont delete no more element";
		}
		else
		{
			q[front]=num;
			front++;
			cout<<"delete the element successfully !";
		}
	}
	void display()
	{
		int i,temp=front;
		cout<<"element in queue::";
		for(i=temp;i<rear;i++)
		{
			cout<<q[i]<<" ";
		}

	}
	


