package org.learning.queue;

import java.util.LinkedList;
import java.util.Queue;

public class NonRepeatingLetter {
    public static void main(String... args) {
        String str = "aabccxb";
        nonRepeatingLetter(str);
    }

    private static void nonRepeatingLetter(String str) {
        int[] freq = new int[26];  // frequency of each character (assuming lowercase a-z)
        Queue<Character> q = new LinkedList<>();

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);

            // increase frequency
            freq[ch - 'a']++;

            // add to queue
            q.add(ch);

            // remove all characters from front of queue that are now repeating
            while (!q.isEmpty() && freq[q.peek() - 'a'] > 1) {
                q.remove();
            }

            // display current non-repeating letter
            if (q.isEmpty()) {
                System.out.print("-1 "); // if no non-repeating character
            } else {
                System.out.print(q.peek() + " ");
            }
        }
    }
}
