public class MyLinkedList<E> {
    public Node head;
    public int numNodes;

    public MyLinkedList(Object data) {
        head = new Node(data);
        numNodes = 1;
    }

    public void add(int index, E element) {
        Node temp = head;
        Node holer;
        for (int i = 0; i < index - 1 && temp.next != null; i++) {
            temp = temp.next;
        }
        holer = temp.next;
        temp.next = new Node(element);
        temp.next.next = holer;
        numNodes++;
    }

    public int size() {
        return numNodes;
    }

    public void addLast(E e) {
        add(numNodes, e);
    }

    public Node get(int index) {
        Node temp = head;
        for (int i = 0; i < index - 1; i++) {
            temp = temp.next;
        }
        return temp;
    }

    public E remove(int index) {
        Node tempOne = head;
        if (index == 0) {
            head = tempOne.next;
        } else {
            for (int i = 0; i < index - 1; i++) {
                tempOne = tempOne.next;
            }
            tempOne.next = tempOne.next.next;
            numNodes--;
        }
        return null;
    }

    public boolean removes(E o) {
        int index = indexOf(o);
        if (index == -1)
            return false;
        remove(index);
        return true;

    }

    public void addFist(E e) {
        Node temp = head;
        head = new Node(e);
        head.next = temp;
        numNodes++;

    }

    public int indexOf(E o) {
        Node temp = head;
        int index = 0;
        while (temp != null) {
            if (o.equals(temp.getData()))
                return index;
            temp = temp.next();
            index++;
        }
        return -1;
    }

    public boolean contains(E o) {
        Node temp = head;

         while (temp != null) {
            if (o.equals(temp.getData()))
                return true;
            temp = temp.next;

        }
        return false;
    }

    public void printList() {
        Node temp = head;
        while (temp != null) {
            System.out.println(temp.data);
            temp = temp.next;
        }
    }

    public class Node {
        public Node next;
        Object data;


        public Node(Object data) {
            this.data = data;
        }


        public Object getData() {
            return this.data;
        }

        public Node next() {
            return next;
        }
    }

}

