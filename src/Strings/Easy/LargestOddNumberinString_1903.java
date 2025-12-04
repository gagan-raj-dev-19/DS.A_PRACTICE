package Strings.Easy;

class LargestOddNumberinString {
    public static String largestOddNumber(String num) {
        // Traverse the string from the last digit to the first
        for (int i = num.length() - 1; i >= 0; i--) {
            // Convert character to integer and check if it's odd
            if (num.charAt(i) % 2 == 1) {
                // Return the substring from 0 to i (inclusive)
                return num.substring(0, i + 1);
            }
        }
        // If no odd digit is found, return an empty string
        return "";
    }

    public static void main(String[] args) {
        System.out.println(largestOddNumber("98765432")); // Output: "987"
        System.out.println(largestOddNumber("11110000")); // Output: "1111"
        System.out.println(largestOddNumber("222222"));   // Output: ""
    }
}

/*

The idea is to iterate over the string from right to left and check for the first occurrence of an odd digit. Once found, return the substring from the start to that index.


  **Time & Space Complexity**

 Brute Force (O(N))
- **Time Complexity:** \( O(N) \) (In the worst case, we check all N digits)
- **Space Complexity:** \( O(1) \) (No extra space is used)

 */