package Maths;

class ReverseInteger {
    public int reverse(int x) {
        int rev = 0;

        while (x != 0) {
            // Extract last digit
            int ld = x % 10;

            // Check for overflow
            if (rev > Integer.MAX_VALUE / 10 || (rev == Integer.MAX_VALUE / 10 && ld > 7)) {
                return 0; // Overflow for positive numbers
            }
            if (rev < Integer.MIN_VALUE / 10 || (rev == Integer.MIN_VALUE / 10 && ld < -8)) {
                return 0; // Overflow for negative numbers
            }

            // Update reversed number
            rev = rev * 10 + ld;

            // Remove the last digit
            x = x / 10;
        }
        return rev;
    }

    public static void main(String[] args) {
        ReverseInteger obj = new ReverseInteger();
        int N = 1234; // Test cases
        System.out.println(obj.reverse(N));
    }
}

// Output: 4321

/*
- Problem Statement
Given a 32-bit signed integer \( x \), reverse its digits. If reversing \( x \) causes it to go outside the 32-bit signed integer range (\(-2^{31}\) to \(2^{31} - 1\)), return 0 instead of the reversed number.

- Approach

1. Extracting Digits:
   - Extract the last digit of \( x \) using \( x \% 10 \).
   - Append this digit to the reversed number \( rev \) by multiplying \( rev \) by 10 and adding the digit.

2. Overflow Check:
   - Before updating \( rev \), check if the operation will cause an overflow.
   - For a 32-bit signed integer, check:
     - Positive Overflow: \( rev > \text{Integer.MAX\_VALUE} / 10 \) or \( rev == \text{Integer.MAX\_VALUE} / 10 \) and \( ld > 7 \).
     - Negative Overflow: \( rev < \text{Integer.MIN\_VALUE} / 10 \) or \( rev == \text{Integer.MIN\_VALUE} / 10 \) and \( ld < -8 \).

3. Iterate Until \( x = 0 \):
   - Update \( x \) by dividing it by 10.

4. Return Result:
   - If no overflow occurs, return \( rev \). Otherwise, return 0.

- Complexity Analysis

1. Time Complexity:
   - The algorithm iterates through all the digits of the number.
   - For a number with \( n \) digits, the time complexity is \( O(n) \).

2. Space Complexity:
   - The space usage is constant because no extra data structures are used.
   - Space Complexity: \( O(1) \).

*/
