import java.text.*;
import java.util.*;
public class Main {
    public static void main(String[] args)
    {

        DateFormat Date = DateFormat.getDateInstance();

        Calendar cals = Calendar.getInstance();

        System.out.println("The original Date: " + cals.getTime());

        String currentDate = Date.format(cals.getTime());
        System.out.println("Formatted Date: " + currentDate);
    }
}
