package Strings.Medium;

class ReverseWords {
    public static String reverseWords(String s) {
        // Step 1: Trim extra spaces
        String[] words = s.trim().split("\\s+");

        // Step 2: Use StringBuilder to reverse words
        StringBuilder result = new StringBuilder();

        for (int i = words.length - 1; i >= 0; i--) {
            result.append(words[i]); // Append the word
            if (i > 0) {
                result.append(" "); // Add a space if it's not the last word
            }
        }

        return result.toString(); // Convert StringBuilder to String
    }

    public static void main(String[] args) {
        String words = "  Sadda  Kutta  Tommy  ";
        System.out.println(reverseWords(words)); // Output: "Tommy Kutta Sadda"
    }
}
/*

Here’s a detailed breakdown of the **Reverse Words in a String** problem, including brute force and optimal approaches, a dry run, time & space complexity analysis, and a visual explanation.

---

 🔹 **Problem Statement**
Given a string `s`, reverse the order of words in the string while maintaining a single space between words.

 **Example**
# **Input:**
```plaintext
s = "  Sadda  Kutta  Tommy  "
```
# **Output:**
```plaintext
"Tommy Kutta Sadda"
```

---

 ✅ **Brute Force Approach** (O(N))

 **Approach:**
1. **Trim** the string to remove leading and trailing spaces.
2. **Split** the string using `split("\\s+")`, which breaks the string based on one or more spaces.
3. **Reverse** the words by iterating from the last word to the first.
4. **Reconstruct** the string using `StringBuilder` to join words with a single space.



 **Time Complexity:**
- `trim()` → O(N)
- `split("\\s+")` → O(N)
- Looping through words and appending → O(N)
- **Total: O(N)**

 **Space Complexity:**
- `String[] words` → O(N)
- `StringBuilder` → O(N)
- **Total: O(N)** (extra space for storing words)

---

 ✅ **Optimal Approach (O(log N))**
We can optimize space usage by **in-place modification** of the string. However, since Java strings are immutable, we typically achieve **O(1) space** with a character array. The approach remains similar:
1. **Trim spaces** manually.
2. **Reverse the entire string**.
3. **Reverse each word individually**.

> **Note:** In-place reversal is not possible in Java strings directly due to immutability, but we can achieve O(1) extra space using a `char[]`.

 **Time Complexity:**
- **Reversing the string** → O(N)
- **Reversing each word** → O(N)
- **Total: O(N)** (since O(N) dominates over O(log N))

---

 ✅ **Dry Run (Step-by-step execution in tabular format)**

 **Input:** `"  Sadda  Kutta  Tommy  "`

| Step | Operation | Result |
|------|-----------|--------|
| 1 | Trim spaces | `"Sadda Kutta Tommy"` |
| 2 | Split words | `["Sadda", "Kutta", "Tommy"]` |
| 3 | Reverse words | `["Tommy", "Kutta", "Sadda"]` |
| 4 | Join with space | `"Tommy Kutta Sadda"` |

---

 ✅ **Time & Space Complexity**
 **Brute Force**
| Operation | Time Complexity | Space Complexity |
|-----------|----------------|------------------|
| `trim()` | O(N) | O(1) |
| `split("\\s+")` | O(N) | O(N) |
| Loop (Reversing & Joining) | O(N) | O(N) |
| **Total** | **O(N)** | **O(N)** |

 **Optimal**
| Operation | Time Complexity | Space Complexity |
|-----------|----------------|------------------|
| Reverse full string | O(N) | O(1) |
| Reverse words individually | O(N) | O(1) |
| **Total** | **O(N)** | **O(1)** |

---

 ✅ **Visual Explanation**
```
Input: "  Sadda  Kutta  Tommy  "

1. Trim spaces:
   "Sadda Kutta Tommy"

2. Split into words:
   ["Sadda", "Kutta", "Tommy"]

3. Reverse order:
   ["Tommy", "Kutta", "Sadda"]

4. Join words with a single space:
   "Tommy Kutta Sadda"
```

---

 **Final Thoughts**
- **Brute Force** is easy to implement but takes extra space.
- **Optimal Solution** achieves in-place reversal but is tricky in Java.
- **Time Complexity is O(N) in both approaches**, but the optimal one uses **O(1) extra space**.

Would you like an in-place Java solution with a character array? 🚀

 */