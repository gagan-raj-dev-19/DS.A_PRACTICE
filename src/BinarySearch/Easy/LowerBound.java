package BinarySearch.Easy;
// bruteforce
class LowerBoundBrute {
    public static int lowerBound(int[] arr, int k){
        int n = arr.length;
        for (int i=0;i<n;i++){
            if (arr[i] >= k){
                return i;
            }
        }
        return n;
    }

    public static void main(String[] args) {
        int[] arr = {3,5,8,15,19};
        int k = 9;
        System.out.println(lowerBound(arr,k));
    }
}

// optimised
class LowerBoundOptimised {
    public static int lowerBound(int[] arr, int k) {
        int left=0;
        int right= arr.length;
        while(left<right){
            int mid=left+(right-left)/2;
            if (arr[mid]>=k){
                right=mid;
            }
            else {
                left=mid+1;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        int[] arr = {3,5,8,15,19};
        int k = 9;
        System.out.println(lowerBound(arr,k));
    }
}
