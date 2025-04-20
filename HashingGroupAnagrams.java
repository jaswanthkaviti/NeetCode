package org.example;

import java.util.*;

public class HashingGroupAnagrams {

    public static void main(String[] args){
        String[] strs = {"cat","act","tops","pots","stop"};
        List<List<String>> failure = mineGroupAnagram(strs);
        List<List<String>> pass    = GroupAnagram(strs);
    }

    private static List<List<String>> GroupAnagram(String[] strs) {
        Map<String , List<String>> map = new HashMap<>();
        for(String s : strs){
            char[] charArray = s.toCharArray();
            Arrays.sort(charArray);
            String key = new String(charArray);
            if(!map.containsKey(key)){
                map.put(key,new ArrayList<>());
            }
            map.get(key).add(s);
        }
        return new ArrayList<>(map.values());
    }

    private static List<List<String>> mineGroupAnagram(String[] strs) {
        String s="";
        String s2="";
        List<List<String>> lists = new ArrayList<>();
        for(int i=0;i<strs.length;i++){
            char[] charString = strs[i].toCharArray();
            Arrays.sort(charString);
            s = new String(charString);
            List<String> list = new ArrayList<>();
            list.add(strs[i]);
            for(int j=i+1;j<strs.length;j++){
                char[] rem = strs[j].toCharArray();
                Arrays.sort(rem);
                s2 = new String(rem);
                if(s.equals(s2)){
                    list.add(strs[j]);
                }
            }
            lists.add(list);
        }
        return lists;
    }
}
