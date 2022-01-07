package data_structures.trees;

import java.util.Scanner;

public class Binary_search_tree {
	static boolean checkBST(Node root) {
		if(root.left != null && root.left.data>root.data)
			return checkBST(root.left) && false;
		if(root.right != null && root.right.data<=root.data)
			return checkBST(root.right) && false;
		return true;
	}

	public static Node insert(Node root, int data) {
        if(root == null) {
            return new Node(data);
        } else {
            Node cur;
            if(data <= root.data) {
                cur = insert(root.left, data);
                root.left = cur;
            } else {
                cur = insert(root.right, data);
                root.right = cur;
            }
            return root;
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        Node root = null;
        while(t-- > 0) {
            int data = scan.nextInt();
            root = insert(root, data);
        }
        scan.close();
        System.out.println(checkBST(root)?"Yes":"No");

    }

}
