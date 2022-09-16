import java.util.*;
public class Main
{
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        int size,i,count=0,max=0;
        System.out.print("enter the size of array:: ");
        size=sc.nextInt();
        int[] array=new int[size];
        System.out.print("enter the element of array:: ");
        for(i=0;i<size;i++)
        {
            array[i]=sc.nextInt();

        }
        System.out.print("stored elements are:: ");
        for(i=0;i<size;i++) {
            System.out.print(" "+array[i]);
        }
        for(i=0;i<array.length;i++)
        {
            if(array[i]==1)
            {
                count++;
                max=Math.max(count,max);
            }
            else {
                count =0;
            }
        }
        System.out.print("\n\n1's consecutive:: "+max);
    }
}
