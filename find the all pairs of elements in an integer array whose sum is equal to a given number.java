import java.util.*;
public  class Main
{
  public static void main(String[] args)
  {
      int size,i,num,j;
      Scanner sc=new Scanner(System.in);
      System.out.print("enter the size of array:: ");
      size=sc.nextInt();
      int[] array=new int[size];

      System.out.print("enter the element of array:: ");
      for(i=0;i<size;i++)
      {
          array[i]=sc.nextInt();
      }
      System.out.print("stored elements are:: ");
      for(i=0;i<size;i++)
      {
          System.out.print(" "+array[i]);
      }
      System.out.print("\nenter the number:: ");
      num=sc.nextInt();
      System.out.print("\narray created:: "+Arrays.toString(array));
      System.out.println("\nindices of elements whose sum is :: "+num);
      for(i=0;i<array.length;i++)
      {
          for(j=i;j<array.length;j++)
          {
              if(array[i]+array[j]==num && i!=j)
              {
                  System.out.println(i+" , "+j);
              }

          }
      }

  }
}
