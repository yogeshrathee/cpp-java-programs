import java.util.*;
public class Main
{
    public static void main(String[] args)
    {
        String num;
        Scanner sc=new Scanner(System.in);
        System.out.print("enter the character:: ");
        num=sc.nextLine();
        char[] array=num.toCharArray();
        for(int i=array.length-1;i>=0;i--)
        {
            System.out.print(array[i]);
        }

    }
}
