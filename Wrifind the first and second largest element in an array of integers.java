import java.util.*;
import java.lang.String;



public class Main
{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int i ,j,max;
        System.out.print("enter the size of array:: ");
        int size = sc.nextInt();
        int[] array = new int[size];
        System.out.println(" ");
        System.out.print("enter the element of array:: ");
        for (i = 0; i < size; i++)
        {
            array[i] = sc.nextInt();
        }
        for (i = 0; i < size; i++)
        {
            for(j=i+1;j<size;j++)
            {
                if(array[i]>array[j])
                {
                    max=array[i];
                    array[i]=array[j];
                    array[j]=max;
                }
            }
        }

        System.out.print("array element after sorted: ");
        for(i=0;i<size;i++)
        {
            System.out.print(" "+array[i]);
        }
        System.out.println(" ");
        System.out.print("\n1st largest element is:: "+array[array.length - 1]);
        System.out.print("\n2nd largest element is:: "+array[array.length - 2]);


    }

}
