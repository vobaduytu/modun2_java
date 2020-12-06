import java.util.Arrays;

public class MyList<E> {
    private int size = 0;
    private static final int DEFAULT_CAPACITY = 10;
    private Object elements[];

    public MyList() {
        elements = new Object[DEFAULT_CAPACITY];
    }

    public MyList(int capacity) {

    }

    public int size() {
        return size;
    }

    private void ensureCapa() {
        int newSize = elements.length * 2;
        elements = Arrays.copyOf(elements, newSize);
    }

    public void add(int index, E e) {
        if (size == elements.length) {
           return;
        }
       for (int i = size; i > index; i--){
           elements[size+ 1] = elements[size];
       }
       elements[index] = e;
       size++;
    }

    public E remove(int index) {
        if (isIndexOutOfRange(index, size - 1)) {
            return null;
        }
        E[] objects = null;
        E holder = (E) elements[index];
        if (size - 1 - index >= 0) System.arraycopy(elements, index + 1, elements, index, size - 1 - index);
        elements[size - 1] = null;
        size--;
        return holder;
    }

    public E get(int i) {
        if (i >= size || i < 0) {
            throw new IndexOutOfBoundsException("Index: " + i + ", Size " + i);
        }
        return (E) elements[i];
    }

    public boolean contains(E o) {
        return indexOf(o) != -1;
    }

    private int indexOf(E o) {
        for (int i = 0; i < size; i++) {
            if (o.equals(elements[i]))
                return i;
        }
        return -1;
    }

    public boolean add(E e) {
        if (isNull(e))
            return false;
        add(size, e);
        return true;

    }

    private boolean isIndexOutOfRange(int index, int i) {
        return index < 0 && index > i;
    }

    private boolean isNull(E e) {
        return e == null;
    }

    public void print() {
        System.out.println(Arrays.toString(elements));
    }

    
}
