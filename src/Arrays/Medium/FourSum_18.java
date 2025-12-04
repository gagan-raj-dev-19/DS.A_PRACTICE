package Arrays.Medium;

import java.util.*;

class FourSum{
    public static List<List<Integer>> fourSum(int[] nums, int target){
        Arrays.sort(nums);
        int n = nums.length;
        List<List<Integer>> result = new ArrayList<>();

        for (int i=0;i<n-3;i++){
            if(i>0 && nums[i]==nums[i-1]) continue;

            for (int j=i+1;j<n-2;j++){
                if(j>i+1 && nums[j]==nums[j-1]) continue;

                int left=j+1; int right = n-1;
                while (left<right){
                    long sum = (long) nums[i]+nums[j]+nums[left]+nums[right];
                    if (sum == target){
                        result.add(Arrays.asList(nums[i],nums[j],nums[left],nums[right]));

                        while (left<right && nums[left] == nums[left+1]) left++;
                        while(left<right && nums[right] == nums[right-1]) right--;
                        left++;
                        right--;
                    } else if (sum<target) {
                        left++;

                    }else {
                        right--;
                    }
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {1,0,-1,0,-2,2};
        int target = 0;
        int[] nums1 = {2,2,2,2,2};
        int target1 = 8;
        System.out.println("result for nums -> "+fourSum(nums,target));
        System.out.println("result for nums1 -> "+fourSum(nums1,target1));

    }
}

/*
 Problem Statement:
Given an integer array `nums` and an integer `target`, return all unique quadruplets `[a, b, c, d]` such that `a + b + c + d == target`. The solution set must not contain duplicate quadruplets.

 Approach:
1. Sorting the Array: First, sort the array to facilitate duplicate removal and two-pointer traversal.
2. Two Nested Loops: Iterate with two pointers (`i` and `j`) to fix the first two numbers.
3. Two-Pointer Technique: Use a two-pointer approach (`left` and `right`) to find the remaining two numbers whose sum matches the required value.
4. Skipping Duplicates: Avoid duplicate quadruplets by skipping repeated values.
5. Early Stopping: If the sum exceeds the target, adjust the `left` and `right` pointers accordingly.

 Complexity Analysis:
- Sorting: (O(N log N))
- Outer Loop ((i)): (O(N))
- Inner Loop ((j)): (O(N))
- Two-Pointer Traversal: (O(N))
- Total Complexity: (O(N^3))

 TO-DO otimizations:
- HashSet for Faster Duplicate Removal: Instead of checking duplicates manually, a HashSet could be used.
- Early Termination: If the smallest possible sum exceeds `target`, break early.

 */



// bruteforce
//class Solution {
//    public List<List<Integer>> fourSum(int[] nums, int target) {
//        Set<List<Integer>> result = new HashSet<>();
//        int n=nums.length;
//        for(int i=0;i<n-3;i++){
//            for(int j=i+1;j<n-2;j++){
//                for(int k=j+1;k<n-1;k++){
//                    for(int l=k+1;l<n;l++){
//                        if(nums[i]+nums[j]+nums[k]+nums[l] == target){
//                            List<Integer> quad = Arrays.asList(nums[i],nums[j],nums[k],nums[l]);
//                            Collections.sort(quad);
//                            result.add(quad);
//                        }
//                    }
//                }
//            }
//        }
//        return new ArrayList<>(result);
//    }
//}