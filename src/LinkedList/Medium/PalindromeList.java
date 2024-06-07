package LinkedList.Medium;

import LinkedList.Easy.ReverseLinkedList1;
import LinkedList.ListOperations;
import LinkedList.Node;

public class PalindromeList {
    public static void main(String[] args) {
        ListOperations i = new ListOperations();
        ReverseLinkedList1 r = new ReverseLinkedList1();
        Node head = null;

        head = i.addLast(1, head);
        head = i.addLast(2, head);
        head = i.addLast(3, head);
        head = i.addLast(4, head);
        head = i.addLast(5, head);
        i.printList(head);
        
        if(palindrome(head)){
            System.out.println("yes");
        }
        else{
            System.out.println("No");
        }
    }

    private static boolean palindrome(Node head) {
        Node middle=middle(head);  //find middle point of list
        Node prev=middle.next;   //second half will start after middle
        Node temp=reverse(prev);   //reverse second half
        middle.next=temp;   //and join reversed second half from middle

        //now start comparing each element of each half
        Node start=head;
        while(start!=null && temp!=null){   ///until anyone of it becomes null
            if(start.data!=temp.data){
                return false;
            }
            start=start.next;
            temp=temp.next;
        }
        return true;
    }

    static Node middle(Node head){
        Node slow=head;
        Node fast=slow.next;

        while(fast!=null && fast.next!=null){
            fast=fast.next.next;
            slow=slow.next;
        }

        return slow;
    }

    static Node reverse(Node head){
        Node prev=null;
        Node curr=head;

        while(curr!=null){
            Node next=curr.next;

            curr.next=prev;

            prev=curr;
            curr=next;
        }
        return prev;
    }
}
