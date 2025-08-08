package Strings.Medium;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

 class Sort_Characters_By_Frequency {
    public static String frequencySort(String s){
        Map<Character,Integer> freqMap = new HashMap<>();
        for(char c : s.toCharArray()){
            freqMap.put(c,freqMap.getOrDefault(c,0)+1);
        }

        PriorityQueue <Character> maxHeap = new PriorityQueue<>(
                (a,b) -> freqMap.get(b) - freqMap.get(a));
        maxHeap.addAll(freqMap.keySet());

        StringBuilder sb = new StringBuilder();
        while(!maxHeap.isEmpty()) {
            char current = maxHeap.poll();
            int freq = freqMap.get(current);
            for (int i = 0; i < freq; i++) {
                sb.append(current);
            }
        }
        return sb.toString();

    }

     public static void main(String[] args) {
         String s = "tree";
         String sorted = frequencySort(s);
         System.out.println(sorted);
     }
}
