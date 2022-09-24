#include<iostream>
#include<stack>
using namespace std;

class Stack
{
	public:
		int *arr;
		int top;
		int size;
		
		Stack(int size)
		{
			this -> size=size;
			arr=new int[size];
			top=-1;
		}
		void push(int element)
		{
			if(size-top>1)
			{
				top++;
				arr[top]=element;
			}
			else
			{
				cout<<"stack is full or overflow !!";
			}
		}
		void pop()
		{
			if(top>=0)
			{
				top--;
			}
			else
			{
				cout<<"stack is empty or underflow !!";
			}
		}
		int peek()
		{
			if(top>=0 && top < size)
			{
				return arr[top];
			}
			else
			{
				cout<<"stack is empty !!";
			}
		}
		bool isEmpty()
		{
			if(top==-1)
			{
				return true;
			}
			else
			{
				return false;
			}
		}
};

int main()
{
	int n=3;
  Stack st(n);
  cout<<"size of stack:: "<<n<<endl;
    cout<<"insert the element:: [22,43,44]"<<endl;
  st.push(22);
  st.push(43);
  st.push(44);
  cout<<endl;
  
  cout<<"top element without any delete element:: "<<st.peek()<<endl;
  st.pop();
  cout<<"After remove element, top element is:: "<<st.peek()<<endl;
  cout<<"left element:: [22,43]\n\n"<<endl;
  st.pop();
  cout<<" Again after remove the element, top element is:: "<<st.peek()<<endl;
  cout<<"left element:: [22]\n\n"<<endl;
  
  cout<<endl;
  cout<<"check stack is empty or not:: ";
  if(st.isEmpty())
  {
	 cout<<"stack is empty !!!"<<endl; 	
  }	
  else
  {
  	cout<<"stack is not empty !!!"<<endl;
  }
}
