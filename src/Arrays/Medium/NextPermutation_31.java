package Arrays.Medium;

import java.util.Arrays;

class NextPermutation {
    public static void nextPermutation(int[] nums) {
        int n = nums.length;
        int i = n - 2;

        // Find the first decreasing element
        while (i >= 0 && nums[i] >= nums[i + 1]) {
            i--;
        }

        // If such an element is found
        if (i >= 0) {
            int j = n - 1;
            // Find the next larger element
            while (nums[j] <= nums[i]) {
                j--;
            }
            // Swap the two elements
            swap(nums, i, j);
        }

        // Reverse the elements from i+1 to the end
        reverse(nums, i + 1, n - 1);
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    private static void reverse(int[] nums, int start, int end) {
        while (start < end) {
            swap(nums, start, end);
            start++;
            end--;
        }
    }

    public static void main(String[] args) {
        int[] nums = {2, 4, 3, 1, 2};
        nextPermutation(nums);
        System.out.println(Arrays.toString(nums));
    }
}

/*


Problem Statement
The goal is to rearrange the given sequence of numbers into the lexicographically next greater permutation of numbers. If such an arrangement is not possible (i.e., the array is sorted in descending order), the function must rearrange the sequence into the lowest possible order (ascending). This needs to be achieved **in-place*with minimal extra space.



Approach
1. Identify the first decreasing element**: Starting from the end of the array, find the first index `i` such that `nums[i] < nums[i+1]`. This identifies the point where rearrangement is needed to move to the next permutation.
2. Find the next larger element**: Once `i` is identified, look for the smallest element larger than `nums[i]` to the right of `i` (let's call its index `j`).
3. Swap the two elements**: Swap `nums[i]` and `nums[j]` to position the next larger element in the correct place.
4. Reverse the tail**: Reverse the subarray starting at `i+1` to the end. This step ensures the smallest lexicographical order for the modified portion.


Complexity Analysis**
1. Time Complexity:
   - Identifying the first decreasing element: (O(n))
   - Finding the next larger element: (O(n))
   - Reversing the subarray: (O(n))
   - Overall: \(O(n)\)
2. Space Complexity**: \(O(1)\), as all operations are performed in-place without additional data structures.


 */
