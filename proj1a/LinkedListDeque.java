public class LinkedListDeque<T> {
    /** T can represent all data types */
    private Node first;
    private Node last;
    private int size; // the length of the list

    /** constructor */
    private class Node {
        private T item;
        private Node next, prev; // pointer

        public Node(T item, Node next, Node prev) {
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

    private LinkedListDeque getremove() {
        LinkedListDeque b = this.copy();
        b.removeFirst();
        return b;
    }

    public void addFirst(T x){
        first = new Node(x, first, null);
        size += 1;

        if (first.next != null){
            first.next.prev = first;
        }

        if (last == null){
            // first = last;
            last = first;
        }
    }

    public void addLast(T x){
        last = new Node(x, null, last);
        size+=1;

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

    /**
     * Helper Function to printList
     * Prints the items in the deque from first to last, separated by a space.
     * Once all the items have been printed, print out a new line
     */
    public void printDeque() {
        if (this.isEmpty()) {
            System.out.println("List is Empty!");

        } else {
            Node temp = first;
            System.out.print("List: ");
            while (temp != last) {
                System.out.print(temp.item.toString() + " -> ");
                temp = temp.next;
            }
            System.out.println(temp.item.toString() + " -> null");
        }
    }

    public T removeFirst() {
        if (this.isEmpty()) {
            return null;
        } else {
            size -= 1;
            T result = first.item;
            first = first.next;
            if (first == null) {  //empty now!
                last = null;
                return result;
            }
            first.prev = null;
            return result;
        }
    }

    public T removeLast() {
        if (this.isEmpty()) {
            return null;
        } else {
            size -= 1;
            T result = last.item;
            last = last.prev;
            if (last == null) {
                first = null;
                return result;
            }
            last.next = null;
            return result;
        }
    }

    public T get(int index) {
        int i = index;
        Node p = first;
        while (i != 0) {
            p = p.next;
            i--;
        }
        return p.item;
    }


    public T getRecursive(int index) {
        if (index == 0) {
            return first.item;
        } else {
            return (T) this.getremove().getRecursive(index - 1);
        }
    }


}









