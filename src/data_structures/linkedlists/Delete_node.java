package data_structures.linkedlists;

import java.io.*;
import java.util.stream.*;

class SinglyLinkedListNode {
    public int data;
    public SinglyLinkedListNode next;

    public SinglyLinkedListNode(int nodeData) {
        this.data = nodeData;
        this.next = null;
    }
}

class SinglyLinkedList {
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

class SinglyLinkedListPrintHelper {
    public static void printList(SinglyLinkedListNode node, String sep, StringBuilder sb) throws IOException {
        while (node != null) {
            sb.append(String.valueOf(node.data));

            node = node.next;

            if (node != null) {
                sb.append(sep);
            }
        }
    }
}

class Result {

    public static SinglyLinkedListNode deleteNode(SinglyLinkedListNode llist, int position) {
    	
    	SinglyLinkedListNode curr = llist;
    	if(position == 0)
    		return llist.next;
    	while(position!=1) {
    		curr = curr.next;
    		position-=1;
    	}
    	SinglyLinkedListNode nxt = curr.next.next;
    	curr.next = nxt;
		return llist;

    }

}

public class Delete_node {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        SinglyLinkedList llist = new SinglyLinkedList();

        int llistCount = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, llistCount).forEach(i -> {
            try {
                int llistItem = Integer.parseInt(bufferedReader.readLine().trim());

                llist.insertNode(llistItem);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        int position = Integer.parseInt(bufferedReader.readLine().trim());

        SinglyLinkedListNode llist1 = Result.deleteNode(llist.head, position);

        SinglyLinkedListPrintHelper.printList(llist1, " ", sb);
        sb.append("\n");
        System.out.println(sb.toString());
        bufferedReader.close();
    }
}


