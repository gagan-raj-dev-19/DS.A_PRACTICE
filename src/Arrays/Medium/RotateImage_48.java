package Arrays.Medium;


class RotateImage {
    public static void rotate(int[][] matrix){
        int n = matrix.length;

        // Step 1: Transpose the matrix
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
        int[][] matrix = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };

        rotate(matrix);

        // Print rotated matrix
        for (int[] ints : matrix) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(ints[j] + " ");
            }
            System.out.println();
        }
    }
}


/*
Here's the breakdown for the problem statement, approach, code, and complexity analysis:

 **Problem Statement**
Given an \( n \times n \) 2D matrix representing an image, rotate the image by 90 degrees clockwise in-place. This means that you cannot use extra space to store another matrix, and the rotation must be achieved by modifying the input matrix directly.

 **Approach**
1. **Transpose the Matrix**:
   - Convert all rows to columns by swapping \( \text{matrix}[i][j] \) with \( \text{matrix}[j][i] \) for \( i < j \). This step reflects the matrix over its main diagonal.

2. **Reverse Each Row**:
   - Reverse the elements of each row to simulate a 90-degree rotation. This step shifts the elements to their final rotated positions.



 **Complexity Analysis**
1. **Time Complexity**:
   - Transposing the matrix involves ( O(n^2) ) operations as we iterate over approximately half the elements of the matrix.
   - Reversing each row also takes ( O(n^2) ) since we iterate over all rows and half the elements of each row.
   - **Total Time Complexity**: ( O(n^2) ).

2. **Space Complexity**:
   - The algorithm performs all operations in-place, requiring no additional space apart from a few variables for swapping.
   - **Total Space Complexity**: ( O(1) ).



 **Output**
For the given matrix:
```
1 2 3
4 5 6
7 8 9
```
The output after rotation is:
```
7 4 1
8 5 2
9 6 3
```



 */