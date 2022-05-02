import java.util.LinkedList;

public class LinkedListDeque<T> {
    /** T can represent all data types */

    private IntNode first; // why private here
    private IntNode last;
    private int size; // the length of the list

    /** constructor */
    private class IntNode {

        private T item;
        private IntNode next, prev; // pointer

        public IntNode(T item, IntNode next, IntNode prev) {
            this.item = item;
            this.next = next;
            this.prev = prev;
        }
    }

    public LinkedListDeque() {
        first = null;
        last = null;
        size = 0;
    }

    /**
     * Creating a deep copy means that you create an entirely new LinkedListDeque, with the exact same items as other
     * However, they should be different objects, i.e. if you change other
     * the new LinkedListDeque you created should not change as well
     * @return result
     */
    private LinkedListDeque copy(){
        // create an entirely new LinkedListDeque
        LinkedListDeque<T> result = new LinkedListDeque<>();

        // [source code]. https://www.youtube.com/watch?v=JNroRiEG7U4
        for (int i = 0; i < this.size; i++){
            result.addLast((T) this.get(i));
        }

        return result;
    }

    public void addFirst(T x){
        size += 1;
        first = new IntNode(x, first, null);

        if (first.next != null){
            first.next.prev = first;
        }

        if (last == null){
            // first = last;
            first = null;
        }
    }


    public void addLast(T x){
        size+=1;
        last = new IntNode(x, null, last);

        if (last.prev != null) {
            last.prev.next = last;
        }

        if (first == null) {
            first = last;
        }
    }

    public boolean isEmpty() {
        return (first == null && last == null);
    }



    /** get the size of linked list */
    public int size() {
        return size;
    }

//    public void printDeque() {
//    }

//    public T removeFirst() {}

//    public T removeLast(){}



}









