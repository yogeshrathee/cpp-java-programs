import java.util.*;
public class Main{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter the name of Phone:: ");
        String name=sc.nextLine();
        System.out.print("Enter the cost of "+name+" :: ");
         double cost=sc.nextDouble();
        System.out.print("Enter the Battery Life of "+name+" , which cost is "+cost+" :: ");
        double life=sc.nextDouble();
        System.out.println(" ");
        Iphone obj=new Iphone();
        obj.name(name);
        obj.cost(name,cost);
        obj.battery_life(name,life);
    }
}