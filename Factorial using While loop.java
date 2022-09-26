import java.util.Scanner;

public class Factorial{

    public static void main(String[] args) 
    {
        
        int n, fact=1;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter any number :");
        n=sc.nextInt();
        
        int i=1;
        while(n>=i)
        {
            fact=fact*i;
            i++;
        }
        System.out.println("Factorial is :" +fact);
    }
        
    }
