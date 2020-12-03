public class MyLinkedListTest {
    public static void main(String[] args) {
        MyLinkedList lll = new MyLinkedList(0);
        lll.add(1,4);
        lll.add(2,5);
        lll.addFirst(10000000);
        lll.printList();
    }
}