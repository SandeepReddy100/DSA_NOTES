/*

let discuss about the stack data structure in java.

Stack is a linear data structure that follows the Last In First Out (LIFO) principle.
    - This means that the last element added to the stack will be the first one to be removed.
    - Elements can only be added or removed from the top of the stack.
    It supports two primary operations:
        1. Push: Adds an element to the top of the stack.
        2. Pop: Removes and returns the top element of the stack.

        Additional operations that can be performed on a stack include:
        3. Peek/Top: Returns the top element without removing it.
        4. isEmpty: Checks if the stack is empty.
        5. Size: Returns the number of elements in the stack.

    Stacks are commonly used in various applications such as:
        - Function call management (call stack)
        - Expression evaluation and syntax parsing
        - Backtracking algorithms (e.g., maze solving, puzzle solving)
        - Undo/Redo functionality in applications


Explanation of process of reversing a stack without using another stack:


1. Base Case: If the stack is empty, return. This is the base case for our recursive function.

2. Pop the Bottom Element: We define a helper function popBottom that removes and returns the 
    bottom element of the stack. This function works by recursively popping elements from the top 
    until it reaches the bottom element. Once the bottom element is found, it is returned, 
    and all other elements are pushed back onto the stack in their original order.

3. Recursive Call: After popping the bottom element, we make a recursive call to 
    reverseStackWithoutExtraSpace to reverse the remaining stack.

4. Push the Bottom Element: After the recursive call returns, we push the previously popped 
    bottom element back onto the top of the stack. This effectively places the bottom element at 
    the top, contributing to the reversal of the stack.

5. Repeat: The process repeats until all elements have been processed and the stack is fully 
    reversed.  


*/


package Stack;
import java.util.Stack;
public class stack {
    
    // Function to reverse a stack without using another stack
    public static void reverseStackWithoutExtraSpace(Stack<Integer> stack) {
        if (stack.isEmpty()) {
            return;
        }
        int bottom = popBottom(stack);
        reverseStackWithoutExtraSpace(stack);
        stack.push(bottom);
    }
    public static int popBottom(Stack<Integer> stack) {
        int top = stack.pop();
        if (stack.isEmpty()) {
            return top;
        } else {
            int bottom = popBottom(stack);
            stack.push(top);
            return bottom;
        }
    }
    public static void main(String[] args) {
        System.out.println("This is stack data structure in java");

        // create a stack
        Stack<Integer> stack = new Stack<>();

        // push elements onto the stack
        stack.push(10);
        stack.push(20);
        stack.push(30);
        System.out.println("Stack after pushing elements: " + stack);

        // pop an element from the stack
        int poppedElement = stack.pop();
        System.out.println("Popped element: " + poppedElement);
        System.out.println("Stack after popping an element: " + stack);

        // peek at the top element of the stack
        int topElement = stack.peek();
        System.out.println("Top element: " + topElement);

        // check if the stack is empty
        boolean isEmpty = stack.isEmpty();
        System.out.println("Is the stack empty? " + isEmpty);

        // get the size of the stack
        int size = stack.size();
        System.out.println("Size of the stack: " + size);

        // reverse the stack
        Stack<Integer> reversedStack = new Stack<>();
        while (!stack.isEmpty()) {
            reversedStack.push(stack.pop());
        }
        System.out.println("Reversed stack: " + reversedStack);

        //search for an element in the stack
        int searchElement = 20;
        int position = reversedStack.search(searchElement);
        if (position != -1) {
            System.out.println("Element " + searchElement + " found at position: " + position);
        } else {
            System.out.println("Element " + searchElement + " not found in the stack.");
        }

        // clear the stack
        reversedStack.clear();

        System.out.println("Stack after clearing: " + reversedStack);

        // reverse stack without using another stack
        stack.push(10);
        stack.push(20);
        stack.push(30);
        reverseStackWithoutExtraSpace(stack);
        System.out.println("Reversed stack without extra space: " + stack);
    }
}
