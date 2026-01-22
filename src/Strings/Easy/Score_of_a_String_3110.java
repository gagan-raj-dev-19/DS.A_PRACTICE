package Strings.Easy;

 class Score_of_a_String_3110 {
     public static int scoreOfString(String s){
         int total = 0;
         for (int i=0;i<s.length()-1;i++){
             total += Math.abs(s.charAt(i) - s.charAt(i+1));
         }
         return total;
     }

     public static void main(String[] args) {
         String s = "hello";
         System.out.println(scoreOfString(s));
     }
}
