package Arrays.Medium;

public class MaximumSubarray_53 {
    public static int maxSubArray(int[] nums) {
        // Initialize variables
        int max = Integer.MIN_VALUE; // Tracks the maximum sum found
        int sum = 0; // Tracks the current sum of the subarray

        // Iterate through each element in the array
        for (int num : nums) {
            sum += num; // Add the current element to the sum

            // Update max if the current sum is greater than max
            if (sum > max) {
                max = sum;
            }

            // Reset sum to 0 if it becomes negative
            if (sum < 0) {
                sum = 0;
            }
        }

        // Return the maximum sum found
        return max;
    }

    public static void main(String[] args) {
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        // Print the result
        System.out.println(maxSubArray(nums)); // Output: 6
    }
}
/*
Problem Statement:
Find the contiguous subarray (containing at least one number) within an array, `nums`, which has the largest sum. Return the maximum sum.

### Approach:
This problem can be solved using **Kadane's Algorithm**:
1. Initialize two variables:
   - `max` to store the maximum sum encountered so far (`Integer.MIN_VALUE` initially).
   - `sum` to store the cumulative sum of the current subarray (`0` initially).
2. Iterate through the array:
   - Add the current element to `sum`.
   - Update `max` if `sum` is greater than `max`.
   - If `sum` becomes negative, reset it to `0` (as starting a new subarray at the next element will provide a better result).
3. Return `max` after completing the iteration.

This approach ensures we find the largest sum in linear time, making it highly efficient.

Complexity Analysis:
- **Time Complexity**:
  The algorithm iterates through the array exactly once, performing O(1) operations for each element.
  **T(n) = O(n)**, where `n` is the length of the array.

- **Space Complexity**:
  The algorithm uses only a constant amount of extra space (`max` and `sum` variables).
  **S(n) = O(1)**.

 Key Insights:
- Kadane's Algorithm is optimal for finding the maximum subarray sum in a single pass.
- Resetting the `sum` to `0` when it becomes negative ensures that only positive contributions are included in the sum.


 */