"""
* Arrays in Python (Lists)

* --- THEORY & CONCEPTS ---


* * 1. DEFINITION
* - In Python, Arrays are implemented as 'Lists'.
* - A List is a built-in data structure that holds an ORDERED collection of items.
* - Unlike Java arrays, Python lists are DYNAMIC (resizable) and HETEROGENEOUS (can mix types).


* * 2. MEMORY STRUCTURE
* - Python lists store REFERENCES (memory addresses) to objects, not the values themselves.
* - This allows them to hold mixed types (e.g., [1, "Hello", True]).


* * 3. COMPLEXITY CHEAT SHEET
* - Access (index):     O(1)
* - Update (index):     O(1)
* - Append (End):       O(1)
* - Insert (Middle):    O(N) (Requires shifting)
* - Delete (Middle):    O(N) (Requires shifting)


* * 4. KEY FEATURES
* - Mutable: Can change elements after creation.
* - Ordered: Maintains insertion order.
* - Slicing: Powerful feature to extract sub-parts of the list.
"""

import copy # Used for deep copy demonstration

def main():
    
    print("--- PART 1: CREATION & BASICS ---")

    # 1. DECLARATION
    # Method 1: Square Brackets (Most common)
    my_list = [10, 20, 30, 40, 50]
    
    # Method 2: Constructor (Useful for converting other types)
    constructor_list = list((1, 2, 3)) 
    
    # Method 3: Mixed Types (Heterogeneous)
    mixed_list = [1, "Hello", 3.14, True]

    # 2. ACCESSING ELEMENTS (Zero-based Indexing)
    print(f"Element at index 0: {my_list[0]}")
    
    # Negative Indexing (Python Specific Feature)
    # -1 is last, -2 is second to last
    print(f"Last element (-1): {my_list[-1]}") 

    # 3. UPDATING ELEMENTS
    my_list[1] = 99
    print(f"Updated index 1 to 99: {my_list}")

    # 4. LENGTH
    print(f"Length of list: {len(my_list)}")


    # ============================================================
    # PART 2: LIST METHODS (OPERATIONS)
    # ============================================================

    print("\n--- PART 2: LIST METHODS ---")

    # --- GROUP A: ADDING ELEMENTS ---
    print("[Adding Elements]")
    
    # append(val): Adds to the END
    my_list.append(60)
    
    # insert(index, val): Adds at specific position (Shifts others right)
    my_list.insert(1, 15) # Insert 15 at index 1
    
    # extend(iterable): Adds multiple elements to the end
    my_list.extend([70, 80])
    print(f"After Additions: {my_list}")


    # --- GROUP B: REMOVING ELEMENTS ---
    print("\n[Removing Elements]")
    
    # remove(val): Removes FIRST occurrence of the value
    # Throws ValueError if not found
    if 99 in my_list:
        my_list.remove(99)
    print(f"After remove(99): {my_list}")

    # pop(index): Removes AND returns element at index
    # If no index is given, removes the last element (pop())
    popped_val = my_list.pop(0) 
    print(f"Popped index 0 (Value: {popped_val}): {my_list}")

    # del keyword: Deletes element or slice (Not a method, but a statement)
    del my_list[0]
    print(f"After del my_list[0]: {my_list}")

    # clear(): Removes all elements
    temp_list = [1, 2, 3]
    temp_list.clear()
    print(f"After clear(): {temp_list}")


    # --- GROUP C: SEARCHING & INFORMATION ---
    print("\n[Searching & Info]")
    
    search_list = [10, 20, 30, 20, 40, 20]
    
    # index(val): Returns index of first occurrence
    # Optional: index(val, start, end)
    idx = search_list.index(30)
    print(f"Index of 30: {idx}")
    
    # count(val): Returns number of times value appears
    count_20 = search_list.count(20)
    print(f"Count of 20: {count_20}")
    
    # 'in' operator: Check existence (Boolean)
    print(f"Is 40 in list? {40 in search_list}")


    # --- GROUP D: SORTING & REVERSING ---
    print("\n[Sorting & Reversing]")
    
    sort_list = [3, 1, 4, 1, 5, 9, 2]
    
    # reverse(): Reverses list IN-PLACE
    sort_list.reverse()
    print(f"Reversed: {sort_list}")
    
    # sort(): Sorts list IN-PLACE (Ascending default)
    sort_list.sort()
    print(f"Sorted (Ascending): {sort_list}")
    
    # sort(reverse=True): Sorts Descending
    sort_list.sort(reverse=True)
    print(f"Sorted (Descending): {sort_list}")
    
    # Custom Sort: sort(key=...)
    words = ["banana", "pie", "apple"]
    words.sort(key=len) # Sort by length of string
    print(f"Sorted by length: {words}")


    # ============================================================
    # PART 3: SLICING (PYTHON EXCLUSIVE POWER)
    # ============================================================

    print("\n--- PART 3: SLICING ---")
    # Syntax: list[start : stop : step]
    # start is inclusive, stop is exclusive
    
    data = [0, 10, 20, 30, 40, 50, 60, 70, 80, 90]
    
    print(f"Original: {data}")
    print(f"Slice [2:5]: {data[2:5]}")   # Indices 2, 3, 4
    print(f"Slice [:3]:  {data[:3]}")    # Start to 3 (exclusive)
    print(f"Slice [5:]:  {data[5:]}")    # 5 to End
    print(f"Step [::2]:  {data[::2]}")   # Every 2nd element
    print(f"Reverse [::-1]: {data[::-1]}") # Reverse list using slice


    # ============================================================
    # PART 4: ITERATION & COMPREHENSION
    # ============================================================

    print("\n--- PART 4: ITERATION ---")
    
    # Method 1: Standard For Loop (Iterate by Item)
    print("Standard Loop:", end=" ")
    for item in words:
        print(item, end=" ")
    print()

    # Method 2: Loop with Index (enumerate)
    print("Enumerate:", end=" ")
    for i, val in enumerate(words):
        print(f"[{i}:{val}]", end=" ")
    print()

    # Method 3: List Comprehension (One-liner creation)
    # [expression for item in iterable if condition]
    squares = [x**2 for x in range(1, 6)]
    print(f"List Comprehension (Squares): {squares}")
    
    # Comprehension with filtering (Even numbers only)
    evens = [x for x in range(10) if x % 2 == 0]
    print(f"Comprehension (Evens): {evens}")


    # ============================================================
    # PART 5: MULTIDIMENSIONAL LISTS (MATRICES)
    # ============================================================

    print("\n--- PART 5: NESTED LISTS ---")
    
    matrix = [
        [1, 2, 3],
        [4, 5, 6],
        [7, 8, 9]
    ]
    
    # Access: matrix[row][col]
    print(f"Element at Row 1, Col 2: {matrix[1][2]}") # Output: 6
    
    # Iterating a matrix
    print("Matrix Elements:")
    for row in matrix:
        print(row)


    # ============================================================
    # PART 6: COPYING LISTS
    # ============================================================

    print("\n--- PART 6: COPYING ---")
    
    original = [1, 2, 3]
    
    # WARNING: Direct assignment creates a reference, not a copy!
    ref_copy = original 
    ref_copy[0] = 99
    print(f"Original changed via reference: {original}") # [99, 2, 3]
    
    # Correct Shallow Copy methods:
    copy1 = original.copy()
    copy2 = list(original)
    copy3 = original[:]
    
    copy1[0] = 100
    print(f"Original remains safe after shallow copy: {original}") # Still [99, 2, 3]

