/*

Explaing Queue Data Structure 
-A Queue is a linear data structure that follows the First In First Out (FIFO) principle. 
-This means that the first element added to the queue will be the first one to be removed. 
-Queues are commonly used in scenarios where order of processing is important, such as task 
 scheduling, handling requests in web servers, and managing resources in operating systems.
 package Queue;

 Typical operations that can be performed on a queue include:
    1. Enqueue: Adds an element to the end of the queue.
    2. Dequeue: Removes and returns the front element of the queue.
    3. Peek/Front: Returns the front element without removing it.
    4. isEmpty: Checks if the queue is empty.
    5. Size: Returns the number of elements in the queue.

    Types of Queues:
    1. Simple Queue: Basic FIFO structure.
        Its operations:
            Enqueue: Add element at the rear.
            Dequeue: Remove element from the front.
            Peek: View the front element without removing it.
            isEmpty: Check if the queue is empty.
            Size: Get the number of elements in the queue.

    2. Circular Queue: The last position is connected back to the first position to make a circle.
        Its operations:
            Enqueue: Add element at the rear, wrapping around if necessary.
            Dequeue: Remove element from the front, wrapping around if necessary.
            Peek: View the front element without removing it.
            isEmpty: Check if the queue is empty.
            isFull: Check if the queue is full.
            Size: Get the number of elements in the queue.


    3. Priority Queue: Elements are removed based on priority rather than order of insertion.
        Its operations:
            Enqueue: Add element based on its priority.
            Dequeue: Remove the highest (or lowest) priority element.
            Peek: View the highest (or lowest) priority element without removing it.
            isEmpty: Check if the queue is empty.
            Size: Get the number of elements in the queue.

Note: -In Java, the Queue interface is part of the java.util package and is implemented by various classes
       such as LinkedList, PriorityQueue, and ArrayDeque.
      -Queues are widely used in various applications such as:
        - Task scheduling
        - Handling requests in web servers
        - Managing resources in operating systems
        - Breadth-First Search (BFS) algorithm in graph traversal

 */
import java.util.LinkedList;   
public class Queue {

