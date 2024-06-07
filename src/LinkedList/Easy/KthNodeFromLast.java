package LinkedList.Easy;

import LinkedList.ListOperations;
import LinkedList.Node;

public class KthNodeFromLast {
    public static void main(String[] args) {
        ListOperations i=new ListOperations();
        Node head=null;

        head=i.addLast(1,head);
        head=i.addLast(2,head);
        head=i.addLast(3,head);
        head=i.addLast(4,head);
        head=i.addLast(5,head);
        head=i.addLast(6,head);
        head=i.addLast(7,head);
        System.out.println("Linked list");
        i.printList(head);
        System.out.println();

        kthNode(2,head);
    }

    private static void kthNode(int n, Node head) {
        int jump=1;
        Node slow=head;
        Node fast=head;


        //Logic: run fast for N jumps. Then move fast and slow together till fast becomes null
        while(jump<=n){
            if(fast==null){
                System.out.println("No such value found");
            }
            fast=fast.next;
            jump++;
        }

        while(fast!=null){
            fast=fast.next;
            slow=slow.next;
        }
        System.out.println( slow.data);
    }
}
