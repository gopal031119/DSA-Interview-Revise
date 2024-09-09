package org.learning.recursion;

public class FindLastOccOfElement {
    public static void main(String args[]){
        int arr[] = {1,2,4,3,5,2,2};
        System.out.println(findLastOccOfElement(arr, 0,2));
    }


    /**
     * Tc - O(n)
     * Sc - O(n)
     *
     */
    private static int findLastOccOfElement(int arr[], int i, int val) {
        
        if(i == arr.length){
            return -1;
        }

        int isFound = findLastOccOfElement(arr, i+1, val);

        if(isFound != -1){
            return isFound;
        }
        
        if(arr[i] == val){
            return i;
        }
        
        // combining both above condition
//        if(isFound == -1 && arr[i] == val){
//            return i;
//        }
//        
       return isFound;
    }
}
