import java.util.Scanner;

public class ReverseNumber {

public static void main(String[] args) {
 
 int n,i,reverse=0,k;
 
 Scanner sc = new Scanner(System.in);
 System.out.print("Enter the no. which u want to reverse : ");
 n=sc.nextInt();
 k=n;
 while(n&gt;0)
 {
 i=n%10;
 reverse=reverse*10+i;
 n=n/10;
 }
 System.out.println("Reverse of " + k + " is : "+ reverse);
 
 }
 
}
