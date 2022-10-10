
/**
 * Base class for node
 *
 * @param <K, T> data type
 */
public class Node<K extends Comparable<K>, T>
{
	Color color;			// Node color
	K key;					// Node key
	T data;					// Node associated data
	Node<K, T> parent; 		// Parent node
	Node<K, T> left, right; 	// Children nodes

	public Node(K key, T data)
	{
		this.key  	= key;
		this.data  	= data;
		this.color = Color.RED; //property 3 (if a node is read, both children are black) may be violated if parent is red
		this.parent = null;

		// Initialise children leaf nodes
		this.left 			= new Node<K, T>();  //leaf node
		this.right 			= new Node<K, T>();  //leaf node
		this.left.parent 	= this; //reference to parent
		this.right.parent 	= this; //reference to parent
	}

	// Leaf node
	public Node() 
	{
		this.key 	= null; //leaf nodes are null
		this.data 	= null; //leaf nodes are null
		this.color = Color.BLACK; //leaf nodes are always black
	}

	public K getKey() {
		return key;
	}

	public T getData() {
		return data;
	}
}