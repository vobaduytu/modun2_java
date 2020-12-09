public class MyStack {
    private int[] arr;
    private int size;
    private int index;


    public MyStack(int size) {
        arr = new int[size];
        this.size = size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return index == size;
    }

    public void push(int elements) {
        if (isFull()) {
            System.out.println("da day");
            return;
        }
        arr[index] = elements;
        index++;
    }

    public int pop() {
        if (isEmpty()) {
            System.out.println("mang trong");
            return -1;
        }

        return arr[--index];
    }

    public int size() {
        return index;
    }

    public void print() {
        for (int i = 0; i < index; i++) {
            System.out.println(arr[i] + " ");
        }
    }

    public static void main(String[] args) {
        MyStack myStack = new MyStack(3);
        myStack.push(1);
        myStack.push(2);
        myStack.push(3);
        myStack.push(4);
        myStack.print();
    }
}
