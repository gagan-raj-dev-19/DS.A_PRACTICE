package Arrays.Easy;

import java.util.Arrays;

class RemoveDuplicatesFromSortedArray {
    public static int removeDuplicates(int[] nums){
        int i = 1;
        for (int j=1;j< nums.length;j++){
            if (nums[j]!=nums[j-1]){
                nums[i]=nums[j];
                i++;
            }
        }

        return i;
    }

    public static void main(String[] args) {
        int[] nums = {1,1,2,2,3,4,5,5,1,2};
        Arrays.sort(nums);
        int result = removeDuplicates(nums);
        for (int i=0;i<result;i++){
            System.out.print(nums[i]+" ");
        }

    }

}
