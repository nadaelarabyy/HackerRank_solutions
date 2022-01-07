package data_structures.trees;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;


public class Solution {
	Solution left;
    Solution right;
    int data;
    Solution parent;
    int level;
    
	Solution(int data) {
        this.data = data;
        left = null;
        right = null;
    }
	
	
	@Override
	public String toString() {
		return "Solution [left=" + left + ", right=" + right + ", data=" + data + ", parent=" + parent + ", level="
				+ level + "]";
	}


	public static void transform(Node root,Solution root2) {
		if(root == null)
			return;
		// for root
		if(root.left!=null) {
			root2.left = new Solution(root.left.data);
			root2.left.parent = root2;
			root2.left.level = root2.level+1;
			root2.left.data = root.left.data;
		}
		if(root.right!=null) {
			root2.right = new Solution(root.right.data);
			root2.right.parent = root2;
			root2.right.level = root2.level+1;
			root2.right.data = root.right.data;
		}
		
		transform(root.left,root2.left);
		transform(root.right,root2.right);
	}
	public static Solution lcaHelper(Solution left,Solution right) {
		if(right.parent!=null && left.data == right.parent.data)
			return left;
		if(left.parent!=null && right.data == left.parent.data)
			return right;
		if(left.parent.data == right.parent.data)
			return left.parent;
		if(left.parent.level > right.parent.level)
			return lcaHelper(left.parent, right);
		return lcaHelper(left, right.parent);
		
	}
	public static Node lca(Node root, int v1, int v2) {
		Solution root2 = new Solution(root.data);
		transform(root,root2); // transform node that has a reference to a parent
		Solution left = null, right = null;
		Queue<Solution> nodes = new LinkedList<Solution>();
		nodes.add(root2);
		while(!nodes.isEmpty()) {
			Solution node = nodes.poll();
			if(node.data == v1)
				left = node;
			if(node.data == v2)
				right = node;
			if(node.left!=null) nodes.add(node.left);
			if(node.right!=null) nodes.add(node.right);
		}
		if(v1 == root.data || v2 == root.data)
			return root;
		Solution out1 =lcaHelper(left,right); 
		Node out = new Node(out1.data);
		return out;
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
      	int v1 = scan.nextInt();
      	int v2 = scan.nextInt();
        scan.close();
        Node ans = lca(root,v1,v2);
        System.out.println(ans.data);
    }

}
