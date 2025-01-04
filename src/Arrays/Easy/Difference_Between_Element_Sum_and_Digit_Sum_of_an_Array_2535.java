package Arrays.Easy;

class DifferenceBetweenElementSumAndDigitSum {
    public int differenceOfSum(int[] nums) {
        int elementSum = 0;
        int digitSum = 0;

        for (int num : nums) {
            elementSum += num;
            digitSum += getDigitSum(num);
        }

        return Math.abs(elementSum - digitSum);
    }

    private static int getDigitSum(int num) {
        int sum = 0;
        while (num > 0) {
            sum += num % 10; // Extract the last digit
            num /= 10;       // Remove the last digit
        }
        return sum;
    }

    public static void main(String[] args) {
        DifferenceBetweenElementSumAndDigitSum obj = new DifferenceBetweenElementSumAndDigitSum();
        int[] nums = {12,24,3,6};
        int result = obj.differenceOfSum(nums);
        System.out.println(result);
    }
}

/*

Problem Statement
The task is to calculate the **absolute difference** between the **sum of the elements** in an array (`elementSum`) and the **sum of the digits of the elements** in the array (`digitSum`). This involves two key steps:
1. Compute the sum of all the array elements.
2. Compute the sum of the digits for each element and then sum these digit sums.

Finally, return the absolute difference between the two sums.


 Approach
1. **Initialization**: Start with two variables, `elementSum` and `digitSum`, initialized to 0.
2. **Iterate through the Array**:
   - Add each element to `elementSum`.
   - Compute the digit sum of the current element using a helper function and add it to `digitSum`.
3. **Helper Function**: The `getDigitSum` function calculates the sum of digits of a number by iteratively extracting its last digit using modulo (`%`) and then removing it using integer division (`/`).
4. **Compute Difference**: Return the absolute difference between `elementSum` and `digitSum`.

Complexity Analysis
1. Time Complexity:
   - Iterating through the array takes \(O(n)\), where \(n\) is the number of elements in the array.
   - Calculating the digit sum for each number depends on the number of digits (\(d\)) in the number. For a single number, this takes \(O(d)\), and across the entire array, it sums to \(O(n \cdot d)\), where \(d\) is the average number of digits.
   - If the numbers are bounded (e.g., integers in the range [0, \(10^5\)]), \(d\) can be considered constant, making the time complexity effectively \(O(n)\).

2. Space Complexity:
   - The algorithm uses \(O(1)\) additional space since it only maintains scalar variables for computations.


 */
