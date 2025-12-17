
public class CircularQueue {
    private int[] queue;
    private int front;
    private int rear;
    private int capacity;

    public CircularQueue(int capacity) {
        // Implementing Circular Queue
        // Initialize the circular queue with the given capacity
        this.capacity = capacity;
        this.queue = new int[capacity];
        this.front = -1;
        this.rear = -1;
    }

    public void enqueue(int i) {
        // Check if the circular queue is full
        if ((rear + 1) % capacity == front) {
            System.out.println("Circular Queue is full. Cannot enqueue " + i);
            return;
        }

        // If the queue is empty, initialize front and rear
        if (front == -1) {
            front = 0;
        }

        // Update rear and add the new element
        rear = (rear + 1) % capacity;
        queue[rear] = i;
    }

    public void dequeue() {
        // Check if the circular queue is empty
        if (front == -1) {
            System.out.println("Circular Queue is empty. Cannot dequeue.");
            return;
        }

        // If there's only one element, reset front and rear
        if (front == rear) {
            front = -1;
            rear = -1;
        } else {
            // Move front to the next position
            front = (front + 1) % capacity;
        }
    }

    public String toString() {
        if (front == -1) {
            return "[]";
        }

        StringBuilder sb = new StringBuilder();
        sb.append("[");

        int i = front;
        while (true) {
            sb.append(queue[i]);
            if (i == rear) {
                break;
            }
            sb.append(", ");
            i = (i + 1) % capacity;
        }

        sb.append("]");
        return sb.toString();
    }

    public boolean isEmpty() {
        return front == -1;
    }

    public boolean isFull() {
        return (rear + 1) % capacity == front;
    }

    public int size() {
        if (isEmpty()) {
            return 0;
        }
        if (rear >= front) {
            return rear - front + 1;
        } else {
            return capacity - front + rear + 1;
        }
    }
}
