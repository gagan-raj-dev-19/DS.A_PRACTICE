package Arrays.Medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class MergeInterval {
    public static int[][] mergeInterval(int[][] intervals) {
        // Sort intervals based on the start time
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        List<int[]> result = new ArrayList<>();
        int[] currentInterval = intervals[0];

        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] <= currentInterval[1]) {
                // Merge intervals by updating the end time
                currentInterval[1] = Math.max(currentInterval[1], intervals[i][1]);
            } else {
                // Add merged interval to the result list and move to the next
                result.add(currentInterval);
                currentInterval = intervals[i];
            }
        }
        result.add(currentInterval); // Add the last merged interval

        return result.toArray(new int[result.size()][]);
    }

    public static void main(String[] args) {
        int[][] intervals = {{1, 3}, {2, 6}, {8, 10}, {18, 28}};
        print(mergeInterval(intervals));
    }

    public static void print(int[][] intervals) {
        for (int[] interval : intervals) {
            System.out.print(Arrays.toString(interval) + " ");
        }
    }
}

/*.

 **Problem Statement**
Given an array of intervals where `intervals[i] = [start, end]`, merge all overlapping intervals and return an array of the non-overlapping intervals that cover all the intervals in the input.

 **Example Input and Output:**
**Input:**
`[[1,3],[2,6],[8,10],[18,28]]`
**Output:**
`[[1,6],[8,10],[18,28]]`


 **Approach**
1. **Sorting Step:**
   - First, sort the intervals based on their start times (`intervals[i][0]`).
   - Sorting ensures that overlapping intervals are adjacent.

2. **Merging Step:**
   - Initialize a list `result` to store merged intervals.
   - Start with the first interval and iterate through the sorted list:
     - If the current interval overlaps with the previous one (`intervals[i][0] ≤ currentInterval[1]`), merge them by updating the end time to the maximum of both.
     - If they don't overlap, add the current merged interval to the result list and proceed to the next interval.
   - Finally, add the last interval to the result list.


 **Complexity Analysis**

 **Time Complexity:**
- **Sorting step:** \(O(n \log n)\)
- **Merging step:** \(O(n)\) (as we traverse through the sorted list once)
- **Overall:** \(O(n \log n)\)

 **Space Complexity:**
- If we don't consider the output, the extra space used is \(O(1)\), as we are modifying and storing the result in the list.
- If considering the output storage, the space complexity is \(O(n)\).



 */