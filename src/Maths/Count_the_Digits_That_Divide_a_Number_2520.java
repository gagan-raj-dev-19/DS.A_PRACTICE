package Maths;

class Count_the_Digits_That_Divide_a_Number {
    public int countDigits(int num) {
        int count = 0;               // Initialize the count of digits that divide num.
        int originalNum = num;       // Store the original number for divisibility checks.

        while(num > 0) {             // Iterate through each digit of num.
            int digit = num % 10;    // Get the last digit.

            // Check if the digit is non-zero and divides the original number.
            if(digit != 0 && originalNum % digit == 0) {
                count++;            // Increment count if the digit divides num.
            }

            num = num / 10;         // Remove the last digit for the next iteration.
        }

        return count;                // Return the final count of divisible digits.
    }



    public static void main(String[] args) {
        Count_the_Digits_That_Divide_a_Number obj = new Count_the_Digits_That_Divide_a_Number();
        int num = 7;
        System.out.println(obj.countDigits(num));
    }
}

/*
Problem Statement:
You are given a positive integer `num`. Your task is to count how many digits in `num` evenly divide the number itself. In other words, for each digit in the number, check if it is non-zero and if the number is divisible by that digit.

 Approach :
1. **Iterate over each digit**: Start by extracting each digit of the number using modulo (`%`) and integer division (`/`).

2. **Check divisibility**: For each digit, check if it is non-zero and if `num % digit == 0`. This checks whether the number is divisible by the current digit.

3. **Count valid digits**: If a digit satisfies the condition, increment a count.

4. **Handle edge case**: Ensure the code handles when the digit is `0`, as division by zero is not allowed.

 Possible Optimizations:
- **Use of Integer.toString(num)**: You can convert the number to a string and iterate through each character, which might be slightly more readable but could be less efficient due to string manipulation overhead.
- **Skip zeros immediately**: Since a digit of zero will always be skipped, checking for `digit != 0` right away helps avoid unnecessary division operations.

Complexity Analysis:
- **Time Complexity**:
  - The while loop iterates once for each digit of the number. In the worst case, this is proportional to the number of digits `d`, where `d = log10(num)`. Therefore, the time complexity is **O(d)**, where `d` is the number of digits in `num`.
  - For each digit, we perform constant-time operations: modulus, division, and comparison. So, overall, the time complexity is **O(d)**.

- **Space Complexity**:
  - We are using only a few integer variables (`count`, `originalNum`, `digit`), which means the space complexity is **O(1)**, or constant space, as we are not using any extra space that grows with the size of the input number.

This solution is optimal in terms of both time and space complexity for this problem.


 */