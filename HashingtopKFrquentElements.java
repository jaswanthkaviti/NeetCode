package org.example;

import java.util.*;

//Given an integer array nums and an integer k, return the k most frequent elements within the array.
public class HashingtopKFrquentElements {

    public static void main(String[] args){
        int[] numbers = {1,2,2,3,3,3,4};
        int k =2;
        int[] pass = topKFrequent(numbers,k);
    }

    private static int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        //In this map , We get Frequency
        for(int num : nums){
            map.put(num,map.getOrDefault(num,0)+1);
        }
        //creating min-heap
        //by this lowest frequency gets on top
        PriorityQueue<Map.Entry<Integer, Integer>> minHeap =
                new PriorityQueue<>((a, b) -> a.getValue() - b.getValue());//using this logic to get the min heap
        //< 0 → a comes before b
        //> 0 → b comes before a
        //= 0 → order doesn't matter
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            //least frequent element will be on top.
            minHeap.offer(entry);//adding element
            if (minHeap.size() > k) {
               //If the heap has more than K elements, you remove the smallest frequency element
                minHeap.poll();
            }
        }
        int[] result = new int[k];
        int i = 0;
        while (!minHeap.isEmpty()) {
            result[i++] = minHeap.poll().getKey();
        }

        return result;
    }
}
