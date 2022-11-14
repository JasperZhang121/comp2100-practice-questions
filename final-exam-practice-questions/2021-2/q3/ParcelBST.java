import parcel.Parcel;

import java.util.*;

public class ParcelBST extends BinarySearchTree<Parcel> implements Iterable<Parcel>  {

    public ParcelBST(Parcel value, ParcelBST leftNode, ParcelBST rightNode) {
        super(value, leftNode, rightNode);
    }

    public ParcelBST(BinarySearchTree<Parcel> parcelBST) {
        super(parcelBST.value,parcelBST.leftNode,parcelBST.rightNode);
    }

    public ParcelBST(Tree<Parcel> parcelTree) {
        super(parcelTree.value,parcelTree.leftNode,parcelTree.rightNode);
    }

    public ParcelBST(Parcel value) {
        super(value);
    }


    @Override
    public Iterator<Parcel> iterator() {
        return new IteratorPreOrder();
    }

    class IteratorPreOrder implements Iterator<Parcel> {
        // Hint: value, left/right sub-trees can be accessed by:
        //    ParcelBST.this.value    ParcelBST.this.leftNode   ParcelBST.this.rightNode
        // Or equivalently directly:
        //    value   leftNode    rightNode


        // You may add methods and variables here if you wish

        Deque<Tree> stack;

        public IteratorPreOrder() {
            // You may add code here if you wish
            stack = new ArrayDeque<>();

            stack.push(ParcelBST.this);

        }

        @Override
        public boolean hasNext() {
            // TODO
            // START YOUR CODE
            return !stack.isEmpty();
            // END YOUR CODE
        }
        @Override
        public Parcel next() {
            // TODO
            // START YOUR CODE

            var node = stack.pop();

            if (!node.rightNode.isEmpty()) stack.push(node.rightNode);
            if (!node.leftNode.isEmpty()) stack.push(node.leftNode);

            return (Parcel) node.value;
            // END YOUR CODE
        }
    }
}
