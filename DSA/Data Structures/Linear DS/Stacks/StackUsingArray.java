public class StackUsingArray {
    private int[] st;
    private int top = -1;

    public StackUsingArray(int capacity) {
        st = new int[capacity];
    }

    public void push(int val) {
        if (size() >= st.length)
            throw new StackOverflowError();

        // Below lines are identical to: `st[++top] = val;`
        top++;
        st[top] = val;
    }

    public int pop() {
        if (isEmpty())
            return -1;

        int poppedItem = st[top];
        top--;

        return poppedItem;
    }

    public int peek() {
        if (isEmpty())
            return -1;

        return st[top];
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public int size() {
        return top + 1;
    }

    public static void main(String[] args) {
        StackUsingArray stack = new StackUsingArray(10);
        System.out.println("Is the stack empty: " + stack.isEmpty());
        stack.push(1);
        stack.push(2);
        stack.push(3);

        System.out.println("Top of the stack: " + stack.peek());

        stack.pop();
        stack.pop();
        stack.pop();
        System.out.println("Size of the stack: " + stack.size());
    }
}