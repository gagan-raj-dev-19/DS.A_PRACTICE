package Arrays.Easy;
class MissingNumber {
public static int missingNum(int[] nums){
    int res = nums.length;
    for (int i =0;i<nums.length;i++){
        res = res+ i - nums[i];
    }
    return res;
}

    public static void main(String[] args) {
        int[] nums = {1,2,3,0,4};
        int res = missingNum(nums);
        System.out.println(res);
    }
}

// using summation

//class MissingNumber{
//    public static int missingNumber(int[] nums){
//        int n = nums.length;
//        int totalSum = (n*(n+1)/2);
//        int numsSum = 0;
//
//        for (int i=0;i<nums.length;i++){
//            numsSum = numsSum+nums[i];
//        }
//        return totalSum - numsSum;
//    }
//
//    public static void main(String[] args) {
//        int[] nums = {1,2,0,3};
//        int res = missingNumber(nums);
//        System.out.println(res);
//    }
//}

/*

xor approach

class Solution {
    public int missingNumber(int[] nums) {
        int n = nums.length;
        int xor1 = 0;
        int xor2 = 0;
        for(int i=0;i<nums.length;i++){
            xor2 = xor2 ^ nums[i];
            xor1 = xor1 ^ (i+1);
        }

         return (xor1 ^ xor2);
    }
}

 */