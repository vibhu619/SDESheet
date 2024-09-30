package LinkedList.Medium;

import LinkedList.ListOperations;
import LinkedList.Node;

public class IntersectionOfLinkedLists {
    public static void main(String[] args) {
        ListOperations i = new ListOperations();
        Node head = null;
        Node head2 = null;
        head = i.addLast(1, head);
        head = i.addLast(2, head);
        head = i.addLast(3, head);
        head = i.addLast(4, head);
        head = i.addLast(5, head);
        head = i.addLast(6, head);
        head = i.addLast(7, head);

        head2 = i.addLast(9, head2);
        head2 = i.addLast(4, head2);
        head2 = i.addLast(5, head2);
        head2 = i.addLast(6, head2);
        head2 = i.addLast(7, head2);

        System.out.println(intersectioOfList(head, head2));
    }

    private static int intersectioOfList(Node head1, Node head2) {

        //
        // code here
        int l1 = length(head1);
        int l2 = length(head2);
        int diff = Math.abs(l1 - l2);
        int jump = 1;
        if (l1 > l2) {
            while (jump <= diff) {
                head1 = head1.next;
                jump++;
            }
        } else {
            while (jump <= diff) {
                head2 = head2.next;
                jump++;
            }
        }

        System.out.println(head1.data + " " + head2.data);
        return findInter(head1, head2);
    }

    static int length(Node head) {
        int c = 0;
        while (head != null) {
            c++;
            head = head.next;
        }
        return c;
    }

    static int findInter(Node head1, Node head2) {
        while (head1 != null && head2 != null) {
            if (head1.data == head2.data) {
                return head1.data;
            }
            head1 = head1.next;
            head2 = head2.next;
        }
        return -1;

    }
}
