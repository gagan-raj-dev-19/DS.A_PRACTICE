package Arrays.Easy;

import java.util.Arrays;

public class MoveZeroes_283 {
    public static void moveZeroes(int[] arr){
        int n = arr.length;
        int left = 0;
        for (int right=0;right<n;right++){
            if (arr[right]!=0){
                int temp = arr[right];
                arr[right] = arr[left];
                arr[left]=temp;
                left++;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr={1,2,3,0,0,4,5,6};
        moveZeroes(arr);
        System.out.println(Arrays.toString(arr));
    }
}
