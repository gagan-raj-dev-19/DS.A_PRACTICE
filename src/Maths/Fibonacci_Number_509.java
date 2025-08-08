package Maths;

class Fibonacci {
    public int fib(int n) {
        int a = 0, b = 1;
        if (n == 0) return a; // Base case: F(0)
        if (n == 1) return b; // Base case: F(1)

        for (int i = 2; i <= n; i++) { // Start loop from 2 to n
            int next = a + b; // Compute the next Fibonacci number
            a = b;            // Shift `a` to `b`
            b = next;         // Update `b` to the new Fibonacci number
        }
        return b; // Return the nth Fibonacci number
    }

    public static void main(String[] args) {
        Fibonacci sol = new Fibonacci();
        int N = 10; // Example input
        System.out.println("The Fibonacci of " + N + " is: " + sol.fib(N));
    }
}



/*
- Problem Statement
The goal is to calculate the n-th Fibonacci number efficiently. The Fibonacci sequence is defined as:

F(0) = 0
F(1) = 1
F(n) = F(n-1) + F(n-2) for n >= 2

- Approach
1. Base Cases:
   - If `n == 0`, return 0.
   - If `n == 1`, return 1.
2. Iterative Solution:
   - Use two variables (`a` and `b`) to store the last two Fibonacci numbers.
   - Use a loop to calculate the next numbers up to `n`.
3. Optimization:
   - The iterative approach uses constant space \(O(1)\) and runs in linear time \(O(n)\).

-  Complexity Analysis
1.Time Complexity: O(n) — the loop runs (n - 1) times.
2.Space Complexity: O(1) — no additional space is used beyond a few variables.

- Sample Output
For N = 10, the output will be:

The Fibonacci of 10 is: 55

*/