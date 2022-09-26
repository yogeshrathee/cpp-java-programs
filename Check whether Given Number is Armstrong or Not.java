import java.util.Scanner;
import java.lang.Math;
public class Armstrong {

    public static void main(String[] args) {
        
        int a,b,n,arm=0,temp;
        System.out.print("Enter No. which u want to Check :");
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        temp=n;
        a=countdigit(n);
        while(n>0)
        {
           b=n%10;
           n=n/10;
          
           arm = (int) (arm + Math.pow(b, a)) ;
           
        }
        if(arm==temp)
        {
            System.out.println("Armstrong No.");
        }
        else
        {
            System.out.println("Not Armstrong No.");
        }
    }
    
    static int countdigit(int n)
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
