package com.leetcode.tcpDemo.tcp;

import java.io.*;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

public class Handle extends Thread {
  Socket socket;

  public Handle(Socket socket) {
    this.socket = socket;
  }

  @Override
  public void run() {
    try {
      InputStream inputStream = socket.getInputStream();
      OutputStream outputStream = socket.getOutputStream();
      handle(inputStream, outputStream);
    } catch (Exception e) {
      try {
        socket.close();
      } catch (IOException ex) {
        throw new RuntimeException(ex);
      }
      System.out.println("客户端断开连接");
    }
  }

  public void handle(InputStream inputStream, OutputStream outputStream) throws IOException {
    var bufferedReader =
        new BufferedReader(new InputStreamReader(inputStream, StandardCharsets.UTF_8));
    var bufferedWriter =
        new BufferedWriter(new OutputStreamWriter(outputStream, StandardCharsets.UTF_8));
    bufferedWriter.write("hello\n");
    bufferedWriter.flush();
    while (true) {
      String line = bufferedReader.readLine();
      if (line.equals("bye")) {
        bufferedWriter.write("bye\n");
        bufferedWriter.flush();
        break;
      }
      bufferedWriter.write("ok: " + line + "\n");
      bufferedWriter.flush();
    }
  }
}
