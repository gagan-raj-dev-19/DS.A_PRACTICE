package Strings.Easy;
import java.util.*;

class BruteForce {
    public static String removeOutermostParentheses(String s) {
        StringBuilder result = new StringBuilder();
        int count = 0;  // Counter to track open/close balance

        for (char ch : s.toCharArray()) {
            if (ch == '(') {
                if (count > 0) { // Ignore first '(' of a primitive component
                    result.append(ch);
                }
                count++;
            } else { // ch == ')'
                count--;
                if (count > 0) { // Ignore last ')' of a primitive component
                    result.append(ch);
                }
            }
        }

        return result.toString();
    }

    public static void main(String[] args) {
        String s1 = "(()())(())";
        System.out.println(removeOutermostParentheses(s1)); // Output: "()()()"

        String s2 = "(()())(())(()(()))";
        System.out.println(removeOutermostParentheses(s2)); // Output: "()()()()(())"
    }
}

class Optimised {
    public static String removeOutermostParentheses(String s) {
        StringBuilder result = new StringBuilder();
        Stack<Character> stack = new Stack<>();

        for (char ch : s.toCharArray()) {
            if (ch == '(') {
                if (!stack.isEmpty()) {
                    result.append(ch);
                }
                stack.push(ch);
            } else {
                stack.pop();
                if (!stack.isEmpty()) {
                    result.append(ch);
                }
            }
        }

        return result.toString();
    }

    public static void main(String[] args) {
        String s1 = "(()())(())";
        System.out.println(removeOutermostParentheses(s1)); // Output: "()()()"

        String s2 = "(()())(())(()(()))";
        System.out.println(removeOutermostParentheses(s2)); // Output: "()()()()(())"
    }
}


/*

Let's break this problem down step by step with all the requested details.

 **Problem Statement**
Given a valid parentheses string `s`, remove its outermost parentheses and return the modified string.

 **Example**
**Input:**
s = "(()())(())"
**Output:**
"()()()"

Input:
`s = "(()())(())(()(()))"`
**Output:**
`"()()()()(())"`



 **Approach 1: Brute Force (O(N))**
 **Explanation:**
1. A valid parentheses string consists of multiple primitive components.
2. We need to remove the first and last parentheses of each primitive component.
3. Use a **counter** (`count`) to track open `(` and close `)`.
4. Append characters to the result only when they are **not the outermost parentheses**.



 **Approach 2: Optimal Approach (O(log N)) using Stack**
We can optimize the approach using a **Stack** to track parentheses pairs instead of manually counting them.

 **Explanation**
1. Use a Stack to manage opening and closing brackets.
2. Only push and pop when necessary.
3. Ignore the first `(` and last `)` of every primitive sequence.


✅ **Time Complexity:** `O(N)`
✅ **Space Complexity:** `O(N)` (Stack storage)

Since log(N) is incorrect for this problem, the actual optimal time complexity is still `O(N)`. The stack-based approach does not improve beyond `O(N)`, but it offers better clarity in certain cases.



 Dry Run (Step-by-Step Execution)
Let's dry-run the brute force approach with input `"(()())(())"`.

| Step | Char | `count` | `result` | Reason |
|------|------|--------|----------|--------|
| 1 | `(` | 1 |  | Ignore first '(' |
| 2 | `(` | 2 | `(` | Append because it's not outermost |
| 3 | `)` | 1 | `()` | Append because `count > 0` |
| 4 | `(` | 2 | `()(` | Append because it's not outermost |
| 5 | `)` | 1 | `()()` | Append because `count > 0` |
| 6 | `)` | 0 | `()()` | Ignore last ')' |
| 7 | `(` | 1 |  | Ignore first '(' of new primitive |
| 8 | `(` | 2 | `()()(` | Append because it's not outermost |
| 9 | `)` | 1 | `()()()` | Append because `count > 0` |
| 10 | `)` | 0 | `()()()` | Ignore last ')' |

Final Output: "()()()"



 Time & Space Complexity Analysis
| Approach | Time Complexity | Space Complexity |
|----------|---------------|----------------|
| Brute Force | `O(N)` | `O(N)` (StringBuilder) |
| Stack-Based | `O(N)` | `O(N)` (Stack storage) |



 **Visual Explanation**
 **Original Input:** `"(()())(())(()(()))"`

Step 1: Primitive:  (()()) → remove outer:  ()()
Step 2: Primitive:  (()) → remove outer:  ()
Step 3: Primitive:  (()(())) → remove outer:  ()(())
Final output:  "()()()()(())"




 **Conclusion**
1. **Brute Force (O(N)):** Simple counting approach using a `count` variable.
2. **Stack-Based (O(N)):** Uses a stack but doesn't improve time complexity.
3. **Best Approach:** The brute force approach using a counter is the most efficient.





 */