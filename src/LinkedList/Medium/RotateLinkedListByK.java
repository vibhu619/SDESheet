package LinkedList.Medium;

import LinkedList.ListOperations;
import LinkedList.Node;

public class RotateLinkedListByK {
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
        head = i.addLast(8, head);
        int k=4;
        System.out.println("Linked list");
        i.printList(head);
        System.out.println();
        Node newHead=rotateList(head,k);
        System.out.println("Rotated Linked list");
        i.printList(newHead);
    }

    private static Node rotateList(Node head, int k) {
        Node tail=head;
        //find tail
        while(tail!=null && tail.next!=null){
            tail=tail.next;
        }
        while(k>0){
            //at each rotation:
            //1.keep head.next in temp node
            //2.connect tail to current head
            //3.make curr head point to null
            //4.make curr head as tail
            //5. make temp node as new head
            Node temp=head.next;
            tail.next=head;
            head.next=null;
            tail=head;
            head=temp;
            k--;

        }
        return head;
    }
}
