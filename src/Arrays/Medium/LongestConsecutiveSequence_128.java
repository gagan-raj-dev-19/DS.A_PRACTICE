package Arrays.Medium;

import java.util.Arrays;

public class LongestConsecutiveSequence_128 {
    public static int longestConsecutive(int[] arr) {
        int n = arr.length;
        if (n == 0) {
            return 0;
        }

        // Step 1: Sort the array
        Arrays.sort(arr);

        // Initialize variables
        int previous = Integer.MIN_VALUE;
        int currentStreak = 1; // To count the length of the current sequence
        int longestStreak = 1; // To store the maximum sequence length

        // Step 2: Traverse the sorted array
        for (int j : arr) {
            if (j == previous + 1) {
                // Consecutive element found
                currentStreak++;
            } else if (j != previous) {
                // Reset streak for non-duplicate, non-consecutive element
                currentStreak = 1;
            }
            // Update the longest streak
            longestStreak = Math.max(longestStreak, currentStreak);
            previous = j;
        }

        return longestStreak;
    }

    public static void main(String[] args) {
        int[] arr = {4, 3, 2, 1, 100, 200};
        System.out.println(longestConsecutive(arr)); // Output: 4
    }
}

/*

**Problem Statement**
Given an unsorted array of integers, find the length of the longest consecutive elements sequence.

**Example Input**: `[4, 3, 2, 1, 100, 200]`
**Output**: `4` (Longest consecutive sequence: `[1, 2, 3, 4]`)



 **Approach Explanation**

 Current Approach (Sorting-based):
1. **Sort the Array**: Sorting ensures that consecutive elements will appear adjacent to each other.
2. **Iterate Through the Array**: Keep track of the length of the current consecutive sequence using two variables:
   - `lastSmallest`: Stores the last seen element in the sequence.
   - `count`: Tracks the current consecutive sequence length.
3. **Update Longest Sequence**: Use a variable `longest` to store the maximum sequence length encountered so far.

 Steps in the Code:
- Sort the array.
- Traverse the sorted array to check for consecutive numbers:
  - If `arr[i] == lastSmallest + 1`, increment the current sequence length (`count`).
  - If `arr[i] != lastSmallest` (i.e., the sequence is broken or duplicates are found), reset `count` to 1.
- Update `longest` with the maximum of `count` and `longest`.

**Complexity Analysis**

1. **Time Complexity**:
   - Sorting takes **O(n log n)**.
   - Traversing the array takes **O(n)**.
   - Overall: **O(n log n)**.

2. **Space Complexity**:
   - Sorting uses extra space depending on the sorting algorithm (e.g., TimSort in Java uses **O(n)** in the worst case for auxiliary storage).
   - No additional space used apart from a few variables: **O(1)**.



 **Optimized Approach (Using HashSet)**
To achieve **O(n)** time complexity, you can use a `HashSet` to check for consecutive sequences without sorting. The key idea is:
- Insert all elements into a `HashSet` for quick lookups.
- For each element, only start a sequence if the element is the smallest in its sequence (i.e., `element - 1` is not in the set).



 */