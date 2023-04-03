public interface Stack<T> {
    /**
     * Adds the element to the top of the stack. 
     */
    void push(T elem);

    /**
     * Removes and returns the top element in the stack, that is the element that was last added to the stack. 
     * Throws an EmptyStackException (you need to import this, see the docs!) if the stack is empty!
     */
    T pop();

    /**
     * Returns the top element in the stack without removing it. 
     * Throws an EmptyStackException (you need to import this, see the docs!) if the stack is empty!
     */
    T top();

    /**
     * Returns the number of elements in the stack.
     */
    int size();

    /**
     * Returns true if the stack is empty.
     */
    boolean isEmpty();
}