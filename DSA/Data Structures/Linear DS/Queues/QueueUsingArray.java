public class QueueUsingArray {
    private int[] q;
    private int count = 0;
    private int front = 0;
    private int rear = 0;
    private int n;

    public QueueUsingArray(int capacity) {
        q = new int[capacity];
        n = capacity;
    }

    public void add(int val) {
        if (isFull())
            throw new IllegalStateException();

        q[rear % n] = val;
        rear++;
        count++;
    }

    public int remove() {
        if (isEmpty())
            throw new IllegalStateException();

        int popped = q[front % n];
        q[front % n] = -1;
        front++;
        count--;

        return popped;
    }

    public int peek() {
        if (isEmpty())
            throw new IllegalStateException();

        return q[front % n];
    }

    public boolean isEmpty() {
        return count == 0;
    }

    public boolean isFull() {
        return count == n;
    }

    public int size() {
        return count;
    }

    public void printQueue() {
        System.out.print("[ ");
        for (int i = front; i < rear; i++)
            System.out.print(q[i % n] + " ");
        System.out.print("]");
        System.out.println();
    }

    public static void main(String[] args) {
        QueueUsingArray queue = new QueueUsingArray(5);
        System.out.println("Is the queue empty? : " + queue.isEmpty());
        queue.add(3);
        queue.add(2);
        queue.add(1);
        queue.add(8);
        queue.add(6);
        System.out.println("Is the queue full? : " + queue.isFull());
        queue.remove();
        queue.remove();
        queue.remove();
        queue.remove();
        System.out.println("The top element is: " + queue.peek());
        queue.add(10);
        queue.printQueue();
        queue.remove();
        queue.printQueue();
    }
}