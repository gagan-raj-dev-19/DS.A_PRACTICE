package Arrays.Medium;

import java.util.HashSet;
import java.util.Set;

class LongestConsecutiveSequence {
    public int longestConsecutive(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        // Step 1: Add all elements to a HashSet
        Set<Integer> numSet = new HashSet<>();
        for (int num : nums) {
            numSet.add(num);
        }

        int longest = 0;

        // Step 2: Find the longest consecutive sequence
        for (int num : numSet) {
            // Only start counting if it's the beginning of a sequence
            if (!numSet.contains(num - 1)) {
                int currentNum = num;
                int currentLength = 1;

                // Count the length of the sequence
                while (numSet.contains(currentNum + 1)) {
                    currentNum++;
                    currentLength++;
                }

                // Update the longest length
                longest = Math.max(longest, currentLength);
            }
        }

        return longest;
    }

    public static void main(String[] args) {
        LongestConsecutiveSequence obj = new LongestConsecutiveSequence();
        int[] nums = {2, 3, 1, 4, 100, 200};
        System.out.println(obj.longestConsecutive(nums)); // Output: 4
    }
}


/*

**Optimized Approach Explanation**

1. **Key Idea**:
   - Use a `HashSet` to store all the elements of the array. This enables O(1) average-time complexity for lookup operations.
   - For each number in the set, determine if it is the start of a sequence (i.e., `num - 1` is not in the set).
   - If the number is the start of a sequence, incrementally check for consecutive numbers (`num + 1`, `num + 2`, ...) and track the length of the sequence.

2. **Steps**:
   - Add all numbers to the `HashSet`.
   - Iterate through the `HashSet`:
     - If a number does not have a predecessor (`num - 1` is not in the set), it's the start of a sequence.
     - Use a `while` loop to count the length of the sequence.
     - Update the `longest` variable with the maximum sequence length found so far.

3. **Advantages**:
   - This approach avoids the need for sorting, achieving O(n) time complexity.
   - Handles duplicates naturally due to the properties of a `HashSet`.

**Complexity Analysis**

1. **Time Complexity**:
   - Adding elements to the `HashSet` takes **O(n)**.
   - Iterating through the `HashSet` and checking for sequences takes **O(n)** in total, since each element is processed once during the `while` loop.
   - Overall: **O(n)**.

2. **Space Complexity**:
   - The `HashSet` stores all unique elements of the array, requiring **O(n)** space.
   - Other variables use constant space: **O(1)**.



 **Explanation of Test Case**
 Input:
nums = {2, 3, 1, 4, 100, 200}
 Output:
- Longest consecutive sequence is `[1, 2, 3, 4]`, length = 4.
- The code correctly outputs `4`.



 */