package BinarySearch.Medium;

 class SearchinRotatedSortedArray {
    public static int searchRotatedArray(int[] arr, int target){
        int n=arr.length;
        int left=0;
        int right=n-1;
        while(left<=right){
            int mid = left+(right-left)/2;
            if (arr[mid]==target){
                return mid;
            }
            if (arr[left]<=arr[mid]){
                if (arr[left]<=target && target<=arr[mid]){
                    right=mid-1;
                }else{
                    left=mid+1;
                }
            }else{
                if(arr[mid]<target && target<=right){
                    left=mid+1;
                }else {
                    right=mid-1;
                }
            }
        }
        return -1;
    }

     public static void main(String[] args) {
         int[] arr = {4,5,6,7,0,1,2};
         int target=0;
         System.out.println(searchRotatedArray(arr,target));
     }
}
