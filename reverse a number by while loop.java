import java.util.*;
public class Main
{
 public static void main(String[] args)
 {
  int number,rev=0;
  Scanner sc=new Scanner(System.in);
  System.out.print("enter a number:: ");
  number=sc.nextInt();
   while(number !=0)
   {
    int rem=number%10;
     rev=rev*10+rem;
     number=number/10;
   }
   System.out.print("reverse number is :: "+rev);

 }
}
