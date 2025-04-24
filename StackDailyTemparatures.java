package org.example;

import java.util.Stack;

public class StackDailyTemparatures {
    public static void main(String[] args){
        int[] temparatures = {30,38,30,36,35,40,28};
        int[] warmTemparatures = dailyTemparatures(temparatures);
        System.out.println(warmTemparatures.toString());
    }

    private static int[] dailyTemparatures(int[] temparatures) {
        Stack<Integer> stack = new Stack<>();
        int n = temparatures.length;
        int[] results = new int[n];
        for(int index = n-1;index>=0;index--){
            while(!stack.isEmpty()&&temparatures[index]>=temparatures[stack.peek()]){
                stack.pop();
            }
            if(!stack.isEmpty()){
                results[index] = stack.peek()-index;
            }
            stack.push(index);
        }
        return results;
    }
}
