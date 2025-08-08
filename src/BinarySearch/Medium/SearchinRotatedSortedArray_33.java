package BinarySearch.Medium;


class SearchinRotatedSortedArray {
    public static int searchRotatedArray(int[] arr, int target) {
        int n = arr.length;
        int left = 0;
        int right = n - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            // Check if the target is found at mid
            if (arr[mid] == target) {
                return mid;
            }

            // If the left half is sorted
            if (arr[left] <= arr[mid]) {
                if (arr[left] <= target && target <= arr[mid]) {
                    right = mid - 1; // Target lies in the left part
                } else {
                    left = mid + 1; // Target lies in the right part
                }
            }
            // If the right half is sorted
            else {
                if (arr[mid] < target && target <= arr[right]) {
                    left = mid + 1; // Target lies in the right part
                } else {
                    right = mid - 1; // Target lies in the left part
                }
            }
        }
        return -1; // Target not found
    }

    public static void main(String[] args) {
        int[] arr = {4, 5, 6, 7, 0, 1, 2}; // Example rotated sorted array
        int target = 0;
        System.out.println(searchRotatedArray(arr, target)); // Expected output: 4
    }
}


/*
 Problem Statement:
Given a rotated sorted array of integers, `arr`, and a target integer, `target`, the task is to find the index of the target in the array. If the target is not found, return `-1`. The array is sorted, but then rotated at an unknown pivot, and each element in the array is unique.

 Approach:
1. Binary Search: Since the array is sorted but rotated, we can use a modified binary search.
2. Identifying the Pivot: The array can be divided into two parts—one part is sorted in ascending order, and the other part is rotated.
3. Two Cases in Each Iteration:
   - Left side is sorted: If the element at the left pointer (`arr[left]`) is less than or equal to the element at the middle (`arr[mid]`), the left side is sorted. In this case, check if the target lies between `arr[left]` and `arr[mid]`. If yes, move the `right` pointer to `mid - 1`; otherwise, move the `left` pointer to `mid + 1`.
   - Right side is sorted: If the left side is not sorted, then the right side must be sorted. In this case, check if the target lies between `arr[mid]` and `arr[right]`. If yes, move the `left` pointer to `mid + 1`; otherwise, move the `right` pointer to `mid - 1`.


 Complexity Analysis:
- Time Complexity: The algorithm runs in O(log N) time because it uses binary search, reducing the problem size by half in each iteration.
- Space Complexity: The space complexity is O(1) because the solution uses a constant amount of extra space for the variables (`left`, `right`, and `mid`).

 Key Observations:
- We exploit the fact that the array is sorted (before being rotated), which allows us to efficiently narrow down the search space by checking which half is sorted at each step.
- The algorithm works even for edge cases like when the array is not rotated or the target is not in the array.


 */