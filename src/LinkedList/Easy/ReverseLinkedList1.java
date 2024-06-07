package LinkedList.Easy;

import LinkedList.ListOperations;
import LinkedList.Node;

//iterative approach
    public class ReverseLinkedList1 {

    public Node reverseList(Node head){
        //Corner case, when list empty or only 1 node return head
        if(head==null || head.next==null){
            return head;
        }

        //initialise prev and curr
        Node prev=head;
        Node curr=head.next;

        //iterate till curr =null
        while(curr!=null){
            // initialise next node
            Node next=curr.next;

            //point curr towards prev
            curr.next=prev;

            //update prev and curr
            prev=curr;
            curr=next;
        }
        //at last , break the 1st link
        head.next=null;
        //prev stands at the 1st node of the reversed list hence make it head
        head=prev;
        return head;
    }

    public static void main(String[] args) {
        ListOperations i=new ListOperations();
        ReverseLinkedList1 r=new ReverseLinkedList1();
        Node head=null;

        head=i.addLast(1,head);
        head=i.addLast(2,head);
        head=i.addLast(3,head);
        head=i.addLast(4,head);
        head=i.addLast(5,head);
        i.printList(head);

        System.out.println("");
        System.out.println("AFTER REVERSING LIST");
        head=r.reverseList(head);
        i.printList(head);
    }
}
