public class Main {
    public  static  MyClass myClass;
    public static void main(String[] args) {
        
       Fan fan1 = new Fan(Fan.FAST, true,10,"yellow");
        System.out.println(fan1);
        Fan fan2 = new Fan(Fan.MEDIUM,false,5,"blue");
        System.out.println(fan2);
    }
}
