package Arrays.Medium;

import java.util.HashMap;

 class LargestSubArray {
    public int largestSubArray(int[] arr){

        HashMap <Integer,Integer> map = new HashMap<>();
        int max = 0;
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum=sum+arr[i];
            if(sum == 0){
                max= i+1;
            }else if (map.get(sum)!=null) {
                max = Math.max(max, i-map.get(sum));
            }else{
                map.put(sum, i);
            }
        }
        return max;


    }
    public static void main(String[] args) {
        LargestSubArray obj = new LargestSubArray();
        int[] arr = {9,-3,3,-1,6,-5};
        System.out.println(obj.largestSubArray(arr));

    }


}
