package BinarySearch.Easy;

// bruteforce linear search approach

class LinearSearch{
    public static int search(int[] arr, int target){
        for(int i=0;i< arr.length;i++){
            if(arr[i] == target){
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int [] arr = {1,3,5,7,9,11};
        int target = 9
        int result = search(arr,target);
        System.out.println(result);
    }
}
// TC -> O(n)
// SC -> O(1)

// optimised approach

