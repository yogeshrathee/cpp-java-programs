public class GrandChild extends Child{
    String name;
    int age;
    String gender;

    public GrandChild(String nam,String nm,int ag,String n,int a,String gen){
        super(nam,nm,ag);
        name=n;
        age=a;
        gender=gen;
    }
    public void show_GrandChild_Details(){
        System.out.println(" ");
        System.out.println("\s\sGrand Child Details are :::: ");
        System.out.println("\s\s\sGrand child name is "+name);
        System.out.println("\s\s\sGrand child age is "+age);
        System.out.println("\s\s\sGrand child Gender is "+gender);
    }
}
