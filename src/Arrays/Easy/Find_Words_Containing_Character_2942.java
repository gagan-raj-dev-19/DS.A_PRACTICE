package Arrays.Easy;

import java.util.ArrayList;
import java.util.List;

class FindWordsContainingCharacter {
    public static List<Integer> findWordsContaining(String[] words, char x){
        List <Integer> result = new ArrayList<>();
        for (int i=0;i<words.length;i++){
            if (words[i].indexOf(x)!= -1){
                result.add(i);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        String[] words= {"iron","man"} ;
       // String[] words1 = {"itachi","uchiha"};
        char x1  = 'n';
       // char x2 = 'z';
        System.out.println(findWordsContaining(words,x1));
      //  System.out.println(findWordsContaining(words1,x2));
    }
}

/*

Problem Statement:
You are tasked to write a function that takes an array of words (strings) and a character. The function should return a list of indices of the words in the array that contain the specified character.


 Approach:

1. **Iterate Through Words**: Loop through each word in the input array.
2. **Check for Character**: Use the `indexOf(char)` method to check if the character is present in the word. If `indexOf(char)` returns `-1`, the character is not found.
3. **Store Indices**: If the character is found, store the index of the word in the result list.
4. **Edge Cases**:
   - The input array is empty (`[]`).
   - No word contains the character.
   - The character does not exist in any string.
   - Case sensitivity (e.g., `'a'` vs. `'A'`).


 Complexity Analysis:

1. Time Complexity:
   - Each `indexOf(char)` call runs in O(L), where `L` is the length of the current string.
   - Iterating through the array of `N` strings, the overall complexity is O(N * L), where `L` is the average length of strings in the array.

2. Space Complexity:
   - O(N): Space for storing indices in the result list.
   - Additional space is negligible as it only depends on primitive operations.


 */