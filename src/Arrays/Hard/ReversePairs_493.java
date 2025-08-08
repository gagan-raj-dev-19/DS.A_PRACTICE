package Arrays.Hard;

//  bruteforce code
//  O(n^2) and O(1)  TLE -> LeetCode
 class ReversePairs {
     public static int reversePairs(int[] nums){
         int n = nums.length;
         int count = 0;
         for (int i=0;i<n;i++){
             for(int j=i+1;j<n;j++){
                 if(nums[i] > 2*nums[j]){
                     count++;
                 }
             }
         }
         return count;
     }

     public static void main(String[] args) {
         int[] nums= {1,3,2,3,1};
         int[] nums1= {2,4,3,5,1};
         System.out.println(reversePairs(nums));
         System.out.println(reversePairs(nums1));

     }
}

// pending optimised code!