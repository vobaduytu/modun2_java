import java.util.Arrays;

public class MyQueue {
    private int capacity;
    private int[] queueArr;
    private int head = 0;
    private int tail = -1;
    private int currentSize;

    public MyQueue(int queueSize){
        this.capacity = queueSize;
        queueArr = new int[this.capacity];
    }
    public boolean isQueueFull(){
        return currentSize == capacity;
    }
    public boolean isQueueEmpty(){
        return  currentSize == 0;
    }
    public void enqueue(int item){
        if (isQueueFull()){
            System.out.println("da day");
        }else {
            tail++;
            queueArr[tail] = item;
            currentSize++;
            System.out.println(item);
        }

    }
    public void dequeue(){
        if (isQueueEmpty()){
            System.out.println("mang rong");
        }
        else {
            head++;
            
            System.out.println(queueArr[head-1]);
        }
        currentSize--;
    }
        public void queue(){
            for(int i = head; i <= tail; i++ ){
                System.out.print(queueArr[i]+" ");
            }
        }
    @Override
    public String toString() {
        return "MyQueue{" +
                "capacity=" + capacity +

                ", head=" + head +
                ", tail=" + tail +
                ", currentSize=" + currentSize +
                '}';
    }

    public static void main(String[] args) {
        MyQueue myQueue =new MyQueue(5);
        myQueue.enqueue(1);
        myQueue.enqueue(2);
        myQueue.enqueue(3);
        myQueue.enqueue(4);
        myQueue.enqueue(5);
        myQueue.dequeue();

        myQueue.queue();
    }
}
