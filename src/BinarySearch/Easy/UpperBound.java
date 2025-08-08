package BinarySearch.Easy;
import java.util.*;

// Brute Force: Upper Bound (O(N))
 class UpperBoundBrute {
    public static int upperBound(int[] arr, int x) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > x) return i; // First occurrence where arr[i] > x
        }
        return arr.length; // If no element is greater than x
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 4, 4, 6, 8, 10};
        int x = 4;
        System.out.println("Upper Bound Index (Brute): " + upperBound(arr, x)); // Output: 4
    }
}


// Optimal: Upper Bound (O(log N))
class UpperBoundOptimal {
    public static int upperBound(int[] arr, int x) {
        int low = 0, high = arr.length;

        while (low < high) {
            int mid = low + (high - low) / 2;

            if (arr[mid] > x) high = mid; // Move left
            else low = mid + 1; // Move right
        }
        return low; // First index where arr[index] > x
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 4, 4, 6, 8, 10};
        int x = 4;
        System.out.println("Upper Bound Index (Optimal): " + upperBound(arr, x)); // Output: 4
    }
}

/*

 Complexity Analysis:
Brute Force:**
  Time Complexity:** (O(N)) (linear scan)
  Space Complexity:** (O(1)) (constant extra space)

Binary Search Approach:**
  Time Complexity:** (O(log N)) (binary search)
  Space Complexity:** (O(1)) (no extra space used)

 Edge Cases to Consider:
✔ `x` is smaller than all elements (should return 0).
✔ `x` is larger than all elements (should return `arr.length`).
✔ All elements are equal to `x` (should return `arr.length`).
✔ Empty array (should return 0).

 */