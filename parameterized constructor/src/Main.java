public class Main{
    public Main(int empId, String name){  //parametrized constructor
        System.out.println("employee id:: "+empId);
        System.out.println("employee name:: "+name);
    }
    public static void main(String[] args){
        Main obj=new Main(101,"yogesh");   // (create an object or reference for execute the constructor) or call the constructor

    }
}