import java.util.Arrays;

public class MyArrayList {
    private Object[] array;
    private int size;

    public MyArrayList() {
        array = new Object[10];
        size = 0;
    }

    public void add(Object value) {
        if (size == array.length) {
            Object[] newArray = new Object[array.length * 2];
            System.arraycopy(array, 0, newArray, 0, array.length);
            array = Arrays.copyOf(newArray, newArray.length);
        }
        array[size++] = value;
    }

    public void remove(int index) {
        if(index >= 0 && index < size) {
            System.arraycopy(array, index + 1, array, index, size - index - 1);
            array[size--] = null;
        } else {
            throw new IndexOutOfBoundsException();
        }
    }

    public void clear() {
        for (int i = 0; i < size; i++) {
            array[i] = null;
        }
        size = 0;
}
