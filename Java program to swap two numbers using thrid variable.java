import java.util.*;
public class Main
{
    public static void main(String[] args)

{
    int temp,a,b;
     Scanner sc=new Scanner(System.in);
     System.out.print("enter the value of a:: ");
     a=sc.nextInt();
     System.out.print("enter the value of b:: ");
     b=sc.nextInt();
     temp=a;
     a=b;
     b=temp;
     System.out.print("\nthe value of a:: "+a);
     System.out.print("\nthe value of b::"+b);


}
}
