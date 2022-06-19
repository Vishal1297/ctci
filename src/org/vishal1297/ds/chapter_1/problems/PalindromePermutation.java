package org.vishal1297.ds.chapter_1.problems;

import java.util.HashMap;

public class PalindromePermutation {

    public static void main(String[] args) {
        String str = "Tact Coa";
        System.out.println(isPalindromePermutation(String.join("", str.split(" ")).toLowerCase()));
    }

    public static boolean isPalindromePermutation(String str){
        HashMap<Character, Integer> map = getCharsFrequencyCount(str);
        return hasMaxOneOddChar(map);
    }

    private static boolean hasMaxOneOddChar(HashMap<Character, Integer> map) {
        int count = 0;
        for (char key : map.keySet()){
            if (map.get(key) % 2 == 1){
                count++;
            }
            if (count == 2){
                return false;
            }
        }
        return true;
    }

    private static HashMap<Character, Integer> getCharsFrequencyCount(String str) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (char ch : str.toCharArray()){
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        return map;
    }
}
