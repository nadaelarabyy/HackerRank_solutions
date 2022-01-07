package data_structures.trees;

public class Node {
	Node left;
    Node right;
    int data;
    
    @Override
	public String toString() {
		return "Node ["+ "data=" + data 
				+ "]";
	}

	public Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }

}
