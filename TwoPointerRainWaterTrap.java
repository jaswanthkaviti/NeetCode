package org.example;

public class TwoPointerRainWaterTrap {
    public static void main(String[] args){
        int[] heights = {0,2,0,3,1,0,1,3,2,1};
        int answer = rainWaterTrap(heights);
        System.out.println(answer);
        
    }

    private static int rainWaterTrap(int[] height) {
        int n = height.length;
        int[] left = new int[n];
        int[] right = new int[n];
        left[0] = height[0];
        right[n-1]=height[n-1];
        for(int i =1;i<n-1;i++){
            left[i] = Math.max(left[i-1],height[i]);
        }
        for(int j =n-2;j>=0;j--){
            right[j]=Math.max(height[j],right[j+1]);
        }
        int contains=0;
        for(int i=0;i<n;i++){
            int answer = Math.min(left[i],right[i])-height[i];
            contains += Math.max(0, answer);
        }

        return contains;
    }
}
