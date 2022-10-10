import parcel.Parcel;

import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * The following interface defines required methods of any Tree.
 * Note that this is simplified (no delete).
 *
 * @param <T> the generic type this Tree uses. It extends comparable
 *            which allows us to order two of the same type.
 */
public abstract class Tree<T extends Comparable<T>> {
    /**
     * Here we store our class fields.
     */
    public final T value;       // element stored in this node of the tree.
    public Tree<T> leftNode;    // less than the node.
    public Tree<T> rightNode;   // greater than the node.

    /**
     * Constructor to allow for empty trees
     */
    public Tree() {
        value = null;
    }

    /**
     * Constructor for creating a new child node.
     * Note that the left and right nodes must be set by the subclass.
     *
     * @param value to set as this node's value.
     */
    public Tree(T value) {
        // Ensure input is not null.
        if (value == null)
            throw new IllegalArgumentException("Input cannot be null");

        this.value = value;
    }

    /**
     * Constructor for creating a new node.
     * Note that this is what allows our implementation to be immutable.
     *
     * @param value     to set as this node's value.
     * @param leftNode  left child of current node.
     * @param rightNode right child of current node.
     */
    public Tree(T value, Tree<T> leftNode, Tree<T> rightNode) {
        // Ensure inputs are not null.
        if (value == null || leftNode == null || rightNode == null)
            throw new IllegalArgumentException("Inputs cannot be null");

        this.value = value;
        this.leftNode = leftNode;
        this.rightNode = rightNode;
    }



    public abstract T min();                     // Finds the minimum.

    public abstract T max();                     // Finds the maximum.

    public abstract Tree<T> find(T element);     // Finds the element and returns the node.

    public abstract Tree<T> insert(T element);   // Inserts the element and returns a new instance of itself with the new node.

    /**
     *
     * @param elements list of elements to add
     * @return tree with elements added
     */
    public Tree<T> insertAll(List<T> elements) {
        Tree<T> buildTree = this;
        for (T element : elements) {
            buildTree = buildTree.insert(element);
        }
        return buildTree;
    }

    /**
     * Height of current node.
     * @return The maximum height of either children.
     */
    public int getHeight() {
        // Check whether leftNode or rightNode are EmptyTree
        int leftNodeHeight = leftNode instanceof EmptyTree ? 0 : 1 + leftNode.getHeight();
        int rightNodeHeight = rightNode instanceof EmptyTree ? 0 : 1 + rightNode.getHeight();
        return Math.max(leftNodeHeight, rightNodeHeight);
    }

    @Override
    public String toString() {
        return "{" +
                "value=" + value +
                ", leftNode=" + leftNode +
                ", rightNode=" + rightNode +
                '}';
    }

    /**
     * Graphically visualises the tree for human readability.
     * Feel free to edit this display methods
     *
     * @return graph of the tree.
     */
    public String display() {
        return display(0);
    }

    /**
     * Graphically visualises the tree for human readability.
     * Feel free to edit this display methods
     *
     * @param tabs from the left side of the screen.
     * @return graph of the tree.
     */
    public String display(int tabs) {
        // StringBuilder is faster than using string concatenation (which in java makes a new object per concatenation).
        assert value != null;
        StringBuilder sb = new StringBuilder(value.toString());
        StringBuilder tb = new StringBuilder();
        for (int i =0; i<tabs; i++) {
            tb.append("\t");
        }
        sb.append("\n").append(tb).append("├─").append(leftNode.display(tabs + 1));
        sb.append("\n").append(tb).append("├─").append(rightNode.display(tabs + 1));
        return sb.toString();
    }

    /**
     * List the elements of the tree with in-order
     */
    public List<T> inOrder() {
        return this.treeToListInOrder(this);
    }

    /**
     * Converts tree to list in-order. Helper method of inOrder.
     * @param tree to convert to list.
     * @return in-order list of tree values.
     */
    private List<T> treeToListInOrder(Tree<T> tree) {
        List<T> list = new LinkedList<>();

        // Recurse through left subtree.
        if (tree.leftNode.value != null) {
            list.addAll(treeToListInOrder(tree.leftNode));
        }

        // Add current node's value
        list.add(tree.value);

        // Recurse through left subtree.
        if (tree.rightNode.value != null) {
            list.addAll(treeToListInOrder(tree.rightNode));
        }

        return list;
    }

    /**
     *
     * @return true if the tree is empty, false if not
     */
    public abstract boolean isEmpty();



}
