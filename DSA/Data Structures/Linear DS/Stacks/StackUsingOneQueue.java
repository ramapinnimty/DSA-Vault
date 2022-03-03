import java.util.Queue;
import java.util.LinkedList;

public class StackUsingOneQueue {
    private Queue<Integer> q;

    public StackUsingOneQueue() {
        q = new LinkedList<>();
    }

    // Time: O(n); Space: O(n)
    public void push(int val) {
        q.add(val);
        int count = q.size() - 1;
        while (count > 0) {
            int popped = q.remove();
            q.add(popped);
            count--;
        }
    }

    public int pop() {
        return q.remove();
    }

    public int peek() {
        return q.peek();
    }

    public boolean isEmpty() {
        return q.size() == 0;
    }

    @Override
    public String toString() {
        return q.toString();
    }

    public static void main(String[] args) {
        StackUsingOneQueue st_q = new StackUsingOneQueue();
        System.out.println("Is the stack empty? : " + st_q.isEmpty());
        st_q.push(3);
        st_q.push(2);
        st_q.push(4);
        System.out.println(st_q);
        st_q.pop();
        System.out.println("Top of the stack is: " + st_q.peek());
        System.out.println(st_q);
    }
}