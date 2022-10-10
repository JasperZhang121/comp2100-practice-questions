import java.util.List;

/**
 * Our Parcel trees will 'extend'
 * this Binary Search tree data structure.
 */
public class BinarySearchTree<T extends Comparable<T>> extends Tree<T> {

    public BinarySearchTree(T value) {
        super(value);
        this.leftNode = new EmptyBST<>();
        this.rightNode = new EmptyBST<>();
    }

    public BinarySearchTree(T value, Tree<T> leftNode, Tree<T> rightNode) {
        super(value, leftNode, rightNode);
    }



    @Override
    public T min() {
        return (leftNode instanceof EmptyTree) ? value : leftNode.min();
    }

    @Override
    public T max() {
        return (rightNode instanceof EmptyTree) ? value : rightNode.max();
    }

    @Override
    public Tree<T> find(T element) {
        /*
            Left is less, right is greater in this implementation.
            compareTo returns 0 if both elements are equal.
            compareTo returns < 0 if the element is less than the node.
            compareTo returns > 0 if the element is greater than the node.
         */

        // Ensure input is not null.
        if (element == null)
            throw new IllegalArgumentException("Input cannot be null");

        if (element.compareTo(value) == 0) {
            return this;
        } else if (element.compareTo(value) < 0) {
            return leftNode.find(element);
        } else {
            return rightNode.find(element);
        }
    }

    @Override
    public BinarySearchTree<T> insert(T element) {
        // Ensure input is not null.
        if (element == null)
            throw new IllegalArgumentException("Input cannot be null");

        // If the two values are equal, in this implementation we want to insert to the left.
        if (element.compareTo(value) > 0) {
            return new BinarySearchTree<>(value, leftNode, rightNode.insert(element));
        } else {
            return new BinarySearchTree<>(value, leftNode.insert(element), rightNode);
        }
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    /**
     * Note that this is not within a file of its own... WHY?
     * The answer is: this is just a design decision. 'insert' here will return something specific
     * to the parent class inheriting Tree. In this case a BinarySearchTree.
     */
    public static class EmptyBST<T extends Comparable<T>> extends EmptyTree<T> {
        @Override
        public Tree<T> insert(T element) {
            // The creation of a new Tree, hence, return tree.
            return new BinarySearchTree<T>(element);
        }

        @Override
        public boolean isEmpty() {
            return true;
        }
    }

    /**
     * Creates a Binary search tree from a list.
     * @param elements to convert to Binary search tree
     * @param <U> type of values that the Binary search tree holds
     * @return tree that contains all elements in list inserted
     */
    public static <U extends Comparable<U>> Tree<U> listToTree(List<U> elements) {
        if (elements.size() > 0) {
            BinarySearchTree<U> binarySearchTree = new BinarySearchTree<U>(elements.get(0));
            binarySearchTree = (BinarySearchTree<U>) binarySearchTree.insertAll(elements.subList(1,elements.size()));
            return binarySearchTree;
        } else {
            return new EmptyBST<>();
        }
    }

    /**
     * Creates a Binary search tree from a list without using the insert method. Please don't modify this method!
     * @param elements to convert to Binary search tree
     * @return tree that contains the list in order that is balanced (left.height >= right.height)
     */
    public static <U extends Comparable<U>> Tree<U> listToTreeDirectInOrder(List<U> elements) {
        if (elements.size() > 1) {
            int median = elements.size() / 2;
            Tree<U> leftTree = listToTreeDirectInOrder(elements.subList(0,median));
            Tree<U> rightTree = listToTreeDirectInOrder(elements.subList(median+1,elements.size()));
            return new BinarySearchTree<U>(elements.get(median),leftTree,rightTree);
        }
        else if (elements.size() == 1) {
            return new BinarySearchTree<>(elements.get(0));
        } else {
            return new EmptyBST<U>();
        }
    }
}
