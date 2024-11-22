package Maths;

class Palindrome {
    public boolean isPalindrome(int x) {
        // A negative number or a number that ends with 0 (except 0 itself) can't be a palindrome
        if (x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }

        int rev = 0;
        // Reverse only half of the number for comparison
        while (x > rev) {
            int ld = x % 10; // Get last digit
            rev = rev * 10 + ld; // Add the digit to the reverse number
            x = x / 10; // Remove the last digit from x
        }

        // For odd length numbers, rev will have one extra digit
        return x == rev || x == rev / 10;
    }

    public static void main(String[] args) {
        Palindrome sol = new Palindrome();
        int N = 121;
        if (sol.isPalindrome(N)) {
            System.out.println("The Number " + N + " is Palindrome");
        } else {
            System.out.println("The Number " + N + " is Not Palindrome");
        }
    }
}

/*
- Problem Statement:

The task is to determine if a given integer is a palindrome. A palindrome number is one that reads the same forward and backward, such as 121 or 1221. Negative numbers are not considered palindromes.

- Approach:

1. Check for Negative Numbers: If the number is negative, it's automatically not a palindrome, as negative numbers don't have a symmetrical form.
2. Reverse the Number: Extract each digit from the original number and reverse the digits to check if the reversed number is equal to the original.
3. Comparison: After reversing, compare the reversed number with the original number. If they match, the number is a palindrome; otherwise, it's not.
4. Optimizations:
We can optimize this by stopping the comparison once we've processed half of the number. This reduces unnecessary operations when the number is large.

Explanation:
1. Negative Numbers and Multiples of 10: The check if (x < 0 || (x % 10 == 0 && x != 0)) ensures that negative numbers and numbers ending with a 0 (except 0 itself) are not palindromes.
2. Reversing the Number:
We only reverse half of the number because once we reach the middle, the remaining digits of x should be compared with the reversed digits stored in rev.
This reduces the number of operations.
3. Odd-Length Numbers: For numbers with an odd number of digits, the middle digit will be the same in both x and rev, so we check if x == rev / 10.


- Complexity Analysis:
1. Time Complexity: O(log(x)) — Since the number is being reduced by a factor of 10 each iteration (by dividing by 10), the number of iterations is proportional to the number of digits, which is logarithmic in the value of x.

2. Space Complexity: O(1) — We are only using a few integer variables (rev, x, etc.), so the space complexity is constant.

Thus, this approach is efficient and works well for large inputs.
*/
