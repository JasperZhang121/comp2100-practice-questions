/**
 * IMPORTANT: This class is incomplete. Please look for "TODO" comments.
 * @author huy.pham
 */
public class BST {	
	Node root;

	/**
	 * Node class
	 */
	public class Node {
		String value;
		Node parent;
		Node left;
		Node right;

		public Node(String value) {
			this.value = value;
			this.parent = null;
			this.left = null;
			this.right = null;
		}

		/**
		 * @param s
		 * @return the node that has the given value.
		 */
	    public Node find(String s) {
			// TODO: Add your implementation here.
	        return this;
	    }

		/**
		 * Insert a new node into the tree
		 * @param s
		 * @return {@link Node}
		 */
		public Node insert(String s) {
			// TODO: Add your implementation here.
			return this;
		}
		
		/**
		 * @return pre-order traversal of the nodes that have odd number of children.
		 */
		public String printOddNodes() {
			// TODO: Add your implementation here.
			return "";
		}
	}

	public String printOddNodes() {
		return root.printOddNodes();
	}
	
	public BST() {
		root = null;
	}

	public Node insert(String value) {
		if (root == null) {
			root = new Node(value);
			return root;
		}

		return root.insert(value);
	}
	
	public Node find(String s) {
		if (root == null) {
			return null;
		}
		
		return root.find(s);
	}
}