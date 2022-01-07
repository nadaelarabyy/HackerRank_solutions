package data_structures.linkedlists;

import java.io.*;
import java.util.*;

public class Reverse_linkedlist {

    static class SinglyLinkedListNode {
        public int data;
        public SinglyLinkedListNode next;

        public SinglyLinkedListNode(int nodeData) {
            this.data = nodeData;
            this.next = null;
        }
    }

    static class SinglyLinkedList {
        public SinglyLinkedListNode head;
        public SinglyLinkedListNode tail;

        public SinglyLinkedList() {
            this.head = null;
            this.tail = null;
        }

        public void insertNode(int nodeData) {
            SinglyLinkedListNode node = new SinglyLinkedListNode(nodeData);

            if (this.head == null) {
                this.head = node;
            } else {
                this.tail.next = node;
            }

            this.tail = node;
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


	public static SinglyLinkedListNode reverse(SinglyLinkedListNode llist) {
    	if(llist.next == null)
    		return llist;
    	SinglyLinkedListNode newNode = new SinglyLinkedListNode(llist.data);
    	while(llist.next != null) {
    		llist = llist.next;
    		SinglyLinkedListNode nxt = new SinglyLinkedListNode(llist.data);
    		nxt.next = newNode;
    		newNode = nxt;
    	}
		return newNode;

    }


    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
    	StringBuilder sb = new StringBuilder();
        int tests = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int testsItr = 0; testsItr < tests; testsItr++) {
            SinglyLinkedList llist = new SinglyLinkedList();

            int llistCount = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int i = 0; i < llistCount; i++) {
                int llistItem = scanner.nextInt();
                scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

                llist.insertNode(llistItem);
            }

            SinglyLinkedListNode llist1 = reverse(llist.head);

            printSinglyLinkedList(llist1, " ", sb);
            sb.append("\n");
        }
        System.out.println(sb.toString());


        scanner.close();
    }
}

