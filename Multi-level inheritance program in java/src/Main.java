import java.util.*;
public class Main{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter the Name of the Parent :: ");
        String P_name=sc.nextLine();
        System.out.print("Enter the Name of the Child :: ");
        String C_name=sc.nextLine();
        System.out.print("Enter the Age of the Child :: ");
        int C_age=sc.nextInt();
        System.out.print("Enter the Name of the Grand Child :: ");
        String G_name=sc.next();
        sc.nextLine();
        System.out.print("Enter the Age of the Grand Child :: ");
        int G_age=sc.nextInt();
        System.out.print("Enter the Gender of the Grand Child :: ");
        String G_gender=sc.next();

        System.out.println(" ");
        System.out.println("User Entered details are ::: ");
        GrandChild obj=new GrandChild(P_name,C_name,C_age,G_name,G_age,G_gender);
        obj.show_Parent_Details();
        obj.show_Child_Details();
        obj.show_GrandChild_Details();
    }
}