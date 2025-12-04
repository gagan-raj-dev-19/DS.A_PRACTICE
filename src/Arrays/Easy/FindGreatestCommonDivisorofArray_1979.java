package Arrays.Easy;


public class FindGreatestCommonDivisorofArray_1979 {
    // Function to calculate the GCD of two numbers
    public static int gcd(int min, int max) {
        while (max != 0) {
            int temp = max;
            max = min % max;
            min = temp;
        }
        return min;
    }

    // Function to find the GCD of the smallest and largest elements in the array
    public static int gcdArray(int[] nums) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        // Find min and max in a single pass
        for (int num : nums) {
            if (num < min) {
                min = num;
            }
            if (num > max) {
                max = num;
            }
        }

        // Return the GCD of min and max
        return gcd(min, max);
    }

    public static void main(String[] args) {
        // Test arrays
        int[] nums = {2, 3, 1, 5, 6, 4};
        int[] nums1 = {2, 5, 6, 9, 10};

        // Outputs
        System.out.println("GCD of nums: " + gcdArray(nums));   // Expected: 1
        System.out.println("GCD of nums1: " + gcdArray(nums1)); // Expected: 2
    }
}
/*
**Problem Statement**
You aim to find the greatest common divisor (GCD) of the smallest and largest numbers in an array.

### **Approach**
1. **Find Minimum and Maximum:** Traverse the array to identify the smallest and largest numbers.
2. **Compute GCD:** Use the Euclidean algorithm to calculate the GCD of these two numbers.
3. **Optimization:** The Euclidean algorithm is efficient, and finding the minimum and maximum requires only one pass through the array, making the approach optimal for this task.

**Complexity Analysis**
1. **Time Complexity:**
   - **Finding Min and Max:** \(O(n)\), where \(n\) is the size of the array.
   - **Computing GCD:** \(O(\log(\text{min}))\), where \(\text{min}\) is the smallest number.
   - **Overall:** \(O(n + \log(\text{min}))\), which simplifies to \(O(n)\).

2. **Space Complexity:**
   - The space complexity is \(O(1)\) since no additional data structures are used.




 */