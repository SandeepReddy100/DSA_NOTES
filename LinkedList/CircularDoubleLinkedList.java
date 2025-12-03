/*

let discuss about circular doubly linked list:
    - A Circular Doubly Linked List is a type of linked list where each node has two pointers:
      one pointing to the next node and another pointing to the previous node. The last
      node points back to the first node, forming a circular structure.
    - This structure allows for efficient traversal in both directions (forward and backward)
      and provides flexibility in insertion and deletion operations.
    - Head and Tail Pointers are used to keep track of the start and end of the list.
    


Operations on Circular Doubly Linked List:

    1. Insertion at Front
    2. Insertion at End
    3. Deletion from Front
    4. Deletion from End
    5. Traversal (Forward and Backward)
    6. Searching for an Element

*/





package LinkedList;

public class CircularDoubleLinkedList {
    Node head;
    Node tail;

    static class Node {
        int data;
        Node next, prev;

        Node(int d) {
            data = d;
            next = prev = null;
        }
    }

    public CircularDoubleLinkedList() {
        head = tail = null;
    }

    public static void main(String[] args) {
        // creation of Circular Doubly Linked List
        CircularDoubleLinkedList cdll = new CircularDoubleLinkedList();

        // Add elements to the list
        Node newNode1 = new Node(10);
        cdll.head = newNode1;
        cdll.tail = newNode1;
        newNode1.next = newNode1;
        newNode1.prev = newNode1;

        Node newNode2 = new Node(20);
        cdll.tail.next = newNode2;
        newNode2.prev = cdll.tail;
        cdll.tail = newNode2;
        cdll.tail.next = cdll.head;
        cdll.head.prev = cdll.tail;

        // The list now contains two nodes: 10 <-> 20 (circular)

        // Insertion at the front
        Node newNode3 = new Node(5);
        newNode3.next = cdll.head;
        newNode3.prev = cdll.tail;
        cdll.head.prev = newNode3;
        cdll.tail.next = newNode3;
        cdll.head = newNode3;

        // Insertion at the end
        Node newNode4 = new Node(30);
        newNode4.prev = cdll.tail;
        newNode4.next = cdll.head;
        cdll.tail.next = newNode4;
        cdll.head.prev = newNode4;
        cdll.tail = newNode4;

        // Traversal forward
        Node current = cdll.head;
        System.out.print("Forward Traversal: ");
        do {
            System.out.print(current.data + " ");
            current = current.next;
        } while (current != cdll.head);
        System.out.println();

        // Traversal backward
        current = cdll.tail;
        System.out.print("Backward Traversal: ");
        do {
            System.out.print(current.data + " ");
            current = current.prev;
        } while (current != cdll.tail);

        System.out.println();

        // Searching for an element
        int searchKey = 20;
        current = cdll.head;
        boolean found = false;
        do {
            if (current.data == searchKey) {
                found = true;
                break;
            }
            current = current.next;
        } while (current != cdll.head);
        System.out.println("Element " + searchKey + (found ? " found." : " not found."));

    }
}


/*

sample Output:
Forward Traversal: 5 10 20 30
Backward Traversal: 30 20 10 5
Element 20 found.

*/