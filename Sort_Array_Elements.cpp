#include<iostream>

using namespace std;

int main()
{
    int i,j,temp,a[50],size;
    cout<<"Enter array size( Max:50 ) :: ";
    cin>>size;
        cout<<"\nEnter array elements :: \n";

        for(i=0; i<size; i++)
        {
            cout<<"\nEnter arr["<<i<<"] Element :: ";
                cin>>a[i];
        }

  cout<<"\nStored Data Before Sorting In Array :: \n\n";

  for(i=0;i<size;i++)
  {
  cout<<" "<<a[i]<<" ";
  }

 for(i=0;i<size;i++)
 {
     for(j=0;j<size-i-1;j++)
     {
         if(a[j]>a[j+1])
         {
             temp=a[j];
             a[j]=a[j+1];
             a[j+1]=temp;
         }
     }
 }

 cout<<"\n\nStored Data After Sorting In Array :: \n\n";

 for(i=0;i<size;i++)
  {
  cout<<" "<<a[i]<<" ";
  }

  cout<<"\n";

  return 0;

 }
