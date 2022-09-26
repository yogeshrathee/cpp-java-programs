import java.util.Scanner;

public class CelsiusToFahrenheit
{
    public static void main(String args[])
    {
        float cen;
        double fah;
        Scanner scan = new Scanner(System.in);
                
        System.out.print("Enter Temperature in Celsius : ");
        cen = scan.nextFloat();
                
        fah = (1.8*cen) + 32;
                
        System.out.println("Temperature in Fahrenheit = " + fah);
    }
}
