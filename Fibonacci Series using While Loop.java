import java.util.Scanner;

public class Fibonacci {

  
    public static void main(String[] args) {
        
        int a=1,b=1,n,fibon=1;
              
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter how many terms u want : ");
        n=sc.nextInt();
        System.out.print(fibon);
        while(n>1)
        {
             System.out.print(" "+fibon);
             fibon=a+b;
             a=b;
             b=fibon;
             n--;
        }
         System.out.println("");
        
    }
    
}
