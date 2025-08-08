package Arrays.Easy;

public class FindLargestElement {
    public static int findLargest(int[] arr){
        int max = arr[0];
        for (int i=0;i<arr.length;i++){
            if (arr[i] > max){
                max = arr[i];
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] arr = {1,3,2,5,6,4};
        System.out.println(findLargest(arr));
    }
}


// bruteforce
//import java.util.Arrays;
//
//public class FindLargestElement {
//    public static int findLargest(int[] arr) {
//        Arrays.sort(arr);
//        return arr[arr.length-1];
//    }
//
//    public static void main(String[] args) {
//        int[]  arr = {5,6,2,4,5,9};
//        System.out.println(findLargest(arr));
//    }
//
//}