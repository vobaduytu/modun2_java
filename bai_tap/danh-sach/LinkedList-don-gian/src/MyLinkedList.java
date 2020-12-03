

public class MyLinkedList {
private Node head;
private int numNodes;

public MyLinkedList(Object data){
    head = new Node(data);
}
public void add(int index , Object data){
    Node temp = head;
    Node holer;
    for (int i = 0; i < index-1 && temp.next!= null; i++){
        temp = temp.next;
    }
    holer = temp.next;
    temp.next = new Node(data);
    temp.next.next = holer;
    numNodes++;
}
    public void printList() {
        Node temp = head;
        while(temp != null) {
            System.out.println(temp.data);
            temp = temp.next;
        }
    }
    public void addFirst(Object data) {
        Node temp = head;
        head = new Node(data);
        head.next = temp;
        numNodes++;
    }
    //    public Node get(int index){
//        Node temp=head;
//        for(int i=0; i<index; i++) {
//            temp = temp.next;
//        }
//        return temp;
//    }
private class Node{

   private  Node next;
   private Object data;

    public Node(Object data) {
        this.data = data;
    }
    public Object getData(){
        return this.data;
    }
}
}