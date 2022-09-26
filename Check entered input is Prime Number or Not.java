import java.util.Scanner;

public class JavaProgram {

    public static void main(String[] args) {
       
        int n,i=2;
        Scanner sc = new Scanner(System.in);
        System.out.println("Please Enter any No. : ");
        n=sc.nextInt();
        
        while(true)
        {   
            if(n==1)
            {
            System.out.println("Smallest Prime number is 2");
            break;
            }
           if(n%i==0)
           {
               break;
           }
           else
           {
               i++;
           }
        }
        if(n==i)
        {
            System.out.println("Prime No.");
        }
        else
        {
            System.out.println("Not Prime No.");
        }
    }
    
}
