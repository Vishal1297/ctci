package org.vishal1297.ds.chapter_1.problems;

public class StringCompression {

    public static void main(String[] args) {
        System.out.println(compress("aabcccccaaa"));
    }

    public static String compress(String inputString) {
        StringBuilder builder = new StringBuilder();
        int count = 0;
        for (int i = 0; i < inputString.length(); i++) {
            char curr = inputString.charAt(i);
            count++;
            if (i + 1 > inputString.length() - 1 || curr != inputString.charAt(i + 1)) {
                builder.append(curr).append(count);
                count = 0;
            }
        }
        return builder.toString();
    }
}
