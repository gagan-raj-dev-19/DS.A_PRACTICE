package Arrays.Medium;

import java.util.HashMap;
import java.util.Map;

public class Subarray_with_given_XOR {
    public static int subArrayXor(int[] arr, int k){
        int xor = 0;
        Map<Integer,Integer> map = new HashMap<>();
        map.put(0,1);
        int count = 0;
        for (int i : arr) {
            xor = xor ^ i;
            int x = xor ^ k;
            if (map.containsKey(x)) {
                count = count + map.get(x);
            }
            if (map.containsKey(xor)) {
                map.put(xor, map.get(xor) + 1);
            } else {
                map.put(xor, 1);
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] arr = {4,2,2,6,4};
        int k = 6;
        System.out.println(subArrayXor(arr,k));
    }
}
