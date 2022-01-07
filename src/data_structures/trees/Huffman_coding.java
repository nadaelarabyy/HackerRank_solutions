package data_structures.trees;
import java.util.*;

abstract class Nodee implements Comparable<Nodee> {
    public  int frequency; // the frequency of this tree
    public  char data;
    public  Nodee left, right; 
    public Nodee(int freq) { 
      frequency = freq; 
    }
 
    // compares on the frequency
    public int compareTo(Nodee tree) {
        return frequency - tree.frequency;
    }

	@Override
	public String toString() {
		return "Nodee [frequency=" + frequency + ", data=" + data + ", left=" + left + "\n, right=" + right + "]";
	}
    
}
 
class HuffmanLeaf extends Nodee {
    
 
    public HuffmanLeaf(int freq, char val) {
        super(freq);
        data = val;
    }
}
 
class HuffmanNode extends Nodee {
    
    public HuffmanNode(Nodee l, Nodee r) {
        super(l.frequency + r.frequency);
        left = l;
        right = r;
    }

}


class Decoding {

/*  
	class Nodee
		public  int frequency; // the frequency of this tree
    	public  char data;
    	public  Nodee left, right;
    
*/ 
	String decodeHelper(String s, Nodee root, int i) {
		if(root == null)
			return "";
		if(root.left == null && root.right == null)
			return root.data + ","+i;
		if(s.charAt(i) == '0')
			return decodeHelper(s, root.left, i+1);
		return decodeHelper(s, root.right, i+1);
			
	}
	void decode(String s, Nodee root) {
		int i=0;
		while(s.length()>i) {
			String[] split = decodeHelper(s, root, i).split(",");
			System.out.print(split[0]);
			i = Integer.parseInt(split[1]);			
		}
       
    }



}

 
public class Huffman_coding {
  
    // input is an array of frequencies, indexed by character code
    public static Nodee buildTree(int[] charFreqs) {
      
        PriorityQueue<Nodee> trees = new PriorityQueue<Nodee>();
        // initially, we have a forest of leaves
        // one for each non-empty character
        for (int i = 0; i < charFreqs.length; i++)
            if (charFreqs[i] > 0)
                trees.offer(new HuffmanLeaf(charFreqs[i], (char)i));
 
        assert trees.size() > 0;
      
        // loop until there is only one tree left
        while (trees.size() > 1) {
            // two trees with least frequency
            Nodee a = trees.poll();
            Nodee b = trees.poll();
 
            // put into new node and re-insert into queue
            trees.offer(new HuffmanNode(a, b));
        }
      
        return trees.poll();
    }
  
    public static Map<Character,String> mapA=new HashMap<Character ,String>();
  
    public static void printCodes(Nodee tree, StringBuffer prefix) {
      
        assert tree != null;
      
        if (tree instanceof HuffmanLeaf) {
            HuffmanLeaf leaf = (HuffmanLeaf)tree;
 
            // print out character, frequency, and code for this leaf (which is just the prefix)
            //System.out.println(leaf.data + "\t" + leaf.frequency + "\t" + prefix);
            mapA.put(leaf.data,prefix.toString());

        } else if (tree instanceof HuffmanNode) {
            HuffmanNode node = (HuffmanNode)tree;
 
            // traverse left
            prefix.append('0');
            printCodes(node.left, prefix);
            prefix.deleteCharAt(prefix.length()-1);
 
            // traverse right
            prefix.append('1');
            printCodes(node.right, prefix);
            prefix.deleteCharAt(prefix.length()-1);
        }
    }
 
    public static void main(String[] args) {
        @SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
    
        String test= input.next();
 
        // we will assume that all our characters will have
        // code less than 256, for simplicity
        int[] charFreqs = new int[256];
      
        // read each character and record the frequencies
        for (char c : test.toCharArray())
            charFreqs[c]++;
 
        // build tree
        Nodee tree = buildTree(charFreqs);
 
        // print out results
        printCodes(tree, new StringBuffer());
        StringBuffer s = new StringBuffer();
      
        for(int i = 0; i < test.length(); i++) {
          	char c = test.charAt(i);
            s.append(mapA.get(c));
        }
      
        Decoding d = new Decoding();
        d.decode(s.toString(), tree);

    }
}