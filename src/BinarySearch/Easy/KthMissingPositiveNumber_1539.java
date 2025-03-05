package BinarySearch.Easy;

class BruteForce {
    public static int findKthPositive(int[] arr, int k) {
        int missingCount = 0;
        int num=1;
        int i=0;
        while(true){
            if(i < arr.length && arr[i] == num){
                i++;
            }else{
                missingCount++;
                if(missingCount == k){
                    return num;
                }
            }
            num++;
        }

    }

    public static void main(String[] args) {
        int[] arr = {2,3,4,7,11};
        int k = 5;
        System.out.println(findKthPositive(arr,k));
    }
}