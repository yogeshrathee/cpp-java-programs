public class Main{
    static {
        System.out.println("block 1");
    }
    static {
        System.out.println("block 2");
    }


    public static void main(String[] args){
        System.out.println("Main Method");
    }


    static {
        System.out.println("block 3");
    }
    static {
        System.out.println("block 4");
    }
}