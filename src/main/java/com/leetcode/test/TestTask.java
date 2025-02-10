package com.leetcode.test;

import com.leetcode.DemoTest.Adapator;
import com.leetcode.DemoTest.Task;

import java.util.concurrent.Callable;

public class TestTask {
  public static void main(String[] args) {
    Callable<Long> callable = new Task(100L);
    Thread thread = new Thread(new Adapator(callable));
    thread.start();
  }
}
