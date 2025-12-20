/*

Implementing Binary Tree structure in Java

 - Binary Tree is a tree data structure where each node has at most two children, referred to as the 
   left child and the right child.
 - The root node is the topmost node in the tree.
 - A leaf node is a node that has no children.
 - The height of a binary tree is the number of edges on the longest path from the root to a leaf.

    Types of Binary Trees:
        1. Full Binary Tree: Every node has either 0 or 2 children.
        2. Perfect Binary Tree: All internal nodes have 2 children and all leaf nodes are at the same level.
        3. Complete Binary Tree: All levels are fully filled except possibly for the last level, which is filled from left to right.
        4. Balanced Binary Tree: The height of the two subtrees of any node never differs by more than one.

    Common Operations on Binary Trees:
        1. Insertion: Adding a new node to the tree.
        2. Deletion: Removing a node from the tree.
        3. Traversal: Visiting all nodes in a specific order (in-order, pre-order, post-order, level-order).
        4. Searching: Finding a node with a specific value.
        5. Height Calculation: Determining the height of the tree.
        6. Node Count: Counting the number of nodes in the tree.
    To Implement a Binary Tree:
        - Define a Node class to represent each node in the tree.
        - Implement methods for the desired operations based on the type of binary tree.
        - Use recursion or iterative approaches as needed for traversal and other operations.

    Traversal Methods:
        1. In-order Traversal (Left, Root, Right)
        2. Pre-order Traversal (Root, Left, Right)
        3. Post-order Traversal (Left, Right, Root)
        4. Level-order Traversal (Breadth-First)

*/

package Trees;

public class BinaryTree {

    class Node {
        int data;
        Node left, right;
        Node(int item) {
            data = item;
            left = right = null;
        }
    }
    Node root;
    public BinaryTree() {
        root = null;
    }

    private Node insertRec(Node root2, int data) {
        if (root2 == null) {
            root2 = new Node(data);
            return root2;
        }
        if (data < root2.data) {
            root2.left = insertRec(root2.left, data);
        } else if (data > root2.data) {
            root2.right = insertRec(root2.right, data);
        }
        return root2;
    }



    private Node deleteRec(Node left, int data) {
        if (left == null) {
            return left;
        }
        if (data < left.data) {
            left.left = deleteRec(left.left, data);
        } else if (data > left.data) {
            left.right = deleteRec(left.right, data);
        } else {
            if (left.left == null)
                return left.right;
            else if (left.right == null)
                return left.left;
            left.data = minValue(left.right);
            left.right = deleteRec(left.right, left.data);
        }
        return left;
    }

    private int minValue(Node right) {
        int minv = right.data;
        while (right.left != null) {
            minv = right.left.data;
            right = right.left;
        }
        return minv;
    }

    public void insert(int data) {
        root = insertRec(root, data);
    }

    public void delete(int data) {
        root = deleteRec(root, data);
    }

    //Traversal methods can be added here (in-order, pre-order, post-order, level-order) using recursion.

    private void inorderRec(Node root2) {
        if (root2 != null) {
            inorderRec(root2.left);
            System.out.print(root2.data + " ");
            inorderRec(root2.right);
        }
    }
    public void inorder()  {
        inorderRec(root);
    }

    private void preorderRec(Node root2) {
        if (root2 != null) {
            System.out.print(root2.data + " ");
            preorderRec(root2.left);
            preorderRec(root2.right);
        }
    }
    public void preorder()  {
        preorderRec(root);
    }

    private void postorderRec(Node root2) {
        if (root2 != null) {
            postorderRec(root2.left);
            postorderRec(root2.right);
            System.out.print(root2.data + " ");
        }
    }
    public void postorder()  {
        postorderRec(root);
    }

    private void levelOrderRec(Node root2) {
        if (root2 == null) return;
        java.util.Queue<Node> queue = new java.util.LinkedList<>();
        queue.add(root2);
        while (!queue.isEmpty()) {
            Node tempNode = queue.poll();
            System.out.print(tempNode.data + " ");
            if (tempNode.left != null) {
                queue.add(tempNode.left);
            }
            if (tempNode.right != null) {
                queue.add(tempNode.right);
            }
        }
    }
    public void levelOrder()  {
        levelOrderRec(root);
    }


    // Traversal methods using stacks.


    private void inorderIterative() {
        java.util.Stack<Node> stack = new java.util.Stack<>();
        Node current = root;
        while (current != null || !stack.isEmpty()) {
            while (current != null) {
                stack.push(current);
                current = current.left;
            }
            current = stack.pop();
            System.out.print(current.data + " ");
            current = current.right;
        }
    }
    public void inorderIter() {
        inorderIterative();
    }

    private void preorderIterative() {
        if (root == null) return;
        java.util.Stack<Node> stack = new java.util.Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            Node node = stack.pop();
            System.out.print(node.data + " ");
            if (node.right != null) {
                stack.push(node.right);
            }
            if (node.left != null) {
                stack.push(node.left);
            }
        }
    }
    public void preorderIter() {
        preorderIterative();
    }

    private void postorderIterative() {
        if (root == null) return;
        java.util.Stack<Node> stack1 = new java.util.Stack<>();
        java.util.Stack<Node> stack2 = new java.util.Stack<>();
        stack1.push(root);
        while (!stack1.isEmpty()) {
            Node node = stack1.pop();
            stack2.push(node);
            if (node.left != null) {
                stack1.push(node.left);
            }
            if (node.right != null) {
                stack1.push(node.right);
            }
        }
        while (!stack2.isEmpty()) {
            Node node = stack2.pop();
            System.out.print(node.data + " ");
        }
    }

    public void postorderIter() {
        postorderIterative();
    }

    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();

        // Inserting nodes
        tree.insert(50);
        tree.insert(30);
        tree.insert(20);
        tree.insert(40);
        tree.insert(70);
        tree.insert(60);
        tree.insert(80);

        // Deleting a node
        tree.delete(20);
        tree.delete(30);
        tree.delete(50);

        // The tree can be traversed or printed as needed

        System.out.println("In-order traversal:");
        tree.inorder();
        System.out.println("\nPre-order traversal:");
        tree.preorder();
        System.out.println("\nPost-order traversal:");
        tree.postorder();
        System.out.println("\nLevel-order traversal:");
        tree.levelOrder();


        System.out.println("\nIn-order traversal (Iterative):");
        tree.inorderIter();
        System.out.println("\nPre-order traversal (Iterative):");
        tree.preorderIter();
        System.out.println("\nPost-order traversal (Iterative):");
        tree.postorderIter();

    }

}