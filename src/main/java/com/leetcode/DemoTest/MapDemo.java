package com.leetcode.DemoTest;

import java.util.Map;
import java.util.TreeMap;

public class MapDemo {
  public static void main(String[] args) {
    //指定TreeMap顺序为由大到小
    TreeMap<Integer, Integer> treeMap = new TreeMap<>((o1, o2) -> o2 - o1);
    treeMap.put(3, 1);
    treeMap.put(2, 2);
    treeMap.put(1, 3);
    System.out.println(treeMap);
  }
}
