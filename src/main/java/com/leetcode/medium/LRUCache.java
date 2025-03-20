package com.leetcode.medium;

import java.util.LinkedHashMap;

class LRUCache {
  int capacity;
  LinkedHashMap<Integer, Integer> map;

  public LRUCache(int capacity) {
    this.capacity = capacity;
    this.map = new LinkedHashMap<>(capacity);
  }

  public int get(int key) {
    if (!map.containsKey(key)) {
      return -1;
    }
    Integer value = map.get(key);
    map.remove(key);
    map.put(key, value);
    return map.get((key));
  }

  public void put(int key, int value) {
    if (map.get(key) != null) {
      map.remove(key);
      // 修改value的值
      map.put(key, value);
      return;
    }
    if (map.size() >= capacity) {
      // 删除最后一个元素
      map.remove(map.keySet().iterator().next());
      map.put(key, value);
    } else {
      map.put(key, value);
    }
  }
}
