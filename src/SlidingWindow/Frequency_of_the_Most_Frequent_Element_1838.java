package SlidingWindow;


import java.util.Arrays;

class MAXFREQUENCY {
    public int maxFrequency(int[] nums, int k) {
        Arrays.sort(nums); // Step 1: Sort the array
        int n = nums.length;
        long total = 0; // Keeps track of the sum of elements in the current window
        int left = 0;   // Left pointer of the sliding window
        int maxFreq = 0;

        for (int right = 0; right < n; right++) {
            total += nums[right];

            // Step 3: Check if the operations needed exceed k
            while (nums[right] * (right - left + 1L) - total > k) {
                total -= nums[left]; // Remove the leftmost element from the window
                left++;              // Shrink the window
            }

            // Step 4: Update maximum frequency
            maxFreq = Math.max(maxFreq, right - left + 1);
        }

        return maxFreq;
    }

    public static void main(String[] args) {
        MAXFREQUENCY solution = new MAXFREQUENCY();
        int[] nums = {1, 2, 4};
        int k = 5;
        System.out.println(solution.maxFrequency(nums, k)); // Output: 3
    }

}
/*

 Problem Statement:
Given an array of integers `nums` and an integer `k`, you are tasked to maximize the frequency of an element in the array by performing at most `k` increment operations. Each increment operation allows you to increase the value of any element in the array by `1`. The goal is to return the maximum possible frequency of any element after applying the operations optimally.


 Approach:
1. **Sorting the Array**:
   - Sort the array `nums` in ascending order. This makes it easier to calculate the operations needed to make elements in a subarray equal to the largest element in the subarray.

2. **Sliding Window with Two Pointers**:
   - Use a sliding window to maintain a subarray where the total operations required to equalize all elements to the largest value is within `k`.
   - Let `right` be the current element and `left` be the start of the window.

3. **Calculate Operations**:
   - For the subarray `[left, right]`, the operations needed to make all elements equal to `nums[right]` is:
     \[
     \text{operations} = \text{nums[right]} \times (\text{right} - \text{left} + 1) - \text{total}
     \]
     where `total` is the sum of elements in the current window.

4. **Adjust the Window**:
   - If `operations > k`, shrink the window by moving `left` and adjust `total` accordingly.

5. **Track Maximum Frequency**:
   - At each step, update the maximum frequency (`maxFreq`) as the size of the current valid window: `right - left + 1`.


Complexity Analysis:
1. **Time Complexity**:
   - Sorting the array: \( O(n \log n) \)
   - Sliding window traversal: \( O(n) \)
   - Total: \( O(n \log n) \)

2. **Space Complexity**:
   - The algorithm uses constant extra space \( O(1) \), excluding input storage.


 Optimizations:
- Sorting is essential for the approach; further optimization can only improve the constants, not the overall complexity.
- Use prefix sums for better readability of the total computation if needed.

This solution ensures efficient use of sliding window mechanics to achieve the desired result with minimal overhead.

 */