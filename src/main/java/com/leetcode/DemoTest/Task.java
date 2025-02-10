package com.leetcode.DemoTest;

import java.util.concurrent.Callable;

public class Task implements Callable<Long> {
  private final Long num;

  public Task(Long num) {
    this.num = num;
  }

  public Long call() throws Exception {
    long r = 0;
    for (long n = 1; n <= this.num; n++) {
      r = r + n;
    }
    System.out.println("Result: " + r);
    return r;
  }
}
