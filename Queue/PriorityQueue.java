import java.util.LinkedList;
public class PriorityQueue {

    private class Node {
        int data;
        int priority;

        Node(int data, int priority) {
            this.data = data;
            this.priority = priority;
        }
    }
    private LinkedList<Node> queue;
    public PriorityQueue() {
        queue = new LinkedList<>();
    }

    public void enqueue(int data, int priority) {
        Node newNode = new Node(data, priority);
        if (queue.isEmpty()) {
            queue.add(newNode);
        } else {
            int i = 0;
            while (i < queue.size() && queue.get(i).priority <= priority) {
                i++;
            }
            queue.add(i, newNode);
        }
    }
    public int dequeue() {
        if (queue.isEmpty()) {
            System.out.println("Priority Queue is empty. Cannot dequeue.");
            return -1;
        }
        return queue.removeFirst().data;
    }
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < queue.size(); i++) {
            sb.append("(").append(queue.get(i).data).append(", ").append(queue.get(i).priority).append(")");
            if (i < queue.size() - 1) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }
    public boolean isEmpty() {
        return queue.isEmpty();
    }
    public int size() {
        return queue.size();
    }
    
}
