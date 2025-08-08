package Arrays.Medium;

import java.util.Arrays;

class Leaders {

    public static int[] printLeaders(int[] arr) {
        int n = arr.length;
        // Array to store leaders
        int[] leaders = new int[n];
        int leaderCount = 0;

        // Last element of an array is always a leader.
        int max = arr[n - 1];
        leaders[leaderCount++] = max;


        // Traverse the array from the second-last element to the beginning.
        for (int i = n - 2; i >= 0; i--) {
            if (arr[i] > max) {
                max = arr[i];
                leaders[leaderCount++] = max;
            }
        }

        // Reverse the leaders array to maintain original order.
        reverseArray(leaders, leaderCount);

        // Return only the valid portion of the leaders array.
        return Arrays.copyOfRange(leaders, 0, leaderCount);
    }

    public static void reverseArray(int[] arr, int size) {
        for (int i = 0; i < size / 2; i++) {
            int temp = arr[i];
            arr[i] = arr[size - 1 - i];
            arr[size - 1 - i] = temp;
        }
    }

    public static void main(String args[]) {
        // Array Initialization

        int arr[] = {10, 22, 12, 3, 0, 6};

        // Get leaders without using ArrayList
        int[] leaders = printLeaders(arr);

        // Print leaders
        for (int leader : leaders) {
            System.out.print(leader + " ");
        }
    }
}

/*



import java.util.*;

class Leaders{

public static ArrayList<Integer>  printLeadersBruteForce(int[] arr, int n){

  ArrayList<Integer> ans= new ArrayList<>();

   // Last element of an array is always a leader,
   // push into ans array.
   int max = arr[n - 1];

    ans.add(arr[n-1]);

    // Start checking from the end whether a number is greater
    // than max no. from right, hence leader.
    for (int i = n - 2; i >= 0; i--)
      if (arr[i] > max) {
        ans.add(arr[i]);
        max = arr[i];
      }

  return ans;

}

public static void main(String args[])
{
  // Array Initialization.
  int n = 6;
  int arr[]=  {10, 22, 12, 3, 0, 6};


  ArrayList<Integer> ans= printLeadersBruteForce(arr,n);

  Collections.sort(ans, Collections.reverseOrder());

  for (int i = 0; i < ans.size(); i++) {
    System.out.print(ans.get(i)+" ");
  }

}
}


 */

/*
 Problem Statement:
You need to find all "leaders" in an array. A leader is defined as an element that is greater than all the elements to its right in the array. The last element is always a leader.

 Approach:
1. **Iterative Analysis:**
   - Start by assuming the last element is a leader since it has no elements to its right.
   - Traverse the array from right to left and keep track of the maximum value encountered so far (`max`).
   - If the current element is greater than `max`, it is a leader.
   - Store leaders in a temporary array.
   - Since leaders are identified in reverse order, reverse the collected leaders before returning them.

2. **Optimizations:**
   - The solution avoids additional data structures like `ArrayList` for storage and uses a fixed-size array for memory efficiency.
   - Time complexity is \(O(n)\) due to single traversal of the array.
   - Space complexity is \(O(n)\) to store the leaders.



 Complexity Analysis:
1. **Time Complexity:**
   - The main traversal from right to left is \(O(n)\).
   - Reversing the array of leaders takes \(O(k)\), where \(k\) is the number of leaders (\(k \leq n\)).
   - Overall time complexity: \(O(n)\).

2. **Space Complexity:**
   - The additional array `leaders` is \(O(n)\), which could be optimized further depending on the requirements.
   - Total space complexity: \(O(n)\).

 Output:
Given the input array `arr = {10, 22, 12, 3, 0, 6}`, the leaders are:

22 12 6




 */