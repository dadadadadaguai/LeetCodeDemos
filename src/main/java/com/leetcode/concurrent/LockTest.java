package com.leetcode.concurrent;

import lombok.Synchronized;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockTest {
  int productPrice = 100;

  public void test1() {
    synchronized (this) {
      productPrice++;
    }
  }

  public void test2() {
    Lock lock = new ReentrantLock();
    try {
      lock.lock();
      productPrice++;
    } finally {
      lock.unlock();
    }
  }

  public void test3() {
    productPrice++;
  }

  public static void main(String[] args) {
    LockTest lockTest = new LockTest();
    LockTest lockTest1 = new LockTest();
    for (int i = 0; i < 10; i++) {
      new Thread(lockTest::test1).start();
      lockTest1.test3();
    }
    System.out.println(lockTest.productPrice);
    System.out.println(lockTest1.productPrice);
  }
}
