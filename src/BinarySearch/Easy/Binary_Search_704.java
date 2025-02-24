package BinarySearch.Easy;

// bruteforce linear search approach

class LinearSearch{
    public static int search(int[] arr, int target){
        for(int i=0;i< arr.length;i++){
            if(arr[i] == target){
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int [] arr = {1,3,5,7,9,11};
        int target = 9;
        int result = search(arr,target);
        System.out.println(result);
    }
}
// TC -> O(n)
// SC -> O(1)

// Optimal: Binary Search (O(log N) Time Complexity)
class BinarySearch {
    public static int search(int[] arr, int x) {
        int low = 0, high = arr.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2; // Avoids overflow

            if (arr[mid] == x) return mid;  // Found target
            else if (arr[mid] < x) low = mid + 1;  // Search right half
            else high = mid - 1;  // Search left half
        }
        return -1; // Element not found
    }

    public static void main(String[] args) {
        int[] arr = {1, 3, 5, 7, 9, 11};
        int x = 7;
        int result = search(arr, x);
        System.out.println("Index of " + x + ": " + result);
    }
}

// Binary Search using Recursion
class BinarySearchRecursive {
    public static int search(int[] arr, int low, int high, int x) {
        if (low > high) return -1; // Base case

        int mid = low + (high - low) / 2;

        if (arr[mid] == x) return mid;  // Found target
        else if (arr[mid] < x) return search(arr, mid + 1, high, x); // Right half
        else return search(arr, low, mid - 1, x); // Left half
    }

    public static void main(String[] args) {
        int[] arr = {1, 3, 5, 7, 9, 11};
        int x = 7;
        int result = search(arr, 0, arr.length - 1, x);
        System.out.println("Index of " + x + ": " + result);
    }
}


/*

Problem Statement
Given a sorted array, implement search algorithms to find the index of a target element.

Approaches
1. **Linear Search (Brute Force) – O(N):** Iterate through the array to find the target.
2. **Binary Search (Iterative) – O(log N):** Use a divide-and-conquer approach to efficiently locate the target.
3. **Binary Search (Recursive) – O(log N):** Implement binary search using recursion for a cleaner approach.



Complexity Analysis
| Approach | Time Complexity | Space Complexity |
|----------|---------------|----------------|
| Linear Search | O(N) | O(1) |
| Binary Search (Iterative) | O(log N) | O(1) |
| Binary Search (Recursive) | O(log N) | O(log N) (due to recursion stack) |

**Conclusion:** Binary Search is optimal for sorted arrays, with iterative being more space-efficient than recursive.

 */