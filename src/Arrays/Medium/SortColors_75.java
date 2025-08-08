package Arrays.Medium;

import java.util.Arrays;

class SortColors {

    public static void sortColors(int[] nums) {
        int red = 0;              // Pointer for the end of the 0s (red region)
        int white = 0;            // Pointer for the current element (white region)
        int blue = nums.length - 1; // Pointer for the start of the 2s (blue region)

        // Iterate until the white pointer crosses the blue pointer
        while (white <= blue) {
            if (nums[white] == 0) {
                // If the current element is 0, swap it with the element at the red pointer
                int temp = nums[white];
                nums[white] = nums[red];
                nums[red] = temp;
                white++; // Move the white pointer forward
                red++;   // Expand the red region
            } else if (nums[white] == 1) {
                // If the current element is 1, just move the white pointer forward
                white++;
            } else {
                // If the current element is 2, swap it with the element at the blue pointer
                int temp = nums[white];
                nums[white] = nums[blue];
                nums[blue] = temp;
                blue--;  // Shrink the blue region
                // Do not increment white here because the swapped value needs evaluation
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {2, 0, 1, 0, 1, 2}; // Input array with 0s, 1s, and 2s
        sortColors(nums);                // Sort the array
        System.out.println(Arrays.toString(nums)); // Output the sorted array
    }
}


/*

Problem Statement:
The task is to sort an array containing only the integers `0`, `1`, and `2` in-place, so that integers of the same value are adjacent, with the order `0, 1, 2`. This problem is also known as the **Dutch National Flag Problem**, originally proposed by Edsger Dijkstra.

Approach:
Your solution uses a **three-pointer approach**:
1. Pointers
   - `red`: Marks the end of the `0` (red) region.
   - `white`: Iterates through the array, determining the current element's region.
   - `blue`: Marks the beginning of the `2` (blue) region.
2. Process
   - If the current element is `0` (red region), swap it with the element at the `red` pointer and increment both `red` and `white`.
   - If the current element is `1` (white region), just move `white` forward.
   - If the current element is `2` (blue region), swap it with the element at the `blue` pointer and decrement `blue`. Do not increment `white` in this case, as the swapped value at `white` needs further evaluation.

Code Explanation:
Your Java implementation effectively handles the in-place sorting using the three-pointer approach.

 Key Points in Code:
- **Swapping Logic:** Temporary variables ensure proper value exchange without data loss.
- **Boundary Conditions:** The `while` loop terminates when the `white` pointer surpasses the `blue` pointer, ensuring all elements are correctly placed.
- **Output:** `System.out.println(Arrays.toString(nums))` prints the sorted array to verify correctness.

**Complexity Analysis:**
- **Time Complexity:** (O(n))
  - Each element is processed at most once by the `white` pointer.
- **Space Complexity:** (O(1))
  - The sorting is performed in-place, requiring no extra space.



**Optimizations:**
Your implementation is already optimal for this problem. If desired, you can improve readability by extracting the swapping logic into a helper method.



**Example Output:**
Given the input `{2, 0, 1, 0, 1, 2}`, the program prints `[0, 0, 1, 1, 2, 2]`, confirming the correctness of the algorithm.

 */