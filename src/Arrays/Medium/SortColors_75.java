package Arrays.Medium;

import java.util.Arrays;

class SortColors {
     public static void sortColors(int[] nums){
         int red = 0;
         int white = 0;
         int blue = nums.length-1;
         while(white <= blue){
             if (nums[white] == 0){
                 int temp = nums[white];
                 nums[white]=nums[red];
                 nums[red]=temp;
                 white++;
                 red++;
             } else if (nums[white]==1) {
                 white++;
             }else {
                 int temp = nums[white];
                 nums[white]=nums[blue];
                 nums[blue]=temp;

                 blue--;
             }
         }
     }

     public static void main(String[] args) {
         int[] nums = {2,0,1,0,1,2};
          sortColors(nums);
         System.out.println(Arrays.toString(nums));
     }
}
