package Arrays.Medium;


import java.util.HashSet;
import java.util.Set;

class LongestConsecutiveSequence {
    public int longestConsecutive(int[] nums) {
        int n = nums.length;
        if (nums == null || n == 0){
            return 0;
        }

        Set <Integer> numSet = new HashSet<>();
        for (int num:nums){
            numSet.add(num);
        }
        int longest = 0;
        for (int num:numSet){
            if (!numSet.contains(num-1)){
                int currentNum = num;
                int currentLength = 1;

                while (numSet.contains(currentNum+1)){
                    currentNum++;
                    currentLength++;
                }
                longest = Math.max(currentLength,longest);
            }
        }


        return longest;

    }

    public static void main(String[] args) {
        LongestConsecutiveSequence obj = new LongestConsecutiveSequence();
        int[] nums = {2,3,1,4,100,200};
        System.out.println(obj.longestConsecutive(nums));
    }
}

//{1,2,3,4,100,200}