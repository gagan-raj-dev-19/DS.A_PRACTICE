package Arrays.Easy;




class FindPivotIndex {
    public static int pivotIndex(int[] nums) {
        // Step 1: Calculate the total sum of the array
        int totalSum = 0;
        for (int num : nums) {
            totalSum += num;
        }

        // Step 2: Initialize leftSum and traverse the array to find the pivot index
        int leftSum = 0;
        for (int i = 0; i < nums.length; i++) {
            // Calculate rightSum as totalSum - leftSum - nums[i]
            int rightSum = totalSum - leftSum - nums[i];

            // Check if leftSum equals rightSum
            if (leftSum == rightSum) {
                return i; // Return the pivot index
            }

            // Update leftSum for the next iteration
            leftSum += nums[i];
        }

        // If no pivot index is found, return -1
        return -1;
    }
    public static void main(String[] args) {

        // Test cases
        int[] nums1 = {1, 7, 3, 6, 5, 6};
        int[] nums2 = {1, 2, 3};
        int[] nums3 = {2, 1, -1};

        // Testing
        System.out.println("Pivot index of nums1: " + pivotIndex(nums1)); // Expected: 3
        System.out.println("Pivot index of nums2: " + pivotIndex(nums2)); // Expected: -1
        System.out.println("Pivot index of nums3: " + pivotIndex(nums3)); // Expected: 0
    }
}

/*
Problem Statement
The task is to find the **pivot index** of an array, where the pivot index is defined as an index such that the sum of elements to the left is equal to the sum of elements to the right. If no such index exists, return `-1`. If there are multiple pivot indices, return the left-most one.

**Example Input/Output:**
- Input: `nums = [1, 7, 3, 6, 5, 6]`
- Output: `3`

---

### Approach
1. **Initial Thought Process:**
   - Calculate the total sum of the array (`totalSum`).
   - Traverse the array while keeping track of the cumulative sum of elements on the left (`leftSum`).
   - At each index `i`, calculate the right sum as `totalSum - leftSum - nums[i]`.
   - Compare `leftSum` with the calculated `rightSum`. If they are equal, return the index `i`.

2. **Optimizations:**
   - Avoid recalculating the right sum repeatedly by precomputing `totalSum` and updating `leftSum` iteratively.
   - Use a single traversal after calculating `totalSum` to achieve an efficient solution.

Complexity Analysis
1. **Time Complexity:**
   - Calculating `totalSum` requires a single traversal of the array: \(O(n)\).
   - Finding the pivot index requires another traversal: \(O(n)\).
   - **Total Time Complexity:** \(O(n)\).

2. Space Complexity:
   - The solution uses a constant amount of extra space: \(O(1)\).

---

### Summary
- This approach efficiently calculates the pivot index with a single pass after computing the total sum.
- The algorithm handles edge cases (e.g., empty arrays, single-element arrays) naturally due to the traversal logic.



 */