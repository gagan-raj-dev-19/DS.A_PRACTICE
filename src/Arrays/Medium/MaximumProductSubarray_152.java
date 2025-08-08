package Arrays.Medium;

class MaximumProductSubarray {
    public int maxProduct(int[] nums) {
        if (nums == null || nums.length == 0) return 0;

        int maxProduct = nums[0];
        int minProduct = nums[0];
        int result = nums[0];

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < 0) {
                // Swap maxProduct and minProduct when a negative number is encountered
                int temp = maxProduct;
                maxProduct = minProduct;
                minProduct = temp;
            }

            // Update max and min product ending at index i
            maxProduct = Math.max(nums[i], maxProduct * nums[i]);
            minProduct = Math.min(nums[i], minProduct * nums[i]);

            // Store the maximum product found so far
            result = Math.max(result, maxProduct);
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 2, -3, 0, -4, -5};
        int[] nums2 = {-2, 3, -4};
        int[] nums3 = {2, 3, -2, 4};
        int[] nums4 = {-1, -3, -10, 0, 60};

        MaximumProductSubarray solution = new MaximumProductSubarray();

        // Running test cases
        System.out.println("Max Product: " + solution.maxProduct(nums1)); // Expected: 20
        System.out.println("Max Product: " + solution.maxProduct(nums2)); // Expected: 24
        System.out.println("Max Product: " + solution.maxProduct(nums3)); // Expected: 6
        System.out.println("Max Product: " + solution.maxProduct(nums4)); // Expected: 60
    }
}



/*
 **Problem Statement**
Given an integer array `nums`, find the contiguous subarray within an array (containing at least one number) which has the largest product.

 **Example Cases**
 **Example 1:**
**Input:** `[2,3,-2,4]`
**Output:** `6`
**Explanation:** The subarray `[2,3]` has the largest product `6`.

 **Example 2:**
**Input:** `[-2,0,-1]`
**Output:** `0`
**Explanation:** The single element `0` has the largest product.



 **Approach**
This problem is similar to "Maximum Subarray Sum" (Kadane’s Algorithm), but we have to account for negative numbers, which can flip the sign of the product.

1. **Track two values for each index:**
   - `maxProduct`: Maximum product ending at `i`.
   - `minProduct`: Minimum product ending at `i` (as a negative number multiplied by another negative may become the largest product).

2. **Iterate through `nums`:**
   - If `nums[i]` is negative, swap `maxProduct` and `minProduct`.
   - Update `maxProduct` as `max(nums[i], maxProduct * nums[i])`.
   - Update `minProduct` as `min(nums[i], minProduct * nums[i])`.
   - Track the maximum product encountered (`result`).



 **Complexity Analysis**
- **Time Complexity:** \(O(N)\) → We iterate through `nums` only once.
- **Space Complexity:** \(O(1)\) → We use a few integer variables (`maxProduct`, `minProduct`, `result`).



 **Optimizations & Edge Cases Considered**
✅ Handles negative numbers (by swapping `maxProduct` and `minProduct`).
✅ Accounts for zeros (resets `maxProduct` and `minProduct`).
✅ Works for single-element arrays.


 */


// bruteforce
// class MaximumProductSubarray{
//     public static int maxProd(int[] arr){
//
//         int max = Integer.MIN_VALUE;
//         for (int i=0;i< arr.length-1;i++){
//             for (int j=i+1;j< arr.length;j++){
//                 int prod = 1;
//                 for (int k = i;k<=j;k++){
//                     prod = prod*arr[k];
//                     max = Math.max(max,prod);
//
//                 }
//             }
//         }
//         return max;
//     }
//
//     public static void main(String[] args) {
//         int[] arr = {1,2,-3,0,-4,-5};
//         System.out.println(maxProd(arr));
//     }
//}

