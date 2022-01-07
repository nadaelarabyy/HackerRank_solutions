package data_structures.linkedlists;
import java.io.*;
import java.util.*;

public class InsertNodeAtHead {
	  private static class SinglyLinkedListNode {
	        public int data;
	        public SinglyLinkedListNode next;

	        public SinglyLinkedListNode(int nodeData) {
	            this.data = nodeData;
	            this.next = null;
	        }
	    }

	    private static class SinglyLinkedList {
	        public SinglyLinkedListNode head;
	        @SuppressWarnings("unused")
			public SinglyLinkedListNode tail;

	        public SinglyLinkedList() {
	            this.head = null;
	            this.tail = null;
	        }

	      
	    }

	    public static void printSinglyLinkedList(SinglyLinkedListNode node, String sep, StringBuilder sb) throws IOException {
	        while (node != null) {
	            sb.append(String.valueOf(node.data));

	            node = node.next;

	            if (node != null) {
	                sb.append(sep);
	            }
	        }
	    }


	    static SinglyLinkedListNode insertNodeAtHead(SinglyLinkedListNode llist, int data) {
	    	SinglyLinkedListNode node = new SinglyLinkedListNode(data);
	    	if(llist == null)
	    		return node;
	    	node.next = llist;
			return node;


	    }

	    private static final Scanner scanner = new Scanner(System.in);

	    public static void main(String[] args) throws IOException {
	        StringBuilder sb = new StringBuilder();

	        SinglyLinkedList llist = new SinglyLinkedList();

	        int llistCount = scanner.nextInt();
	        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

	        for (int i = 0; i < llistCount; i++) {
	            int llistItem = scanner.nextInt();
	            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
	        	
	          SinglyLinkedListNode llist_head = insertNodeAtHead(llist.head, llistItem);

	          llist.head = llist_head;
	        }



	        printSinglyLinkedList(llist.head, "\n", sb);
	        sb.append("\n");

	        System.out.println(sb.toString());

	        scanner.close();
	    }

}
