package Arrays.Easy;

public class Minimumoperationstomakearraysumdivisiblebyk_3512 {

    public static int minOperations(int[] nums, int k){
        int sum = 0;
        for(int i=0;i<nums.length;i++){
            sum+= nums[i];
        }
        return sum%k;
    }

    public static void main(String[] args) {
        int[] nums = {3,9,7};
        int k = 5;
        System.out.println(minOperations(nums,k));
    }
}
