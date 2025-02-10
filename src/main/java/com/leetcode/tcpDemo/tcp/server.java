package com.leetcode.tcpDemo.tcp;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class server {
  public static void main(String[] args) throws IOException {
    ServerSocket serverSocket = new ServerSocket(6667);
    while (true) {
      Socket socket = serverSocket.accept(); // 当有客户端请求时创建一个socket
      System.out.println("connected.");
      Thread thread = new Handle(socket);
      thread.start();
    }
  }
}
