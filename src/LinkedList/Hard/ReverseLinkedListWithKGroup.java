package LinkedList.Hard;

import LinkedList.ListOperations;
import LinkedList.Node;
//Reverse a Linked List in groups of given size
//        HardAccuracy: 57.08%Submissions: 200K+Points: 8
//        Be the comment of the day in POTD and win a GfG T-Shirt!
//        Solve right now
//
//        banner
//        Given a linked list of size N.
//        The task is to reverse every k nodes (where k is an input to the function) in the linked list.
//        If the number of nodes is not a multiple of k then left-out nodes, in the end, should be considered as a group
//        and must be reversed (See Example 2 for clarification).
//
//        Example 1:
//
//        Input:
//        LinkedList: 1->2->2->4->5->6->7->8
//        K = 4
//        Output: 4 2 2 1 8 7 6 5
//        Explanation:
//        The first 4 elements 1,2,2,4 are reversed first
//        and then the next 4 elements 5,6,7,8. Hence, the
//        resultant linked list is 4->2->2->1->8->7->6->5.
//
//Example 2:
//
//        Input:
//        LinkedList: 1->2->3->4->5
//        K = 3
//        Output: 3 2 1 5 4
//        Explanation:
//        The first 3 elements are 1,2,3 are reversed
//        first and then elements 4,5 are reversed.Hence,
//        the resultant linked list is 3->2->1->5->4.
public class ReverseLinkedListWithKGroup {
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
        head = i.addLast(9, head);
        head = i.addLast(10, head);
        System.out.println("Linked list");
        i.printList(head);
        System.out.println();
        int n=length(head);
        head=reverse(head,4,n);
        i.printList(head);
        System.out.println();
    }

    private static int length(Node head) {
        int n=0;
        while(head!=null){
            n++;
            head=head.next;

        }
        return n;
    }

    private static Node reverse(Node curr, int k,int n) {
        if(curr==null){
            return curr;
        }
        Node prev=null;
        Node temp=curr;
        Node next=null;
        int jump=0;
        if(n>k)
             jump=k;
        else
            jump=n;

        while(jump>0){
            next=curr.next;
            curr.next=prev;

            prev=curr;
            curr=next;
            jump--;
        }
        //System.out.println(temp.data);
        temp.next=reverse(next,k,n-k);
        return prev;
    }
}
