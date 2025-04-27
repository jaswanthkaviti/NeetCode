package org.example;

public class BSFindMinRotatedSortedArray {
    public static void main(String[] args){
        int[] nums= {4,5,0,1,2,3};
        int answer = findMin(nums);
        int originalAnswer = originalFindMin(nums);
        System.out.println(answer);
        System.out.println(originalAnswer);
    }

    private static int originalFindMin(int[] nums) {
        int min = 0;
        int max = nums.length - 1;

        while (min < max) {
            int mid = min + (max - min) / 2;

            if (nums[mid] > nums[max]) {
                min = mid + 1;
            } else {
                max = mid;
            }
        }
        return nums[min];
    }

    private static int findMin(int[] nums) {
        int answer = Integer.MAX_VALUE;
        int min = 0;
        int max = nums.length-1;
        while(min<max){
            int mid = min + (max-min)/2;
            if(nums[min]<nums[mid] && nums[max]<nums[mid]){
                min = mid;
                answer = Math.min(answer,nums[mid]);
            }
            else{
                max=mid;
                answer = Math.min(answer,nums[mid]);
            }
        }
        return answer;
    }
}
