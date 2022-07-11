package org.vishal1297.ds.chapter_1.problems;

public class StringRotation {

    public static void main(String[] args) {
        System.out.println(isRotation("waterbottle", "erbottlewat"));
    }

    public static boolean isRotation(String s1, String s2) {
        if (s1.length() != s2.length()) return false;
        int splitIndex = -1;
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(0) == s2.charAt(i)) {
                splitIndex = i;
            }
        }
        if (splitIndex == -1) return false;
        String splitOne = s2.substring(0, splitIndex);
        return isSubstring(s2 + splitOne, s1);
    }

    public static boolean isSubstring(String s1, String s2) {
        return s1.contains(s2);
    }

}
