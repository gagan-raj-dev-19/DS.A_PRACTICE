package Maths;

class RotateImage {
    public static void rotate(int[][] matrix) {
        int n = matrix.length;

        // Step 1: Transpose the matrix (swap elements symmetrically along the diagonal)
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        // Step 2: Reverse each row
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n / 2; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][n - 1 - j];
                matrix[i][n - 1 - j] = temp;
            }
        }
    }

    public static void main(String[] args) {
        // Input matrix
        int[][] matrix = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };

        // Rotate the matrix in place
        rotate(matrix);

        // Print the rotated matrix
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}


/*
 **Problem Statement**

You are given an \( n * n \) 2D matrix representing an image. Rotate the image by 90 degrees (clockwise).
- **Input**: A square matrix (2D array) of integers.
- **Output**: The same matrix should be rotated in-place, meaning you cannot use extra space for another matrix, but you can modify the input matrix directly.

 **Approach**

 **Thought Process**
1. **Transpose the Matrix**:
   - Convert rows into columns. The value at \( matrix[i][j] \) is swapped with \( matrix[j][i] \) for all \( i \) and \( j \) where \( j > i \) (to avoid redundant swaps).
   - After this step, the diagonal elements remain fixed, and rows become columns.

2. **Reverse Each Row**:
   - Once the matrix is transposed, reverse the order of elements in each row to achieve the 90-degree clockwise rotation.
   - Swap \( matrix[i][j] \) with \( matrix[i][n-1-j] \) for the first half of each row.

 **Optimizations**
- The algorithm is already optimal since it performs the task in-place without requiring additional memory for a new matrix.
- Any further optimization would involve parallel processing if needed.

### **Complexity Analysis**

1. **Time Complexity**:
   - **Transpose Step**: This involves \( \frac{n \cdot (n-1)}{2} \) swaps (upper triangular matrix), which is \( O(n^2) \).
   - **Row Reversal Step**: Each row has \( n/2 \) swaps, leading to \( O(n^2) \).
   - Total time complexity = **\( O(n^2) \)**.

2. **Space Complexity**:
   - The algorithm operates in-place, requiring no additional space apart from temporary variables used for swapping.
   - Space complexity = **\( O(1) \)**.

---

 **Output for the Given Input**
3*3 matrix
**Input Matrix**:
```
1 2 3
4 5 6
7 8 9
```

**Rotated Matrix (90 degrees clockwise)**:
```
7 4 1
8 5 2
9 6 3


4*4 matrix

1  2  3  4
5  6  7  8
9  10 11 12
13 14 15 16

**Rotated Matrix (90 degrees clockwise)**:
13  9   5   1
14  10  6   2
15  11  7   3
16  12  8   4

*/