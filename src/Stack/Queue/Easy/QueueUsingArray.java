package Stack.Queue.Easy;


class Queue {
    private int front, rear;
    private int capacity;
    int[] queue;

    Queue(int c){
        front=rear=0;
        capacity=c;
        queue=new int[capacity];
    }
    //rear will always be at index after last element
    public void Enqueue(int x) {
        if (rear == capacity) {
            System.out.println("Queue is full");
            return;
        }
        queue[rear] = x;
        rear++;
    }

    public void dequeue(){
        if(front==rear){
            System.out.println("Queue is empty");
            return;
        }
        //shift elements from front+1 to rear-2(element before last element)
        for(int i=front;i<rear-1;i++){
            queue[i]=queue[i+1];
        }
        rear--;

    }

    public int front(){
        if(front==rear){
            System.out.println("Queue is empty");
            return -1;
        }
        return queue[front];

    }

    public  void display(){
        if(front==rear){
            System.out.println("Empty queue");
        }
        else{
            for(int i=front;i<rear;i++){
                System.out.print(queue[i]+" ");
            }
            System.out.println("");
        }
    }
}

public class QueueUsingArray {
    public static void main(String[] args) {

        Queue q=new Queue(5);

        q.Enqueue(1);
        q.Enqueue(2);
        q.Enqueue(3);
        q.Enqueue(4);
        q.Enqueue(5);

        System.out.println(q.front());
        q.display();

        q.dequeue();
        System.out.println(q.front());
        q.display();


    }
}
