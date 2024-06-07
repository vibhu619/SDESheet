package LinkedList.Easy;

import LinkedList.ListOperations;
import LinkedList.Node;

public class SeggregateZeroOneTwos {
    public static void main(String[] args) {
        ListOperations i = new ListOperations();
        Node head = null;

        head = i.addLast(1, head);
        head = i.addLast(0, head);
        head = i.addLast(2, head);
        head = i.addLast(2, head);
        head = i.addLast(1, head);
        head = i.addLast(1, head);
        head = i.addLast(0, head);
        System.out.println("Linked list");
        i.printList(head);
        System.out.println();


        head=segregate(head);
        i.printList(head);

    }

    private static Node segregate(Node head) {
        int[] count={0,0,0};  //Iniitialise the array to store frequency

        Node curr=head;
        while(curr!=null){   //Iterate through LL
            count[curr.data]++;  //Store frequency
            curr=curr.next;
        }

        curr=head;
        int i=0;
        while(curr!=null){
            if(count[i]==0){   //if no frequency left for i, i++
                i++;
            }
            else{  //else replace da of current node with i and decrease frequency
                curr.data=i;
                count[i]--;
                curr=curr.next;
            }
        }

        System.out.println();
        return head;
    }
}
