
/**
 * Skeleton code for Red Black Tree
 * 
 * @author COMP2100/6442
 * @param <K, T> data type
 */
public class RBTree<K extends Comparable<K>, T> 
{	
	Node<K, T> root; // The root node of the tree

	/**
	 * Initialize empty RBTree
	 */
	public RBTree()
	{
		root = null;
	}

	/**
	 * Add a new node into the tree with {@code root} node.
	 *
	 * @param root Node<K, T> The root node of the tree where x is being inserted.
	 * @param x    Node<K, T> New node being inserted.
	 */
	private void insertRecurse(Node<K, T> root, Node<K, T> x)
	{
		int cmp = root.key.compareTo(x.key);

		if (cmp > 0)
		{
			if (root.left.key == null)
			{
				root.left 	= x;
				x.parent 	= root;
			}
			else
			{
				insertRecurse(root.left, x);
			}
		}
		else if (cmp < 0)
		{
			if (root.right.key == null)
			{
				root.right 	= x;
				x.parent 	= root;
			}
			else
			{
				insertRecurse(root.right, x);
			}
		}
		// Do nothing if the tree already has a node with the same value.
	}

	/**
	 * Insert node into RBTree.
	 *
	 * @param x Node<K, T> The new node being inserted into the tree.
	 */
	private void insert(Node<K, T> x)
	{
		// You need to finish cases 1, 2 and 3; the rest has been done for you
		// Insert node into tree
		if (root == null)
		{
			root = x;
		}
		else
		{
			if(search(x.key) != null)
				return;

			insertRecurse(root, x);
		}

		// Fix tree
		while (x.key != root.key && x.parent.color == Color.RED)
		{
			boolean left  = x.parent == x.parent.parent.left; // Is parent a left node
			Node<K, T> uncle = left ? x.parent.parent.right : x.parent.parent.left; // Get opposite "uncle" node to parent

			if (uncle.color == Color.RED)
			{
				// Case 1: Recolour
				x.parent.color 		= Color.BLACK;
				uncle.color 			= Color.BLACK;
				x.parent.parent.color 	= Color.RED;

				// Check if violated further up the tree
				x = x.parent.parent;
			}
			else
			{
				if (x.key == (left ? x.parent.right.key : x.parent.left.key))
				{
					// Case 2: Left (uncle is left node) / Right (uncle is right node) Rotation
					x = x.parent;
					if (left)
					{
						// Perform left rotation
						if (x.key == root.key)
							root = x.right; // Update root
						rotateLeft(x);
					}
					else
					{
						// This is part of the "then" clause where left and right are swapped
						// Perform right rotation
						if (x.key == root.key)
							root = x.left; // Update root
						rotateRight(x);
					}
				}
				// Adjust colours to ensure correctness after rotation
				x.parent.color 		= Color.BLACK;
				x.parent.parent.color 	= Color.RED;

				// Case 3 : Right (uncle is left node) / Left (uncle is right node) Rotation

				if (left)
				{
					// Perform right rotation
					if (x.parent.parent.key == root.key)
						root = x.parent.parent.left;

					x.parent.color 		= Color.BLACK;
					x.parent.parent.color 	= Color.RED;
					rotateRight(x.parent.parent);
				}
				else
				{
					// This is part of the "then" clause where left and right are swapped
					// Perform left rotation
					if(x.parent.parent.key == root.key)
						root = x.parent.parent.right;

					x.parent.color 		= Color.BLACK;
					x.parent.parent.color 	= Color.RED;
					rotateLeft(x.parent.parent);
				}
			}
		}
		// Ensure property 2 (root and leaves are black) holds
		root.color = Color.BLACK;
	}

    /** Rotate the node so it becomes the child of its right branch
    /*
        e.g.
              [x]                    b
             /   \                 /   \
           a       b     == >   [x]     f
          / \     / \           /  \
         c  d    e   f         a    e
                              / \
                             c   d
    */
	public void rotateLeft(Node<K,T> x)
	{
		// Make parent (if it exists) and right branch point to each other
		if (x.parent != null)
		{
			// Determine whether this node is the left or right child of its parent
			if (x.parent.left.key == x.key)
			{
				x.parent.left = x.right;
			}
			else
			{
				x.parent.right = x.right;
			}
		}
		x.right.parent 	= x.parent;
		x.parent 		= x.right;

		// Take right node's left branch
		x.right 		= x.parent.left;
		x.right.parent 	= x;

		// Take the place of the right node's left branch
		x.parent.left 	= x;
	}

    /** Rotate the node so it becomes the child of its left branch
    /*
        e.g.
              [x]                    a
             /   \                 /   \
           a       b     == >     c     [x]
          / \     / \                   /  \
         c  d    e   f                 d    b
                                           / \
                                          e   f
    */
	public void rotateRight(Node<K, T> x)
	{
		if (x.parent != null)
		{
			// Determine whether this node is the left or right child of its parent
			if (x.parent.left.key == x.key)
			{
				x.parent.left = x.left;
			}
			else
			{
				x.parent.right = x.left;
			}
		}

		x.left.parent 	= x.parent;
		x.parent 		= x.left;

		// Take left node's right branch
		x.left 			= x.parent.right;
		x.left.parent 	= x;

		// Take the place of the left node's right branch
		x.parent.right 	= x;
	}

	/**
	 * Demo functions (Safely) insert a value into the tree
	 *
	 * @param value T The value of the new node being inserted.
	 */
	public void insert(K key, T data)
	{
		Node<K, T> node = new Node<K, T>(key, data);
		if (node != null)
			insert(node);
	}



	/**
	 * Return the corresponding node of a key, if it exists in the tree
	 *
	 * @param n Node<K, T> The root node of the tree we search for the key {@code k}
	 * @param k Node<K, T> The node that we are looking for
	 * @return
	 */
	private Node<K, T> find(Node<K, T> n, K k)
	{
		if (n == null || n.key == null)
			return null;

		int cmp = k.compareTo(n.key);

		if (cmp < 0)
			return find(n.left, k);
		else if (cmp > 0)
			return find(n.right, k);
		else
			return n;
	}

	/**
	 * Returns a node if the value of the node is {@code key}.
	 *
	 * @param key K The key we are looking for
	 * @return
	 */
	public Node<K, T> search(K key)
	{
		return find(root, key);
	}
	
	/**
	 * Returns value of a node with {@code key}.
	 * 
	 * @param key K The key we are looking for
	 * @return
	 */
	public T getData(K key) 
	{
		Node<K, T> f = find(root, key);
		if (f != null)
			return f.data;
		return null;
	}
}