import static org.junit.jupiter.api.Assertions.*;

class MyLinkedListTest {
    public static void main(String[] args) {

        MyLinkedList list = new MyLinkedList(0);

        list.add(1, 100);
        list.add(2, 122);
        list.add(3, 5);
        list.add(4, 4);
        list.addFist(1);
        list.addLast(1000);



        System.out.println("xóa chỉ định: "+ list.removes(100));

        list.remove(5);
        list.remove(0);
        System.out.println("test " + list.indexOf(1));;
        System.out.println("kiem tra phan tu: "+ list.contains(122));
//        System.out.println("ban sao: " + list.clone());
        list.clone();
        list.printList();
    }
}