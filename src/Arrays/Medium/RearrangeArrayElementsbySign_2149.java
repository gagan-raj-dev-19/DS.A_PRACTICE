package Arrays.Medium;

import java.util.Arrays;

class RearrangeArrayElementsbySign {

    public static int[] rearrangeArray(int[] nums) {
        // Resultant array to store rearranged elements
        int[] res = new int[nums.length];
        // Pointers to track positions for positive and negative numbers
        int pos = 0; // Start placing positive numbers at index 0
        int neg = 1; // Start placing negative numbers at index 1

        // Traverse the input array
        for (int num : nums) {
            if (num >= 0) {
                // Place positive number at the current 'pos' index
                res[pos] = num;
                pos += 2; // Move pointer to the next position for a positive number
            } else {
                // Place negative number at the current 'neg' index
                res[neg] = num;
                neg += 2; // Move pointer to the next position for a negative number
            }
        }

        return res; // Return the rearranged array
    }


    public static void main(String[] args) {
        // Input array
        int[] nums = {3, 1, -2, -5, 2, -4};
        // Call the rearrangeArray method and store the result
        int[] res = rearrangeArray(nums);
        // Print the rearranged array
        System.out.println(Arrays.toString(res));
    }
}

/*
**Problem Statement**
Given an array `nums` of even length containing both positive and negative integers, rearrange the elements such that:
- Positive integers and negative integers alternate.
- The relative order of positive integers and negative integers from the original array is maintained.

Return the rearranged array.


 **Approach**
1. **Initialization**: Create an empty result array `res` of the same size as `nums`. Use two pointers:
   - `pos` to place positive integers (starting at index `0`).
   - `neg` to place negative integers (starting at index `1`).

2. **Iteration**: Traverse through the given array `nums`:
   - If the current number is positive, place it at index `pos` in the result array and increment `pos` by `2`.
   - If the current number is negative, place it at index `neg` in the result array and increment `neg` by `2`.

3. **Output**: The resultant array will have the desired arrangement of elements.

**Complexity Analysis**
1. **Time Complexity**:
   - Iterating through the array `nums` takes **O(n)**, where `n` is the number of elements in the array.
   - Overall: **O(n)**.

2. **Space Complexity**:
   - The result array `res` takes **O(n)** additional space.
   - Overall: **O(n)**.



**Example**
Input:
`nums = {3, 1, -2, -5, 2, -4}`

Output:
`[3, -2, 1, -5, 2, -4]`

Here:
- Positive numbers `[3, 1, 2]` appear at even indices (`0, 2, 4`).
- Negative numbers `[-2, -5, -4]` appear at odd indices (`1, 3, 5`).

---

### **Optimizations**
- This approach maintains the relative order of positive and negative numbers, as it processes elements in the same sequence they appear in the input.
- The algorithm avoids additional passes or complex data structures, keeping it efficient for practical use cases.



 */