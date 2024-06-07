package LinkedList.Medium;

import LinkedList.ListOperations;
import LinkedList.Node;

public class MergeSortedLinkedList {
    public static void main(String[] args) {
        ListOperations i = new ListOperations();
        Node head1 = null;
        Node head2 = null;

        head1 = i.addLast(1, head1);
        head1 = i.addLast(4, head1);
        head1 = i.addLast(8, head1);
        head1 = i.addLast(9, head1);
        System.out.println("Linked List 1: ");
        i.printList(head1);
        System.out.println('\n');


        head2 = i.addLast(0, head2);
        head2 = i.addLast(2, head2);
        head2 = i.addLast(5, head2);
        head2 = i.addLast(12, head2);
        System.out.println("Linked List 2: ");
        i.printList(head2);
        System.out.println('\n');


        Node headMaster = mergeList(head1, head2);
        i.printList(headMaster);
    }

    private static Node mergeList(Node head1, Node head2) {
        Node a = head1;
        Node b = head2;

        Node newHead = null;
        Node c = null;
        if (a.data < b.data) {
            newHead = a;
            c = a;
            a = a.next;
        } else {
            newHead = b;
            c = b;
            b = b.next;
        }

        while (a != null && b != null) {
            if (a.data < b.data) {
                c.next = a;
                c = a;
                a = a.next;
            } else {
                c.next = b;
                c = b;
                b = b.next;
            }
        }

        if (a == null) {
            c.next = b;
        } else {
            c.next = a;
        }
        return newHead;
    }
}
