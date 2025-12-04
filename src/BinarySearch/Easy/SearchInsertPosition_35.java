package BinarySearch.Easy;

// Brute Force: Search Insert Position (O(N))
class SearchInsertBrute {
    public static int searchInsert(int[] arr, int x) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] >= x) return i; // Position to insert X
        }
        return arr.length; // If X is greater than all elements
    }

    public static void main(String[] args) {
        int[] arr = {1, 3, 5, 6};
        int x = 5;
        System.out.println("Insert Position (Brute): " + searchInsert(arr, x)); // Output: 2
    }
}

// Optimal: Search Insert Position (O(log N))
 class SearchInsertOptimal {
    public static int searchInsert(int[] arr, int x) {
        int low = 0, high = arr.length;

        while (low < high) {
            int mid = low + (high - low) / 2;

            if (arr[mid] >= x) high = mid; // Move left
            else low = mid + 1; // Move right
        }
        return low; // Position to insert X
    }

    public static void main(String[] args) {
        int[] arr = {1, 3, 5, 6};
        int x = 5;
        System.out.println("Insert Position (Optimal): " + searchInsert(arr, x)); // Output: 2
    }
}

/*
 * Search Insert Position
 *
 * Problem Statement:
 * Given a sorted array and a target value, return the index if the target is found.
 * If not, return the index where it would be inserted to maintain order.
 * The array contains distinct integers and is sorted in ascending order.
 *
 * Approaches:
 *
 * 1. Linear Search (Brute Force) – O(N)
 *    - Iterate through the array.
 *    - Return the first index where arr[i] >= target.
 *    - If no such index exists, return arr.length.
 *
 * 2. Binary Search (Optimal) – O(log N)
 *    - Use a divide-and-conquer approach.
 *    - Maintain low and high pointers.
 *    - Find mid, adjust search space accordingly.
 *    - Return low as the insert position.
 *
 * Complexity Analysis:
 *
 * | Approach                | Time Complexity | Space Complexity |
 * |-------------------------|---------------|----------------|
 * | Linear Search (Brute)   | O(N)          | O(1)          |
 * | Binary Search (Optimal) | O(log N)      | O(1)          |
 *
 * Conclusion:
 * - Binary Search is optimal for sorted arrays.
 * - It significantly improves efficiency compared to the brute-force approach.
 */


