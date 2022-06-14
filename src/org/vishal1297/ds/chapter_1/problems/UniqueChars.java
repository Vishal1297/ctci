package org.vishal1297.ds.chapter_1.problems;

import java.util.HashSet;

/**
 * Check if string has unique characters
 */
public class UniqueChars {

    public static void main(String[] args) {
        String input = "abd";
        System.out.println(hasUniqueChars(input));
    }

    public static boolean hasUniqueChars(String str){
        int checker = 0;
        for (int i = 0; i < str.length(); i++) {
            int val = str.charAt(i) - 'a';
            if ((checker & ( 1 << val)) > 0) {
                return false;
            }
            checker |= ( 1 << val);
        }
        return true;
    }


//    public static boolean hasUniqueChars(String str){
//        if (str.length() > 128) return false;
//        boolean[] exists = new boolean[128];
//        for (int i = 0; i < str.length(); i++) {
//            if (exists[str.charAt(i)]) return false;
//            exists[str.charAt(i)] = true;
//        }
//        return true;
//    }

//    public static boolean hasUniqueChars(String str){
//        HashSet<Character> uniqueChars = new HashSet<>();
//        for (int i = 0; i < str.length(); i++) {
//            if (uniqueChars.contains(str.charAt(i))) return false;
//            uniqueChars.add(str.charAt(i));
//        }
//        return true;
//    }
}
