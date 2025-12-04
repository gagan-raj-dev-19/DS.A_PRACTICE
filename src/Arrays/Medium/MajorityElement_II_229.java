package Arrays.Medium;

import java.util.ArrayList;
import java.util.List;

class MajorityElement_II {
    public static List<Integer> majorityElement(int[] nums) {
        int n = nums.length;
        if (nums == null || nums.length == 0) {
            return new ArrayList<>();
        }

        int candidate1 = 0, count1 = 0;
        int candidate2 = 0, count2 = 0;

        // Step 1: Find potential candidates
        for (int num : nums) {
            if (num == candidate1) {
                count1++;
            } else if (num == candidate2) {
                count2++;
            } else if (count1 == 0) {
                candidate1 = num;
                count1 = 1;
            } else if (count2 == 0) {
                candidate2 = num;
                count2 = 1;
            } else {
                count1--;
                count2--;
            }
        }

        // Step 2: Count occurrences of the candidates
        count1 = 0;
        count2 = 0;
        for (int num : nums) {
            if (num == candidate1) {
                count1++;
            } else if (num == candidate2) {
                count2++;
            }
        }

        // Step 3: Prepare the result
        List<Integer> result = new ArrayList<>();
        if (count1 > n / 3) {
            result.add(candidate1);
        }
        if (count2 > n / 3) {
            result.add(candidate2);
        }

        return result;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 2, 3, 2};
        System.out.println(majorityElement(nums));
    }
}


/*
 **Problem Statement:**
Given an integer array `nums`, find all elements that appear **more than** `⌊ n/3 ⌋` times, where `n` is the length of the array. The goal is to return these majority elements in any order.

**Example Input/Output:**

**Input:**
`nums = [3,2,3]`
**Output:**
`[3]`

**Input:**
`nums = [1,1,1,3,3,2,2,2]`
**Output:**
`[1,2]`

---

 **Approach:**
We solve the problem using **Boyer-Moore Voting Algorithm**, which optimizes the solution by reducing the space complexity from O(n) to O(1). The approach follows these steps:

1. **Step 1:** Identify potential majority candidates.
   - Maintain two potential candidates (`candidate1` and `candidate2`) and their respective counts.
   - Traverse through the array:
     - If the current number matches a candidate, increment its count.
     - If any candidate's count is zero, assign the current number to it.
     - Otherwise, decrement counts of both candidates.

2. **Step 2:** Verify the candidates.
   - Traverse through the array again to count occurrences of the selected candidates.
   - If any candidate appears more than `⌊ n/3 ⌋` times, add it to the result list.

 **Why two candidates?**
Since we are looking for elements appearing more than `n/3` times, there can be at most **two** such elements.



 **Complexity Analysis:**

 **Time Complexity:**
- O(n): We iterate over the array twice (once for candidate selection, once for counting), leading to linear time complexity.

 Space Complexity:
- **O(1):** We only use a few extra variables (constant space) to store the candidates and their counts.


 */