package BinarySearch.Medium;

class smallestDivisorBrute {
    public static int smallestDivisor(int[] nums, int threshold) {
        int divisor = 5;
        while(true){
            int sum = 0;
            for(int num : nums){
                sum+= Math.ceil((double) num / divisor);
                if(sum <= threshold){
                    return divisor;
                }
            }
            divisor++;
        }
    }

    public static void main(String[] args) {
        int[] nums = {1,2,5,9};
        int threshold = 6;
        System.out.println("brute : "+ smallestDivisor(nums,threshold));
    }
}

class  smallestDivisorOptimal{
    public static int smallestDivisor(int[] nums, int threshold) {
        int left = 1;
        int right = findMax(nums);
        int ans = right;
        while (left <= right){
            int mid = left+(right-left)/2;
            if(isValid(nums,mid,threshold)){
                ans = mid;
                right=mid-1;
            }else{
                left=mid+1;
            }
        }
        return ans;

    }

    private static int findMax(int[] nums) {
        int maxVal = nums[0];
        for(int num:nums){
            maxVal = Math.max(maxVal,num);
        }
        return maxVal;
    }
    private static boolean isValid(int[] nums, int divisor,int threshold ) {
        int sum = 0;
        for (int num : nums){
            sum += (num + divisor-1) / divisor;
        }
        return sum <= threshold;
    }

    public static void main(String[] args) {
        int nums[] = {21212,10101,12121};
        int threshold = 1000000;
        System.out.println("Optimal : " + smallestDivisor(nums,threshold));
    }
}

/*
 * Smallest Divisor Given a Threshold
 *
 * Problem Statement:
 * Given an array of integers `nums` and an integer `threshold`,
 * find the smallest integer `divisor` such that the sum of all elements in `nums`
 * divided by `divisor`, rounded up individually, does not exceed `threshold`.
 *
 * Approaches:
 *
 * 1. Linear Search (Brute Force) – O(N * Max Element)
 *    - Start from `divisor = 1` and incrementally check each divisor.
 *    - Compute the sum of ceiling values `num / divisor` for all elements.
 *    - If sum ≤ threshold, return the divisor.
 *    - Very slow for large values of `nums`.
 *
 * 2. Binary Search (Optimal) – O(N log Max Element)
 *    - Perform binary search on the range `[1, max(nums)]`.
 *    - For each `mid`, compute the sum using `(num + mid - 1) / mid` (equivalent to `ceil(num / mid)`).
 *    - If sum ≤ threshold, try a smaller divisor (`right = mid - 1`).
 *    - Otherwise, increase divisor (`left = mid + 1`).
 *
 * Complexity Analysis:
 *
 * | Approach                   | Time Complexity    | Space Complexity |
 * |----------------------------|------------------|----------------|
 * | Linear Search (Brute)      | O(N * Max)       | O(1)           |
 * | Binary Search (Optimal)    | O(N log Max)     | O(1)           |
 *
 * Conclusion:
 * - **Binary Search** optimally finds the smallest divisor with a much lower time complexity.
 * - **Efficient for large datasets compared to brute force.**
 */
