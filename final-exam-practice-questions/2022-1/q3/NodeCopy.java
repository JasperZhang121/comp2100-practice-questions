/**
 * This is a shallow copy of the node in the BST
 */
public class NodeCopy {

	public String key;
	public int value;
	
	public NodeCopy(String key, int value) {
		this.key = key;
		this.value = value;
	}
	
	public NodeCopy(Node node) {
		this.key = node.key;
		this.value = node.value;
	}
	
	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}

		NodeCopy n = (NodeCopy) o;
		if (n.value != this.value) {
			return false;
		}

		if (n.key == null) {
			if (this.key != null) {
				return false;
			}
		} else {
			return n.key.equals(this.key);
		}

		return true;
	}
	
	@Override
	public String toString() {
		return this.key + " " + this.value;
	}
}
