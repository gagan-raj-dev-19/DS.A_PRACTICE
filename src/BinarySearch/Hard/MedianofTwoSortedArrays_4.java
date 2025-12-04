package BinarySearch.Hard;

import java.util.Arrays;
// Brute Force Using Merge Sort
class MedianofTwoSortedArrays {
    public static double findMedianSortedArrays(int[] nums1, int[] nums2){
        int n = nums1.length;
        int m = nums2.length;

        int[] merged = new int [n+m];
        int k = 0;
        for(int i=0;i<n;i++){
            merged[k++] = nums1[i];
        }
        for(int i =0;i<m;i++){
            merged[k++] = nums2[i];
        }
        Arrays.sort(merged);

        int total =  merged.length;

        if(total % 2 == 1){
            return (double) merged[total/2];
        }else{
            int mid1 = merged[total/2-1];
            int mid2 = merged[total/2];
            return ((double) mid1 + (double) mid2)/2.0;
        }
    }

    public static void main(String[] args) {
        int[] nums1 = {1,2};
        int[] nums2 = {3,4};
        System.out.println(findMedianSortedArrays(nums1,nums2));
    }
}
// !!!!