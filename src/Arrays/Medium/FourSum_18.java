package Arrays.Medium;

import java.util.*;

class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Set<List<Integer>> result = new HashSet<>();
        int n=nums.length;
        for(int i=0;i<n-3;i++){
            for(int j=i+1;j<n-2;j++){
                for(int k=j+1;k<n-1;k++){
                    for(int l=k+1;l<n;l++){
                        if(nums[i]+nums[j]+nums[k]+nums[l] == target){
                            List<Integer> quad = Arrays.asList(nums[i],nums[j],nums[k],nums[l]);
                            Collections.sort(quad);
                            result.add(quad);
                        }
                    }
                }
            }
        }
        return new ArrayList<>(result);
    }
}