# ============================================================
# EXECUTION ENTRY POINT
# ============================================================
if __name__ == "__main__":
    main()





""" Sample Output

          --- PART 1: CREATION & BASICS ---
          Element at index 0: 10
          Last element (-1): 50
          Updated index 1 to 99: [10, 99, 30, 40, 50]
          Length of list: 5

          
          --- PART 2: LIST METHODS ---
          [Adding Elements]
          After Additions: [10, 15, 30, 40, 50, 60, 70, 80]
          [Removing Elements]
          After remove(99): [10, 15, 30, 40, 50, 60, 70, 80]
          Popped index 0 (Value: 10): [15, 30, 40, 50, 60, 70, 80]
          After del my_list[0]: [30, 40, 50, 60, 70, 80]
          After clear(): []
          [Searching & Info]
          Index of 30: 2
          Count of 20: 3
          Is 40 in list? True
          [Sorting & Reversing]
          Reversed: [2, 9, 5, 1, 4, 1, 3]
          Sorted (Ascending): [1, 1, 2, 3, 4, 5, 9]
          Sorted (Descending): [9, 5, 4, 3, 2, 1, 1]
          Sorted by length: ['pie', 'apple', 'banana']

          
          --- PART 3: SLICING ---
          Original: [0, 10, 20, 30, 40, 50, 60, 70, 80, 90]
          Slice [2:5]: [20, 30, 40]
          Slice [:3]:  [0, 10, 20]
          Slice [5:]:  [50, 60, 70, 80, 90]
          Step [::2]:  [0, 20, 40, 60, 80]
          Reverse [::-1]: [90, 80, 70, 60, 50, 40, 30, 20, 10, 0]


          --- PART 4: ITERATION ---
          Standard Loop: banana pie apple 
          Enumerate: [0:banana] [1:pie] [2:apple]   
          List Comprehension (Squares): [1, 4, 9, 16, 25]
          Comprehension (Evens): [0, 2, 4, 6, 8]


          --- PART 5: NESTED LISTS ---
          Element at Row 1, Col 2: 6    
          Matrix Elements:
          [1, 2, 3]
          [4, 5, 6]
          [7, 8, 9] 

          
          --- PART 6: COPYING ---
          Original changed via reference: [99, 2, 3]
          Original remains safe after shallow copy: [99, 2, 3]
"""


"""
  ---Example Problems---
  1. Given a list of integers, write a function to return a new list containing only the even numbers from the original list.
  2. Write a function that takes a list of strings and returns a new list with the strings sorted by their lengths in ascending order.
  3. Create a 3x3 matrix (nested list) and write a function to calculate the sum of all its elements.

"""