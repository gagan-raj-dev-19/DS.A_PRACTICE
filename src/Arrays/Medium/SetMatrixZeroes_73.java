package Arrays.Medium;

class SetMatrixZeroes {
    public static void setZeroes(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        boolean firstRowZero = false;
        boolean firstColZero = false;

        // Check if the first row has any zero
        for (int i = 0; i < cols; i++) {
            if (matrix[0][i] == 0) {
                firstRowZero = true;
                break;
            }
        }

        // Check if the first column has any zero
        for (int j = 0; j < rows; j++) {
            if (matrix[j][0] == 0) {
                firstColZero = true;
                break;
            }
        }

        // Use the first row and column as markers
        for (int i = 1; i < rows; i++) {
            for (int j = 1; j < cols; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }

        // Set matrix cells to zero based on markers
        for (int i = 1; i < rows; i++) {
            for (int j = 1; j < cols; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }

        // Handle the first row
        if (firstRowZero) {
            for (int i = 0; i < cols; i++) {
                matrix[0][i] = 0;
            }
        }

        // Handle the first column
        if (firstColZero) {
            for (int j = 0; j < rows; j++) {
                matrix[j][0] = 0;
            }
        }
    }

    public static void main(String[] args) {
        int[][] matrix = {{0, 1, 2, 0}, {3, 4, 5, 2}, {1, 3, 1, 5}};
        setZeroes(matrix);
        printMatrix(matrix);
    }

    // Helper method to print the matrix
    private static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int elem : row) {
                System.out.print(elem + " ");
            }
            System.out.println();
        }
    }
}



/*
 Problem Statement
You are given an `m x n` matrix. If an element is `0`, set its entire row and column to `0`. Do this **in place**, meaning you must not use additional space for another matrix but can use constant space.



 Approach
To achieve this in-place, we can use the first row and the first column of the matrix as markers to indicate which rows and columns should be set to `0`. The detailed steps are:

1. **Check if the first row or column needs to be zeroed out**:
   - Traverse the first row and column to check for any `0`.
   - Use `firstRowZero` and `firstColZero` flags to remember if they should be set to `0`.

2. **Use the first row and column as markers**:
   - For every cell in the matrix (excluding the first row and column), if the cell is `0`, mark the corresponding first row and first column cell as `0`.

3. **Set matrix cells to `0` based on markers**:
   - Traverse the matrix (excluding the first row and column) and set cells to `0` if their corresponding marker in the first row or column is `0`.

4. **Handle the first row and column**:
   - If `firstRowZero` is `true`, set all elements in the first row to `0`.
   - If `firstColZero` is `true`, set all elements in the first column to `0`.


Complexity Analysis

1. **Time Complexity**:
   - Traversing the matrix to mark rows and columns: \(O(m \times n)\).
   - Traversing the matrix again to set zeros: \(O(m \times n)\).
   Overall: **\(O(m \times n)\)**.

2. **Space Complexity**:
   - We only use two boolean flags (`firstRowZero` and `firstColZero`) and no additional storage.
   Overall: **\(O(1)\)**.

 Example Execution
**Input Matrix**:

[[0, 1, 2, 0],
 [3, 4, 5, 2],
 [1, 3, 1, 5]]


**Output Matrix**:

[[0, 0, 0, 0],
 [0, 4, 5, 0],
 [0, 3, 1, 0]]

 */