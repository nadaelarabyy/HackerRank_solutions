package data_structures.linkedlists;
import java.io.*;
import java.util.*;

public class InsertNodeAtTail {
	private static class SinglyLinkedListNode {
        @Override
		public String toString() {
			return "SinglyLinkedListNode [data=" + data + ", next=" + next + "]";
		}

		public int data;
        public SinglyLinkedListNode next;

        public SinglyLinkedListNode(int nodeData) {
            this.data = nodeData;
            this.next = null;
        }
    }

    private static class SinglyLinkedList {
        public SinglyLinkedListNode head;

        @Override
		public String toString() {
			return "SinglyLinkedList [head=" + head + "]";
		}

		public SinglyLinkedList() {
            this.head = null;
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

    static SinglyLinkedListNode insertNodeAtTail(SinglyLinkedListNode head, int data) {
    	SinglyLinkedListNode node = new SinglyLinkedListNode(data);
    	if(head == null)
    		return node;
    	
		SinglyLinkedListNode curr = head;
		while(curr.next!=null) {
			curr = curr.next;
		}
		curr.next = node;
		return head;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

        SinglyLinkedList llist = new SinglyLinkedList();
        StringBuilder sb = new StringBuilder();

        int llistCount = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < llistCount; i++) {
            int llistItem = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        	
          SinglyLinkedListNode llist_head = insertNodeAtTail(llist.head, llistItem);

          llist.head = llist_head;
        }
        printSinglyLinkedList(llist.head, "\n", sb);
        sb.append("\n");
        System.out.println(sb.toString());






        scanner.close();
    }

}
