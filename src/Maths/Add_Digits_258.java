package Maths;

class AddDigits {
    public static int addDigits(int num) {
        // Base case: If the number is zero, the result is zero
        if (num == 0) return 0;

        // Calculate the digit root using the mathematical formula
        return 1 + (num - 1) % 9;
    }
    public static void main(String[] args) {
        int num = 38; // Example input
        System.out.println("Single-digit result: " + addDigits(num)); // Output: 2
    }
}

/*
**Problem Statement**
Given a non-negative integer `num`, repeatedly add all its digits until ->(the result has only one digit.) Return that single-digit result.



### **Approach**
1. **Digit Root Concept**:
   - The process of repeatedly summing the digits of a number until a single-digit result is obtained is equivalent to finding the **digit root** of the number.
   - The digit root has a mathematical property derived from modular arithmetic:
     - If `num == 0`, the result is `0`.
     - Otherwise, the result can be calculated as \(1 + (num - 1) \% 9\).

2. **Reasoning**:
   - The formula leverages the fact that the number `9` is the base of our decimal system, and the repeated summation of digits essentially reduces the number modulo `9` with some adjustments.

3. **Optimizations**:
   - The above formula is a constant time solution, \(O(1)\), as it avoids the iterative process of summing digits multiple times.

**Complexity Analysis**

1. **Time Complexity**:
   - \(O(1)\): The solution involves a constant-time arithmetic operation, regardless of the size of `num`.

2. **Space Complexity**:
   - \(O(1)\): No additional data structures are used; the computation uses only a fixed amount of memory.



### **Alternative Approach**

If you don't use the mathematical formula, an iterative approach could sum the digits repeatedly until the number is a single digit. However, this approach is less efficient, as its time complexity depends on the number of digits in `num`.
.
 */
