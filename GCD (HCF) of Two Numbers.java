import java.util.Scanner;

public class GCD {
    
    public static void main(String[] args) {
        
        int a,b,gcd,temp1,temp2;
        
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Enter 1st No.");
        a=sc.nextInt();
        System.out.println("Enter 2nd No.");
        b=sc.nextInt();
        
        temp1=a;
        temp2=b;
        
                while(true)
                {
                    if(a>b)
                    {
                            if(a%b==0)
                            {
                                gcd=b;
                                break;
                            }
                            else
                            {
                                a=a%b;
                            }
                    }
                    else
                    {
                            if(b%a==0)
                            {
                                gcd=a;
                                break;
                            }
                            else
                            {
                                b=b%a;
                            }
                    }
                }
        
        System.out.println("GCD of "+ temp1 +" and "+ temp2 +" = "+ gcd);
    }
    
}