    public static void main(String[] args) {
        
        //Implementing Simple Queue
        LinkedList<Integer> queue = new LinkedList<>();

        // Enqueue operation
        queue.addLast(10);
        queue.addLast(20);
        queue.addLast(30);
        System.out.println("Queue after enqueuing elements: " + queue);

        // officially we use offer() method to add elements in queue
        // queue.offer(10);
        // queue.offer(20);
        // queue.offer(30);
        // System.out.println("Queue after enqueuing elements using offer(): " + queue);
        // Both addLast() and offer() methods add elements at the end of the queue.

        // Dequeue operation
        int removedElement = queue.removeFirst();
        System.out.println("Dequeued element: " + removedElement);
        System.out.println("Queue after dequeuing an element: " + queue);

        // Peek operation
        int frontElement = queue.getFirst();
        System.out.println("Front element: " + frontElement);

        // Check if the queue is empty
        boolean isEmpty = queue.isEmpty();
        System.out.println("Is the queue empty? " + isEmpty);

        // Get the size of the queue
        int size = queue.size();
        System.out.println("Size of the queue: " + size);

        // Implementing Circular Queue
        // Need to initialize the capacity of circular queue before using it.
        // Because we are using array to implement circular queue.
        // Here is an example of using CircularQueue class defined in CircularQueue.java
        // Make sure to have CircularQueue.java in the same package or import it accordingly.
        // Here i am in a same package so no need to import CircularQueue class.


        // Initialize Circular Queue with capacity 5
        int capacity = 5;
        CircularQueue circularQueue = new CircularQueue(capacity);


        // enqueue() and dequeue() operations on Circular Queue
        circularQueue.enqueue(1);
        circularQueue.enqueue(2);
        circularQueue.enqueue(3);
        circularQueue.enqueue(4);
        circularQueue.enqueue(5);
        System.out.println("Circular Queue after enqueuing elements: " + circularQueue);

        circularQueue.dequeue();
        circularQueue.enqueue(6);
        System.out.println("Circular Queue after dequeuing and enqueuing elements: " + circularQueue);

        // isEmpty and isFull checks can be added in CircularQueue class for better functionality.

        System.out.println("Is Circular Queue empty? " + circularQueue.isEmpty());
        System.out.println("Is Circular Queue full? " + circularQueue.isFull());
        System.out.println("Size of Circular Queue: " + circularQueue.size());  


        // Note: For Priority Queue implementation, you can use Java's built-in PriorityQueue class from java.util package.

        // Example of Priority Queue
        /*
        import java.util.PriorityQueue;
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        */

        //But i am creating a class and using it here is an example of PriorityQueue class defined in PriorityQueue.java
        // Make sure to have PriorityQueue.java in the same package or import it accordingly.
        // Priority queue implementation is using LinkedList in PriorityQueue.java file.

        PriorityQueue priorityQueue = new PriorityQueue();

        // Enqueue elements with priorities
        priorityQueue.enqueue(10, 2); // data: 10, priority: 2
        priorityQueue.enqueue(20, 1); // data: 20, priority: 1
        priorityQueue.enqueue(30, 3); // data: 30, priority: 3
        System.out.println("Priority Queue after enqueuing elements: " + priorityQueue);

        // Priority Queue after enqueuing elements: [(20, 1), (10, 2), (30, 3)]

        //Priority Queue operations
        System.out.println("Dequeued element: " + priorityQueue.dequeue());
        System.out.println("Priority Queue after dequeuing an element: " + priorityQueue);

        System.out.println("Is Priority Queue empty? " + priorityQueue.isEmpty());
        System.out.println("Size of Priority Queue: " + priorityQueue.size());


        // Now Using Java's built-in PriorityQueue for comparison

        // Initialize Java's built-in Priority Queue
        java.util.PriorityQueue<Integer> javaPriorityQueue = new java.util.PriorityQueue<>();

        // Enqueue elements
        javaPriorityQueue.add(10);
        javaPriorityQueue.add(20);
        javaPriorityQueue.add(30);
        System.out.println("Java's built-in Priority Queue: " + javaPriorityQueue);

        // Java's built-in Priority Queue: [10, 20, 30]

        // Dequeue from Java's built-in Priority Queue
        System.out.println("Dequeued element from Java's built-in Priority Queue: " + javaPriorityQueue.poll());
        System.out.println("Java's built-in Priority Queue after dequeuing an element: " + javaPriorityQueue);

        // Check if Java's built-in Priority Queue is empty and its size
        System.out.println("Is Java's built-in Priority Queue empty? " + javaPriorityQueue.isEmpty());
        System.out.println("Size of Java's built-in Priority Queue: " + javaPriorityQueue.size());


    }
}

/*

Note:
 - The CircularQueue and PriorityQueue classes should be defined in their respective files
   (CircularQueue.java and PriorityQueue.java) within the same package or imported accordingly.

 - The CircularQueue class implements a circular queue using an array, while the PriorityQueue
   class implements a priority queue using a linked list.

 - The main method in the Queue class demonstrates how to use these queue implementations
   along with Java's built-in LinkedList and PriorityQueue classes.

 - Prefer offer() method to add elements in queue instead of addLast() for better readability and convention.
   Because offer() is specifically designed for queue operations.And it returns false if the element cannot be added
   due to capacity restrictions, whereas addLast() throws an exception.

*/

/*

Sample output of the above code:


Queue after enqueuing elements: [10, 20, 30]
Dequeued element: 10
Queue after dequeuing an element: [20, 30]
Front element: 20
Is the queue empty? false
Size of the queue: 2

Circular Queue after enqueuing elements: [1, 2, 3, 4, 5]
Circular Queue after dequeuing and enqueuing elements: [6, 2, 3, 4, 5]
Is Circular Queue empty? false
Is Circular Queue full? true
Size of Circular Queue: 5

Priority Queue after enqueuing elements: [(20, 1), (10, 2), (30, 3)]
Dequeued element: 20
Priority Queue after dequeuing an element: [(10, 2), (30, 3)]
Is Priority Queue empty? false
Size of Priority Queue: 2

Java's built-in Priority Queue: [10, 20, 30]
Dequeued element from Java's built-in Priority Queue: 10
Java's built-in Priority Queue after dequeuing an element: [20, 30]
Is Java's built-in Priority Queue empty? false
Size of Java's built-in Priority Queue: 2

*/