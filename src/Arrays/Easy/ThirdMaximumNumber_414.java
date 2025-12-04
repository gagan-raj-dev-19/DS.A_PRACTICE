package Arrays.Easy;

import java.util.TreeSet;

class ThirdMaximumNumber {
    public static int thirdMax(int[] nums) {
        TreeSet<Integer> result = new TreeSet<>();
        for (int num : nums) {
            result.add(num);
            if (result.size() > 3) {
                result.pollFirst(); // Remove the smallest element
            }
        }
        return result.size() < 3 ? result.last() : result.first();
    }

    public static void main(String[] args) {
        int[] nums = {3, 2, 2, 1, 5};
        int res = thirdMax(nums);
        System.out.println(res); // Expected output: 2
    }
}


/*
**Problem Statement**
Find the third distinct maximum number in an array of integers. If the third maximum does not exist, return the maximum number.

---

### **Approach**
1. Use a **TreeSet** to automatically sort and store distinct integers.
2. Iterate through the array and add each number to the TreeSet.
   - If the TreeSet's size exceeds 3, remove the smallest element to ensure it contains only the largest three distinct numbers at any time.
3. At the end:
   - If the size of the TreeSet is less than 3, return the largest number (`result.last()`).
   - Otherwise, return the smallest number in the TreeSet (`result.first()`), which represents the third largest.

**Optimizations**:
- The TreeSet maintains a sorted order and ensures O(log k) insertion/deletion time, where \( k \) is the size of the TreeSet. Here, \( k \leq 3 \), which makes the operations efficient.

**Complexity Analysis**

#### **Time Complexity**
- **TreeSet Operations**:
  Each insertion/removal operation in a TreeSet takes \( O(\log k) \), where \( k \) is the size of the TreeSet. In this case, \( k \leq 3 \).
  - Looping through all \( n \) elements: \( O(n \log 3) = O(n) \).
- **Overall**: \( O(n) \).

#### **Space Complexity**
- The TreeSet stores at most 3 elements at a time, leading to a constant \( O(1) \) additional space.

---

### **Key Notes**
- The solution handles duplicates automatically because TreeSet only stores unique elements.
- It efficiently maintains only the top three largest distinct numbers, ensuring optimal memory usage and processing time.

 */