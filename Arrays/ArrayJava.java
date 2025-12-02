import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.Spliterator;
import java.util.function.Consumer;
import java.util.function.Predicate;

/**
 * ============================================================
 * COMPLETE GUIDE: ARRAY DATA STRUCTURES (JAVA)
 * ============================================================
 * BASED ON: arrjava.pdf, arrlist.pdf
 * * --- THEORY & CONCEPTS ---
 * 
 * * 1. DEFINITION
 * - An array is a linear data structure collecting elements of the same type.
 * - Stored in CONTIGUOUS memory locations.
 * 
 * 
 * * 2. TYPES OF ARRAYS
 * 
 * * A. Static Arrays (Standard Java Arrays): 
 * - Fixed size. Size cannot change once created.
 * - Efficient access O(1).
 * - Stores primitives (values) or Objects (references).
 * 
 * * B. Dynamic Arrays (ArrayList):
 * - Resizable. Grows/Shrinks automatically.
 * - Part of Java Collection Framework (java.util).
 * - Slower than static arrays but more flexible.
 *
 * 
 * * 3. COMPLEXITY CHEAT SHEET
 * - Access (get):       O(1)
 * - Update (set):       O(1)
 * - Insert (End):       O(1)
 * - Insert (Middle):    O(N) (Requires shifting)
 * - Delete (Middle):    O(N) (Requires shifting)
 * 
 * 
 * * 4. ADVANTAGES
 * - Efficient access O(1).
 * - Cache friendly (contiguous memory).
 * - Good for storing data when size is known (Static).
 * 
 * 
 * * 5. DISADVANTAGES
 * - Fixed size (Static).
 * - Shift operations are costly for insert/delete.
 * - Homogeneous (can only store one type).
 */

public class ArrayJava {

