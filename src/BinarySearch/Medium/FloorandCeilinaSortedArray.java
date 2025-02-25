package BinarySearch.Medium;


// Brute Force: Floor & Ceil in a Sorted Array (O(N))
 class FloorCeilBrute {
    public static int findFloor(int[] arr, int x) {
        int floor = -1;
        for (int num : arr) {
            if (num <= x) floor = num; // Update floor if num ≤ X
            else break; // No need to check further
        }
        return floor;
    }

    public static int findCeil(int[] arr, int x) {
        for (int num : arr) {
            if (num >= x) return num; // First num ≥ X is ceil
        }
        return -1; // No ceil found
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 8, 10, 10, 12, 19};
        int x = 5;
        System.out.println("Floor: " + findFloor(arr, x)); // Output: 2
        System.out.println("Ceil: " + findCeil(arr, x));   // Output: 8
    }
}


// Optimal: Floor & Ceil in a Sorted Array (O(log N))
 class FloorCeilOptimal {
    public static int findFloor(int[] arr, int x) {
        int low = 0, high = arr.length - 1;
        int floor = -1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] <= x) {
                floor = arr[mid]; // Update floor and search right
                low = mid + 1;
            } else {
                high = mid - 1; // Search left
            }
        }
        return floor;
    }

    public static int findCeil(int[] arr, int x) {
        int low = 0, high = arr.length - 1;
        int ceil = -1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] >= x) {
                ceil = arr[mid]; // Update ceil and search left
                high = mid - 1;
            } else {
                low = mid + 1; // Search right
            }
        }
        return ceil;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 8, 10, 10, 12, 19};
        int x = 5;
        System.out.println("Floor: " + findFloor(arr, x)); // Output: 2
        System.out.println("Ceil: " + findCeil(arr, x));   // Output: 8
    }
}

/*
 * Floor & Ceil in a Sorted Array
 *
 * Problem Statement:
 * Given a sorted array and an integer X, find:
 *  - Floor(X): The greatest element ≤ X. If no such element exists, return -1.
 *  - Ceil(X): The smallest element ≥ X. If no such element exists, return -1.
 *
 * Approaches:
 *
 * 1. Linear Search (Brute Force) – O(N)
 *    - Iterate through the array to find the largest number ≤ X (Floor).
 *    - Iterate again to find the smallest number ≥ X (Ceil).
 *    - Inefficient for large arrays.
 *
 * 2. Binary Search (Optimal) – O(log N)
 *    - Use binary search to efficiently locate Floor(X) and Ceil(X).
 *    - Maintain variables to store the best candidate found so far.
 *    - Reduce search space by adjusting `low` and `high` pointers.
 *
 * Complexity Analysis:
 *
 * | Approach                   | Time Complexity | Space Complexity |
 * |----------------------------|---------------|----------------|
 * | Linear Search (Brute)      | O(N)          | O(1)          |
 * | Binary Search (Optimal)    | O(log N)      | O(1)          |
 *
 * Conclusion:
 * - **Binary Search** significantly improves efficiency compared to the brute-force approach.
 * - **Useful in scenarios like range queries and searching within sorted data.**
 */
