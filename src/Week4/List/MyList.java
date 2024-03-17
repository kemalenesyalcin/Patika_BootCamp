package Week4.List;

public class MyList<T> {
    private T[] array;
    private int size;
    private static final int DEFAULT_CAPACITY = 10;

    public MyList() {
        this(DEFAULT_CAPACITY);
    }

    public MyList(int capacity) {
        array = (T[]) new Object[capacity];
        size = 0;
    }

    public int size() {
        return size;
    }

    public int getCapacity() {
        return array.length;
    }

    public void add(T data) {
        if (size == array.length) {
            ensureCapacity();
        }
        array[size++] = data;
    }

    private void ensureCapacity() {
        int newCapacity = array.length * 2;
        T[] newArray = (T[]) new Object[newCapacity];
        System.arraycopy(array, 0, newArray, 0, size);
        array = newArray;
    }

    public T get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index is out of bounds!");
        }
        return array[index];
    }

    public void remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index is out of bounds!");
        }
        System.arraycopy(array, index + 1, array, index, size - index - 1);
        array[--size] = null;
    }

    public void set(int index, T data) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index is out of bounds!");
        }
        array[index] = data;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < size; i++) {
            sb.append(array[i]);
            if (i < size - 1) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }
}

