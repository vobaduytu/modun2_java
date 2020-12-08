public class CircularQueueTest {
    public static void main(String[] args) {
        CircularQueue circularQueue = new CircularQueue();
        circularQueue.queue(1);
        circularQueue.queue(2);
        circularQueue.queue(3);
        circularQueue.queue(4);
        circularQueue.queue(5);
        System.out.println(circularQueue);
        System.out.println(circularQueue.dequeue());
        System.out.println(circularQueue);


    }
}