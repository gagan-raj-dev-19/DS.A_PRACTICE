package Arrays.Medium;
// bruteforce
 class MaximumProductSubarray{
     public static int maxProd(int[] arr){

         int max = Integer.MIN_VALUE;
         for (int i=0;i< arr.length-1;i++){
             for (int j=i+1;j< arr.length;j++){
                 int prod = 1;
                 for (int k = i;k<=j;k++){
                     prod = prod*arr[k];
                     max = Math.max(max,prod);

                 }
             }
         }
         return max;
     }

     public static void main(String[] args) {
         int[] arr = {1,2,-3,0,-4,-5};
         System.out.println(maxProd(arr));
     }
}

// optimised code pending