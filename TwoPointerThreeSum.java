package org.example;

import java.util.*;

public class TwoPointerThreeSum {
    public static void main(String[] args){
        int[] numbers ={-1,0,1,2,-1,-4};
        List<List<Integer>> myAnswer = mineThreeSum(numbers);
        System.out.println(myAnswer.toString());

        List<List<Integer>> answer = threeSum(numbers);
        System.out.println(answer.toString());
    }

    private static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        Set<List<Integer>> set = new HashSet<>();
        for(int i =0;i<nums.length-2;i++){
            int left = i+1;
            int right = nums.length-1;
            while(left<right){
                int sum = nums[i]+nums[left]+nums[right];
                if(sum==0){
                    set.add(Arrays.asList(nums[i],nums[left],nums[right]));
                    left++;
                    right--;
                }
                else if(sum<0){
                    left++;
                }
                else{
                    right--;
                }
            }
        }
        return new ArrayList<>(set);
    }

    private static List<List<Integer>> mineThreeSum(int[] nums) {
        List<List<Integer>> answer = new ArrayList<>();
        Arrays.sort(nums);
        for(int i=0,j=i+1,k=j+1;k<nums.length-1;i++,j++,k++){
            List<Integer> zeroNumbers = new ArrayList<>();
            if(nums[i]+nums[j]+nums[k]==0){
                zeroNumbers.add(nums[i]);
                zeroNumbers.add(nums[j]);
                zeroNumbers.add(nums[k]);
                answer.add(zeroNumbers);
            }
        }
        return answer;
    }
}
