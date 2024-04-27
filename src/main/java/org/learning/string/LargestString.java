package org.learning.string;

public class LargestString {
    public static void main(String...args){
        String[] strArr= {"apple", "mango", "banana"};
        System.out.println(lexicographicalLargest(strArr));
    }

    private static String lexicographicalLargest(String[] strArr) {
        String largest = strArr[0];
        for(String str:strArr){
            if(str.compareTo(largest)>0){
                largest = str;
            }
        }
        return largest;
    }
}
