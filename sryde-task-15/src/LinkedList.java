import java.util.EmptyStackException;
import java.util.NoSuchElementException;

/**
 * A singly linked list.
 * 
 * @author Sara Rydell
 * @version 2023-01-26
 */
public class LinkedList<T> implements Stack<T> { 
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
        this.first = null;
        this.last = null;
        this.size = 0;
    }

    /**
     * Inserts the given element at the beginning of this list.
     *
     * @param element An element to insert into the list.
     */
    public void addFirst(T element) {
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
        this.size++;
    }

    /**
     * Inserts the given element at the end of this list.
     *
     * @param element An element to insert into the list.
     */
    public void addLast(T element) {
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
        while (this.size() > 0){
            this.removeFirst();
        }
        if (this.size == 0){
            this.last = null;
        }
    }

    /**
     * @return The number of elements in the list.
     */
    @Override // Added for task-15
    public int size() {
        int size = 0;
        ListElement<T> object = first;
        while (object != null) {
            object = object.next;
            size++;
        }
        return size;
    }

    /**
     * Note that by definition, the list is empty if both first and last
     * are null, regardless of what value the size field holds (it should
     * be 0, otherwise something is wrong).
     * @return <code>true</code> if this list contains no elements.
     */
    @Override // Added for task-15
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

    // Down below is the new code for interface methods for task-15

    @Override
    public void push(T elem) {
        addFirst(elem);
    }

    @Override
    public T pop() {
        if (isEmpty()){
            throw new EmptyStackException();
        }
        T top = removeFirst();
        return top;
    }

    @Override
    public T top() {
        if (isEmpty()){
            throw new EmptyStackException();
        }
        return getFirst();
    }
}