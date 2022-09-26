import java.util.Scanner;


public class quadratic_equation
{
    public static void main(String args[])
    {
        double a, b, c;
        double root1, root2, D, sqrroot;
        System.out.println("\nEnter The Values");
        Scanner sc = new Scanner(System.in);
        System.out.print("\nA:  ");
        a = sc.nextDouble();
        System.out.print("\nB:  ");
        b = sc.nextDouble();
        System.out.print("\nC:  ");
        c = sc.nextDouble();
        System.out.println("\nGiven quadratic equation : "+a+"x^2 + "+b+"x + "+c);
       
        if((a==0)&&(b==0)&&(c==0))
        {
            System.out.println("\nEnter atleast two non-zero co-efficients");
            System.exit(0);
        }
        else if(a==0 && b!=0)
            {
                root1= -c/b;
                System.out.println("\nThe roots are:"+root1);
                System.exit(0);
            }
        else if(a==0&&b==0&&c!=0)
        {
            System.out.println("\nThe equation has no solution");
            System.exit(0);
        }
            else
            {
       
                D = b*b - 4*a*c;
                sqrroot = Math.sqrt(D);

                if(D<0)
                {
                    System.out.println("\nRoots Are Imaginary\n");
                }
                else if(D == 0)
                {
                    System.out.println("\nRoots are real and equal");
                    root1 = (-b + sqrroot) / (2*a);
                    System.out.println("\nRoots are : "+root1);

                } 
                else
                {

                    System.out.println("\nRoots are real and unequal");     
                    root1 = (-b + sqrroot) / (2*a);
                    root2 = (-b - sqrroot) / (2*a);
                    System.out.println("\nRoot 1 = " + root1 + "\n");
                    System.out.println("Root 2 = " + root2 + "\n");
                }
            }
        
        
        
}
}
