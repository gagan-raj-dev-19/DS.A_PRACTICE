package Arrays.Easy;

import java.util.Arrays;

class SortArrayByParityII {
    public static int[] sortParity2(int[] nums) {
        int even = 0; // Pointer for even indices
        int odd = 1;  // Pointer for odd indices
        int[] result = new int[nums.length]; // Array to store the rearranged numbers

        // Iterate through the input array
        for (int num : nums) {
            if (num % 2 == 0) { // Check if the number is even
                result[even] = num;
                even += 2; // Move to the next even index
            } else { // Number is odd
                result[odd] = num;
                odd += 2; // Move to the next odd index
            }
        }
        return result; // Return the rearranged array
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6};
        // Print the rearranged array
        System.out.println(Arrays.toString(sortParity2(arr)));
    }
}

/*
**Problem Statement**
The task is to rearrange an array such that:
1. Every even index contains an even number.
2. Every odd index contains an odd number.

The input guarantees that there are equal numbers of even and odd integers in the array.

---

 **Approach**
Your approach follows these steps:
1. Create a new array `result` of the same size as the input `nums`.
2. Use two pointers:
   - `even`: Points to the next available even index (starting at 0).
   - `odd`: Points to the next available odd index (starting at 1).
3. Iterate through the input array:
   - If the current number is even, place it at the `even` index in `result`, and increment `even` by 2.
   - If the current number is odd, place it at the `odd` index in `result`, and increment `odd` by 2.
4. Return the `result` array.

This approach ensures that the array is processed in a single pass, maintaining the constraints.

 **Complexity Analysis**
 Time Complexity:
- **O(n)**: The input array is traversed once, where `n` is the length of the array.

 Space Complexity:
- **O(n)**: A new array `result` of the same size as the input is created to store the rearranged elements.

---

 **Optimization Possibility**
If in-place modification is allowed:
- Use two pointers directly on the input array to swap elements instead of creating a new array, reducing space complexity to **O(1)**.

 */