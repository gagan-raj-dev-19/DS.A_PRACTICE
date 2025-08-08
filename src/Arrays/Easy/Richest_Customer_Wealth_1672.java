package Arrays.Easy;

class RichestCustomerWealth {
    public int maximumWealth(int[][] accounts) {
        int maxWealth = 0; // Initialize the variable to store maximum wealth

        // Iterate through each customer's account
        for (int[] customer : accounts) {
            int customerWealth = 0; // Variable to store current customer's wealth

            // Calculate total wealth of the current customer
            for (int bank : customer) {
                customerWealth += bank;
            }

            // Update maxWealth if the current customer's wealth is greater
            maxWealth = Math.max(maxWealth, customerWealth);
        }

        return maxWealth; // Return the maximum wealth found
    }



     public static void main(String[] args) {
         RichestCustomerWealth obj = new RichestCustomerWealth();
         int[][] customer = {{1,2,3},{3,2,1,12},{4,5,6}};
         System.out.println(obj.maximumWealth(customer));
     }
}

/*
Problem Statement:
You are given a 2D integer array `accounts` where `accounts[i][j]` represents the amount of money the \(i^{th}\) customer has in the \(j^{th}\) bank. The task is to determine the maximum wealth among all customers. A customer's wealth is defined as the sum of the money they have across all banks. Return the maximum wealth.

Approach:
1. **Thought Process:**
   - Iterate through each customer's data in the `accounts` array.
   - For each customer, calculate their total wealth by summing all elements in their array (i.e., sum of money in all banks for that customer).
   - Keep track of the maximum wealth encountered so far.
   - After processing all customers, return the maximum wealth.

2. **Optimization Considerations:**
   - Use a single loop structure to ensure efficiency.
   - Use the `Math.max()` function to efficiently update the maximum wealth.

Complexity Analysis:
1. **Time Complexity:**
   - Outer loop iterates through each customer: \(O(n)\), where \(n\) is the number of customers.
   - Inner loop sums up the wealth for each customer: \(O(m)\), where \(m\) is the number of banks per customer.
   - Total complexity: \(O(n \cdot m)\).

2. **Space Complexity:**
   - No additional data structures are used apart from a few variables.
   - Space complexity is \(O(1)\).

---

### Example Walkthrough:
#### Input:
```java
accounts = [[1, 2, 3], [3, 2, 1], [4, 5, 6]]
```

#### Execution Steps:
1. **Customer 1 Wealth:** \(1 + 2 + 3 = 6\) → \(maxWealth = 6\)
2. **Customer 2 Wealth:** \(3 + 2 + 1 = 6\) → \(maxWealth = 6\)
3. **Customer 3 Wealth:** \(4 + 5 + 6 = 15\) → \(maxWealth = 15\)

#### Output:
```java
15
```

---

This solution ensures clarity, efficiency, and correctness, with comments aiding comprehension.

 */