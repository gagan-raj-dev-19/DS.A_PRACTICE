package Sorting;

import java.util.HashMap;
import java.util.Map;

class Make_Two_Arrays_Equal_by_Reversing_Subarrays {
     public boolean canBeEqual(int[] target, int[] arr) {
         Map<Integer ,Integer> map = new HashMap<>();
         for(int i=0;i<target.length; i++){
             map.put(target[i], map.getOrDefault(target[i], 0) +1);
             map.put(arr[i], map.getOrDefault(arr[i],0)-1);
         }
         for(int i :map.keySet()){
             if(map.get(i)!=0){
                 return false;
             }
         }
         return true;
     }
}

// 31/07/25

