package Maths;

import java.util.Arrays;

class minimumNumberGame {
    public int[] numberGame(int[] nums) {
        // Step 1: Sort the array
        Arrays.sort(nums);

        // Step 2: Swap adjacent elements to alternate their order
        int a = 0, b = 1;
        while (b < nums.length) {
            // Swap nums[a] and nums[b]
            int temp = nums[a];
            nums[a] = nums[b];
            nums[b] = temp;

            // Move to the next pair
            a = b + 1;
            b = a + 1;
        }

        return nums;
    }

    public static void main(String[] args) {
        minimumNumberGame obj = new minimumNumberGame();
        int[] num ={ 1,3,5,2} ;
        int[] result = obj.numberGame(num);
        System.out.println(Arrays.toString(result));
    }

}
/*

Problem Statement

You are given an array of integers `nums`. Your task is to rearrange the elements of the array such that for every adjacent pair of indices `(i, i+1)` in the array, the elements `nums[i]` and `nums[i+1]` alternate in size. Specifically, after sorting the array, you swap adjacent elements pairwise to create this alternating order.

---

 Approach

1. **Sorting:**
   - Start by sorting the array in ascending order. Sorting ensures that the elements are in increasing order, making it easier to rearrange them alternately.

2. **Pairwise Swap:**
   - After sorting, iterate through the array with two pointers, `a` (current index) and `b` (next index).
   - Swap the elements at these indices, ensuring alternation.

3. **Edge Cases:**
   - If the array has fewer than two elements, no swapping is needed.
   - If the array length is odd, the last element remains unchanged since there’s no pair for it.

4. **Possible Optimizations:**
   - The algorithm is already efficient because sorting dominates the time complexity.
   - Further improvements are unnecessary unless additional constraints are introduced.


Complexity Analysis

1. **Time Complexity:**
   - Sorting: \(O(n \log n)\), where \(n\) is the length of `nums`.
   - Swapping: \(O(n)\), as we iterate through the array once.
   - Overall: \(O(n \log n)\), dominated by the sorting step.

2. **Space Complexity:**
   - Sorting typically requires \(O(\log n)\) auxiliary space for recursive calls (depending on the implementation).
   - In-place swapping does not use additional memory.
   - Overall: \(O(\log n)\).


Example Walkthrough

 Input:
`nums = [4, 1, 3, 2, 5]`

#### Process:
1. **Sorting:**
   Sorted array: `[1, 2, 3, 4, 5]`.

2. **Swapping:**
   - Swap `nums[0]` and `nums[1]`: `[2, 1, 3, 4, 5]`.
   - Swap `nums[2]` and `nums[3]`: `[2, 1, 4, 3, 5]`.

3. **Result:**
   `[2, 1, 4, 3, 5]`

 Output:
`[2, 1, 4, 3, 5]`


 */
