import java.util.*;
public class Main
{
    public static void main(String[] args)
    {
        int count;
        Scanner sc=new Scanner(System.in);
        System.out.print("enter a character string:: ");
        String str=sc.nextLine();
        char[] string=str.toCharArray();
        System.out.println("length of string:: "+string.length);
        System.out.print("duplicate characters in string:: ");
        for(int i=0;i<string.length;i++)
        {
            count=1;
            for(int j=i+1;j<string.length;j++)
            {
                if(string[i]==string[j] && string[i]!='0')
                {
                    count++;
                    string[j]='0';
                }
            }
            if(count>1 && string[i]!='0')
            {
                System.out.print(string[i]+" ");
            }
        }


    }
}
