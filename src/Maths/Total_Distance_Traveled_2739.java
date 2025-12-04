package Maths;

class Solution {
    public int distanceTraveled(int mainTank, int additionalTank) {
        // Initialize the total distance traveled
        int distance = 0;

        // Loop until fuel in the main tank is less than 5 and no more fuel can be transferred
        while (mainTank > 0) {
            // Check if we can use 5 units and refill
            if (mainTank >= 5 && additionalTank > 0) {
                // Consume 5 units from the main tank
                mainTank -= 5;
                // Transfer 1 unit from the additional tank to the main tank
                additionalTank -= 1;
                mainTank += 1;
            } else {
                // Break the loop if no transfer is possible
                break;
            }
            // Add the distance for consuming 5 units of fuel
            distance += 50;
        }

        // Add the remaining distance from the remaining fuel in the main tank
        distance += mainTank * 10;

        return distance;
    }
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test Case 1
        int mainTank1 = 5, additionalTank1 = 10;
        System.out.println("Maximum distance for mainTank = 5, additionalTank = 10: " + solution.distanceTraveled(mainTank1, additionalTank1)); // Output: 60

        // Test Case 2
        int mainTank2 = 1, additionalTank2 = 2;
        System.out.println("Maximum distance for mainTank = 1, additionalTank = 2: " + solution.distanceTraveled(mainTank2, additionalTank2)); // Output: 10

        // Test Case 3
        int mainTank3 = 10, additionalTank3 = 5;
        System.out.println("Maximum distance for mainTank = 10, additionalTank = 5: " + solution.distanceTraveled(mainTank3, additionalTank3)); // Output: 150

        // Test Case 4
        int mainTank4 = 7, additionalTank4 = 3;
        System.out.println("Maximum distance for mainTank = 7, additionalTank = 3: " + solution.distanceTraveled(mainTank4, additionalTank4)); // Output: 90
}}

/*
**Problem Statement**
You are given two integers: `mainTank` and `additionalTank`. A vehicle can travel 10 units of distance for every unit of fuel from the `mainTank`.

- For every 5 units of fuel used from the `mainTank`, 1 unit of fuel can be transferred from the `additionalTank` to the `mainTank` (if available).
- Your task is to calculate the maximum distance the vehicle can travel given the fuel constraints.

---

 **Approach**
To solve the problem, simulate the fuel consumption and transfer process. Here's the thought process:

1. **Simulate Fuel Usage and Refills**:
   - Check if the `mainTank` has at least 5 units of fuel.
   - If yes, consume 5 units of fuel and transfer 1 unit from the `additionalTank` to the `mainTank` (if `additionalTank > 0`).
   - Add the corresponding distance (50 units) to the total distance.

2. **Edge Case**:
   - If the `mainTank` has less than 5 units, use the remaining fuel to calculate the distance directly without transferring fuel.

3. **Stop Condition**:
   - Stop when `mainTank` has less than 5 units of fuel and no fuel can be transferred from `additionalTank`.
 **Complexity Analysis**

1. **Time Complexity**:
   - Each iteration reduces `mainTank` by 5 units and may involve transferring fuel from `additionalTank`.
   - The loop runs a maximum of \( \lceil \text{mainTank} / 5 \rceil \) times.
   - Thus, the time complexity is **O(mainTank / 5)**, which simplifies to **O(mainTank)**.

2. **Space Complexity**:
   - The solution uses only a few variables to store intermediate values.
   - Hence, the space complexity is **O(1)** (constant space).

---

**Optimizations**

- The logic is already efficient and straightforward. Since it directly simulates the problem conditions, there's no need for further optimization.
- If the problem changes to include additional constraints, we can revisit for refinements.

 */
