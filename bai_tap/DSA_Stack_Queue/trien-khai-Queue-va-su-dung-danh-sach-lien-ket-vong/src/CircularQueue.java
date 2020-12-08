public class CircularQueue<E> {
    private class Node {
        public int data;
        public Node link;

        public Node(int data) {
            this.data = data;
            this.link = null;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "data=" + data +
                    '}';
        }
    }

    public Node front;
    public Node rear;

    public CircularQueue() {
        this.front = null;
        this.rear = null;

    }

    public void queue(int data) {
        Node temp = new Node(data);
        if (this.front == null) {
            this.front = this.rear = temp;
            return;
        }
        rear.link = temp;
        this.rear = temp;
        rear.link = front;
    }

    @Override
    public String toString() {
        String result = "[";
        Node temp = front;
        while (temp != rear) {
            result += temp.data + "-";
            temp = temp.link;
        }

        return result + rear.data + ']';
    }

    public int dequeue() {
        if (this.front == null) {
            System.out.println("null");
            return -1;
        }
        Node temp = this.front;
        this.front = this.front.link;

        return temp.data;
    }
}
