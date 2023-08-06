public class Child extends Parent{
    String name;
    int age;

    public Child(String nam,String nm,int ag){
        super(nam);
        name=nm;
        age=ag;
    }
    public void show_Child_Details(){
        System.out.println(" ");
        System.out.println("\s\sChild details are ::::");
        System.out.println("\s\s\sChild name is "+name);
        System.out.println("\s\s\sChild age is "+age);
    }
}
