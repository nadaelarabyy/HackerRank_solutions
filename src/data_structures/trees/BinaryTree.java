package data_structures.trees;

import java.util.*;


class BinaryTree {
   
  	public static void preOrder( Node root ) {
      
    	if( root == null)
        	return;
      
        System.out.print(root.data + " ");
        preOrder(root.left);
        preOrder(root.right);
     
    }

	public static Node insert(Node root,int data) {
		if(root == null)
			return new Node(data);
		if(root.data >= data && root.left == null) {
			Node node = new Node(data);
			root.left = node;
			return root;
		}
		else if(root.data >= data && root.left != null) 
			insert(root.left, data);
		
		else if(root.data < data && root.right == null){
			Node node = new Node(data);
			root.right = node;
			return root;
		}
		else
			insert(root.right, data);
		return root;
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
      	preOrder(root);
    }	
}