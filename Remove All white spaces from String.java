import java.util.*;
public class Main
{
    public static void main(String[] args)
    {
        String num;
        Scanner sc=new Scanner(System.in);
        System.out.print("enter the character:: ");
        num=sc.nextLine();
        System.out.print("return result:: ");
        System.out.print(num.replaceAll(" ",""));


    }
}
