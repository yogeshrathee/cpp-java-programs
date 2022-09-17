import java.util.*;
public class Main
{
    public static void main(String[] args)
    {
        int size,i,size1,j;
        Scanner sc=new Scanner(System.in);
        System.out.print("enter the size of array1:: ");
        size=sc.nextInt();
        int[] array1=new int[size];
        System.out.print("enter the element of array1:: ");
        for(i=0;i<size;i++)
        {
            array1[i]=sc.nextInt();
        }
        System.out.print("elements of array1:: ");
        for(i=0;i<size;i++)
        {
            System.out.print(" "+array1[i]);
        }
        System.out.println("\n\n");
        System.out.print("enter the size of array2:: ");
        size1=sc.nextInt();
        int[] array2=new int[size1];
        System.out.print("enter the element of array2:: ");
        for(i=0;i<size1;i++)
        {
            array2[i]=sc.nextInt();
        }
        System.out.print("stored elements of array2:: ");
        for(i=0;i<size1;i++)
        {
            System.out.print(" "+array2[i]);
        }
        System.out.println("\n\n");
        System.out.print("intersection of two arrays:: ");
        for(i=0;i<array1.length;i++)
        {
            for(j=0;j<array2.length;j++)
            {
                if(array1[i]==array2[j])
                {
                    System.out.print(" "+array2[j]);
                }
            }
        }
    }
}
