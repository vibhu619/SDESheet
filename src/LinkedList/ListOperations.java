package LinkedList;

public class ListOperations {

    public static void main(String[] args) {
        //Head initialisation
        Node head = null;

        //object of linkedList class
        ListOperations i = new ListOperations();

        //Add element at first index
        head = i.addFirst(3, head);
        head = i.addFirst(2, head);
        head = i.addFirst(1, head);


        //Add element at last index
        head = i.addLast(6, head);
        head = i.addLast(11, head);

        //Add element after nth index
        head = i.addAtNthNode(4, 3, head);
        head = i.addAtNthNode(7, 5, head);
//      head=i.addAtNthNode(9,10,head);

        //Print list
        System.out.println("Linked List: ");
        i.printList(head);


        //DELETE AT FIRST NODE
        System.out.println("");
        System.out.println("List after Delete 1st node");
        head = i.deleteFirst(head);
        i.printList(head);

        //delete at last node
        System.out.println("");
        System.out.println("List after Delete last node");
        head = i.deleteLast(head);
        i.printList(head);


        //delete at nth node
        System.out.println("");
        System.out.println("List after delete at 3rd index");
        head = i.deletAtNthIndex(3, head);
        i.printList(head);
    }

    public Node addFirst(int data, Node head) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            return head;
        }
        newNode.next = head;
        head = newNode;
        return head;
    }

    public Node addLast(int data, Node head) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            return head;
        }
        Node currNode = head;
        while (currNode.next != null) {
            currNode = currNode.next;
        }
        currNode.next = newNode;
        return head;
    }

    public Node addAtNthNode(int data, int index, Node head) {
        int jump = 1;
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            return head;
        }
        Node temp = head;
        while (jump <= index - 1) {
            if (temp.next == null) {
                System.out.println("reached end of linked list");
                return head;
            }
            temp = temp.next;
            jump++;
        }
        newNode.next = temp.next;
        temp.next = newNode;
        return head;
    }

    public Node deleteFirst(Node head) {
        if (head == null) {
            System.out.println("Empty list");
            return head;
        }

        head = head.next;
        return head;
    }

    public Node deleteLast(Node head) {
        //No node
        if (head == null) {
            System.out.println("Empty List");
            return head;
        }

        //1 node
        if (head.next == null) {
            head = null;
            return head;
        }

        //More than 1 node
        Node prev = head;
        Node last = head.next;
        while (last.next != null) {
            last = last.next;
            prev = prev.next;
        }
        prev.next = null;
        return head;
    }

    public Node deletAtNthIndex(int idx, Node head) {
        if (idx == 1) {
            deleteFirst(head);
        }
        Node prev = head;
        Node last = head.next;
        int jump = 1;
        while (jump <= idx - 2) {
            prev = prev.next;
            last = last.next;
            jump++;
        }
        prev.next = last.next;
        return head;
    }

    public void printList(Node head) {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }
        Node currNode = head;
        while (currNode != null) {
            System.out.print(currNode.data + "->");
            currNode = currNode.next;
        }
        System.out.print("NULL");
    }
}

