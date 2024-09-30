package LinkedList.Easy;

import LinkedList.ListOperations;
import LinkedList.Node;

//Runner technique
public class MiddlePointInLL {
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
        System.out.println("Linked list");
        i.printList(head);
        System.out.println();

        MiddlePointInLL m = new MiddlePointInLL();
        Node ans = m.middleElement(head);
        System.out.println(ans.data);

    }

    public Node middleElement(Node head) {
        //corner case-if one or no node
        if (head == null || head.next == null) {
            return head;
        }

        //Create two pointers, one a head and one at next of head
        Node slow = head;
        Node fast = head.next;

        //slow move 1 jump, fast two jumps
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }
}
