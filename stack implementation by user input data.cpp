#include<iostream>
using namespace std;


int stack[100];
int n,i,top,x;

void push();
void pop();
void display();
int main()
{ 
  int ch;
  cout<<"Enter the size of stack :: ";
  cin>>n;
  int exit=1;
  
  top=-1;
  while(1)
  { 
  cout<<"\nEnter your choice(1-4):: "<<endl;
    cout<<"1.PUSH\n2.POP\n3.DISPLAY\n4.EXIT\n";
    
    cout<<"enter your choice:: ";
    cin>>ch;
    switch(ch)
    {
      case 1:push();
      		display();
             break;
      case 2:pop();
      		display();
             break;
      case 3:display();
             break;
      case 4:exit=0;
             break;
      default:cout<<"\nWrong Choice!!!!"<<endl;
             break;
    }
  }
return 0;  
}

void push()
{  
    if(top>=n-1)          
    {
      cout<<"\nSTACK IS OVERFLOW\n"<<endl;
    
  }
  else
  {
  
    cout<<"\nEnter the value to be added:: ";
  cin>>x;
  top=top+1;
  stack[top]=x;
    }
}

void pop()
{
  if(top<=-1)                
  {
    cout<<"\nSTACK IS UNDERFLOW\n"<<endl;

  }
  else
  {
    cout<<"Value : ["<<stack[top]<<"] GOT deleted."<<endl;
    top--;
  }
}
void display()
{
  if(top>=0)
  {
    cout<<"\nElements in the stack are:: ";
    for(i=0;i<=top;i++)
       cout<<stack[i]<<" ";
    cout<<"\n";
  }
  else
   cout<<"\nSTACK IS EMPTY.\n"<<endl;
}
