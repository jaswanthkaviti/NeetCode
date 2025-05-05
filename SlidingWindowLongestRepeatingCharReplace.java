package org.example;

import java.util.HashMap;
import java.util.Map;

public class SlidingWindowLongestRepeatingCharReplace {
    public static void main(String[] args){
        String s ="XYYX";
        int answer = characterReplacement(s,2);
        System.out.println(answer);
    }

    private static int characterReplacement(String s, int k) {
        int maxLength = 0;
        int start = 0;
        Map<Character, Integer> charCounts = new HashMap<>();

        for (int end = 0; end < s.length(); end++) {
            charCounts.put(s.charAt(end), charCounts.getOrDefault(s.charAt(end), 0) + 1);

            int maxCount = 0;
            for (int count : charCounts.values()) {
                maxCount = Math.max(maxCount, count);
            }

            while (end - start + 1 - maxCount > k) {
                charCounts.put(s.charAt(start), charCounts.get(s.charAt(start)) - 1);
                start++;
            }
            maxLength = Math.max(maxLength, end - start + 1);
        }
        return maxLength;
    }
}
