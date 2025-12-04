package Arrays.Medium;

import java.util.ArrayList;
import java.util.List;

class SpiralMatrix {
    public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        int top = 0;
        int left = 0;
        int bottom = matrix.length - 1;
        int right = matrix[0].length - 1;

        while (top <= bottom && left <= right) {
            // Traverse from left to right along the top boundary
            for (int i = left; i <= right; i++) {
                result.add(matrix[top][i]);
            }
            top++;

            // Traverse from top to bottom along the right boundary
            for (int i = top; i <= bottom; i++) {
                result.add(matrix[i][right]);
            }
            right--;

            // Traverse from right to left along the bottom boundary (if valid)
            if (top <= bottom) {
                for (int i = right; i >= left; i--) {
                    result.add(matrix[bottom][i]);
                }
                bottom--;
            }

            // Traverse from bottom to top along the left boundary (if valid)
            if (left <= right) {
                for (int i = bottom; i >= top; i--) {
                    result.add(matrix[i][left]);
                }
                left++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        System.out.println(spiralOrder(matrix));
    }
}
/*
 Problem Statement
You need to traverse a 2D matrix in a spiral order starting from the top-left corner, proceeding along the outer edge in a clockwise manner, and continuing inward until all elements are visited. The output should be a list of integers representing the traversal sequence.

 Approach
1. **Define Boundaries:** Use four boundaries (`top`, `bottom`, `left`, `right`) to track the unvisited edges of the matrix.
2. **Traversal Directions:**
   - Traverse the top boundary from left to right.
   - Traverse the right boundary from top to bottom.
   - Traverse the bottom boundary from right to left (if still valid).
   - Traverse the left boundary from bottom to top (if still valid).
3. **Update Boundaries:** After each traversal, shrink the corresponding boundary inward to avoid reprocessing elements.
4. **Termination Condition:** Continue traversing as long as `top <= bottom` and `left <= right`.

 Complexity Analysis
1. **Time Complexity:** (O(m times n)), where (m) is the number of rows and (n) is the number of columns. Each element is visited exactly once.
2. **Space Complexity:** (O(1)) additional space (excluding the output list).

 */