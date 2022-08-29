public class Node {
    Integer key;
    Character value;
    Node parent;
    Node left;
    Node right;

    public Node(Integer key, Character value) {
        this.key = key;
        this.value = value;
        this.parent = null;
        this.left = null;
        this.right = null;
    }
}