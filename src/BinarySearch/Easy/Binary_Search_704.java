package BinarySearch.Easy;
// iterative approach
class Iterative {
    public int search(int[] nums, int target) {
        int n = nums.length;

        int left =0;
        int right = n-1;

        while(left<=right){
            int mid = left + (right-left)/2;
            if(nums[mid] == target){
                return mid;
            }else if(target < nums[mid]){
                right = mid-1;
            }else{
                left = mid+1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Iterative obj = new Iterative();
        int[] nums = {3, 4, 6, 7, 9, 12, 16, 17};
        int target = 6;
        System.out.println("iterative o/p = "+obj.search(nums,target));
    }
}

// recursive approach

class Recursive {
    public int search(int[] nums, int target) {
        return binarySearch(nums, 0,nums.length-1,target);
    }

    public static int binarySearch(int[]nums, int left, int right, int target){
        if(right < left){
            return -1;
        }
        int mid = left + (right-left)/2;
        if(nums[mid] == target){
            return mid;
        }
        else if(target > nums[mid]){
            return binarySearch(nums,mid+1,right,target);
        }else{
            return binarySearch(nums,left,mid-1,target);
        }
    }

    public static void main(String[] args) {
        Recursive obj1 = new Recursive();
        int[] nums= {3, 4, 6, 7, 9, 12, 16, 17};
        int target = 6;
        System.out.println("recursive o/p = "+obj1.search(nums,target));
    }
}