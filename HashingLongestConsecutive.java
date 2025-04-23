package org.example;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class HashingLongestConsecutive {

    public static void main(String[] args){
        int[] numbers = {2,20,4,10,3,4,5};//4
        int anwser = consecutive(numbers);
        System.out.println(anwser);
    }

    private static int consecutive(int[] nums) {
       Set<Integer> set = new HashSet<>();
       for(int num : nums){
           set.add(num);
       }
       int streak=0;
       int maxStreak=Integer.MIN_VALUE;
       for(int num:nums){
           int digits=num;
           while(set.contains(digits)) {
                   streak++;
                   digits++;
           }
           maxStreak=Math.max(streak,maxStreak);
           streak=0;
       }
       return maxStreak;
    }
}
