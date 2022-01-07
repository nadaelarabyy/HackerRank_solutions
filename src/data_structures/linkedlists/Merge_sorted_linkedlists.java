package data_structures.linkedlists;

import java.io.*;
import java.util.*;

public class Merge_sorted_linkedlists {

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
    static SinglyLinkedListNode mergeLists2(SinglyLinkedListNode head1, SinglyLinkedListNode head2) {
    	while(head2!=null) {
    		SinglyLinkedListNode curr = head1;
    		while(curr.next!=null && head2.data > curr.data && head2.data > curr.next.data) {
    			curr = curr.next;
    		}
    		SinglyLinkedListNode tmp = curr.next; 
    		curr.next = new SinglyLinkedListNode(head2.data);
    		curr.next.next = tmp;
    		head2 = head2.next;
    		
    	}
		return head1;
    	
    }
    static SinglyLinkedListNode mergeLists(SinglyLinkedListNode head1, SinglyLinkedListNode head2) {
    	if(head1.data<head2.data)
    		return mergeLists2(head1, head2);
    	return mergeLists2(head2, head1);
    
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
    	StringBuilder sb = new StringBuilder();

        int tests = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int testsItr = 0; testsItr < tests; testsItr++) {
            SinglyLinkedList llist1 = new SinglyLinkedList();

            int llist1Count = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int i = 0; i < llist1Count; i++) {
                int llist1Item = scanner.nextInt();
                scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

                llist1.insertNode(llist1Item);
            }
          
          	SinglyLinkedList llist2 = new SinglyLinkedList();

            int llist2Count = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int i = 0; i < llist2Count; i++) {
                int llist2Item = scanner.nextInt();
                scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

                llist2.insertNode(llist2Item);
            }

            SinglyLinkedListNode llist3 = mergeLists(llist1.head, llist2.head);

            printSinglyLinkedList(llist3, " ", sb);
            sb.append("\n");
        }
        System.out.println(sb.toString());

        scanner.close();
    }
}


