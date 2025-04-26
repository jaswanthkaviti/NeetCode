package org.example;

public class BSBinarySearch {
    public static void main(String[] args){
        int[] nums = {1,2,3,4,5,6,7,8,9};
        int answer = search(nums,8);
        System.out.println(answer);
    }


    private static int search(int[] nums, int target) {
        int low =0;
        int high = nums.length-1;
        while(low<=high){
            int mid = low+(high-low)/2;
            if(nums[mid]>target){
                high=mid-1;
            }
            else if(nums[mid]<target){
                low=mid+1;
            }
            else if(nums[mid] == target){
                return mid;
            }

        }
        return -1;
    }

}
