package org.learning.string;

public class StringCompression{
    public static void main(String...args){
        String str= "aaabbcccdd";
        System.out.println(compress(str));
    }

    /**
     * Time Complexity - O(n)
     * @param str
     * @return
     */
    private static String compress(String str) {
        String result = "";
        
        for(int i=0;i<str.length();i++){
            int count =1;
            while(i<str.length()-1 && str.charAt(i)==str.charAt(i+1)){
                count++;
                i++;
            }
            
            result += str.charAt(i);
            if(count > 1) {
                result += String.valueOf(count);
            }
            
        }
        return result;
    }
}
