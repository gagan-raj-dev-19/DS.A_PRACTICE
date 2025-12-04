package Arrays.Medium;
import java.util.Arrays;
import java.util.HashMap;

public class TwoSum_1 {
    // Function to find two indices such that their values add up to the target
    public static int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i]; // Calculate complement
            if (map.containsKey(complement)) { // Check if complement exists
                return new int[]{map.get(complement), i}; // Return indices
            }
            map.put(nums[i], i); // Add current number to hash map
        }
        return new int[]{}; // Return empty array if no solution exists
    }

    public static void main(String[] args) {
        int[] nums = {1, 4, 4, 8};
        int target = 8;
        int[] res = twoSum(nums, target);
        System.out.println(Arrays.toString(res)); // Output the result
    }
}


/*
**Problem Statement**
Given an array of integers `nums` and an integer `target`, return the indices of the two numbers such that they add up to the target. Each input has exactly one solution, and you may not use the same element twice.
**Example Input:**
- `nums = [1, 4, 4, 8]`
- `target = 8`

**Output:** `[1, 2]` (since `nums[1] + nums[2] = 4 + 4 = 8`).

---

### **Approach**
To solve this problem, we use a **hash map (dictionary)** to store elements and their indices as we iterate through the array.
- **Thought process**:
  1. Calculate the `complement` for each element (`target - nums[i]`).
  2. Check if the `complement` exists in the hash map. If it does, we have found the solution.
  3. If not, store the current number and its index in the hash map for future reference.

This approach avoids using a nested loop and ensures an efficient solution.

**Complexity Analysis**
1. **Time Complexity**:
   - The algorithm runs in O(n), where `n` is the number of elements in `nums`.
   - Each lookup and insertion in the hash map is O(1), making the approach very efficient.

2. **Space Complexity**:
   - The space complexity is O(n) due to the hash map storing up to `n` elements.

---

### **Optimizations**
- This solution is already optimized in terms of time complexity.
- If the input array is guaranteed to be sorted, a two-pointer technique can be used for O(n) time and O(1) space. However, the hash map approach is more versatile for unsorted arrays.



 */
