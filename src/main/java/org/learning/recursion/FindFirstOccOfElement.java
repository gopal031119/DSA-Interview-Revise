package org.learning.recursion;

public class FindFirstOccOfElement {
    public static void main(String args[]){
        int arr[] = {1,2,4,3,5,2,2};
        System.out.println(findFirstOccOfElement(arr, 0,2));
    }


    /**
     * Tc - O(n)
     * Sc - O(n)
     *
     */
    private static int findFirstOccOfElement(int arr[], int i, int val) {

        if(i == arr.length){
            return -1;
        }

        if(arr[i] == val){
            return i;
        }

        return findFirstOccOfElement(arr, i+1, val);
    }
}
