#include<iostream>
#include<conio.h>
#include<stdlib.h>
#define SIZE 100
using namespace std;

void enQueue(int);
int deQueueFront();
int deQueueRear();
void enQueueRear(int);
void enQueueFront(int);
void display();

int queue[SIZE];
int rear = 0, front = 0;

int main()
{
    char ch;
    int choice1, choice2, value;
    cout<<"\n******* Type of Double Ended Queue *******\n";
     do
     {
          cout<<"\n1.Input-restricted deque \n";
          cout<<"2.output-restricted deque \n";
          cout<<"\nEnter your choice of Queue Type : ";
          cin>>choice1;

          switch(choice1)
          {
               case 1: 
                    cout<<"\nSelect the Operation\n";
                    cout<<"1.Insert at front only\n2.Delete from Rear\n3.Delete from Front\n4. Display";
                    do
                    {
                       cout<<"\nEnter your choice for the operation:: ";
                       cin>>choice2;
                       switch(choice2)
                       {   
                          case 1: enQueueFront(value);
                                  display();
                       			break;
                       	  case 2: value = deQueueRear();
                       		  cout<<"\nThe value deleted from the REAR successfully :: ";
                                  display();
                       		  break;
                          case 3: value=deQueueFront();
                       	          cout<<"\nThe value deleted from the FRONT successfully :: ";
                                  display();
                       	          break;
                          case 4: display();
                                  break;
                          default:cout<<"Wrong choice";
                       }
                       cout<<"\nDo you want to perform another operation (Y/N):: ";
                       ch=getch();
                    }
					while(ch=='y'||ch=='Y');
                    getch();
                    break; 

               case 2 :
                   cout<<"\n---- Select the Operation ----\n";
                   cout<<"1. Insert at Rear\n2. Insert at Front\n3. Delete from only Rear \n4. Display";
                   do
                   {
                      cout<<"\nEnter your choice for the operation: ";
                      cin>>choice2;
                      switch(choice2)
                      {   
                         case 1: enQueueRear(value);
                                 display();
                                 break;
                         case 2: enQueueFront(value);
                                 display();
                                 break;
                         case 3: value = deQueueRear();
                                 cout<<"\nThe value deleted from REAR successfully !!"; 
                                 display();
                                 break;
                         case 4: display();
                                 break;
                         default:cout<<"Wrong choice";
                       }
                       cout<<"\nDo you want to perform another operation (Y/N):: ";
                       ch=getch();
                    } 
					while(ch=='y'||ch=='Y');
                    getch();
                    break ;
            }
            cout<<"\nDo you want to continue(y/n):: ";
            ch=getch();
      }
	  while(ch=='y'||ch=='Y');
}

void enQueueRear(int value)
{   
     char ch;
     if(front == SIZE/2)
      {
            cout<<"\nQueue is full!!! Insertion is not possible!!! ";
            return;
      }
      do
      {
            cout<<"\nEnter the value to be inserted:: ";
            cin>>value;
            queue[front] = value;
            front++;
            cout<<"Do you want to continue insertion Y/N:: ";
            ch=getch();
      }
	  while(ch=='y');
}

void enQueueFront(int value)
{   
     char ch;
     if(front==SIZE/2)
      {
            cout<<"\nQueue is full!!! Insertion is not possible!!!";
            return;
      }
      do
      {
            cout<<"\nEnter the value to be inserted:: ";
            cin>>value;
            rear--;
            queue[rear] = value;
            cout<<"Do you want to continue insertion Y/N:: ";
            ch = getch();
      }
      while(ch == 'y');
}
int deQueueRear()
{
     int deleted;
     if(front == rear)
     {
            cout<<"\nQueue is Empty!!! Deletion is not possible!!!";
            return 0;
     }
     front--;
     deleted = queue[front+1];
     return deleted;
}
int deQueueFront()
{
     int deleted;
     if(front == rear)
     {
            cout<<"\nQueue is Empty!!! Deletion is not possible!!!";
            return 0;
     }
     rear++;
     deleted = queue[rear-1];
     return deleted;
}

void display()
{
     int i;
     if(front == rear)
        cout<<"\nQueue is Empty!!! Deletion is not possible!!!";
     else{
        cout<<"\nThe Queue elements are:: ";
        for(i=rear; i < front; i++)
        {
           cout<<queue[i]<<" ";
        }
     }
}
