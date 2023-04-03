import java.util.NoSuchElementException;

/**
 * A singly linked list.
 * 
 * @author Sara Rydell
 * @version 2023-01-26
 */
public class LinkedList<T> { 
    private ListElement<T> first;   // First element in list.
    private ListElement<T> last;    // Last element in list.
    private int size;               // Number of elements in list.
    
    /**
     * A list element.
     */
    private static class ListElement<T> {
        public T data;
        public ListElement<T> next;
        
        public ListElement(T data) {
            this.data = data;
            this.next = null;
        }
    }
    
    /**
     * Creates an empty list.
     */
    public LinkedList() {
        // TODO
        // Returns null by default
    }

    /**
     * Inserts the given element at the beginning of this list.
     *
     * @param element An element to insert into the list.
     */
    public void addFirst(T element) {
        // TODO
        ListElement<T> newElement = new ListElement<T> (element);
        if(isEmpty()) {
            this.first = newElement;
            this.last = newElement;
        }
        else{
            ListElement<T> temp = this.first;
            this.first = newElement;
            this.first.next = temp;     
        }
        size++;
    }

    /**
     * Inserts the given element at the end of this list.
     *
     * @param element An element to insert into the list.
     */
    public void addLast(T element) {
        // TODO
        ListElement<T> newElement = new ListElement<T> (element);
        if(isEmpty()) {
            this.first = newElement;
            this.last = newElement;
        }
        else{
            this.last.next = newElement;
            this.last = this.last.next;
        }
        size++;
    }

    /**
     * @return The head of the list.
     * @throws NoSuchElementException if the list is empty.
     */
    public T getFirst() {
        // TODO
        if(isEmpty()){
            throw new NoSuchElementException();
        }
        else{
            return this.first.data;
        }
    }

    /**
     * @return The tail of the list.
     * @throws NoSuchElementException if the list is empty.
     */
    public T getLast() {
        // TODO
        if(isEmpty()){
            throw new NoSuchElementException();
        }
        else{
            return this.last.data;
        }
    }

    /**
     * Returns an element from a specified index.
     *
     * @param index A list index.
     * @return The element at the specified index.
     * @throws IndexOutOfBoundsException if the index is out of bounds.
     */
    public T get(int index) {
        // TODO
        if((this.size() <= index) || (index < 0)){
            throw new IndexOutOfBoundsException();
        }
        else if (index == 0){
            return this.first.data;
        }
        else{
            ListElement<T> temp = this.first;
            for (int i=0; i<index; i++) {
                temp = temp.next;
            }
            return temp.data;
        }
    }

    /**
     * Removes the first element from the list.
     *
     * @return The removed element.
     * @throws NoSuchElementException if the list is empty.
     */
    public T removeFirst() {
        // TODO
        if(isEmpty()){
            throw new NoSuchElementException();
        }
        else{
            T temp = this.first.data;
            this.first = this.first.next;
            this.size--;
            if (this.size == 0){
                this.last = null;
            }
            return temp;
        }
    }

    /**
     * Removes all of the elements from the list.
     */
    public void clear() {
        // TODO
        while (this.size() > 0){
            this.removeFirst();
        }
    }

    /**
     * @return The number of elements in the list.
     */
    public int size() {
        // TODO
        return this.size;
    }

    /**
     * Note that by definition, the list is empty if both first and last
     * are null, regardless of what value the size field holds (it should
     * be 0, otherwise something is wrong).
     *
     * @return <code>true</code> if this list contains no elements.
     */
    public boolean isEmpty() {
        return this.first == null && this.last == null;
    }

    /**
     * Creates a string representation of this list. The string
     * representation consists of a list of the elements enclosed in
     * square brackets ("[]"). Adjacent elements are separated by the
     * characters ", " (comma and space). Elements are converted to
     * strings by the method toString() inherited from Object.
     *
     * Examples:
     *  "[1, 4, 2, 3, 44]"
     *  "[]"
     *
     * @return A string representing the list.
     */
    public String toString() {
        // TODO
        ListElement<T> object = first;
        String string = "[";
        while (object != null){
            string = string + object.data.toString() + ", ";
            object = object.next;
        }
        if (!isEmpty()){
            string = string.substring(0, string.length()-2);
        }
        string = string + "]";
        return string;
    }
}
