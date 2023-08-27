public class Main{
    public static void main(String[] args){
        DataObject.StaticInnerClass obj=new DataObject.StaticInnerClass();  //create an object from access the non-static Variable

        System.out.println("innerNonStaticVar from StaticInnerClass :: "+obj.innerNonStaticVar); // print innerNonStaticVar from StaticInnerClass

        System.out.println("innerStaticVar from StaticInnerClass :"+DataObject.StaticInnerClass.innerStaticVar); //print innerStaticVar from staticInnerClass variable
    }
}
class DataObject{  //another class
    static class StaticInnerClass{ //static inner class
        int innerNonStaticVar=10; //non-static variable (non-static variable is not directly access from the  static class.)
        static int innerStaticVar=20; //static variable
    }
}