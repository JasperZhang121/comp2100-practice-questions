/** This class is a part of {@code package tree}. Do not change the package structure.
 * Make sure that your IDE do not change it to for example {@code package src.tree}.
 * If it happens, please revert it once you finish the implementation.
 */
package tree;

/**
 * Binary search tree with integer keys (values). {@code insert} method is
 * provided.
 * 
 * @author dongwoo
 *
 */
public class BST {
	Node root;

	/**
	 * Q2 - Task1 TODO: Implement "find" method. The method should return "true" if
	 * a tree contains the node with value, otherwise return "false". You can define
	 * additional functions in class BST or Node if you need.
	 * 
	 * @param value
	 * @return return true if the tree contains the node with value otherwise false
	 */
	public Boolean find(int value) {

		// start your code

		// end your code
	}

	/**
	 * Q2 - Task2 TODO: Implement "delete" method. Find the node with {@code value}
	 * and remove it from the tree. If the target node has two children, use
	 * successor to replace the target node. You can define additional functions in
	 * class BST or Node if you need.
	 * 
	 * Do not care about the case where the target node does not exist.
	 * 
	 * @param value value of the target node
	 */
	public void delete(int value) {

		// start your code

		// end your code
	}

	/**
	 * Q2 - Task3 TODO: Implement "sumEvenNodes" function. The method should return
	 * print the sum of the nodes that have an even number of direct children (zero
	 * is an even number). You can define additional functions in class BST or Node
	 * if you need.
	 * 
	 * @return Sum of the nodes that have an even number of direct children
	 */
	public int sumEvenNodes() {
		//start your code
		
		
		
		//end your code
	}

	public class Node {
		public Integer value;
		public Node parent;
		public Node left;
		public Node right;

		public Node(Integer value) {
			this.value = value;
			this.parent = null;
			this.left = null;
			this.right = null;
		}
	}

	public BST() {
		root = null;
	}

	/**
	 * Insert a new node based on an input value. Do not modify the method.
	 * 
	 * Do not consider the case where a tree already has the node with the same
	 * value.
	 * 
	 * @param value value of inserted node
	 * @return inserted node (not the entire tree)
	 */
	public Node insert(int value) {
		Node parent = null;
		Node current = root;
		while (current != null) {
			if (current.value < value) {
				parent = current;
				current = current.right;
			} else if (current.value > value) {
				parent = current;
				current = current.left;
			}
		}

		if (parent == null && current == null) {
			root = new Node(value); // no parent = root is empty
			return root;
		} else {
			Node newNode = new Node(value);

			if (parent.value < value) {
				parent.right = newNode;
				newNode.parent = parent;
			} else if (parent.value > value) {
				parent.left = newNode;
				newNode.parent = parent;
			}
			return newNode;
		}
	}

}