import java.util.Scanner;
public class Prime_numbers {

    public static void main(String[] args) {
        
        int n,i=2,j=2;
        Scanner sc = new Scanner(System.in);
        System.out.println("ENter upto which no. u want :");
        
        try{
           n=sc.nextInt();
           if(n>0)
           {
               System.out.println("Prime Numbers are : ");
               prime(n);
               System.out.println("");
           }
           else
           {
               System.out.println("Please enter only positive integer ");
           }  
        }
        catch(Exception e)
        {
            System.out.println(e);
            System.out.println("Please enter only integer ");
        }     
    }
    
    
    
    static void prime(int a)
    {
        int i=2,j=2;
        
        while(a>i)
        {
            
            while(true)
            {
                if(i%2==0)
                {
                    break;
                }

                if(i%j==0)
                {
                    break;
                }
                else
                {
                    j++;

                }

            }
                if(j==i)
                       {
                          System.out.print(" "+ i);
                          j=2;
                       }
            i++;
        }
    }   
}
