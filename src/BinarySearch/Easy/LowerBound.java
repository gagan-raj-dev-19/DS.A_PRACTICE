package BinarySearch.Easy;
// bruteforce
class LowerBoundBrute {
    public static int lowerBound(int[] arr, int k){
        int n = arr.length;
        for (int i=0;i<n;i++){
            if (arr[i] >= k){
                return i;
            }
        }
        return n;
    }

    public static void main(String[] args) {
        int[] arr = {3,5,8,15,19};
        int k = 9;
        System.out.println(lowerBound(arr,k));
    }
}

// optimised
class LowerBoundOptimised {
    public static int lowerBound(int[] arr, int k) {
        int left=0;
        int right= arr.length;
        while(left<right){
            int mid=left+(right-left)/2;
            if (arr[mid]>=k){
                right=mid;
            }
            else {
                left=mid+1;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        int[] arr = {3,5,8,15,19};
        int k = 9;
        System.out.println(lowerBound(arr,k));
    }
}
/*


 **Problem Statement**
Given a sorted array and a target value `k`, find the **lower bound** of `k`. The lower bound is the index of the first element in the array that is **greater than or equal to** `k`. If no such element exists, return the size of the array.

---

 **Approach**
There are two ways to solve this problem:

 **1. Brute Force Approach**
- Iterate through the array.
- Find the first element that is **greater than or equal to** `k` and return its index.
- If no such element is found, return `n` (array size).
- **Time Complexity**: \(O(N)\), since we may traverse the entire array in the worst case.
- **Space Complexity**: \(O(1)\), as no extra space is used.

 **2. Optimized Approach (Binary Search)**
- Use **Binary Search** to efficiently find the lower bound.
- Maintain two pointers: `left = 0` and `right = n`.
- Find the **midpoint**:
  - If `arr[mid] >= k`, move `right = mid` (narrow the search to the left half).
  - Otherwise, move `left = mid + 1` (narrow the search to the right half).
- The **loop ends when left and right converge**, and `left` will hold the index of the lower bound.
- **Time Complexity**: \(O(\log N)\), as the search space is reduced by half at each step.
- **Space Complexity**: \(O(1)\), as no extra space is used.



 **Complexity Analysis**
| Approach | Time Complexity | Space Complexity |
|----------|---------------|----------------|
| **Brute Force** | \(O(N)\) | \(O(1)\) |
| **Binary Search** | \(O(\log N)\) | \(O(1)\) |

---

 **Key Takeaways**
- **Use brute force** for small arrays (linear search is simple and easy to implement).
- **Use binary search** for larger arrays as it significantly reduces the number of comparisons.



 */