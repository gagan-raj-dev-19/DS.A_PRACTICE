package Arrays.Hard;

class CountInversion {
    static int inversionCount(int arr[]) {
        return mergeSort(arr,new int[arr.length],0,arr.length-1);
    }
    private static int mergeSort(int[]arr, int[] temp,int left, int right){
        if(left>=right){
            return 0;
        }
        int mid = left+(right-left)/2;
        int count= mergeSort(arr,temp,left,mid);
        count=count+mergeSort(arr,temp,mid+1,right);
        count=count+merge(arr,temp,left,mid,right);
        return count;
    }
    private static int merge(int[]arr, int[]temp,int left,int mid, int right){
        int i=left;
        int j=mid+1;
        int k=left;
        int count=0;

        while(i<=mid && j<=right){
            if(arr[i]<=arr[j]){
                temp[k++]=arr[i++];
            }else{
                temp[k++]=arr[j++];
                count=count+(mid-i+1);
            }
        }

        while(i<=mid){
            temp[k++]=arr[i++];
        }
        while(j<=right){
            temp[k++]=arr[j++];
        }
        System.arraycopy(temp,left,arr,left,right-left+1);
        return count;

    }
}
/*



 */