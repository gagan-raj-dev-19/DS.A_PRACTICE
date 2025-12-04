package Maths;

class FirstUnique {
    public int firstUniqeChar(String s) {
        // Step 1: Create a frequency array to count character occurrences
        int[] frequency = new int[26];

        // Step 2: Populate the frequency array
        for (char c : s.toCharArray()) {
            frequency[c - 'a']++;
        }

        // Step 3: Find the first character with a frequency of 1
        for (int i = 0; i < s.length(); i++) {
            if (frequency[s.charAt(i) - 'a'] == 1) {
                return i;
            }
        }

        // Step 4: Return -1 if no unique character is found
        return -1;
    }

    public static void main(String[] args) {
        FirstUnique obj = new FirstUnique();
        String s1 = "ironman";
        String s2 = "wonderwomen";
        String s3 = "batman";

        System.out.println("s1 "+ obj.firstUniqeChar(s1));
        System.out.println("s2 "+ obj.firstUniqeChar(s2));
        System.out.println("s3 "+ obj.firstUniqeChar(s3));

    }

}


/*
Problem Statement:
You are given a string `s` consisting of lowercase English letters. You need to find the **index** of the first non-repeating character in the string. If all characters are repeating, return `-1`.

 Approach:
1. **Understanding the Problem**:
   - A character is considered non-repeating if it appears only once in the string.
   - The task is to find the **index** of the first such character.

2. **Thought Process**:
   - Use a frequency array of size 26 to count occurrences of each character.
     - Index `0` corresponds to `'a'`, index `1` to `'b'`, and so on.
   - Traverse the string a second time to find the first character with a frequency of `1`.

3. **Optimization Considerations**:
   - The approach ensures we traverse the string only twice (O(2n)), which simplifies to O(n).
   - Space usage is limited to the array of size 26, which is constant (O(1)).


Complexity Analysis:
1. **Time Complexity**:
   - First traversal (to populate the frequency array): O(n), where `n` is the length of the string.
   - Second traversal (to find the first unique character): O(n).
   - Total: **O(n)**.

2. **Space Complexity**:
   - The frequency array of size 26 is used: O(1) (constant space).

 Summary:
This approach efficiently solves the problem with minimal space usage and linear time complexity, making it suitable for large input strings.

 */
