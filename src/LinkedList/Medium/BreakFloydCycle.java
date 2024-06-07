package LinkedList.Medium;

import LinkedList.ListOperations;
import LinkedList.Node;

public class BreakFloydCycle {
    public static void main(String[] args) {
        ListOperations i = new ListOperations();
        Node head = null;

        head = i.addLast(1, head);
        head = i.addLast(2, head);
        head = i.addLast(3, head);
        head = i.addLast(4, head);
        head = i.addLast(5, head);
        head = i.addLast(6, head);
        head = i.addLast(7, head);
        breakCycle(head);
    }

    private static void breakCycle(Node head) {
        Node slow=head;
        Node fast=head;
        Node temp=head;
        while(fast!=null && fast.next!=null) {
            fast = fast.next.next;
            slow = slow.next;

            if (slow == fast) {
                while (slow != temp) {
                    slow = slow.next;
                    temp = temp.next;
                }
                while (fast.next != slow) {
                    fast = fast.next;
                }
                fast.next = null;
            }
        }
    }
}
