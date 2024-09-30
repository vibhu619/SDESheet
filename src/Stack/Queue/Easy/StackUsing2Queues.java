package Stack.Queue.Easy;

import java.util.LinkedList;
import java.util.Queue;

class Queues {
    java.util.Queue<Integer> q1 = new LinkedList<Integer>();
    Queue<Integer> q2 = new LinkedList<Integer>();

    //Function to push an element into stack using two queues.
    void push(int a) {
        // Your code here
        q1.add(a);
    }

    //Function to pop an element from stack using two queues.
    int pop() {
        // Your code here

        if (q1.size() == 0) {
            return -1;
        }
        while (q1.size() > 1) {
            q2.add(q1.remove());
        }
        int ans = q1.remove();
        while (!q2.isEmpty()) {
            q1.add(q2.remove());
        }

        return ans;
    }

}

public class StackUsing2Queues {
    public static void main(String[] args) {
        Queues q = new Queues();
        q.push(2);
        q.push(3);
        q.push(5);

        System.out.println(q.pop());
    }
}
