package LinkedList.Easy;

import LinkedList.ListOperations;
import LinkedList.Node;

public class DeleteWithoutHead {
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
        //Suppose we want to delete 3rd node
        int jump = 1;
        Node del = head;
        while (jump < 3) {
            del = del.next;
            jump++;
        }
        deleteNode(del);
        i.printList(head);
    }

    private static void deleteNode(Node del) {
        //copy ek agge vali node to curr node
        del.data = del.next.data;

        //delete agge vala node
        del.next = del.next.next;
    }
}
