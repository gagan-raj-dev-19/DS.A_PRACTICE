package Arrays.Easy;

import java.util.Arrays;

class SortArrayByParity {
    public int[] sortArrayByParity(int[] nums) {
        int start = 0; // Pointer to place the next even number

        // Iterate through the array
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] % 2 == 0) { // Check if the current number is even
                // Swap the current even number with the element at 'start'
                int temp = nums[start];
                nums[start] = nums[i];
                nums[i] = temp;
                start++; // Move the 'start' pointer forward
            }
        }
        return nums; // Return the modified array
    }

    public static void main(String[] args) {
        SortArrayByParity obj = new SortArrayByParity();
        int[] nums = {1,3,4,2};
        int[] res = obj.sortArrayByParity(nums);
        System.out.println(Arrays.toString(res));

    }
}

/*

**Problem Statement**
You are given an integer array `nums`. You need to rearrange the elements of the array so that all the even integers appear before all the odd integers while maintaining the relative order of the numbers. Return any array that satisfies this condition.

---

### **Approach**

1. **Understanding the Task:**
   - Traverse through the array.
   - Identify even and odd numbers.
   - Rearrange such that all even numbers are grouped at the beginning of the array, and odd numbers follow.

2. **Thought Process:**
   - Use a pointer (`start`) to track the position where the next even number should be placed.
   - Iterate through the array, swapping even numbers to their correct position while moving the pointer forward.
   - Avoid using additional space, adhering to an **in-place algorithm**.

3. **Optimizations:**
   - The solution is already optimized for space (O(1)) since it sorts the array in-place.
   - The time complexity is O(n), as the array is traversed once.

**Complexity Analysis**

1. **Time Complexity:**
   - The loop runs through the array once (O(n)).
   - The swapping operation takes constant time (O(1)).
   - Overall time complexity: **O(n)**.

2. **Space Complexity:**
   - The sorting is done in-place without using extra space.
   - Overall space complexity: **O(1)**.


 */