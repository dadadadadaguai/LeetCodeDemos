package com.leetcode.medium;

import java.util.HashSet;

public class problem349 {
    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> set1 = new HashSet<>();
        HashSet<Integer> set2 = new HashSet<>();
        for (int i : nums1) {
            set1.add(i);
        }
        for (int i : nums2) {
                set2.add(i);
            }
        set2.retainAll(set1);
        return set2.stream().mapToInt(Integer::intValue).toArray();
        }
    }
