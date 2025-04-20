package org.example;

public class HashingProductOfArrayExceptSelf {

    public static void main(String[] args){
        int[] nums = {1,2,4,6};
        int[] answer = mineProductExceptSelf(nums);
        System.out.print(answer);
    }

    private static int[] mineProductExceptSelf(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];

        result[0] = 1;
        //prepare left prodect array
        for (int i = 1; i < n; i++) {
            result[i] = result[i - 1] * nums[i - 1];
        }

        int rightProduct = 1;
        //now multiply with right
        for (int i = n - 1; i >= 0; i--) {
            result[i] *= rightProduct;
            rightProduct *= nums[i];
        }

        return result;
    }
}
