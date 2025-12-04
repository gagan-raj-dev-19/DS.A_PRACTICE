package Arrays.Easy;

import java.util.Arrays;

class SortedSquares {
    public int[] sortedSquares(int[] nums) {
        int n = nums.length;
        int[] result = new int[n]; // Result array
        int left = 0;             // Pointer at the start
        int right = n - 1;        // Pointer at the end
        int index = n - 1;        // Fill result array from the end

        while (left <= right) {
            int leftSquare = nums[left] * nums[left];   // Square of the left pointer
            int rightSquare = nums[right] * nums[right]; // Square of the right pointer

            if (leftSquare > rightSquare) {
                result[index] = leftSquare; // Larger value goes at index
                left++;                     // Move left pointer forward
            } else {
                result[index] = rightSquare; // Larger value goes at index
                right--;                    // Move right pointer backward
            }
            index--; // Move to the next position in the result array
        }
        return result;
    }

    public static void main(String[] args) {
        SortedSquares obj = new SortedSquares();
        int [] nums = {-7,10,12,-8};
        int[] result = obj.sortedSquares(nums);
        System.out.println(Arrays.toString(result));
    }
}

/*
Problem Statement
The task is to take a sorted array of integers (which may include both negative and positive values), square each element, and return a new array with these squared values sorted in non-decreasing order.

---

 Approach

1. **Two-Pointer Technique**:
   - Since the input array is sorted, the absolute values of elements might not be sorted.
   - Use two pointers:
     - `left` starting at the beginning of the array.
     - `right` starting at the end of the array.
   - Compare the squares of the values at `left` and `right`. The larger square is placed at the current highest available index in the result array (`index`), which starts from the last position of the array.
   - Move the pointer (`left` or `right`) corresponding to the larger square and decrement the `index`.

2. **Iterative Placement**:
   - By iterating and placing the larger square values at the end of the result array, the result is sorted in non-decreasing order.

3. **Edge Cases**:
   - Empty input array: Return an empty array.
   - All elements are positive or all negative: The squares are already sorted.

Complexity Analysis

1. **Time Complexity**:
   - The algorithm iterates through the array once with the two pointers (`left` and `right`), resulting in a time complexity of \(O(n)\), where \(n\) is the number of elements in the array.

2. **Space Complexity**:
   - The result array requires \(O(n)\) space. Aside from this, only a few scalar variables are used, so the auxiliary space is \(O(1)\).

---

 Optimizations
- The current implementation is already optimal for both time and space. No additional sorting is needed since the two-pointer approach directly constructs the sorted result.

 */
