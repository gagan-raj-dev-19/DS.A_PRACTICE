package Arrays.Easy;

public class Single_Number_136 {
    public static int singleNumber(int[] nums){
        int res = 0;
        for (int num : nums){
            res = res^num;
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {1,1,2,2,3,3,5};
        System.out.print(singleNumber(nums));
    }
}
