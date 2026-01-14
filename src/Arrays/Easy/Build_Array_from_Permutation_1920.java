package Arrays.Easy;

import java.util.Arrays;

public class Build_Array_from_Permutation_1920 {
    public static int[] buildArray(int[] nums){
        int n = nums.length;
        int[] res = new int[n];
        for (int i=0; i<n; i++){
            res[i] = nums[nums[i]];
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {0,2,1,5,3,4};
        System.out.println(Arrays.toString(buildArray(nums)));
    }
}
