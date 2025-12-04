package Arrays.Easy;

class FirstPalindrome {
    public String firstPalindrome(String[] words) {
        // Traverse each word in the array
        for (String word : words) {
            // Check if the current word is a palindrome
            if (isPalindrome(word)) {
                return word; // Return the first palindrome found
            }
        }
        return ""; // If no palindrome is found, return an empty string
    }

    // Helper function to check if a string is a palindrome
    public static boolean isPalindrome(String word) {
        int left = 0; // Left pointer
        int right = word.length() - 1; // Right pointer
        // Compare characters from both ends
        while (left < right) {
            if (word.charAt(left) != word.charAt(right)) {
                return false; // If mismatch, it's not a palindrome
            }
            left++; // Move left pointer inward
            right--; // Move right pointer inward
        }
        return true; // All characters matched; it's a palindrome
    }

    public static void main(String[] args) {
        FirstPalindrome obj = new FirstPalindrome();
        String[] words = {"gagan's","poop","is","good","yay"};
        System.out.println("Result "+obj.firstPalindrome(words));
    }
}

/*
**Problem Statement**
You are given an array of strings `words`. The task is to return the **first palindrome string** from the array. If no palindrome exists, return an empty string `""`.

A **palindrome** is a string that reads the same backward as forward, e.g., "radar", "level".


 **Approach**
1. **Iterate through the Array:** Traverse each string in the array `words`.
2. **Check for Palindrome:** For each string, use a helper function `isPalindrome` to determine if it is a palindrome.
3. **Return the Result:**
   - If a palindrome is found, return it immediately.
   - If the loop completes without finding any palindrome, return `""`.

 **Optimizations**
- As soon as a palindrome is found, exit early to minimize unnecessary computations.
- Use a two-pointer technique in `isPalindrome` to compare characters efficiently.

 **Complexity Analysis**

 **Time Complexity**
- **Outer Loop:** Iterates through each word in the array → `O(n)` (where `n` is the number of words).
- **Inner Loop (isPalindrome):**
  - For a word of length `m`, the comparison loop runs at most `m/2` iterations.
  - If all words are of average length `m`, this contributes `O(m)` for each word.
- **Total Time Complexity:**
  `O(n * m)`
  (where `n` is the number of words and `m` is the average length of the words).

 **Space Complexity**
- The algorithm uses a constant amount of extra space → **`O(1)`**.



### **Explanation with Example**
**Input:**
```java
String[] words = {"abc", "car", "ada", "racecar", "cool"};
```

**Execution:**
1. Check "abc" → Not a palindrome.
2. Check "car" → Not a palindrome.
3. Check "ada" → Palindrome! Return "ada".

**Output:**
```java
"ada"
```

 */