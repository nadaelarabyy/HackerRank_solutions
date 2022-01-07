package data_structures.linkedlists;


import java.io.*;
import java.util.*;

public class insrtNodeAtSpecificPos {

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



    public static SinglyLinkedListNode insertNodeAtPosition(SinglyLinkedListNode llist, int data, int position) {
    	SinglyLinkedListNode node = new SinglyLinkedListNode(data);
    	
    	SinglyLinkedListNode curr = llist;
    	while(position != 1) {
    		curr = curr.next;
    		position -=1;
    	}
		node.next = curr.next;
		curr.next = node;
    	return llist;
    }


    @Override
	public String toString() {
		return "insrtNodeAtSpecificPos []";
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

            llist.insertNode(llistItem);
        }

        int data = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int position = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        SinglyLinkedListNode llist_head = insertNodeAtPosition(llist.head, data, position);

        printSinglyLinkedList(llist_head, " ", sb);
        sb.append("\n");
        System.out.println(sb.toString());


        scanner.close();
    }
}

