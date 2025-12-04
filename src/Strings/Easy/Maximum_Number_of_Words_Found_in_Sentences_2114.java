package Strings.Easy;

 class Maximum_Number_of_Words_Found_in_Sentences {

         public static int mostWordsFound(String[] sentences) {
             int maxCount = 0; // Variable to track the maximum word count
             for (String sentence : sentences) {
                 int wordCount = 1; // Start with 1 word since spaces separate words
                 for (char c : sentence.toCharArray()) { // Iterate through each character
                     if (c == ' ') { // Count spaces
                         wordCount++;
                     }
                 }
                 maxCount = Math.max(maxCount, wordCount); // Update maxCount if a higher count is found
             }
             return maxCount; // Return the maximum word count
         }



     public static void main(String[] args) {
         String[] char1 = {"i am batman","i am ironman","i am gagan raj"};
         System.out.println(mostWordsFound(char1));
     }
}

/*
**Problem Statement**
You are given an array of strings, where each string represents a sentence. The task is to find the maximum number of words present in a single sentence. Words in a sentence are separated by spaces.


 *Approach*
1. **Thought Process**:
   - Iterate through each sentence in the array.
   - For each sentence, count the number of spaces (`' '`) and add one to get the word count since words are separated by spaces.
   - Track the maximum word count encountered across all sentences.

2. **Possible Optimizations**:
   - Instead of counting spaces manually, leverage built-in methods like `split(" ")` to calculate the word count more concisely. However, using `split()` may introduce slight overhead due to array creation.
   - Focus on edge cases, such as:
     - Empty strings.
     - Sentences with trailing, leading, or multiple consecutive spaces.



 Complexity Analysis
1. **Time Complexity**:
   - Let `n` be the total number of sentences and `m` be the average length of each sentence.
   - For each sentence, we iterate through all characters, leading to a complexity of \( O(n \times m) \).
2. **Space Complexity**:
   - The solution uses \( O(1) \) extra space since no additional data structures are used apart from variables.



 optional  Optimized Approach
Using the `split(" ")` method:

java
class Solution {
    public int mostWordsFound(String[] sentences) {
        int maxCount = 0;
        for (String sentence : sentences) {
            int wordCount = sentence.split(" ").length; // Count words using split
            maxCount = Math.max(maxCount, wordCount); // Update maxCount
        }
        return maxCount;
    }
}


Complexity
**Time**: Still \( O(n \times m) \), but with extra overhead for splitting.
**Space**: \( O(m) \), for the temporary array created by `split`.


 */