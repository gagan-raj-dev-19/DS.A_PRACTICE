package Arrays.Easy;

class NumberofEmployeesWhoMettheTarget {
    public static int numberOfEmployeesWhoMetTarget(int[] hours, int target) {
        int count = 0;
        for(int hour : hours){
            if(hour >= target){
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] hours = {1,2,3,4,5,6};
        int target = 3;
        int[] hours1 = {1,2,3,4,5,6};
        int target1 = 7;
        System.out.println(numberOfEmployeesWhoMetTarget(hours,target));
        System.out.println(numberOfEmployeesWhoMetTarget(hours1,target1));

    }
}

/*


 **Problem Statement:**
You are given an array `hours` where each element represents the number of hours an employee worked. You are also given a target value `target`. The task is to determine the number of employees who worked `target` hours or more.



 **Approach:**
1. **Iterate through the array:** Use a simple `for-each` loop to traverse each element in the array.
2. **Compare with target:** For each element, check if it is greater than or equal to the `target`.
3. **Count the matches:** Maintain a counter that increments for every match.
4. **Return the count:** After completing the iteration, return the final count.

 **Possible Optimizations:**
This problem is already solved in O(n) time complexity. Given the simplicity, there is no need for advanced optimizations unless additional constraints are introduced.


 **Complexity Analysis:**

1. **Time Complexity:**
   - The function performs a single pass through the array `hours` (of size `n`).
   - Thus, the time complexity is **O(n)**.

2. **Space Complexity:**
   - No additional data structures are used.
   - The space complexity is **O(1)** (constant space).



 **Sample Outputs:**

 Input:
- `hours = {1, 2, 3, 4, 5, 6}`
- `target = 3`

 Output:
- `4` (Employees working 3 or more hours: `{3, 4, 5, 6}`)

 Input:
- `hours = {1, 2, 3, 4, 5, 6}`
- `target = 7`

 Output:
- `0` (No employee worked 7 or more hours)

---

This solution is clear, efficient, and adheres to the problem requirements.



 */
