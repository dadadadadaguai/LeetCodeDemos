package com.leetcode.DemoTest;

public class Singleton {
  private static final Singleton INSTANCE = new Singleton();

  private Singleton() {}

  public static Singleton getInstance() {
    System.out.println("获取实例");
    return INSTANCE;
  }

  public static void main(String[] args) {
    Singleton s = Singleton.getInstance();
  }
}
