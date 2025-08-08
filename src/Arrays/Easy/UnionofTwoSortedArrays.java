package Arrays.Easy;

import java.util.ArrayList;

public class UnionofTwoSortedArrays {
    public static ArrayList<Integer> findUnion(int[] arr1, int[] arr2){
        int i = 0;
        int j = 0;
        ArrayList <Integer> result = new ArrayList<>();
        while (i<arr1.length && j< arr2.length){
            if (arr1[i]<arr2[j]) {
                if (result.isEmpty() || result.get(result.size() - 1) != arr1[i]) {
                    result.add(arr1[i]);
                }
                i++;
            } else if (arr1[i]>arr2[j]) {
                if (result.isEmpty() || result.get(result.size()-1)!=arr2[j]){
                    result.add(arr2[j]);
                }
                j++;
            }else {
                if (result.isEmpty() || result.get(result.size() - 1) != arr1[i]) {
                    result.add(arr1[i]);
                }
                i++;j++;
            }

        }
        while (i< arr1.length){
            if (result.isEmpty() || result.get(result.size() - 1) != arr1[i]) {
                result.add(arr1[i]);
            }
            i++;
        }
        while(j< arr2.length){
            if (result.isEmpty() || result.get(result.size() - 1) != arr2[j]) {
                result.add(arr2[j]);
            }
            j++;
        }
        return result;

    }

    public static void main(String[] args) {
        int[] arr1 = {1,2,3,4,5,6,7,8,9};
        int[] arr2 = {1,2,3,3,5,6,10,11};
        ArrayList<Integer> res = findUnion(arr1,arr2);
        System.out.println(res);
    }
}
