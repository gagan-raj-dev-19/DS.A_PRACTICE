package Arrays.Easy;

import java.util.ArrayList;
import java.util.List;

public class PascalsTriangle_118 {


    public static List<List<Integer>> pascalTriangle(int numRows) {
        List<List<Integer>> triangle = new ArrayList<>();

        // Edge case: no rows requested
        if (numRows <= 0) {
            return triangle;
        }

        // First row is always [1]
        triangle.add(new ArrayList<>());
        triangle.get(0).add(1);

        // Generate rows 2 through numRows
        for (int i = 1; i < numRows; i++) {
            List<Integer> prevRow = triangle.get(i - 1);
            List<Integer> currRow = new ArrayList<>();

            // First element of the row
            currRow.add(1);

            // Intermediate elements are sums of elements from the previous row
            for (int j = 1; j < prevRow.size(); j++) {
                currRow.add(prevRow.get(j - 1) + prevRow.get(j));
            }

            // Last element of the row
            currRow.add(1);

            // Add the constructed row to the triangle
            triangle.add(currRow);
        }

        return triangle;
    }

    public static void main(String[] args) {
        int numRows = 5;
        List<List<Integer>> result = pascalTriangle(numRows);

        // Print Pascal's Triangle row by row
        for (List<Integer> row : result) {
            System.out.println(row);
        }
    }
}


/*
**Problem Statement**
Generate the first `numRows` rows of Pascal's Triangle.
Each row is constructed using the following rules:
- The first and last element of every row is 1.
- Every other element is the sum of the two elements directly above it from the previous row.

### **Approach**
1. **Initialization:**
   Start with an empty list (`triangle`) to store the rows of Pascal's Triangle. Add the first row manually as `[1]`.

2. **Row Construction:**
   - For each subsequent row:
     - Begin with `1`.
     - Compute intermediate elements as the sum of adjacent elements from the previous row.
     - End the row with `1`.

3. **Optimization:**
   This approach builds the triangle row by row, storing only the necessary information for each row. There’s no redundant computation or storage.

4. **Output:**
   Return the list of lists representing Pascal's Triangle.

**Complexity Analysis**
1. **Time Complexity:**
   - Generating each row requires iterating through the previous row.
   - Total number of elements across all rows for `n` rows is:
     \( 1 + 2 + 3 + \dots + n = \frac{n(n + 1)}{2} \).
   - **Time complexity:** \( O(n^2) \).

2. **Space Complexity:**
   - The space used for the `triangle` list is proportional to the number of elements:
     \( O(n^2) \).

   - Additional space for intermediate variables is negligible compared to the total size of the triangle.
   - **Space complexity:** \( O(n^2) \).


 */