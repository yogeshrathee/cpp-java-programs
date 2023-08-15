public class Main{
    int num=20;
    static int staticNum=40;
    public static void main(String[] args){
       Main obj=new Main();
       obj.sum();

       multi();
    }
    public void sum(){
        System.out.println("1. non-static variable:: "+num+num);
        System.out.println("2. static variable:: "+staticNum+staticNum);
    }
    public static void multi(){

//        num is non-static variable ,and method is static . if you want to execute this statement successfully then, you make the num is static variable.


//        System.out.println("3. non-static variable:: "+(num*num));


        System.out.println("4. static variable:: "+(staticNum*staticNum));
    }
}