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

        String[] names = {"Naruto","Sasuke","Itachi","Obito"};
        int[] heights = {160,170,150,155};

        // Test input


        // Get the sorted result
        String[] result = solution.sortPeople(names, heights);

        // Print the result
        System.out.println(Arrays.toString(result)); // Output: [Mary, Emma, John]
    }
}

