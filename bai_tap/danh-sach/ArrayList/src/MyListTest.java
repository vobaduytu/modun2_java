import static org.junit.jupiter.api.Assertions.*;

class MyListTest {
    public static void main(String[] args) {
        MyList<Integer> list = new MyList<Integer>();
       list.add(0,9);
       list.add(1,10);
       list.add(2,11);
       list.add(3,12);
       list.print();

       list.remove(0);
        System.out.println("xnxx.es");
        System.out.println(list.get(1));

        System.out.println(list.contains(11));
        System.out.println(list.add(-1));
        System.out.println(list.add(null));
    }
}