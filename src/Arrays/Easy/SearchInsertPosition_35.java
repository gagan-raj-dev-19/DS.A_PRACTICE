package Arrays.Easy;

class InsertPos {
    public static int searchInsert(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, 5, 8}; // Ensure the array is sorted
        int target = 7;
        int res = searchInsert(nums, target);
        System.out.println("Insert position: " + res);
    }
}

/*
**Problem Statement**
Given a sorted array of distinct integers and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.

**Example:**
Input: `nums = [1,3,5,6], target = 5`
Output: `2`

Input: `nums = [1,3,5,6], target = 2`
Output: `1`

---

### **Approach**
1. Use Binary Search:
   - Calculate the middle index.
   - Check if the target matches the middle element.
   - If the target is smaller, adjust the search range to the left.
   - If larger, adjust to the right.
2. Return the left pointer as the insertion point when the loop exits.

**Complexity Analysis**
- **Time Complexity**: `O(log n)` due to binary search.
- **Space Complexity**: `O(1)` as no additional space is used.

---

### **Key Points**
1. Always ensure the input array meets the problem's constraints (sorted in ascending order).
2. Binary search is efficient for finding the target or determining the insertion index.


 */