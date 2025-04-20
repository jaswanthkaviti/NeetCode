package org.example;

import java.util.ArrayList;
import java.util.List;

public class HashingEncodeAndDecode {
    public static void main(String[] args){
       List<String> strings = new ArrayList<>();
       strings.add("jaswanth");
       strings.add("kumar");
       strings.add("kaviti");
       //failed
        // If the String itself contains space then it will fail
       String encodeString = stringEncoder(strings);
       List<String> decodedStrings = new ArrayList<>();
       decodedStrings = stringDecoder(encodeString);
       //passed
        String passEncodeString = passStringEncoder(strings);
        List<String> passdecodedStrings = new ArrayList<>();
        passdecodedStrings = passStringDecoder(passEncodeString);
    }

    private static List<String> passStringDecoder(String str) {
        List<String> result = new ArrayList<>();
        int i=0;
        while(i<str.length()){
            int j=i;
            while (str.charAt(j) !='#') {
                j++;
            }
            int length = Integer.parseInt(str.substring(i, j));
            j++;
            result.add(str.substring(j,(j+length)));
            i=j+length;
            }
        return result;
    }

    private static String passStringEncoder(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for (String str : strs) {
            //here we will append length and # delimeter and string
            sb.append(str.length()).append("#").append(str);
        }
        return sb.toString();
    }

    private static List<String> stringDecoder(String strs) {
        String[] stringArray = strs.split(" ");
        List<String> list = new ArrayList<>();
        for(String str : stringArray){
            list.add(str.trim());
        }
        return list;
    }

    private static String stringEncoder(List<String> strs) {
        StringBuilder stringBuilder = new StringBuilder();
        if(strs.size()!=0) {
            for (String string : strs) {
                stringBuilder.append(string + " ");
            }
        }
        return stringBuilder.toString().trim();
    }
}
