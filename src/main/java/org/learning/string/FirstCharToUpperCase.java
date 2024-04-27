package org.learning.string;

public class FirstCharToUpperCase {
    public static void main(String...args){
        String str= "hi, i am java developer";
        System.out.println(covertFirstCharToUpperCase(str));
    }

    /**
     * you can use String builder instead of String;
     * @param str
     * @return
     */
    private static String covertFirstCharToUpperCase(String str) {
        String result= "";
        //base case
        result = result + Character.toUpperCase(str.charAt(0));
        
        for(int i=1;i<str.length();i++){
            if(str.charAt(i-1) == ' '){
                result = result + Character.toUpperCase(str.charAt(i));
            }
            else {
                result = result + str.charAt(i);
            }
        }
        return result;
    }
}
