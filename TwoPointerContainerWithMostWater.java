package org.example;

public class TwoPointerContainerWithMostWater {
    public static void main(String[] args){
        int[] heights ={1,7,2,5,4,7,3,6};
        int myAnswer = containerWithMostWater(heights);
        System.out.println(myAnswer);
    }

    private static int containerWithMostWater(int[] heights) {
        int i =0;
        int j = heights.length-1;
        int answer = Integer.MIN_VALUE;
        while(i<j){
            int formulaValue = (j-i)*Math.min(heights[i],heights[j]);
            if(formulaValue>answer){
                answer=formulaValue;
            }
            if(heights[i]<heights[j]){
                i++;
            }
            else {
                j--;
            }
        }
        return answer;
    }
}
