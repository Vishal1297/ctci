package org.vishal1297.ds.chapter_1.problems;

import java.util.Arrays;
import java.util.HashMap;

public class IsPermutation {

    public static void main(String[] args) {
        System.out.println(isPermutation("abc", "aaa"));
    }


    public static boolean isPermutation(String s, String t) {
        if (s.equals(t)) return true;
        if (s.length() != t.length()) return false;
        HashMap<Character, Integer> sMap = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            sMap.put(s.charAt(i), sMap.getOrDefault(s.charAt(i), 0) + 1);
        }
        HashMap<Character, Integer> tMap = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            tMap.put(t.charAt(i), tMap.getOrDefault(t.charAt(i), 0) + 1);
        }
        return sMap.equals(tMap);
    }

//    public static boolean isPermutation(String s, String t) {
//        if (s.equals(t)) {
//            return true;
//        }
//        if (s.length() == t.length()) {
//            char[] sArr = s.toLowerCase().toCharArray();
//            char[] tArr = t.toLowerCase().toCharArray();
//            Arrays.sort(sArr);
//            Arrays.sort(tArr);
//            if (Arrays.equals(sArr, tArr)) {
//                return true;
//            }
//        }
//        return false;
//    }


}
