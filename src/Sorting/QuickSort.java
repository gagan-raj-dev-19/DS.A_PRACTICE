package Sorting;

class QuickSort{
    public static void quickSort(int[] arr, int left, int right){
        if (left < right){
            int pivotIndex = partition(arr,left,right);
            quickSort(arr,left,pivotIndex-1);
            quickSort(arr,pivotIndex+1,right);
        }
    }
    public static int partition(int[] arr, int left, int right){
        int pivot = arr[right];
        int i = left-1;
        for (int j=left;j<right;j++){
            if (arr[j] < pivot){
                i++;
                int temp = arr[i];
                arr[i]= arr[j];
                arr[j] = temp;
            }
        }
        int temp = arr[i+1];
        arr[i+1]=arr[right];
        arr[right]=temp;
        return i+1;
    }

    public static void main(String[] args) {
        int[] arr = {9,8,7,6,5,4,3,2,1,0};
        quickSort(arr,0,arr.length-1);
        for (int sort : arr){
            System.out.print(sort+" ");
        }
    }
}
/*

 */