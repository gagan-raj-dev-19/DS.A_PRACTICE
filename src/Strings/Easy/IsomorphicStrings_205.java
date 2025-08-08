package Strings.Easy;

import java.util.HashMap;
// using hashmap
class IsomorphicStrings {
     public static boolean isIsomorphic(String s, String t){
         if (s.length() != t.length()){
             return false;
         }
         HashMap<Character,Character> mapS = new HashMap<>();
         HashMap<Character,Character> mapT = new HashMap<>();


         for (int i=0;i<s.length();i++){
             char charS = s.charAt(i);
             char charT = t.charAt(i);

             if(mapS.containsKey(charS)){
                 if(mapS.get(charS) != charT){
                     return false;
                 }
             }else {
                 mapS.put(charS,charT);
             }
             if(mapT.containsKey(charT)){
                 if(mapT.get(charT) != charS){
                     return false;
                 }
             }else {
                 mapT.put(charT,charS);
             }
         }
         return true;
     }

    public static void main(String[] args) {
        System.out.println(isIsomorphic("egg", "add"));    // true
        System.out.println(isIsomorphic("foo", "bar"));    // false
        System.out.println(isIsomorphic("paper", "title"));// true
    }
    }



class Iteration {
    public static boolean Isomorphic(String s, String t) {
        int[] idxS = new int[200];
        int[] idxT = new int[200];

        if(s.length() != t.length()){
            return false;
        }

        for (int i=0;i<s.length();i++){
            if(idxS[s.charAt(i)] != idxT[t.charAt(i)]){
                return false;
            }

            idxS[s.charAt(i)] = i+1;
            idxT[t.charAt(i)] = i+1;

        }
        return true;

    }
    public static void main(String[] args) {
        System.out.println(Isomorphic("egg", "add"));    // true
        System.out.println(Isomorphic("foo", "bar"));    // false
        System.out.println(Isomorphic("paper", "title"));// true
    }
}
