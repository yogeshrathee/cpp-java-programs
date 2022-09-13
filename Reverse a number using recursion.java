import java.util.*;
public class Main
{
 public static void reversenumber(int number)
 {
  if(number < 10)
  {
   System.out.println(number);
  }
  else
  {
   System.out.print(number%10);
   reversenumber(number/10);
  }
 }
 public static void main(String[] args)
 {
    System.out.print("enter a number:: ");
    Scanner sc=new Scanner(System.in);
    int num=sc.nextInt();
    System.out.print("reverse number is :: ");
    reversenumber(num);
 }
}
