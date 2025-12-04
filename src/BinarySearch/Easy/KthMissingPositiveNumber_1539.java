package BinarySearch.Easy;

// Brute Force Approach
class BruteForce {
    public static int findKthPositive(int[] arr, int k) {
        int missingCount = 0; // Count of missing numbers
        int num = 1; // Starting number to check
        int i = 0; // Pointer for array traversal

        // Infinite loop that breaks when we find the kth missing number
        while (true) {
            if (i < arr.length && arr[i] == num) { // If num is present in arr, move to next element
                i++;
            } else { // If num is missing from arr, increment missing count
                missingCount++;
                if (missingCount == k) { // If we found the kth missing number, return it
                    return num;
                }
            }
            num++; // Move to next number
        }
    }

    public static void main(String[] args) {
        int[] arr = {2, 3, 4, 7, 11};
        int k = 5;
        System.out.println(findKthPositive(arr, k)); // Output: 9
    }
}

// Optimized Approach using Binary Search
class Optimised {
    public static int findKthPositive(int[] arr, int k) {
        int left = 0;
        int right = arr.length - 1;

        // Binary search to find the position where kth missing number would be
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int missingNumber = arr[mid] - (mid + 1); // Count of missing numbers till index mid

            if (missingNumber < k) {
                left = mid + 1; // Move to the right half
            } else {
                right = mid - 1; // Move to the left half
            }
        }

        return k + left; // The kth missing number
    }

    public static void main(String[] args) {
        int[] arr = {2, 3, 4, 7, 11};
        int k = 5;
        System.out.println(findKthPositive(arr, k)); // Output: 9
    }
}

/*

 * Problem Statement:
 * Given a sorted array 'arr' of positive integers in strictly increasing order and an integer 'k',
 * return the k-th missing positive integer.

 * Example:
 * Input: arr = [2, 3, 4, 7, 11], k = 5.
 * Output: 9
 * Explanation: The missing numbers are [1, 5, 6, 8, 9, 10, 12, ...].
 * The 5th missing number is 9.

 * Approach 1: Brute Force (O(N))
 * - Iterate from 1 upward and check if each number is in 'arr'.
 * - Keep track of the count of missing numbers.
 * - Stop when we reach the k-th missing number.

 * Time Complexity: O(N) (Iterate until we find the k-th missing number)
 * Space Complexity: O(1) (No extra space used)

 * Approach 2: Binary Search (O(log N))
 * - Calculate the missing count before each element.
 * - Use binary search to find the position where missing numbers become >= k.
 * - The answer is (k + left).

 * Time Complexity: O(log N) (Binary search reduces search space)
 * Space Complexity: O(1) (Only variables used)
 */