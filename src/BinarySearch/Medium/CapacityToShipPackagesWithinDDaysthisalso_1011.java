package BinarySearch.Medium;

class ShipWithinDaysBruteForce {
    public static int shipWithinDays(int[] weights, int D) {
        int maxWeight = 0, sumWeight = 0;

        for (int w : weights) {
            maxWeight = Math.max(maxWeight, w);
            sumWeight += w;
        }

        for (int cap = maxWeight; cap <= sumWeight; cap++) {
            if (canShip(weights, cap, D)) return cap;
        }
        return sumWeight;
    }

    private static boolean canShip(int[] weights, int cap, int D) {
        int days = 1, currLoad = 0;

        for (int w : weights) {
            if (currLoad + w > cap) {
                days++;
                currLoad = 0;
            }
            currLoad += w;
        }
        return days <= D;
    }

    public static void main(String[] args) {
        int[] weights = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int D = 5;
        System.out.println("Minimum Capacity: " + shipWithinDays(weights, D)); // Output: 15
    }
}

class ShipWithinDaysOptimal {
    public static int shipWithinDays(int[] weights, int D) {
        int left = 0, right = 0;

        for (int w : weights) {
            left = Math.max(left, w);
            right += w;
        }

        while (left < right) {
            int mid = left + (right - left) / 2;
            if (canShip(weights, mid, D)) right = mid;
            else left = mid + 1;
        }
        return left;
    }

    private static boolean canShip(int[] weights, int cap, int D) {
        int days = 1, currLoad = 0;

        for (int w : weights) {
            if (currLoad + w > cap) {
                days++;
                currLoad = 0;
            }
            currLoad += w;
        }
        return days <= D;
    }

    public static void main(String[] args) {
        int[] weights = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int D = 5;
        System.out.println("Minimum Capacity: " + shipWithinDays(weights, D)); // Output: 15
    }
}
/*
 * Capacity to Ship Packages Within D Days.

 * Problem Statement:
 * Given an array `weights` representing package weights and an integer `D` (days),
 * find the minimum ship capacity required to deliver all packages within `D` days.
 * The ship must take packages in the given order and can only ship once per day.

 * Approaches:

 * 1. Linear Search (Brute Force) – O(N * Sum(weights))
 *    - Compute `maxWeight` (heaviest package) and `sumWeight` (total weight).
 *    - Try all capacities from `maxWeight` to `sumWeight`.
 *    - Use a helper function `canShip(weights, cap, D)` to check feasibility.
 *    - Inefficient for large weight arrays.

 * 2. Binary Search (Optimal) – O(N log Sum(weights))
 *    - Perform binary search in the range `[maxWeight, sumWeight]`.
 *    - Compute `mid` and check if it's a valid ship capacity.
 *    - If `mid` can ship in `D` days, reduce capacity (`right = mid`).
 *    - Otherwise, increase capacity (`left = mid + 1`).

 * Complexity Analysis:

 * | Approach                   | Time Complexity       | Space Complexity |
 * |----------------------------|---------------------|----------------|
 * | Linear Search (Brute)      | O(N * Sum(weights)) | O(1)          |
 * | Binary Search (Optimal)    | O(N log Sum(weights)) | O(1)          |

 * Conclusion:
 * - **Binary Search** efficiently finds the minimum ship capacity.
 * - **Much faster than brute force, especially for large input sizes.**
 */


