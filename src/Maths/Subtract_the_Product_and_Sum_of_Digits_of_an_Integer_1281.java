package Maths;

class SubtractProductandSum{
    public int subtractProductAndSum(int n) {
        int prod = 1;  // Initialize product of digits
        int sum = 0;   // Initialize sum of digits

        while (n != 0) { // Loop until all digits are processed
            int digit = n % 10; // Extract the last digit
            prod *= digit;      // Update product
            sum += digit;       // Update sum
            n /= 10;            // Remove the last digit
        }

        return prod - sum; // Return the difference
    }

    public static void main(String[] args) {
        SubtractProductandSum obj= new SubtractProductandSum();
        int num = 123;
        int num2= 258;
        System.out.println(obj.subtractProductAndSum(num));
        System.out.println(obj.subtractProductAndSum(num2));
    }
}

/*

**Problem Statement**:
Given an integer `n`, calculate the difference between the product of its digits and the sum of its digits.
- **Input**: An integer `n` (1 ≤ `n` ≤ 10^5).
- **Output**: An integer representing the difference between the product and the sum of its digits.

---

 **Approach**:

1. **Extract Digits**:
   - Use modulo operation (`n % 10`) to extract the last digit.
   - Use integer division (`n / 10`) to remove the last digit.

2. **Compute Product and Sum**:
   - Initialize `prod` as `1` (multiplicative identity) and `sum` as `0` (additive identity).
   - In a loop, update:
     - `prod` by multiplying with the current digit.
     - `sum` by adding the current digit.

3. **Return the Difference**:
   - Calculate the result as `prod - sum`.

4. **Optimizations**:
   - The loop runs in `O(d)` time, where `d` is the number of digits in `n`. Given the constraint (max `n` is 100,000), this is efficient.
   - Space complexity is `O(1)` since we use only a constant amount of extra space.


**Complexity Analysis**:

1. **Time Complexity**:
   - Extracting digits and performing arithmetic operations within a loop takes `O(d)` time, where `d` is the number of digits in `n`.
   - In the worst case, `d` is `5` (for the largest input, `100,000`).
   - Thus, the time complexity is O(log₁₀(n)).

2. **Space Complexity**:
   - Only a fixed number of variables (`prod`, `sum`, `digit`) are used.
   - Thus, the space complexity is **O(1)**.

**Example Walkthrough**:

**Input**: `n = 234`
**Digits**: `2, 3, 4`
- Product (`prod`): `2 * 3 * 4 = 24`
- Sum (`sum`): `2 + 3 + 4 = 9`
- Difference: `24 - 9 = 15`

**Output**: `15`

This solution is efficient and adheres to the problem constraints, providing both clarity and performance.

 */