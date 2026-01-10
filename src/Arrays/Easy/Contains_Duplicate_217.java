package Arrays.Easy;

import java.util.HashSet;

public class Contains_Duplicate_217 {
    public static boolean containsDuplicate(int[] nums){
        HashSet<Integer> seen = new HashSet<>();
        for(int num : nums){
            if(seen.contains(num)){
                return true;
            }
            seen.add(num);
        }
        return false;

    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,4};
        System.out.println(containsDuplicate(nums));


    }

}
