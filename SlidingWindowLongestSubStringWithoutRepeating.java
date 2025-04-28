package org.example;

import java.util.HashSet;

public class SlidingWindowLongestSubStringWithoutRepeating {
    public static void main(String[] args){
        String s = "xxx";
        int longestLength=lengthOfLongestSubString(s);
        int originalLongestLength=originalLengthOfLongestSubString(s);

        System.out.println(originalLongestLength);
    }

    private static int originalLengthOfLongestSubString(String s) {
        int i = 0, j = 0, maxLength = 0;
        HashSet<Character> set = new HashSet<>();

        while (j < s.length()) {
            if (!set.contains(s.charAt(j))) {
                set.add(s.charAt(j));
                maxLength = Math.max(maxLength, j - i + 1);
                j++;
            } else {
                set.remove(s.charAt(i));
                i++;
            }
        }

        return maxLength;
    }

    private static int lengthOfLongestSubString(String s) {
        char[] arr = s.toCharArray();
        int i=0;
        int j = i+1;
        int count =1;
        int maxcount =1;
        HashSet<Character> c= new HashSet<>();
        while(j<arr.length){
            if(arr[i]!=arr[j]){
                c.add(arr[i]);
                if(!c.add(arr[j])) {
                    c.add(arr[j]);
                    count++;
                    maxcount = Math.max(count, maxcount);
                    j++;
                }
                else{
                    i++;
                    j++;
                }
            }
            else{
                i++;
                j++;
                count=0;
            }
        }
        return maxcount;
    }
}
