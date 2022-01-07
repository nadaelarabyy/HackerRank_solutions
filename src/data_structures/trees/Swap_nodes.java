package data_structures.trees;


import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.toList;

class TreeNode{
	int data;
	TreeNode left;
	TreeNode right;
	public TreeNode(int data) {
		// TODO Auto-generated constructor stub
		this.data = data;
		this.left = null;
		this.right = null;
	}
	@Override
	public String toString() {
		return "TreeNode [data=" + data + ", left=" + left + ", right=" + right + "]";
	}
	
}
class Result {
	public static void swapNodes(int level,TreeNode root) {
		if(root == null) return;
		if(level == 1) {
			TreeNode tmp = root.left;
			root.left = root.right;
			root.right = tmp;	
		}
		swapNodes(level - 1, root.left);
		swapNodes(level - 1, root.right);
		
	}
	public static void generateLevels(int level, int d,TreeNode root){
		int t = level;
		while(d>=level) {
			swapNodes(level, root);
			level+=t;	
		}
	}
	public static void generateTree(Queue<List<Integer>> queue, TreeNode root, int level) {
		if(root == null) return;
		if(level == 0)
		{
			List<Integer> head = queue.poll();
			TreeNode left = head.get(0) == -1 ? null:new TreeNode(head.get(0));
			TreeNode right = head.get(1) == -1 ? null:new TreeNode(head.get(1));
			root.left = left;
			root.right = right;
			return;
		}
		generateTree(queue, root.left, level - 1);
		generateTree(queue, root.right, level - 1);
	}
	public static void inOrder(TreeNode root) {
		if(root == null)
			return;
		inOrder(root.left);
		System.out.print(root.data+" ");
		inOrder(root.right);
	}
    public static void swapNodes(List<List<Integer>> indexes, List<Integer> queries) {
    	TreeNode root = new TreeNode(1);
    	Queue<List<Integer>> queue = new LinkedList<List<Integer>>();
    	for(List<Integer> list : indexes)
    		queue.add(list);
    	int level = 0;
    	while(!queue.isEmpty()) {
    		generateTree(queue, root, level);
    		level++;
    	}
    	for(int query:queries) {
    		generateLevels(query, level, root);
    		inOrder(root);
    		System.out.println();
    	}
    	
    }

}

public class Swap_nodes {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<List<Integer>> indexes = new ArrayList<>();

        IntStream.range(0, n).forEach(i -> {
            try {
                indexes.add(
                    Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                        .map(Integer::parseInt)
                        .collect(toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        int queriesCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> queries = IntStream.range(0, queriesCount).mapToObj(i -> {
            try {
                return bufferedReader.readLine().replaceAll("\\s+$", "");
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        })
            .map(String::trim)
            .map(Integer::parseInt)
            .collect(toList());
        
        Result.swapNodes(indexes, queries);

    
        bufferedReader.close();
    }
}
