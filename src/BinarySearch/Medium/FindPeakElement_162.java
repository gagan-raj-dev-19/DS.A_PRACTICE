package BinarySearch.Medium;

public class FindPeakElement_162 {
    public static int findPeakElement(int[] nums) {
        int n = nums.length;
        int left = 0, right = n - 1;

        while (left < right) {
            int mid = left + (right - left) / 2; // Avoid overflowing

            // If mid is greater than mid+1, move left (potential peak found)
            if (nums[mid] > nums[mid + 1]) {
                right = mid;
            } else {
                // Else, move right
                left = mid + 1;
            }
        }
        return left; // left will always point to a peak
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6, 7, 8, 5, 1};
        System.out.println("Peak found at index: " + findPeakElement(nums));
    }
}
// another
/*
 Problem Statement:
You are given an array `nums` where:
- `nums[i] ≠ nums[i+1]` (no two adjacent elements are the same)
- A peak element is defined as an element that is strictly greater than its neighbors.
- Your task is to find any peak element and return its index. If multiple peaks exist, returning any is acceptable.

Constraints:
- You must solve this in O(log n) time complexity.

 Approach:
We use binary search to efficiently locate a peak element. The key observations are:
1. If `nums[mid] > nums[mid + 1]`, it means we are in a descending sequence, and a peak exists in the left half, so we move `right = mid`.
2. Otherwise, if `nums[mid] < nums[mid + 1]`, we are in an ascending sequence, meaning there must be a peak in the right half, so we move `left = mid + 1`.
3. The loop terminates when `left == right`, which is our peak index.
# Why does this work?
- Since each element is distinct, the binary search will always converge to some peak efficiently.
- The search space halves with each iteration, ensuring O(log n) complexity.


 Complexity Analysis:
- Time Complexity: O(log n) → Each iteration halves the search space.
- Space Complexity: O(1) → No extra space used, only variables.

 Alternative Approaches
1. Linear Scan - O(n)
   - Iterate through `nums`, checking `nums[i] > nums[i-1] && nums[i] > nums[i+1]`.
   - Works but inefficient compared to binary search.

2. Recursive Binary Search
   - Similar to the iterative approach but uses recursion.
   - Avoids explicit loops but adds function call overhead.

 Test Cases to Consider:
1. Single Element → `nums = [3]`
2. Strictly Increasing → `nums = [1, 2, 3, 4, 5]`
3. Strictly Decreasing → `nums = [5, 4, 3, 2, 1]`
4. Multiple Peaks → `nums = [1, 3, 2, 4, 1]`
5. Large Input → Edge case testing for efficiency.

 Final Thoughts
- This approach guarantees a peak element in O(log n).
- The binary search efficiently narrows down the search space.
- Works well for both small and large arrays.

 */