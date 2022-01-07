package data_structures.trees;


import java.util.*;



class Tree_Traversal {
	public static void printLevel(Node root, int level,List<Integer> out) {
		if(root == null)
			return;
		if(level == 0) 
			out.add(root.data);
		else{
			level -= 1;
			printLevel(root.left, level,out);
			printLevel(root.right, level,out);

		}
	}



	public static void printCurrentLeve(Node root, int level) {
		if(root == null)
			return;
		if(level == 0)
			System.out.print(root.data + " ");
		printCurrentLeve(root.left, level - 1);
		printCurrentLeve(root.right, level - 1);
	}
	public static void levelOrder(Node root) {
		int height = height(root);
		for(int i=0;height>=i;i++)
			printCurrentLeve(root, i);
		
	}
	public static int height(Node root) {
		if(root == null)
			return -1;
		return 1 + Math.max(height(root.left), height(root.right)); 
    }
	
	
	public static void topView(Node root) {
		class NodeVariant{
			
			int hd;
			Node node;
			NodeVariant(int hd, Node node) {
				this.hd = hd;
				this.node = node;
			}
			
		}
		Queue<NodeVariant> queue = new LinkedList<NodeVariant>();
		Map<Integer,Node> map = new HashMap<Integer, Node>();
		queue.add(new NodeVariant(0, root));
		while(!queue.isEmpty()) {
			NodeVariant nv = queue.poll();
			if(!map.containsKey(nv.hd))
				map.put(nv.hd, nv.node);
			if(nv.node.left != null) 
				queue.add(new NodeVariant(nv.hd-1, nv.node.left));
		
			if(nv.node.right != null) 
				queue.add(new NodeVariant(nv.hd+1, nv.node.right));
			
		}
		for(int key:new TreeSet<Integer>(map.keySet()))
			System.out.print(map.get(key).data+" ");
		
	}
	

    public static void preOrder(Node root) {
    	// root, left, right
    	System.out.print(root.data+" ");
    	if(root.left != null)
    		preOrder(root.left);
    	if(root.right != null)
    		preOrder(root.right);
    	
    	

    }
    public static void inOrder(Node root) {
    	if(root.left !=null )
    		inOrder(root.left);
    	System.out.print(root.data+" ");
    	if(root.right != null)
    		inOrder(root.right);
    }
    
    public static void postOrder(Node root) {
    	// left, right, root
    	if(root.left != null)
    		postOrder(root.left);
    	if(root.right != null)
    		postOrder(root.right);
    	System.out.print(root.data+" ");
    	
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
        topView(root);

    }	
}
