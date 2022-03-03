import java.util.LinkedList;
import java.util.Queue;

public class StackUsingTwoQueues {
    private Queue<Integer> q1;
    private Queue<Integer> q2;

    public StackUsingTwoQueues() {
        q1 = new LinkedList<>();
        q2 = new LinkedList<>();
    }

    // Time: O(n); Space: O(n)
    public void push(int val) {
        // STEP-1: Add the new incoming element (`val`) to the empty Q2
        q2.add(val);

        // STEP-2: Now, add all the elements from Q1 to Q2
        while (!q1.isEmpty())
            q2.add(q1.remove());

        // STEP-3: Finally, move all the elements from Q2 to Q1
        while (!q2.isEmpty())
            q1.add(q2.remove());
    }

    public int pop() {
        if (q1.isEmpty())
            throw new IllegalStateException();

        return q1.remove();
    }

    public int peek() {
        if (q1.isEmpty())
            throw new IllegalStateException();

        return q1.peek();
    }

    public boolean isEmpty() {
        return q1.isEmpty();
    }

    @Override
    public String toString() {
        return q1.toString();
    }

    public static void main(String[] args) {
        StackUsingTwoQueues st_q = new StackUsingTwoQueues();
        st_q.push(1);
        st_q.push(2);
        st_q.push(3);
        st_q.pop();
        System.out.println(st_q.toString());
        System.out.println("The top of the stack is: " + st_q.peek());
    }
}