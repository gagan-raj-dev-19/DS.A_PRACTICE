package Arrays.Easy;

import java.util.Arrays;

class PLUSONE {
    public int[] plusOne(int[] digits) {
        int n = digits.length;

        // Traverse the array from the last digit to the first
        for (int i = n - 1; i >= 0; i--) {
            if (digits[i] < 9) {
                // Increment the current digit and return the result
                digits[i]++;
                return digits;
            }
            // Set the current digit to 0 and carry over
            digits[i] = 0;
        }

        // Handle the case where all digits are 9
        int[] result = new int[n + 1];
        result[0] = 1; // The new most significant digit
        return result;
    }

    public static void main(String[] args) {
        PLUSONE obj = new PLUSONE();
        int[] digit1 = {1,2,3};
        int[] digit2 = {9,9,9};
        int[] digit3 = {9};
        System.out.println("Output for digit1 = "+ Arrays.toString(obj.plusOne(digit1)));
        System.out.println("Output for digit2 = "+ Arrays.toString(obj.plusOne(digit2)));
        System.out.println("Output for digit3 = "+ Arrays.toString(obj.plusOne(digit3)));

    }
}

/*

Problem Statement

You are given a non-negative integer represented as an array of digits, where the most significant digit is at the start of the array. Increment the integer by one and return the resulting array of digits.

- Each element in the array contains a single digit (0-9).
- There are no leading zeros except for the number 0 itself.

---

 Approach

1. **Initial Thought Process:**
   - Traverse the array from the least significant digit (rightmost) to the most significant digit (leftmost).
   - If the current digit is less than 9, simply increment it and return the updated array.
   - If the digit is 9, set it to 0 and continue to the next digit to handle the carry.

2. **Handling Overflow:**
   - If all digits are 9 (e.g., 999 → 1000), the result requires one additional digit.
   - Allocate a new array of size `n + 1` (where `n` is the input size) with the first digit set to 1, and the rest default to 0.

3. **Optimization Consideration:**
   - The approach uses a single loop from the last digit to the first, making it efficient in terms of both time and space.

Complexity Analysis

1. **Time Complexity:**
   - \(O(n)\): The loop iterates through the digits array at most once.

2. **Space Complexity:**
   - \(O(1)\): The solution modifies the input array in-place when possible.
   - \(O(n)\): In the worst case (e.g., all 9s), a new array of size \(n+1\) is created.

 */

