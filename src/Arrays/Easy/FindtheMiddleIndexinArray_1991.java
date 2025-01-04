package Arrays.Easy;


public class FindtheMiddleIndexinArray_1991 {
    public static int findMiddleIndex(int[] nums) {
        int totalSum = 0;

        // Calculate the total sum of the array
        for (int num : nums) {
            totalSum += num;
        }

        int leftSum = 0;

        // Iterate through the array to find the middle index
        for (int i = 0; i < nums.length; i++) {
            // Check if left sum equals the right sum
            if (leftSum == totalSum - leftSum - nums[i]) {
                return i; // Return the index
            }
            leftSum += nums[i]; // Update the left sum
        }

        return -1; // No such index found
    }


    public static void main(String[] args) {
        int[] nums = {2,3,-1,8,4};
        System.out.println(findMiddleIndex(nums));
    }
}
/*
**Problem Statement**
Given an array of integers `nums`, find the **middle index** such that the sum of the elements to the left of this index is equal to the sum of the elements to the right of this index. If no such index exists, return `-1`. If there are multiple such indices, return the left-most one.

### **Approach**
1. **Calculate the Total Sum:**
   Compute the sum of all elements in the array (`totalSum`). This gives the sum of the entire array.

2. **Iterate Through the Array:**
   Use a variable `leftSum` to keep track of the sum of elements to the left of the current index. For each index:
   - Check if `leftSum` equals `totalSum - leftSum - nums[i]` (the sum of elements to the right of the current index).
   - If true, return the current index.
   - Update `leftSum` by adding the value of `nums[i]`.

3. **Return Result:**
   If no such index is found after traversing the array, return `-1`.

**Complexity Analysis**

1. **Time Complexity:**
   - **O(N):** The algorithm performs a single pass to calculate `totalSum` and another pass to check each index for the condition, resulting in a linear time complexity.

2. **Space Complexity:**
   - **O(1):** No additional data structures are used, and only a few integer variables are allocated.

---

### **Example Run**
For the input `nums = {2, 3, -1, 8, 4}`:
1. Calculate `totalSum = 2 + 3 + (-1) + 8 + 4 = 16`.
2. Initialize `leftSum = 0` and iterate through the array:
   - `i = 0`: `leftSum = 0`, `rightSum = 16 - 0 - 2 = 14` → Not equal.
   - `i = 1`: `leftSum = 2`, `rightSum = 16 - 2 - 3 = 11` → Not equal.
   - `i = 2`: `leftSum = 5`, `rightSum = 16 - 5 - (-1) = 12` → Not equal.
   - `i = 3`: `leftSum = 4`, `rightSum = 16 - 4 - 8 = 4` → **Equal!** Return `3`.

Output: `3`.

---

### **Optimization Ideas**
The algorithm is already optimal with respect to time and space complexity. Additional improvements might include:
- **Input Validation:** Handle edge cases like empty arrays or arrays with a single element.
- **Early Exit:** If `leftSum` ever exceeds half of `totalSum`, we can terminate early.





 */