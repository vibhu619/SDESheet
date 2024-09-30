package LinkedList.Hard;

import LinkedList.ListOperations;
import LinkedList.Node;

public class MergeKSortedList {
    public static void main(String[] args) {
        ListOperations i = new ListOperations();
        Node head1 = null;
        Node head2 = null;
        Node head3 = null;
        Node head4 = null;
        head1 = i.addLast(1, head1);
        head1 = i.addLast(2, head1);
        head1 = i.addLast(3, head1);


        head2 = i.addLast(3, head2);
        head2 = i.addLast(4, head2);

        head3 = i.addLast(5, head3);
        head3 = i.addLast(7, head3);

        head4 = i.addLast(9, head4);
        head4 = i.addLast(11, head4);

        Node[] arr = {head1, head2, head3, head4};

        Node newhead = mergeKList(arr, arr.length);

        i.printList(newhead);
    }

    static Node mergeKList(Node[] arr, int k) {
        //Add your code here.
        if (arr.length == 0) return null;
        Node newNode = arr[0];
        for (int i = 1; i < arr.length; i++) {
            Node temp = arr[i];
            newNode = mergeList(temp, newNode);
        }

        return newNode;
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
