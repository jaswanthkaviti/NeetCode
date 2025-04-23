package org.example;

import java.util.List;

public class TwoPointerTwoSum {
    public static void main(String[] args){
        int[] numbers ={1,2,3,4};
        int target =3;
        int[] answer = twoSum(numbers,target);
        System.out.println(answer[0]);
        System.out.println(answer[1]);

    }

    private static int[] twoSum(int[] numbers, int target) {
        int[] output = new int[2];

        for(int i=0,j=numbers.length-1;i<j;){
            if(numbers[i]+numbers[j] > target){
                j--;
            }
            else if(numbers[i]+numbers[j] == target){
                output[0]=i+1;
                output[1]=j+1;
                break;
            }
            else{
                i++;
            }
        }
        return output;
    }
}
