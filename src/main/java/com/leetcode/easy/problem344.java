package com.leetcode.easy;

public class problem344 {
    public void reverseString(char[] s) {
        if (s.length==1){
            return;
        }
        int len = s.length/2;
        for (int i = 0; i <= len; i++) {
            char temp = s[i];
            s[i] = s[s.length-i-1];
            s[s.length-i-1] = temp;
        }
    }
    public static void main(String[] args){
        problem344 p = new problem344();
        char[] s = {'A',' ','m','a','n',' ','a',' ','p','l','a','n',' ','a',' ','c','a','n','a','l',' ',':',' ','P','a','n','a','m','a'};
        p.reverseString(s);
        System.out.println(s);
    }
}
