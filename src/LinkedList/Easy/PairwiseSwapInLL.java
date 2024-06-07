package LinkedList.Easy;

import LinkedList.ListOperations;
import LinkedList.Node;

public class PairwiseSwapInLL {
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

        head=PairwiseSwap(head);
        i.printList(head);

    }

    private static Node PairwiseSwap(Node head) {

        //If only one node or no node
        if(head==null | head.next==null){
            return head;
        }

        //Initialise two pointers
        Node prev=head;
        Node curr=prev.next;
        head=curr;  //mke second node as head because after first swap it will become head

        while(true){

            Node next=curr.next;  //keep reference  of curr'next in next
            curr.next=prev;  //make connection from 2nd to 1st node in pair

            // If next NULL or next is the last node
            if(next==null || next.next==null){
                prev.next=next;
                break;
            }

            //make connection bw previous and a node ahead of next , as after next swap second element of second swap will be connected to first element of first swap
            prev.next=next.next;

            //update prev and curr
            prev=next;
            curr=prev.next;
        }
        return head;
    }
}
