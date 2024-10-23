package Queue.Easy;

import java.util.Stack;

class StackQueue {
    Stack<Integer> s1 = new Stack<Integer>();
    Stack<Integer> s2 = new Stack<Integer>();

    //Function to push an element in queue by using 2 stacks.
    void add(int x) {
        // Your code here
        s1.push(x);
    }


    //Function to pop an element from queue by using 2 stacks.
    int remove() {
        // Your code here
        if (s1.isEmpty()) {
            return -1;
        }

        while (!s1.isEmpty()) {
            s2.push(s1.pop());
        }
        int ans = s2.pop();

        while (!s2.isEmpty()) {
            s1.push(s2.pop());
        }
        return ans;
    }
}

public class QueueUsing2Stacks {
    public static void main(String[] args) {
        StackQueue s = new StackQueue();
        s.add(1);
        s.add(2);
        s.add(3);
        s.add(5);

        System.out.println(s.remove());
    }
}
