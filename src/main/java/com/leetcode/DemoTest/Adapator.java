package com.leetcode.DemoTest;

import java.util.concurrent.Callable;

public class Adapator implements Runnable {
  private Callable<?> callable;

  public Adapator(Callable<?> callable) {
    this.callable = callable;
  }

  @Override
  public void run() {
    try {
      System.out.println("适配callable,run");
      callable.call();
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }
}
