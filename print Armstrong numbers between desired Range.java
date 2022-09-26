import java.util.Scanner;
import java.lang.Math;
public class Armstrong1
{
    public static void main(String args[])
    {
        int num1, num2, i, n, rem, temp, count=0,a;
        Scanner scan = new Scanner(System.in);
        
        System.out.print("Enter the Interval :\n");             
        System.out.print("Enter Starting Number : ");
        num1 = scan.nextInt();
        
        System.out.print("Enter Ending Number : ");
        num2 = scan.nextInt();
                
        for(i=num1; i<num2; i++)
        {
            temp = i;
            n = 0;
            a=countdigit(temp);
            while(temp!=0)
            {
                rem = temp%10;
                temp = temp/10;
                 n = (int) (n + Math.pow(rem,a)) ;

            }
            if(i == n && i>10) 
            {
                if(count == 0)
                {
                    System.out.print("Armstrong Numbers Between the Given Interval are :\n");
                }
                System.out.print(i + "  ");
                count++;
            }
        }
        if(count == 0)
        {
            System.out.print("Armstrong Number not Found between the Given Interval.");
        }
    }
    
    public static int countdigit(int n)
    {
      int c=0;
      
      while(n>0)
      {
          n=n/10;
          
          c++;
      }
      return c;
      
    }
}
