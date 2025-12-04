package Maths;

class GcdOfStrings {
    public String gcdOfStrings(String str1, String str2) {
        // Check if str1 and str2 are compatible to form a GCD string
        if (!(str1 + str2).equals(str2 + str1)) {
            return ""; // No valid GCD string
        }

        // Calculate the GCD of the lengths of str1 and str2
        int gcdLength = gcd(str1.length(), str2.length());

        // Return the substring of str1 from 0 to gcdLength
        return str1.substring(0, gcdLength);
    }

    // Helper method to calculate GCD using the Euclidean algorithm
    private int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }



    public static void main(String[] args) {
        GcdOfStrings obj = new GcdOfStrings();
        String str1 = "ABCABC";
        String str2 = "ABC";
        String result = obj.gcdOfStrings(str1,str2);
        System.out.println(result);
    }
}

/*
Problem Statement
You are tasked with finding the greatest common divisor (GCD) of two strings `str1` and `str2`. The GCD of two strings is the largest string `X` such that both `str1` and `str2` can be represented as `X` repeated some number of times.

---

 Approach
1. **Validation**:
   - Check if the concatenation `str1 + str2` is equal to `str2 + str1`. If not, there's no valid GCD string, and the result is `""`.
   - This ensures that the strings are cyclic permutations of each other and thus can have a common divisor string.

2. **Finding GCD Length**:
   - Use the Euclidean algorithm to compute the GCD of the lengths of the two strings.
   - The GCD length gives the size of the largest repeating unit.

3. **Extract Substring**:
   - Extract the substring of `str1` from index `0` to `gcdLength`. This substring is the potential GCD string.

4. **Optimization**:
   - The Euclidean algorithm for finding GCD is efficient with a time complexity of \( O(\log(\min(a, b))) \), where `a` and `b` are the lengths of the strings.
   - By reducing the problem to string concatenation checks and length computation, unnecessary iterations over substrings are avoided.


Complexity Analysis
1. **Time Complexity**:
   - Concatenation and comparison of strings: \( O(n + m) \), where \( n \) and \( m \) are the lengths of `str1` and `str2`.
   - GCD computation: \( O(\log(\min(n, m))) \).
   - Substring operation: \( O(g) \), where \( g \) is the GCD of `n` and `m`.

   Overall: \( O(n + m + \log(\min(n, m))) \).

2. **Space Complexity**:
   - Concatenation requires \( O(n + m) \) space.
   - Substring operation requires \( O(g) \) additional space.
   - Total: \( O(n + m) \).



This approach ensures clarity, efficiency, and correctness in solving the problem. Possible further optimization might include avoiding explicit concatenations for very large strings, which can be replaced with more efficient comparison methods.



 */