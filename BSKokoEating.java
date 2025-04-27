package org.example;

public class BSKokoEating {
    public static void main(String[] args){
        int[] piles = {1,4,3,2};
        int answer = minEatingSpeed(piles,9);
        System.out.println(answer);
    }

    private static int minEatingSpeed(int[] piles, int h) {
        int minSpeed = 1;
        int maxSpeed = 0;
        for(int pile:piles){
            maxSpeed=Math.max(pile,maxSpeed);
        }
        while(minSpeed<maxSpeed){
            int mid = minSpeed+(maxSpeed-minSpeed)/2;
            if(canEatInTime(piles,h,mid)){
                maxSpeed=mid;
            }
            else{
                minSpeed=mid+1;
            }
        }
        return minSpeed;
    }

    private static boolean canEatInTime(int[] piles, int h, int mid) {
        int hours =0;
        for(int pile:piles){
            hours = hours + (int)Math.ceil((double) pile/mid);
        }
        return hours<=h;
    }
}
