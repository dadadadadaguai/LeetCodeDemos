package com.leetcode.easy;

import java.util.HashMap;
import java.util.Map;

class Solution387 {
    public boolean canConstruct(String ransomNote, String magazine) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i=0;i<26;i++){
            map.put((char) ('a'+i),0);
        }
        for (char c : ransomNote.toCharArray()) {
            map.compute(c, (k, countNumber) -> countNumber + 1);
        }
        for (char c : magazine.toCharArray()){
            map.compute(c, (k, countNumber)-> countNumber - 1);
        }
        for (Integer countNumber : map.values()) {
            if (countNumber >0)
                return false;
        }
        return true;
    }
    public static void main(String[] args){
        Solution387 s = new Solution387();
        System.out.println(s.canConstruct("aa","aab"));
    }
}