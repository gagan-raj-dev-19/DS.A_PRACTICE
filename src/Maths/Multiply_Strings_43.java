package Maths;

class MultiplyStrings {
    public String multiply(String num1, String num2) {
        // Handle edge case of multiplication with zero
        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }

        int m = num1.length();
        int n = num2.length();
        int[] result = new int[m + n]; // Array to hold the intermediate results

        // Reverse iteration to perform digit-by-digit multiplication
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                // Multiply current digits
                int mul = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');

                // Position in result array for the current product
                int sum = mul + result[i + j + 1];

                // Update result array
                result[i + j + 1] = sum % 10; // Store the single digit
                result[i + j] += sum / 10;    // Add carry to the next position
            }
        }

        // Convert the result array into a string
        StringBuilder sb = new StringBuilder();
        for (int num : result) {
            // Skip leading zeros
            if (!(sb.length() == 0 && num == 0)) {
                sb.append(num);
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        MultiplyStrings obj = new MultiplyStrings();
        String num1 = "123";
        String num2 = "456";
        System.out.println("result : " + obj.multiply(num1, num2));
    }
}


/*
**Problem Statement**
Given two non-negative integers `num1` and `num2` represented as strings, return the product of `num1` and `num2`, also represented as a string.
- **Constraints**:
  - Inputs `num1` and `num2` will not contain leading zeroes, except for the number "0".
  - The length of `num1` and `num2` can be up to 200.



### **Approach**
1. **Key Idea**:
   Simulate the traditional multiplication process performed manually. Each digit in `num1` is multiplied with each digit in `num2`, and the intermediate products are stored in an array. Finally, the result is constructed from the array.

2. **Steps**:
   - Reverse iterate over both strings to access digits from the least significant to the most significant.
   - Compute the product of each pair of digits and update the respective positions in the `result` array.
   - Handle carry propagation as part of the process.
   - Convert the `result` array back into a string, skipping any leading zeros.

3. **Edge Case**:
   If either `num1` or `num2` is "0", return "0" immediately to avoid unnecessary calculations.

**Complexity Analysis**
- **Time Complexity**:
  (O(m times n)), where \(m\) and \(n\) are the lengths of `num1` and `num2`, respectively. Each digit in `num1` is multiplied with each digit in `num2`.

- **Space Complexity**:
  (O(m + n)), for the `result` array used to store intermediate calculations..

 */