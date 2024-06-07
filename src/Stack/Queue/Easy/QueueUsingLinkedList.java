package Stack.Queue.Easy;

import java.util.ArrayDeque;
import java.util.Deque;

class QueueNode
{
    int data;
    QueueNode next;
    QueueNode(int a)
    {
        data = a;
        next = null;
    }
}


class MyQueue
{
    QueueNode front, rear;

    //Function to push an element into the queue.
    void add(int a)
    {
        // Your code here
        QueueNode temp=new QueueNode(a);
        if(rear==null){
            front=rear=temp;
            return;
        }
        rear.next=temp;
        rear=temp;
    }

    //Function to pop front element from the queue.
    int remove()
    {
        // Your code here
        if(rear==null){
            return -1;
        }
        QueueNode temp=front;
        front=front.next;
        if(front==null){
            rear=null;
        }
        return temp.data;
    }
}
public class QueueUsingLinkedList {
    public static void main(String[] args) {
        MyQueue q=new MyQueue();
        q.add(1);
        q.add(2);
        q.add(3);
        q.add(5);

        System.out.println(q.remove());

    }
}
