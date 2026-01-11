package Arrays.Easy;

import java.util.Arrays;

class ConcatenationofArray {
    public static int[] concatenate(int[] nums) {
        // Create a new array of double the size of nums
        int[] result = new int[nums.length * 2];

        // Populate the result array
        for (int i = 0; i < nums.length; i++) {
            result[i] = nums[i];             // First half
            result[i + nums.length] = nums[i]; // Second half
        }

        return result;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        int[] res = concatenate(nums);
        System.out.println(Arrays.toString(res)); // Output: [1, 2, 3, 1, 2, 3]
    }
}


/*
Problem Statement:
Given an integer array `nums` of length `n`, the task is to create an array `result` of length `2n` where the elements of `nums` are repeated in sequence. Formally, `result[i] = nums[i]` and `result[i + n] = nums[i]` for `0 <= i < n`.



Approach:
1. **Initialization**: Create a new array `result` of size `2n` where `n` is the length of the input array.
2. **Iteration**: Loop through the elements of `nums`. Copy each element into the first half of `result` and simultaneously into the second half at an offset of `n`.
3. **Output**: Return the resultant array after the loop completes.

Complexity Analysis:
1. **Time Complexity**:
   - Iterating through the array once gives \(O(n)\), where \(n\) is the length of the input array.
   - Total time complexity: \(O(n)\).

2. **Space Complexity**:
   - A new array `result` of size \(2n\) is created.
   - Space complexity: \(O(2n)\), which simplifies to \(O(n)\) as constants are ignored in asymptotic analysis.

---

This solution efficiently handles the concatenation problem with linear complexity in both time and space. Additional optimizations could be explored for specific use cases or constraints.


 */