package org.vishal1297.ds.chapter_1.problems;

public class OneAway {

    public static void main(String[] args) {
        String str1 = "qxzfgyqmgjsmg";
        String str2 = "xzfgyqmgjsmg";
        System.out.println(S1(str1, str2));
    }

    // S1 - Bruteforce
    public static boolean S1(String str1, String str2) {
        if (str1.equalsIgnoreCase(str2)) return true;
        int l1 = str1.length();
        int l2 = str2.length();
        if (Math.abs(l2 - l1) > 1) {
            return false;
        }
        if (l1 == l2) {
            return oneEditReplace(str1, str2);
        } else if (l1 + 1 == l2) {
            return oneEditInsert(str1, str2);
        } else if (l1 - 1 == l2) {
            return oneEditInsert(str1, str2);
        }
        return false;
    }

    public static boolean oneEditReplace(String str1, String str2) {
        boolean foundDiff = false;
        for (int i = 0; i < str1.length(); i++) {
            if (str1.charAt(i) != str2.charAt(i)) {
                if (foundDiff) {
                    return false;
                }
                foundDiff = true;
            }
        }
        return true;
    }

    public static boolean oneEditInsert(String str1, String str2) {
        int index1 = 0, index2 = 0;
        while (index1 < str1.length() && index2 < str2.length()) {
            if (str1.charAt(index1) != str2.charAt(index2)) {
                if (index1 != index2) {
                    return false;
                }
            } else {
                index1++;
            }
            index2++;
        }
        return true;
    }

}
