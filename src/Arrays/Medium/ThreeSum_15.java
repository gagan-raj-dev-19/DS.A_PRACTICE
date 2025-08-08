package Arrays.Medium;

import java.util.*;

class ThreeSum {
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        int n = nums.length;

        // Step 1: Sort the array
        Arrays.sort(nums);

        // Step 2: Iterate through each number as a fixed element
        for (int i = 0; i < n - 2; i++) {
            // Skip duplicate elements to avoid repeated triplets
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            // Step 3: Two-pointer approach
            int left = i + 1;
            int right = n - 1;

            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];

                if (sum == 0) {
                    // Found a valid triplet
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));

                    // Move both pointers to find the next potential triplet
                    left++;
                    right--;

                    // Skip duplicate elements from both sides
                    while (left < right && nums[left] == nums[left - 1]) left++;
                    while (left < right && nums[right] == nums[right + 1]) right--;
                }
                else if (sum < 0) {
                    left++;  // Increase the sum by moving left pointer
                }
                else {
                    right--; // Decrease the sum by moving right pointer
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {-1, 0, 1, 2, -1, -4};
        List<List<Integer>> result = threeSum(nums);
        System.out.println(result);
    }
}


/*

**Problem Statement:**
Given an integer array `nums`, return all the unique triplets `[nums[i], nums[j], nums[k]]` such that:

- i != j, i != k, and j != k
- ( nums[i] + nums[j] + nums[k] = 0 )

The solution set must **not contain duplicate** triplets.

**Example:**
**Input:** `nums = [-1,0,1,2,-1,-4]`
**Output:** `[[-1,-1,2],[-1,0,1]]`

 **Approach:**
To solve the problem efficiently, we can use the **two-pointer technique** after sorting the array. The approach follows these steps:

1. **Sort the array:** This helps in easily avoiding duplicate triplets and simplifies the two-pointer search.
2. **Fix the first element:** Iterate through the array and fix one element (`nums[i]`) at a time.
    - Skip duplicate elements to avoid repeated triplets.
3. **Two-pointer technique:**
   - Use two pointers (`left` and `right`) to find pairs that sum to the negative of the fixed element (`-nums[i]`).
   - If the sum equals zero, add the triplet to the result and move both pointers, avoiding duplicates.
   - If the sum is less than zero, increment the `left` pointer.
   - If the sum is greater than zero, decrement the `right` pointer.



 **Complexity Analysis:**

1. **Time Complexity:**
   - Sorting the array takes \( O(n \log n) \).
   - The main loop runs \( O(n) \) times, and for each iteration, the two-pointer approach runs in \( O(n) \).
   - Thus, the total time complexity is **\( O(n^2) \)**.

2. **Space Complexity:**
   - The output list stores triplets, which in the worst case could take \( O(n) \) space.
   - Sorting modifies the input array, but apart from that, no additional space is used.
   - Thus, the space complexity is **\( O(n) \)** (excluding the output list).





 */