import java.util.Scanner;

public class Multiplication  
 {  
   public static void main(String[] args)   
   {  
       int i,n;
       Scanner sc = new Scanner(System.in);
       System.out.print("How many elements u want to multiply : ");
       n=sc.nextInt();
       
       int a[]=new int[n];
       
       System.out.println("Enter your elements below :---- \n");
       for(i=0;i<n;i++)
       {
           System.out.print("Enter "+(i+1)+" Element : ");
           a[i]=sc.nextInt();
       }
       
       for(i=1;i<n;i++)
       {
           int j=0,sum=0;
           while(j<a[i])
           {
               sum+=a[i-1];
               j++;
           }
           a[i]=sum;
       }
    System.out.println("\nMultiplication of "+n+" Numbers :"+ a[n-1] +" \n");   
   }  
 }
