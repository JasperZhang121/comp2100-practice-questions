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

			/*if (s.compareTo(this.value)<0){
				if (this.left!=null) return this.left.find(s);
				else return null;
			} else if (s.compareTo(this.value)>0){
				if (this.right!=null) return this.right.find(s);
				else return null;
			}*/

			if (this.value.compareTo(s)<0){
				if (this.right!=null)return this.right.find(s);
				else return null;
			}
			if (this.value.compareTo(s)>0){
				if (this.left!=null) return this.left.find(s);
				else return null;
			}
			if (root.value.equals(s)) return root;

			// TODO: Add your implementation here.
	        return this;
	    }


		/**
		 * Insert a new node into the tree
		 * @param s
		 * @return {@link Node}
		 */
		public Node insert(String s) {

			/*Node insertNode = new Node(s);
			if (this==null)return insertNode;
			if (s.compareTo(this.value)>0){
				if (this.right!=null){
					this.right = this.right.insert(s);
				} else {
					this.right = insertNode;
				}
			}
			else{
				if (this.left!=null){
					this.left = this.left.insert(s);
				}else {
					this.left=insertNode;
				}
			}*/

			if (this.value.compareTo(s)<0){
				if (this.right!=null)this.right.insert(s);
				else this.right= new Node(s);
			}
			if (this.value.compareTo(s)>0){
				if (this.left!=null)this.left.insert(s);
				else this.left= new Node(s);
			}

			// TODO: Add your implementation here.
			return this;
		}
		
		/**
		 * @return pre-order traversal of the nodes that have odd number of children.
		 */
		public String printOddNodes() {
			/*preTra(this);
			// TODO: Add your implementation here.
			return global_odd_nodes;*/

			var s = "";
			if ((this.left==null && this.right!=null) || (this.left!=null && this.right==null)) s = this.value + " ";
			if (this.left!=null){
				s += this.left.printOddNodes();
			}
			if (this.right!=null){
				s += this.right.printOddNodes();
			}
			return s;
		}

		String global_odd_nodes = "";
		public void preTra(Node node){
			if (node==null) return;
			if (node.left!=null){
				if (node.right==null) global_odd_nodes+=" "+node.value;
				preTra(node.left);
			}
			if (node.right!=null){
				if (node.left==null) global_odd_nodes+=" "+ node.value;
				preTra(node.right);
			}
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