/*

    Implementation of Deque (Double-Ended Queue) using Doubly Linked List
Types of Linked Lists:
    1. Singly Linked List: Each node points to the next node in the sequence
    2. Doubly Linked List: Each node points to both the next and previous nodes.
    3. Circular Linked List: The last node points back to the first node, forming
         a circle.

    Let Discuss About The Double Ended Queue (Deque):
    - A Deque (Double-Ended Queue) is a linear data structure that allows insertion 
    and deletion of elements from both ends (front and rear). 
    - It combines the properties of both stacks and queues, providing more flexibility in data management.
    - Deque supports operations such as adding and removing elements from both ends, making it suitable for scenarios where elements need to be processed in a 
    non-linear order.
    - Contain Front and Rear Pointers to keep track of both ends of the Deque.


Operations on Deque:
    1. Insertion at the front
    2. Insertion at the rear
    3. Deletion from the front
    4. Deletion from the rear
    5. Traversal from front to rear
    6. Traversal from rear to front
    7. Checking if the Deque is empty
    8. Getting the size of the Deque
    9. Searching for an element in the Deque




*/



package LinkedList;

public class Deque {
    Node front, rear;
    int size;

    static class Node {
        int data;
        Node next, prev;

        Node(int d) {
            data = d;
            next = prev = null;
        }
    }

    public Deque() {
        front = rear = null;
        size = 0;
    }

    public static void main(String[] args) {

        // creation of Deque
        Deque deque = new Deque();

        // Add elements to the front
        Node newNode1 = new Node(10);
        deque.front = newNode1;
        deque.rear = newNode1;
        deque.size++;

        // Add elements to the rear
        Node newNode2 = new Node(20);
        deque.rear.next = newNode2;
        newNode2.prev = deque.rear;
        deque.rear = newNode2;
        deque.size++;

        // Print Deque from front to rear
        Node current = deque.front;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }

        // Add elements to the front
        Node newNode3 = new Node(5);
        deque.front.prev = newNode3;
        newNode3.next = deque.front;
        deque.front = newNode3;
        deque.size++;

        // Print Deque from front to rear after adding at front
        System.out.println();
        current = deque.front;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }

        // Delete from rear
        if (deque.rear != null) {
            deque.rear = deque.rear.prev;
            if (deque.rear != null) {
                deque.rear.next = null;
            } else {
                deque.front = null; // Deque is now empty
            }
            deque.size--;
        }

        // Print Deque from front to rear after deletion from rear
        System.out.println();   
        current = deque.front;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();

        // traverse from rear to front
        current = deque.rear;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.prev;
        }
        System.out.println();

        // traverse from front to rear
        current = deque.front;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();

        // Print size of Deque
        System.out.println("Size of Deque: " + deque.size);

        // isEmpty check
        System.out.println("Is Deque empty? " + (deque.size == 0));

        // Search for an element
        int searchElement = 20;
        current = deque.front;
        boolean found = false;
        while (current != null) {
            if (current.data == searchElement) {
                found = true;
                break;
            }
            current = current.next;
        }
        System.out.println("Element " + searchElement + (found ? " found in Deque." : " not found in Deque."));






    }
}




/*

sample Output:
5 10 20
5 10 20
5 10
20 10 5
5 10
Size of Deque: 2
Is Deque empty? false
Element 20 found in Deque.

*/