package com.leetcode.test;

import java.util.List;
import java.util.stream.Collectors;

public class test1 {
  public static void main(String[] args) {
    List<String> list =
        List.of("A", "B", "C", "D", "E", "F").stream()
            .sorted(String::compareToIgnoreCase)
            .distinct()
            .skip(2)
            .limit(3)
            .collect(Collectors.toList());
    list.forEach(System.out::println);
  }
}
