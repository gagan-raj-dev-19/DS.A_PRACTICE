package Sorting;



import java.util.Arrays;

class SortThePeople {
    public String[] sortPeople(String[] names, int[] heights) {
        int n = names.length;

        // Step 1: Initialize an array of indices
        Integer[] indices = new Integer[n];
        for (int i = 0; i < n; i++) {
            indices[i] = i;
        }

        // Step 2: Sort indices based on heights in descending order
        Arrays.sort(indices, (a, b) -> heights[b] - heights[a]);

        // Step 3: Build the sorted names array
        String[] sortedNames = new String[n];
        for (int i = 0; i < n; i++) {
            sortedNames[i] = names[indices[i]];
        }

        return sortedNames;
    }

    public static void main(String[] args) {
        SortThePeople solution = new SortThePeople();

        // Test input
        String[] names = {"Naruto", "Sasuke", "Itachi", "Obito"};
        int[] heights = {160, 170, 150, 155};

        // Get the sorted result
        String[] result = solution.sortPeople(names, heights);

        // Print the result
        System.out.println(Arrays.toString(result));
    }
}

/*
Problem Statement:
You are given two arrays:
1. `names`, where `names[i]` is the name of the person.
2. `heights`, where `heights[i]` is the height of the person.

You need to return the `names` array, sorted in descending order of the corresponding `heights`.

---

 Approach:

1. **Index-based Sorting**:
   - Create an array of indices representing positions of elements in the original array.
   - Sort the indices array based on the corresponding heights in descending order.

2. **Map Indices to Names**:
   - Using the sorted indices, construct the output array of names.

3. **Key Optimizations**:
   - Sorting the indices instead of sorting the names/heights directly avoids unnecessary memory copying.
   - Sorting directly in descending order eliminates additional steps.

Output:
For the input:
`names = {"Naruto", "Sasuke", "Itachi", "Obito"}`
`heights = {160, 170, 150, 155}`

The output will be:
`["Sasuke", "Naruto", "Obito", "Itachi"]`

---

 Complexity Analysis:

1. **Time Complexity**:
   - Sorting the indices: \(O(n \log n)\) where \(n\) is the size of the arrays.
   - Constructing the sorted names array: \(O(n)\).
   - Overall: \(O(n \log n)\).

2. **Space Complexity**:
   - Auxiliary array for indices: \(O(n)\).
   - Output array for sorted names: \(O(n)\).
   - Total: \(O(n)\).

This approach is efficient for moderate-sized inputs and ensures clarity and maintainability.



 */

