package Stack.Queue.Easy.Deque;

import java.util.ArrayDeque;

public class ImplementigDeque {
    public static void main(String[] args) {
        ArrayDeque<Integer> q = new ArrayDeque<>();

        q.addFirst(1);
        q.addFirst(2);

        q.addLast(3);
        System.out.println(q);

        int r = q.removeFirst();
        System.out.println(r);

        System.out.println(q);

        q.removeLast();
        System.out.println(q);
    }
}
