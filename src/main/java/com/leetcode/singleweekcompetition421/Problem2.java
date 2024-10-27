package com.leetcode.singleweekcompetition421;

import java.util.ArrayList;
import java.util.List;

//未通过线性时间复杂度
public class Problem2 {
    public int lengthAfterTransformations(String s, int t) {
        //转为Array集合
        char[] array = s.toCharArray();
        List<Integer> list = new ArrayList<>();

        for (char c : array) {
            list.add(c - 'a'+1);
        }
        for(int j = 0; j < t; j++) {
            List<Integer> numList = new ArrayList<>();
            for (int  i= 0; i < list.size(); i++) {
                int n = list.get(i);
                if (n %26 != 0){
                    n+=1;
                    list.set(i,n);
                }else {
                    list.set(i,1);
                    numList.add(1);
                }
            }
            // numList拼接到list后面
            list.addAll(numList);
        }
        //最后对10的9次方+7取余
        return list.size() % 1000000007;
    }
    public static void main(String[] args) {
        int result = new Problem2().lengthAfterTransformations("abcyy", 2);
        int result1 = new Problem2().lengthAfterTransformations("jqktcurgdvlibczdsvnsg", 1);
        System.out.println(result);
        System.out.println(result1);
    }
}
