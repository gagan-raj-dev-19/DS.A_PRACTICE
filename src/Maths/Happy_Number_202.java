package Maths;

import java.util.HashSet;
import java.util.Set;

class HappyNumber {
    public boolean isHappy(int n) {
        // Set to store already seen numbers
        Set<Integer> seen = new HashSet<>();

        // Iterate until n becomes 1 or a cycle is detected
        while (n != 1 && !seen.contains(n)) {
            seen.add(n); // Add the current number to the set
            n = sumOfSquares(n); // Calculate the sum of the squares of digits
        }

        // Return true if n becomes 1, otherwise false
        return n == 1;
    }

    // Helper function to compute the sum of the squares of the digits of a number
    public static int sumOfSquares(int num) {
        int sum = 0;
        while (num > 0) {
            int digit = num % 10; // Extract the last digit
            sum += digit * digit; // Add the square of the digit
            num /= 10; // Remove the last digit
        }
        return sum;
    }
    public static void main(String[] args) {
        HappyNumber  obj = new HappyNumber();
        int n = 19;
        System.out.println(obj.isHappy(n));  // Output: true
    }

}

/*
Problem Statement:
The task is to determine whether a given number `n` is a **happy number**. A number is called a happy number if, after repeatedly replacing it with the sum of the squares of its digits, it eventually becomes 1. If it loops endlessly without reaching 1, it is not a happy number.

---

 Approach:
1. **Thought Process**:
   - For each number, calculate the sum of the squares of its digits.
   - If the result becomes 1, the number is happy.
   - If the number enters a cycle (repeating values), it is not happy. Detect cycles using a `Set`.

2. **Optimization**:
   - Use a `Set` to track already seen numbers to prevent infinite loops.
   - If `n` becomes 1, stop the process early.

3. **Algorithm**:
   - Create a `Set` to store numbers that have already been computed.
   - While `n` is not 1 and hasn’t been seen before:
     - Add `n` to the `Set`.
     - Replace `n` with the sum of the squares of its digits.
   - If the loop exits because `n == 1`, return true.
   - If the loop exits because of a cycle, return false.


Complexity Analysis:

1. **Time Complexity**:
   - **Sum of Squares Calculation**: For each number, extracting digits takes \(O(\log_{10}(n))\) time (since there are \(\log_{10}(n)\) digits).
   - **Number of Iterations**: Each new `n` is smaller than the previous one. Empirically, for happy numbers, this process is logarithmic. For unhappy numbers, there are a limited number of unique values before a cycle is detected (e.g., the cycle for 19 is small).
   - **Overall**: \(O(\log n \cdot k)\), where \(k\) is the number of iterations.

2. **Space Complexity**:
   - **Set to Track Seen Numbers**: Stores a limited number of values (typically less than 100 for inputs like 19 or 7).
   - **Overall**: \(O(k)\), where \(k\) is the number of iterations.

---

 Example Walkthrough:

 Input: `n = 19`
1. Start with `n = 19`, compute sum of squares: \(1^2 + 9^2 = 82\).
2. Next `n = 82`, compute: \(8^2 + 2^2 = 68\).
3. Next `n = 68`, compute: \(6^2 + 8^2 = 100\).
4. Next `n = 100`, compute: \(1^2 + 0^2 + 0^2 = 1\).
5. Result: `true`.

 Input: `n = 2`
1. Start with `n = 2`, compute sum of squares: \(2^2 = 4\).
2. Next `n = 4`, compute: \(4^2 = 16\).
3. Next `n = 16`, compute: \(1^2 + 6^2 = 37\).
4. Next `n = 37`, compute: \(3^2 + 7^2 = 58\).
5. Next `n = 58`, compute: \(5^2 + 8^2 = 89\), and so on.
6. Eventually enters a cycle (`4 → 16 → 37 → 58 → 89 → ...`).
7. Result: `false`.

---

This solution efficiently handles both happy and non-happy numbers while maintaining clear logic and modularity.

 */