/*
LinkedList/LinkedList.java
This file defines a basic structure for a singly linked list in Java.

It is Linear data structure.
Each element (node) contains data and a reference (link) to the next node in the sequence.
The first node is called the head, and the last node points to null, indicating the end of the list.
Operations that can be performed on a linked list include:
- Insertion: Adding a new node at the beginning, end, or a specific position.
- Deletion: Removing a node from the beginning, end, or a specific position.
- Traversal: Accessing each node in the list to read or modify its data.
- Searching: Finding a node with a specific value.

- Linked lists are dynamic in size, allowing for efficient memory usage as they can grow and shrink as needed.
- Memory allocation is not contiguous(unlike an array) it store data in nodes and join them with Pointers or Addresses,
  which can lead to better utilization of memory.




  Types of Linked Lists:
    1. Singly Linked List: Each node points to the next node in the sequence.
    2. Doubly Linked List: Each node points to both the next and previous nodes.
    3. Circular Linked List: The last node points back to the first node, forming a circle.

  operations in singly linked list:
    1. Insertion at the beginning
    2. Insertion at the end
    3. Insertion at a specific position
    4. Deletion from the beginning
    5. Deletion from the end
    6. Deletion from a specific position
    7. Traversal
    8. Searching for an element

  operations in doubly linked list:
    1. Insertion at the beginning
    2. Insertion at the end
    3. Insertion at a specific position
    4. Deletion from the beginning
    5. Deletion from the end
    6. Deletion from a specific position
    7. Traversal (forward and backward)
    8. Searching for an element

  operations in circular linked list:
    1. Insertion at the beginning
    2. Insertion at the end
    3. Insertion at a specific position
    4. Deletion from the beginning  
    5. Deletion from the end
    6. Deletion from a specific position
    7. Traversal
    8. Searching for an element

*/


package LinkedList;
public class LinkedList {
    Node head;

    static class Node {
        int data;
        Node next;

        Node(int d) {
            data = d;
            next = null;
        }
    }

    public static void main(String[] args) {


        // conversion of array to linked list
        int[] arr = {10, 20, 30, 40, 50};
        LinkedList arrayList = new LinkedList();  
        Node current = null;
        for (int value : arr) {
            Node newNode = new Node(value);
            if (arrayList.head == null) {
                arrayList.head = newNode;
                current = arrayList.head;
            } else {
                current.next = newNode;
                current = newNode;
            }
        }

        // Add nodes to the LinkedList
        
        LinkedList list = new LinkedList();
        list.head = new Node(1);
        list.head.next = new Node(2);
        list.head.next.next = new Node(3);


        // Print the LinkedList
        Node node = list.head;
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }

        // Insert a new node at the end ---  Find the last Position so we haave to traverse the whole linked list
        Node newNode = new Node(4);
        Node last = list.head;
        while (last.next != null) {
            last = last.next;
        }
        last.next = newNode;

        // Print after insertion at the end
        System.out.println("\nAfter insertion at the end:");
        node = list.head;
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }

        // Insertion at the beginning
        Node begNode = new Node(0);
        begNode.next = list.head;
        list.head = begNode;

        // Print after insertion at the beginning
        System.out.println("\nAfter insertion at the beginning:");  
        node = list.head;
        while (node != null) {  
            System.out.print(node.data + " ");
            node = node.next;
        }

        // Insertion at a specific position (after 2nd node)  --- insertion at kth position so we have to traverese to kth position.
        Node specNode = new Node(1);
        Node CurrNode = list.head;
        for (int i = 0; i < 2; i++) {
            CurrNode = CurrNode.next;
        }
        specNode.next = CurrNode.next;
        CurrNode.next = specNode;

        // Print after insertion at a specific position
        System.out.println("\nAfter insertion at a specific position:");
        node = list.head;
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }

        // Deletion from the beginning
        list.head = list.head.next;
        System.out.println("\nAfter deletion from the beginning:");
        node = list.head; 
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }

        // Deletion from the end
        Node temp = list.head;
        while(temp.next.next != null) {
            temp = temp.next;
        }
        temp.next = null;
        System.out.println("\nAfter deletion from the end:");
        node = list.head;
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }

        // Deletion from a specific position (2nd position)
        Node temp2 = list.head;
        for (int i = 0; i < 1; i++) {
            temp2 = temp2.next;
        }
        temp2.next = temp2.next.next;
        System.out.println("\nAfter deletion from a specific position:");
        node = list.head;
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }

        // Forward Traversal
        System.out.println("\nForward Traversal:");
        node = list.head;
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.next; 

        }

        // Backward Traversal is not possible in singly linked list as we dont have any pointer to previous node.

        // Searching for an element (e.g., 2)
        int searchValue = 2;
        node = list.head;
        boolean found = false;
        while (node != null) {
            if (node.data == searchValue) {
                found = true;
                break;
            }
            node = node.next;
        }
        if (found) {
            System.out.println("\nElement " + searchValue + " found in the list.");
        } else {
            System.out.println("\nElement " + searchValue + " not found in the list.");
        }

    }

}




/*

Sample Output:
1 2 3 
After insertion at the end: 1 2 3 4
After insertion at the beginning: 0 1 2 3 4
After insertion at a specific position: 0 1 1 2 3 4
After deletion from the beginning: 1 1 2 3 4
After deletion from the end: 1 1 2 3
After deletion from a specific position: 1 2 3
Forward Traversal: 1 2 3
Element 2 found in the list.


*/