    public static void main(String[] args) {
        
        // ============================================================
        // PART 1: STANDARD STATIC ARRAYS (Primitive & Object)
        // ============================================================
        System.out.println("--- PART 1: STANDARD STATIC ARRAYS ---");

        // 1. DECLARATION & INITIALIZATION
        // Method 1: Declare then Allocate (Default values: 0)
        int[] arr = new int[5]; 
        
        // Method 2: Array Literal (Values known upfront)
        int[] literalArr = {10, 20, 30, 40, 50};

        // 2. ACCESS & UPDATE
        System.out.println("Element at index 0: " + literalArr[0]); // Access
        literalArr[1] = 99; // Update index 1
        System.out.println("Updated index 1: " + literalArr[1]);

        // 3. LENGTH PROPERTY (Not a method)
        System.out.println("Array Length: " + literalArr.length);

        // 4. ITERATION
        System.out.print("Traversal: ");
        for(int i : literalArr) {
            System.out.print(i + " ");
        }
        System.out.println();

        // 5. EXCEPTION HANDLING
        // Trying to access index outside size throws ArrayIndexOutOfBoundsException
        try {
            int error = literalArr[100];
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Exception Caught: " + e);
        }

        // 6. MULTIDIMENSIONAL ARRAYS (Matrix)
        int[][] matrix = {
            {1, 2, 3},
            {4, 5, 6}
        };
        System.out.println("Matrix [1][2] (Row 1, Col 2): " + matrix[1][2]); // Output: 6

        // 7. PASSING & RETURNING ARRAYS
        passArray(literalArr);
        int[] returnedArr = getArray();
        System.out.println("Returned array element: " + returnedArr[0]);

        // 8 . Sorting & Searching

        Arrays.sort(literalArr); // Sorts in ascending order
        System.out.println("Sorted Array: " + Arrays.toString(literalArr));
        int index = Arrays.binarySearch(literalArr, 30); // Binary search for 30
        System.out.println("Index of 30 after sorting: " + index);

        // 9. ARRAY UTILITIES
        int[] copyArr = Arrays.copyOf(literalArr, literalArr.length);   
        System.out.println("Copied Array: " + Arrays.toString(copyArr));
        Arrays.fill(copyArr, 0); // Fill with zeros
        System.out.println("Filled Copied Array: " + Arrays.toString(copyArr));

        // 10. CONVERTING BETWEEN ARRAYS & LISTS
        // Array to List    
        ArrayList<Integer> listFromArray = new ArrayList<>(
            Arrays.asList(1, 2, 3, 4, 5)
        );      
        System.out.println("List from Array: " + listFromArray);
        // List to Array        
        Integer[] arrayFromList = listFromArray.toArray(new Integer[0]);
        System.out.println("Array from List: " + Arrays.toString(arrayFromList));   



        // ============================================================
        // PART 2: DYNAMIC ARRAYS (ArrayList) - ALL METHODS
        // ============================================================
        System.out.println("\n--- PART 2: ARRAYLIST COMPLETE METHODS ---");

        // 1. CONSTRUCTORS
        // Default constructor
        ArrayList<String> list = new ArrayList<>(); 
        // Constructor with initial capacity (optimization)
        ArrayList<String> capacityList = new ArrayList<>(20); 
        // Constructor from another collection
        ArrayList<String> copyList = new ArrayList<>(list);

        // --- GROUP A: ADDING ELEMENTS ---
        System.out.println("[Adding Elements]");
        
        // add(E e): Appends to end
        list.add("Java");
        list.add("Python");
        list.add("C++");
        
        // add(int index, E element): Inserts at specific position
        list.add(1, "JavaScript"); // Shifts Python and C++ to right
        
        // addAll(Collection c): Appends all from another list
        ArrayList<String> newLangs = new ArrayList<>();
        newLangs.add("Ruby");
        newLangs.add("Go");
        list.addAll(newLangs);
        
        // addAll(int index, Collection c): Inserts all at position
        list.addAll(0, Arrays.asList("Swift", "Kotlin"));

        System.out.println("Current List: " + list);


        // --- GROUP B: ACCESSING & SEARCHING ---
        System.out.println("\n[Accessing & Searching]");

        // get(int index): Returns element at position
        String val = list.get(2);
        System.out.println("Element at index 2: " + val);

        // set(int index, E element): Replaces element
        list.set(2, "TypeScript"); // Replaces "JavaScript"
        System.out.println("After set(2, TypeScript): " + list);

        // contains(Object o): Returns true if found
        boolean hasJava = list.contains("Java");
        System.out.println("Contains 'Java'? " + hasJava);

        // indexOf(Object o): First occurrence index
        int firstIndex = list.indexOf("Java");
        System.out.println("Index of 'Java': " + firstIndex);

        // lastIndexOf(Object o): Last occurrence index
        list.add("Java"); // Add duplicate to test
        int lastIndex = list.lastIndexOf("Java");
        System.out.println("Last Index of 'Java': " + lastIndex);

        // isEmpty(): Returns true if no elements
        System.out.println("Is list empty? " + list.isEmpty());

        // size(): Number of elements
        System.out.println("Size: " + list.size());


        // --- GROUP C: REMOVING ELEMENTS ---
        System.out.println("\n[Removing Elements]");

        // remove(int index): Removes by position
        list.remove(0); // Removes "Swift"
        System.out.println("After remove(0): " + list);

        // remove(Object o): Removes first occurrence of object
        list.remove("Kotlin");
        System.out.println("After remove('Kotlin'): " + list);

        // removeAll(Collection c): Removes all elements present in c
        list.removeAll(Arrays.asList("Ruby", "Go"));
        System.out.println("After removeAll(Ruby, Go): " + list);

        // removeIf(Predicate filter): Removes elements matching condition (Java 8+)
        // Example: Remove all strings starting with 'J'
        list.removeIf(s -> s.startsWith("J"));
        System.out.println("After removeIf(starts with J): " + list);
        
        // retainAll(Collection c): Keeps ONLY elements in c, removes others
        list.add("Rust");
        list.add("Dart");
        // Only keep Rust and Dart, discard others
        list.retainAll(Arrays.asList("Rust", "Dart")); 
        System.out.println("After retainAll(Rust, Dart): " + list);

        // clear(): Removes everything
        list.clear();
        System.out.println("After clear(): " + list);


        // --- GROUP D: ITERATION ---
        System.out.println("\n[Iteration Methods]");
        // Repopulate for demo
        list.addAll(Arrays.asList("Apple", "Banana", "Cherry", "Date"));

        // listIterator(): Returns a ListIterator (can go forward and back)
        ListIterator<String> it = list.listIterator();
        System.out.print("ListIterator Forward: ");
        while(it.hasNext()) {
            System.out.print(it.next() + " ");
        }
        System.out.println();
        
        // listIterator(int index): Starts at specific position
        ListIterator<String> itFrom1 = list.listIterator(1);
        
        // forEach(Consumer action): Java 8 functional iteration
        System.out.print("forEach Loop: ");
        list.forEach(s -> System.out.print(s + " "));
        System.out.println();

        // spliterator(): Parallel traversal (Advanced)
        Spliterator<String> split = list.spliterator();
        System.out.println("Spliterator estimate size: " + split.estimateSize());


        // --- GROUP E: VIEW & CONVERSION ---
        System.out.println("\n[View & Conversion]");

        // subList(int from, int to): Returns a view of portion
        // Note: Changes to sublist affect original list!
        java.util.List<String> sub = list.subList(1, 3); // Banana, Cherry
        System.out.println("SubList (1 to 3): " + sub);

        // clone(): Shallow copy
        Object clonedList = list.clone();
        System.out.println("Cloned List: " + clonedList);

        // toArray(): Convert to Object array
        Object[] objArr = list.toArray();
        
        // toArray(T[] a): Convert to Typed array (Preferred)
        String[] strArr = list.toArray(new String[0]);
        System.out.println("Converted to Array: " + strArr[0]);


        // --- GROUP F: MEMORY MANAGEMENT ---
        System.out.println("\n[Memory Optimization]");
        
        // ensureCapacity(int min): Pre-allocates memory to avoid resizing
        // Useful if you know you are about to add huge amount of data
        ArrayList<Integer> bigList = new ArrayList<>();
        bigList.ensureCapacity(1000); 
        System.out.println("Capacity ensured for 1000 elements.");

        // trimToSize(): Trims capacity to current size to save memory
        bigList.add(1);
        bigList.add(2);
        // Capacity was 1000, now it's strictly 2
        bigList.trimToSize(); 
        System.out.println("Memory trimmed to size.");


        // --- GROUP G: SORTING AND SEARCHING ---

        // sort(Comparator c): Sorts using custom comparator
        // Example: Sort by string length   

        ArrayList<String> sortList = new ArrayList<>(
            Arrays.asList("Fig", "Banana", "Apple", "Cherry", "Date")
        );
        Collections.sort(sortList, (a, b) -> a.length() - b.length());
        System.out.println("Sorted by length: " + sortList); 
    }   


