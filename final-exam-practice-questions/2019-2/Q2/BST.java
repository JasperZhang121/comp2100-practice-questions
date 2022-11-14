/** This class is a part of {@code package tree}. Do not change the package structure.
 * Make sure that your IDE do not change it to for example {@code package src.tree}.
 * If it happens, please revert it once you finish the implementation.
 */
package tree;

import java.security.PublicKey;
import java.util.ArrayList;

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

/*		// start your code
		return find_helper(root,value);
		// end your code*/

		var res = false;
		if (root==null)return false;
		if (root.value==value)return true;
		if (root.left!=null){
			BST bst = new BST();
			bst.root=root.left;
			res = bst.find(value);
		}
		if (root.right!=null){
			BST bst = new BST();
			bst.root=root.right;
			res = res || bst.find(value);
		}
		return res;
	}

	public Boolean find_helper(Node node, int value){
		if (node==null)return false;
		if (node.value==value)return true;
		var res = false;
		if (value>node.value){
			res = res || find_helper(node.right,value);
		}
		if (value<node.value){
			res = res || find_helper(node.left,value);
		}
		return res;
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
		root = delete_helper(value);
		// end your code
	}

	public Node delete_helper(int value){
		if (root==null)return root;
		if (value< root.value){
			BST bst = new BST();
			bst.root = root.left;
			root.left = bst.delete_helper(value);
		}
		else if (value> root.value){
			BST bst = new BST();
			bst.root = root.right;
			root.right = bst.delete_helper(value);
		}
		else {
			if (root.left==null) return root.right;
			else if (root.right==null) return root.left;
			root.value = minValue(root.right);
			BST bst = new BST();
			bst.root = root.right;
			root.right = bst.delete_helper(root.value);
		}
		return root;
	}

	int minValue(Node root)
	{
		int minv = root.value;
		while (root.left != null)
		{
			minv = root.left.value;
			root = root.left;
		}
		return minv;
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

		/*var lis = new ArrayList<Node>();
		sumEvenHelper(lis);
		var total = 0;
		for (int i = 0; i < lis.size(); i++) {
			total+=lis.get(i).value;
		}
		return total;*/
		var res = 0;
		if (root==null)return 0;
		if ((root.left==null&&root.right==null)||(root.right!=null&&root.left!=null)) res+=root.value;
		if (root.left!=null){
			BST bst = new BST();
			bst.root=root.left;
			res+=bst.sumEvenNodes();
		}
		if (root.right!=null){
			BST bst = new BST();
			bst.root=root.right;
			res+=bst.sumEvenNodes();
		}
		return res;
		//end your code
	}

	public void sumEvenHelper(ArrayList<Node> lis){
		if (root==null)return;
		if ((root.left==null && root.right==null)||(root.left!=null&&root.right!=null)) lis.add(root);

		if (root.left!=null){
			BST bst =new BST();
			bst.root = root.left;
			bst.sumEvenHelper(lis);
		}
		if (root.right!=null){
			BST bst =new BST();
			bst.root = root.right;
			bst.sumEvenHelper(lis);
		}
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