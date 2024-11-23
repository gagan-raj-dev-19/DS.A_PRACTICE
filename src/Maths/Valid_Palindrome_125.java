package Maths;

class ValidPalindrome {
    public boolean isPalindrome(String s) {
        // Initialize pointers
        int left = 0, right = s.length() - 1;

        // Loop until pointers cross
        while (left < right) {
            // Skip non-alphanumeric characters
            while (left < right && !Character.isLetterOrDigit(s.charAt(left))) {
                left++;
            }
            while (left < right && !Character.isLetterOrDigit(s.charAt(right))) {
                right--;
            }

            // Compare characters at both pointers
            if (Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))) {
                return false; // Mismatch found
            }

            // Move pointers closer
            left++;
            right--;
        }

        return true; // String is a palindrome
    }

    public static void main(String[] args) {
        ValidPalindrome obj = new ValidPalindrome();
        String pal = "Yo, Banana Boy";
        System.out.println("Is the Given String a Valid Palindrome :"+ obj.isPalindrome(pal));
    }
}

/*
 Problem Statement
Given a string `s`, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases. A string is a palindrome if it reads the same forward and backward.

---

 Approach
1. **Two-Pointer Technique**:
   - Use two pointers (`left` and `right`) starting from the beginning and end of the string, respectively.
   - Move the pointers towards each other, skipping non-alphanumeric characters.
   - At each step, compare the characters at the pointers after converting them to lowercase. If a mismatch occurs, return `false`.
   - If the pointers cross without mismatches, the string is a palindrome.

2. **Optimizations**:
   - Skip unnecessary comparisons using `Character.isLetterOrDigit()` to filter out irrelevant characters.
   - Use `Character.toLowerCase()` to handle case insensitivity efficiently.


### Complexity Analysis
1. **Time Complexity**:
   - Traverses the string once (`O(n)`), where `n` is the length of the string.
   - Each character is processed at most twice (once by `left` and once by `right`).

2. **Space Complexity**:
   - `O(1)`: Uses a constant amount of extra space (two pointers).

---

 Example Execution
 Input: "Yo, Banana Boy"
- **Normalized Check**: Considers only alphanumeric characters: "YoBananaBoy"
- **Output**: `true`

 Input: `"race a car"`
- **Normalized Check**: Considers only alphanumeric characters: `raceacar`.
- **Output**: `false`

 */