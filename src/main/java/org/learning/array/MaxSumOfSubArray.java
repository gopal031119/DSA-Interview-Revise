package org.learning.array;

public class MaxSumOfSubArray {
    public static void main(String arg[]){
        int arr[]= {1,-2,6,-1,3};
        System.out.println(bruteforce(arr));
        System.out.println(betterApproach(arr));
        System.out.println(kadaneAlgo(arr));
    }

    /**
     * Time Complexity :- O(n)
     * Kadane's algorithm
     * 
     * @param arr
     * @return
     */
    private static int kadaneAlgo(int[] arr) {
        int max = Integer.MIN_VALUE, sum=0;
        for(int i=0;i<arr.length;i++){
            
            sum = sum + arr[i];
            
            max = Math.max(sum, max);
            
            if(sum<0)
                sum=0;
        }
        return sum;
    }

    /**
     * Time Complexity - O(n2)
     * 
     * @param arr
     * @return
     */
    private static int betterApproach(int[] arr) {
        {
            int max=Integer.MIN_VALUE;
            for(int i=0;i< arr.length;i++){
                int sum=0;
                for(int j=i;j<arr.length;j++){
                    sum = sum + arr[j];
                }
                max= Math.max(sum,max);
            }
            return max;
        }
    }

    /**
     * Time Complexity - O(n3)
     * 
     * @param arr
     * @return
     */
    private static int bruteforce(int[] arr) {
        int max=Integer.MIN_VALUE;
        for(int i=0;i< arr.length;i++){
            for(int j=i;j<arr.length;j++){
                int sum=0;
                for(int k=i;k<=j;k++){
                    sum=sum+=arr[k];
                }
                max = Math.max(sum,max);
            }
        }
        return max;
    }
}
