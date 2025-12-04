package Maths;

class AddStrings {
    public static String addStrings(String num1, String num2) {
        StringBuilder result = new StringBuilder();
        int i = num1.length() - 1;
        int j = num2.length() - 1;
        int carry = 0;

        // Process digits from the end of both strings
        while (i >= 0 || j >= 0 || carry > 0) {
            int x = (i >= 0) ? num1.charAt(i) - '0' : 0;
            int y = (j >= 0) ? num2.charAt(j) - '0' : 0;

            int sum = x + y + carry;
            result.append(sum % 10);  // Append the last digit of the sum
            carry = sum / 10;        // Update the carry

            i--;
            j--;
        }

        return result.reverse().toString();
    }

    public static void main(String[] args) {
        String num1 = "11";
        String num2 = "123";

        System.out.println(addStrings(num1, num2)); // Output: "134"
    }
}
/*

Problem Statement:
Given two non-negative integers `num1` and `num2` represented as strings, return the sum of `num1` and `num2` as a string. You must not use built-in libraries or convert the strings to integers directly.

---

 Approach:
1. **Reverse Iteration:**
   - Start iterating from the least significant digit (end of the strings).
   - Sum the corresponding digits from both strings, considering a carry from the previous operation.

2. **Handling Unequal Lengths:**
   - If one string is shorter, treat the missing digits as `0`.

3. **Carry Management:**
   - Calculate the carry using integer division and use the remainder for the current digit.

4. **Reverse the Result:**
   - The computed result is in reverse order due to appending digits to the `StringBuilder`. Reverse it at the end to get the correct order.

5. **Edge Cases:**
   - One or both strings are empty (handle as `0`).
   - Strings of very large lengths that cannot be stored as integers in traditional types.

Complexity Analysis:

1. **Time Complexity:**
   - **O(max(n, m))**, where `n` and `m` are the lengths of `num1` and `num2`.
   - Each digit is processed once, and the `reverse()` operation at the end takes linear time.

2. **Space Complexity:**
   - **O(max(n, m))**, for the `StringBuilder` to store the result.
   - No additional data structures with significant space requirements are used.

---

 Optimization Insights:
- The use of `StringBuilder` ensures efficient appending and reversing operations.
- Only the necessary operations (no unnecessary parsing or memory allocation) are performed.


 */