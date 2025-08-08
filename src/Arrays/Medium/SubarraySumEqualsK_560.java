package Arrays.Medium;

import java.util.HashMap;

class SubarraySumEqualsK {
    public static int subarraySum(int[] nums, int k) {
        int count = 0;
        int currentSum = 0;
        HashMap<Integer, Integer> prefixSumCount = new HashMap<>();

        // Initialize the map with the prefix sum of 0
        prefixSumCount.put(0, 1);

        // Iterate through the array
        for (int num : nums) {
            // Update the cumulative sum
            currentSum += num;

            // Check if (currentSum - k) exists in the map
            if (prefixSumCount.containsKey(currentSum - k)) {
                count += prefixSumCount.get(currentSum - k);
            }

            // Update the map with the current cumulative sum
            prefixSumCount.put(currentSum, prefixSumCount.getOrDefault(currentSum, 0) + 1);
        }

        return count;
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 2, 5};
        int k = 7;
        int[] nums1 = {2, 3, 5, 6, 4};
        int k1 = 10;

        System.out.println(subarraySum(nums, k));  // Output: 1
        System.out.println(subarraySum(nums1, k1)); // Output: 2
    }
}

/*
**Problem Statement**
Given an array of integers `nums` and an integer `k`, find the total number of continuous subarrays whose sum equals `k`.

---

 **Approach**
1. **Key Idea**:
   Use a prefix sum technique along with a hash map to track the frequency of prefix sums encountered so far. This avoids recomputing sums for every subarray, which would result in an inefficient O(n²) solution.

2. **Steps**:
   - Initialize a hash map (`prefixSumCount`) to store the counts of prefix sums and set `prefixSumCount[0] = 1` to account for cases where a subarray starting from index 0 sums to `k`.
   - Iterate through the array while maintaining a `currentSum` to track the cumulative sum of elements up to the current index.
   - For each element, check if `currentSum - k` exists in the hash map:
     - If it exists, it means there's a subarray that sums to `k`, and the value in the map represents the number of such subarrays.
   - Update the hash map to include the new `currentSum`, incrementing its count.

3. **Optimizations**:
   - The hash map ensures O(1) average time complexity for lookup and updates.
   - The algorithm processes the array in a single pass, making it efficient.

**Complexity Analysis**
1. **Time Complexity**:
   - **O(n)**: We traverse the array once and perform constant-time operations (hash map lookups and updates) for each element.

2. **Space Complexity**:
   - **O(n)**: In the worst case, the hash map stores a unique entry for every prefix sum.

---

 **Explanation of Test Cases**
1. **Input**: `nums = {1, 1, 2, 5}`, `k = 7`
   - Subarray `{2, 5}` sums to 7.
   - **Output**: `1`.

2. **Input**: `nums = {2, 3, 5, 6, 4}`, `k = 10`
   - Subarrays `{2, 3, 5}` and `{6, 4}` sum to 10.
   - **Output**: `2`.
 */