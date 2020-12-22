import java.util.Arrays;

public class MyStack<E> {
    private static final int INITIAL_SIZE = 3;
    private E[] elements;
    private int count = 0;

    public MyStack(){
        elements = (E[]) new Object[INITIAL_SIZE];
    }
    public void push(E e){
        ensureCapacity();
        elements[count++] = e;
    }
    private void ensureCapacity(){
        if (count>= elements.length){
            E[] newElements = (E[]) new Object[elements.length*2 ];
            System.arraycopy(elements,0,newElements,0,count);
            elements = newElements;
        }
    }
    public E pop(){
        if (count==0){
           throw new IndexOutOfBoundsException("ooooo");
        }
        E e = elements[count-1];
        elements[count -1 ] = null;
        count--;
        return e;
    }

    public boolean isEmpty(){
        if(count < 1 ){
            return true;
        } else return false;
    }

    @Override
    public String toString() {
        return "MyStack{" +
                "elements=" + Arrays.toString(elements) +
                '}';
    }
}