    // --- HELPER METHODS FOR PART 1 ---

    // Example of passing array to method
    public static void passArray(int[] arr) {
        System.out.println("Inside passArray method. Summing...");
        int sum = 0;
        for(int i : arr) sum += i;
        System.out.println("Sum: " + sum);
    }

    // Example of returning array from method
    public static int[] getArray() {
        return new int[]{100, 200, 300};
    }
}


/*  Sample Output

--- PART 1: STANDARD STATIC ARRAYS ---

Element at index 0: 10
Updated index 1: 99
Array Length: 5
Traversal: 10 99 30 40 50
Exception Caught: java.lang.ArrayIndexOutOfBoundsException: Index 100 out of bounds for length 5
Matrix [1][2] (Row 1, Col 2): 6 
Inside passArray method. Summing...
Sum: 229
Returned array element: 100
Sorted Array: [10, 30, 40, 50, 99]
Index of 30 after sorting: 1
Copied Array: [10, 30, 40, 50, 99]
Filled Copied Array: [0, 0, 0, 0, 0]
List from Array: [1, 2, 3, 4, 5]
Array from List: [1, 2, 3, 4, 5]


--- PART 2: ARRAYLIST COMPLETE METHODS ---

[Adding Elements]
Current List: [Swift, Kotlin, Java, Python, C++, Ruby, Go]  

[Accessing & Searching]
Element at index 2: JavaScript
After set(2, TypeScript): [Swift, Kotlin, TypeScript, Python, C++, Ruby, Go]
Contains 'Java'? true   
Index of 'Java': 2
Last Index of 'Java': 3
Is list empty? false
Size: 7

[Removing Elements]
After remove(0): [Kotlin, TypeScript, Python, C++, Ruby, Go]
After remove('Kotlin'): [TypeScript, Python, C++, Ruby, Go] 
After removeAll(Ruby, Go): [TypeScript, Python, C++]
After removeIf(starts with J): [Python, C++]
After retainAll(Rust, Dart): []
After clear(): []

[Iteration Methods]
ListIterator Forward: Apple Banana Cherry Date
forEach Loop: Apple Banana Cherry Date
Spliterator estimate size: 4

[View & Conversion]
SubList (1 to 3): [Banana, Cherry]
Cloned List: [Apple, Banana, Cherry, Date]
Converted to Array: 
Apple   

[Memory Optimization]
Capacity ensured for 1000 elements.
Memory trimmed to size.

[Sorting and Searching]
sorted by length: [Fig, Date, Apple, Banana, Cherry]


 */


/*  Example Problem: 
        1.Sum of Array Elements
        2. Find Maximum & Minimum in Array
        3. Reverse an Array 
        4. Merge Two Sorted Arrays
        5. Remove Duplicates from Array
        6. Rotate Array by K Positions
        7. Check if Array is Sorted
        8. Find Pair with Given Sum
        9. Find Missing Number in Array
        10. Find Intersection of Two Arrays
    
*/