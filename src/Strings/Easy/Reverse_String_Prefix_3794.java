package Strings.Easy;

public class Reverse_String_Prefix_3794 {
    public static String reversePrefix(String s, int k){
        char[] arr = s.toCharArray();
        for (int i=0;i<k/2;i++){
            char temp = arr[i];
            arr[i] = arr[k-1-i];
            arr[k-1-i] = temp;
        }
        return new String(arr);
    }

    public static void main(String[] args) {
        String s= "abcd";
        int k = 2;
        System.out.println(reversePrefix(s,k));
    }

}

