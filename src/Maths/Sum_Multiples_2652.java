package Maths;

class SumMultiplies {
    public int sumOfMultiples(int n) {
        int totalSum = 0;
        // Iterate through each number from 1 to n
        for (int i = 1; i <= n; i++) {
            // Check divisibility by 3, 5, or 7
            if (i % 3 == 0 || i % 5 == 0 || i % 7 == 0) {
                totalSum += i; // Add to the total sum
            }
        }
        return totalSum; // Return the total sum
    }

    public static void main(String[] args) {
SumMultiplies obj = new SumMultiplies();
        int n = 7;
        int n1 = 10;
        System.out.println(obj.sumOfMultiples(n));
        System.out.println(obj.sumOfMultiples(n1));

    }
}
/*

**Problem Statement**

You are given a positive integer `n`. Your task is to find the sum of all integers between `1` and `n` (inclusive) that are divisible by `3`, `5`, or `7`. If a number is divisible by more than one of these, it should only be counted once.

---

### **Approach**

1. **Brute-Force Iteration**:
   - Iterate over each integer from `1` to `n`.
   - Check if the number is divisible by `3`, `5`, or `7`.
   - If divisible, add the number to a running sum (`totalSum`).

2. **Optimizations**:
   - The current solution iterates through every number up to `n` to perform modulo checks. While this is simple, it can be slow for large values of `n`.
   - An alternative would be to compute the sum directly using arithmetic progression (AP) sums for multiples of `3`, `5`, and `7`. Then subtract the sums for their pairwise intersections to avoid overcounting.

**Complexity Analysis**

1. **Time Complexity**:
   - **O(n)**: The loop iterates over all numbers from `1` to `n`, and each iteration performs at most three modulo operations.

2. **Space Complexity**:
   - **O(1)**: No additional data structures are used, and the space used is constant.


 */
