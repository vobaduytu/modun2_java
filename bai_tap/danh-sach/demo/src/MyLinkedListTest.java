import static org.junit.jupiter.api.Assertions.*;

class MyLinkedListTest {
    public static void main(String[] args) {
        MyLinkedList<Integer> linkedList = new MyLinkedList<Integer>();
        linkedList.add(1);
//        linkedList.add(2);
        System.out.println("elemen 1:   " + linkedList.get(0));
    }
}