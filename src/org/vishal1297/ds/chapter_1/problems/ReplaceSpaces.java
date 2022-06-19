package org.vishal1297.ds.chapter_1.problems;

public class ReplaceSpaces {

    public static void main(String[] args) {
        String str = "Mr John Smith    ";
        char[] arr = str.toCharArray();
        replaceSpaces(arr, 13);
        System.out.println(arr);
    }

    public static void replaceSpaces(char[] str, int trueLength) {
        int spaceCount = 0, index, i;
        for (i = 0; i < trueLength; i++) {
            if (str[i] == ' ') spaceCount++;
        }
        index = trueLength + spaceCount * 2;
        if (trueLength < str.length) str[trueLength] = '\0';
        for (i = trueLength - 1;  i >= 0; i--) {
            if (str[i] == ' ') {
                str[index - 1] = '0';
                str[index - 2] = '2';
                str[index - 3] = '%';
                index -= 3;
            }else {
                str[index - 1] = str[i];
                index--;
            }
        }
    }

    public static int findLastCharacter(char[] str) {
        for (int i = str.length - 1; i >= 0; i--) {
            if (str[i] != ' ') {
                return i;
            }
        }
        return -1;
    }

//    public static String replaceSpaces(String str) {
//        return str.trim().replace(" ", "%20");
//    }
}
