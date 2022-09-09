#include<iostream>
#include<sstream>
#include <string>
using namespace std;
int main()
{
	int size,i,j,unit[j],price,gst[j],totalexp,gstcount,totalprice[j],totalprices[j],extragst[j],sum=0,sumUnit=0;
	string product;
	cout<<"how many products detail you want to fill:: ";
	cin>>size;
	
	for(j=0;j<size;j++)
	{
		cout<<"\n--------------------------------------------------------------------------\n"<<endl;
		cout<<"                    ENTER THE DETAIL OF PRODUCT ("<<j+1<<")                   "<<endl;
        cout<<"\n--------------------------------------------------------------------------\n"<<endl;
		
		cout<<"enter the name of product ["<<j+1<<"]:: ";
		cin>>product;
		cout<<"enter the Quantity of product ["<<product<<"]:: ";
		cin>>unit[j];
		cout<<"enter the price of product ["<<product<<"] Rs. :: ";
		cin>>price;
		
		cout<<"enter the GST of product ["<<product<<"] % :: ";
		cin>>gst[j];
		cout<<"\n"<<endl;
		
		totalexp=unit[j]*price;
	gstcount=((totalexp*gst[j])/100);
	totalprice[j]=price+gstcount;
	cout<<"price of product ["<<product<<"]:: "<<totalprice[j]<<" Rs.\n"<<endl;

    
	if(price>500)
	{
		extragst[j]=((totalexp*5)/100);
		cout<<"price is greater then 500 (Rs.) so 5% discount of the oiginal price::"<<extragst[j]<<" Rs."<<endl;
		totalprices[j]=totalprice[j]-extragst[j];
		cout<<"total price of product["<<j<<"]:: "<<totalprices[j]<<" Rs.\n"<<endl;
		
		
	}
	else
	{
	extragst[j]=((totalexp*0)/100);
		cout<<"price is less then 500 (Rs.) so 5% discount is not included"<<endl;
		totalprices[j]=totalprice[j]-extragst[j];
		cout<<"total price of product:: "<<totalprices[j]<<" Rs.\n"<<endl;
			
	}
	sum +=totalprices[j];
	sumUnit +=unit[j];
	
}
cout<<"\n--------------------------------------------------------------------------\n"<<endl;
cout<<"\n--------------------------------------------------------------------------\n"<<endl;
cout<<"total amount to be paid to the shop-keeper:: "<<sum<<" Rs."<<endl;
cout<<"\ntotal Quantity of products to be buy the shop-keeper:: "<<sumUnit<<" units"<<endl;
 int   largest=gst[0];

        for (j=0;j<size;j++)
    	{
                if(gst[j]>largest)
                {
                        largest=gst[j];
                        
                }
                
        }
        
        
cout<<"\nwe paid maximum orginal GST charge:: "<<largest<<"%"<<endl;
	return 0;
}
