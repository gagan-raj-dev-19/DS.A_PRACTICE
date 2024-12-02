package Maths;
/*
this solution is more efficient but both solution works fine.

class Pangram{
    public static boolean isPangram(String sentence){
        if (sentence.length() < 26)return false;
        for (char ch ='a';ch<='z';ch++){
            if (sentence.indexOf(ch)<0){
                return false
            }

        }
        return true;
    }
}

 */
import java.util.HashSet;

class Pangram {
    public boolean checkIfPangram(String sentence) {
        // Create a HashSet to store unique characters
        HashSet<Character> charSet = new HashSet<>();

        // Iterate through the sentence
        for (int i = 0; i < sentence.length(); i++) {
            charSet.add(sentence.charAt(i));
            // Early exit if all 26 letters are found
            if (charSet.size() == 26) {
                return true;
            }
        }

        // Check if all letters ('a' to 'z') are in the HashSet
        for (char ch = 'a'; ch <= 'z'; ch++) {
            if (!charSet.contains(ch)) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        Pangram obj = new Pangram();
        String sentence1 = "The quick brown fox jumps over the lazy dog";
        String sentence2 = "I am Batman";
        System.out.println("is Sentence 1 a valid panagram: "+ obj.checkIfPangram(sentence1));
        System.out.println("is Sentence 2 a valid panagram: "+ obj.checkIfPangram(sentence2));

    }
    }

/*
Problem Statement

**Check if the Sentence is a Pangram:**
A pangram is a sentence containing every letter of the English alphabet at least once. Given a string `sentence`, determine if it is a pangram. Return `true` if it is; otherwise, return `false`. The input `sentence` will consist only of lowercase English letters.

---

 Approach

1. **Using a HashSet**:
   - A `HashSet` is used to store unique characters from the `sentence`.
   - As we iterate over the `sentence`, each character is added to the `HashSet`.
   - After processing the string, the `HashSet` should contain all 26 English lowercase letters if the string is a pangram.
   - Verify this by checking if all letters ('a' to 'z') are present in the `HashSet`.

2. **Optimizations**:
   - Early exit: If the size of the `HashSet` reaches 26 during the iteration, return `true` immediately since it means the sentence is already a pangram.
   - Skip redundant checks: Avoid unnecessary iterations by checking directly during the addition process.

Complexity Analysis

1. **Time Complexity**:
   - **Iteration through the sentence:** \(O(n)\), where \(n\) is the length of the `sentence`.
   - **Checking all 26 letters:** \(O(1)\), as we are iterating over a constant range ('a' to 'z').
   - Overall time complexity: \(O(n)\).

2. **Space Complexity**:
   - The `HashSet` stores unique letters, which is capped at 26 for English alphabets.
   - Space complexity: \(O(1)\), as the maximum size of the `HashSet` is constant.




 */




