import java.lang.*;
import java.util.Scanner;
public class Main
{
    
    public static void main(String[] args) {
        int[] array = new int[500];
        int i;
         int size;
        Scanner sc = new Scanner(System.in);
        System.out.print("enter the size of array:: ");
        size=sc.nextInt();
        System.out.print("element are:: ");
        for(i=0;i<size;i++)
        {
            array[i]=sc.nextInt();

        }
        for(i=0;i<size;i++) {
            System.out.println("stored element of index ["+i+"] are::" + array[i] + " ");
        }
        System.out.println(" ");
        for(i=0;i<size;i++)
        {
            for(int j=i+1;j<size;j++)
            {
                if(array[i]==array[j] && i!=j)
                {
                    System.out.println("duplicate elements are::"+array[j]);
                    
                }
            }

        }

    }

}
