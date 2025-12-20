/*

Explanation of Recursion:
 - Recursion is a programming technique where a method calls itself in order to solve a problem.
 - It is commonly used for problems that can be broken down into smaller, similar subproblems.

    - A recursive method typically has two main components:
    1. Base Case: This is the condition under which the recursion stops. It prevents infinite loops and ensures that the method eventually terminates.
    2. Recursive Case: This is where the method calls itself with modified arguments, gradually approaching the base case.

    - Example of a simple recursive method to calculate the factorial of a number:
    public static int factorial(int n) {
        // Base case
        if (n == 0) {
            return 1;
        }
        // Recursive case
        return n * factorial(n - 1);
    }


    Types of Recursion:
    1. Direct Recursion: A method calls itself directly.
    2. Indirect Recursion: A method calls another method, which in turn calls the first method.
    3. Tail Recursion: The recursive call is the last operation in the method. This can be optimized 
       by the compiler to avoid increasing the call stack.
    
    Advantages of Recursion:
    - Simplifies code and makes it easier to read and maintain.
    - Useful for problems that have a natural recursive structure, such as tree traversals and combinatorial problems.

    Disadvantages of Recursion:
    - Can lead to high memory usage due to call stack growth.
    - May be less efficient than iterative solutions for certain problems due to overhead of multiple method calls.
    - Can cause stack overflow errors if the recursion depth is too large.

    Most Popular Problems Solved Using Recursion:
    1. Factorial Calculation
    2. Fibonacci Sequence
    3. Tower of Hanoi
    4. Tree Traversals (Preorder, Inorder, Postorder)
    - Graph Traversals (Depth-First Search)
    - Backtracking Problems (N-Queens, Sudoku Solver)
    - Merge Sort and Quick Sort


*/

package Recurssion;

public class Recurssion {

    // Example recursive method to calculate factorial
    public static int factorial(int n) {
        // Base case
        if (n == 0) {
            return 1;
        }
        // Recursive case
        return n * factorial(n - 1);
    }

    // Example recursive method to calculate Fibonacci numbers
    public static int fibonacci(int n) {
        // Base cases
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        // Recursive case
        return fibonacci(n - 1) + fibonacci(n - 2);
    }

    // Example recursive method for Tower of Hanoi
    // Problem Explanation:
    // Move n disks from source peg to destination peg using auxiliary peg
    
}
