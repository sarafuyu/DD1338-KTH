//import java.util.*;
//import javax.swing.plaf.RootPaneUI;

/**
 * A binary tree.
 * 
 * @author Sara Rydell
 * @version 2023-02-16
 */
public class Tree<T extends Comparable<T>> {
    private Tree<T> root;   // The root element in the tree
    private int size;       // Number of elements in the tree

    public T data;          // Element's data
    public Tree<T> left;    // Element to the left in the tree
    public Tree<T> right;   // Element to the right in the tree

    /**
     * Creates a new Tree object
     * @param data
     */
    public Tree() {
        this.data = null;
        this.left = null;
        this.right = null;
    }

    /**
     * Test for presence of a value. 
     * Should be implemented iteratively!
     * @param elem the value to search for
     * @return true if the value is in the tree, false otherwise
     */
    public boolean search(T elem) {
        Tree<T> current = this.root; 
        while (current != null) {
            int compare = elem.compareTo(current.data);
            if (compare < 0) {
                current = current.left;
            }
            else if (compare > 0) {
                current = current.right;
            }
            else {
                return true;
            }
        }
        return false;
    }

    /**
     * Add value to tree; duplicates are not allowed. 
     * Return true if the element is not already present (and is thus inserted), false otherwise.
     * Should be implemented iteratively!
     * @param elem the value to add to the tree
     * @return true if the value was inserted, false otherwise
     */
    public boolean insert(T elem) {
        if (this.root == null) {
            this.root = new Tree<>();
            this.root.data = elem;
            this.size = 1;
            return true;
        }
        Tree<T> current = this.root;
        Tree<T> parent = null;
        while (current != null) {
            parent = current;
            int compare = elem.compareTo(current.data);
            if (compare < 0) {
                current = current.left;
            }
            else if (compare > 0) {
                current = current.right;
            }
            else {
                return false;
            }
        }
        Tree<T> newNode = new Tree<>();
        newNode.data = elem;
        if (elem.compareTo(parent.data) < 0) {
            parent.left = newNode;
        }
        else {
            parent.right = newNode;
        }
        this.size++;
        return true;
    }

    /**
     * The number of elements in the tree.
     * Should be implemented to run in O(1) time.
     * @return
     */
    public int size() {
        return this.size;
    }

    /**
     * The height of the tree. The empty tree and the tree with only the root node both have height 0.
     * Should be implemented recursively!
     * The height of the empty tree is often undefined, but we decide that it is 0 (because we need it to be something). 
     * Another common choice is -1, to differentiate between the empty tree and the root-only tree.
     * @return
     */
    public int height() {
        if (this.root == null) {
            return 0;
        }
        else if (root.left == null && root.right == null) {
            return 0;
        }
        return Math.max(height(root.left), height(root.right));
    }

    /**
     * Helper method to call the function height() recursively
     * @param current
     * @return
     */
    private int height(Tree<T> current) {
        if (current == null) {
            return 0;
        }
        return Math.max(height(current.left), height(current.right)) + 1;
    }

    /**
     * The number of leaves in the tree.
     * Should be implemented recursively!
     * @return
     */
    public int leaves() {
        if (root == null) {
            return 0;
        }
        return leaves(root);
    }

    /**
     * Helper method to call the function leaves() recursively
     * @param current
     * @return
     */
    private int leaves(Tree<T> current) {
        int result = 0;
        if (current.left == null && current.right == null) {
            result = 1;
        }
        else {
            if (current.left != null) {
                result += leaves(current.left);
            }
            if (current.right != null) {
                result += leaves(current.right);
            }
        }
        return result;
    }

    /**
     * A string describing the tree.
     * Should be implemented recursively!
     * The string should represent the tree in ascending order, like a sorted list. E.g, a tree with elements 1, 54 and -3 should be represented as [-3, 1, 54].
     * Choose the most appropriate traversal technique out of in-, pre- and post-order.
     */
    public String toString() {
        if (root == null) {
            String empty = "[]";
            return empty;
        }
        if (root.left == null && root.right == null) {
            String oneElem = "[" + root.data + "]";
            return oneElem;
        }
        return "[" + orderedString(root) + "]";
    }

    /**
     * Helper method to call the function toString() recursively
     * @param current
     * @return
     */
    private String orderedString(Tree<T> current) {
        String str = "";
        if (current != null) {
            str += orderedString(current.left);
            str += current.data;
            if (current.left == null || current.right != null) {
                str += ", ";
            }
            str += orderedString(current.right);
        }
        return str;
    }
}