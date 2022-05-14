/**
 * ArrayDeque
 *
 * @author Kane li
 * @create 2022-05-13-23:51
 **/

public class ArrayDeque<T> {
    private final int FACTOR = 2;
    private int size = 0;
    private T[] arr;

    // constructor
    public ArrayDeque() {
        size = 0;
        // source: https://youtu.be/Qcrd80To-TM?t=39
        // have to use the awkward syntax here
        arr = (T[]) new Object[8]; // starting size should be 8
        
    }


    /** Resizes the array to the target capacity */
    // cs61b sp18 ch2.5, source form: https://youtu.be/tLcinQx5VnY
    private void resize(int length, int position, int position1) {
        if (length <= 16) {
            length = 16;
        }

        // Create a new array to store data
        T[] newArr = (T[]) new Object[length];

        // Copy the original data of array to new array
        // arraycopy(Object src, int srcPos, Object dest, int destPos, int length)
        System.arraycopy(arr, position, newArr, position1, size);
        arr = newArr;
    }


    public void addFirst(T item) {
        int al = arr.length;
        if (size == arr.length) {
            al = size * FACTOR; // https://youtu.be/oysadh63NxY
        }

        resize(al, 0, 1);
        arr[0] = item;
        size += 1;
    }

    
    public void addLast(T item) {
        if (size == arr.length) {
            resize(size * FACTOR, 0, 0);
        }
        arr[size] = item;
        size += 1;
    }


    public T removeFirst() {
        T first = arr[0]; // the value should be removed
        size -= 1;
        int firstSize = arr.length;

        if ((size <= (arr.length * 0.25)) && (arr.length >= 16)) {
            firstSize = size * FACTOR;
        }
        resize(firstSize, 1, 0);
        return first;
    }


    public T removeLast() {
        T last = arr[size - 1];
        arr[size - 1] = null;
        size -= 1 ;
        if ((size <= (arr.length * 0.25)) && (arr.length >= 16)) {
            resize(size * FACTOR, 0, 0);
        }
        return last;
    }


    public int size() {
        return size;
    }


    public boolean isEmpty() {
        return size == 0;
    }


    public void printDeque() {
        int i = 0;
        while (i < size) {
            System.out.println(arr[i]);
            i += 1;
        }

    }


    public T get(int index) {
        if ((index + 1) > size) {
            return null;
        }
        return arr[index];
    }

}

