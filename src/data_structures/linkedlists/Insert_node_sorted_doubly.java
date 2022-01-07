package data_structures.linkedlists;

import java.io.*;
import java.util.*;

public class Insert_node_sorted_doubly {

    static class DoublyLinkedListNode {
        public int data;
        public DoublyLinkedListNode next;
        public DoublyLinkedListNode prev;

        public DoublyLinkedListNode(int nodeData) {
            this.data = nodeData;
            this.next = null;
            this.prev = null;
        }
    }

    static class DoublyLinkedList {
        public DoublyLinkedListNode head;
        public DoublyLinkedListNode tail;

        public DoublyLinkedList() {
            this.head = null;
            this.tail = null;
        }

        public void insertNode(int nodeData) {
            DoublyLinkedListNode node = new DoublyLinkedListNode(nodeData);

            if (this.head == null) {
                this.head = node;
            } else {
                this.tail.next = node;
                node.prev = this.tail;
            }

            this.tail = node;
        }
    }

    public static void printDoublyLinkedList(DoublyLinkedListNode node, String sep, StringBuilder sb) throws IOException {
        while (node != null) {
            sb.append(String.valueOf(node.data));

            node = node.next;

            if (node != null) {
                sb.append(sep);
            }
        }
    }


    public static DoublyLinkedListNode sortedInsert(DoublyLinkedListNode llist, int data) {
    	DoublyLinkedListNode curr = llist;
    	DoublyLinkedListNode node = new DoublyLinkedListNode(data);
    	if(data<llist.data)
    	{
    		llist.prev = node;
    		node.next = llist;
    		return node;
    	}
    	boolean changed = false;
    	
    	while(curr.next!=null) {
    		
    		if(data>=curr.data && curr.next.data>=data) {
    			node.next = curr.next;
    			node.prev = curr;
    			curr.next = node;
    			changed = true;
    			break;
    		}
    		
    		curr = curr.next;
    	}
    	if(!changed) {
    		node.prev = curr;
    		curr.next = node;
    	}
    	return llist;

    }


    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
    	StringBuilder sb = new StringBuilder();

        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            DoublyLinkedList llist = new DoublyLinkedList();

            int llistCount = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int i = 0; i < llistCount; i++) {
                int llistItem = scanner.nextInt();
                scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

                llist.insertNode(llistItem);
            }

            int data = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            DoublyLinkedListNode llist1 = sortedInsert(llist.head, data);

            printDoublyLinkedList(llist1, " ", sb);
            sb.append("\n");
        }

        System.out.println(sb.toString());
        scanner.close();
    }
}

