package org.learning.recursion;

public class FindOccOfElement {
    public static void main(String args[]){
        int arr[] = {1,2,4,3,5,2,2};
        System.out.println(findOccOfElement(arr, 0,2));
    }


    /**
     * Tc - O(n)
     * Sc - O(n)
     *
     */
    private static int findOccOfElement(int arr[], int i, int val) {

        if(i == arr.length){
            return -1;
        }

        if(arr[i] == val){
            return i;
        }

        return findOccOfElement(arr, i+1, val);
    }
}
