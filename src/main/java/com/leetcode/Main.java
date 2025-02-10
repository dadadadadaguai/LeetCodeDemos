package com.leetcode;

import com.google.gson.Gson;
import com.leetcode.domain.Student;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
  public static void main(String[] args) {
    Stream<Student> studentStream =
        Stream.of(
            new Student(2, 3, "小明", 80),
            new Student(3, 1, "小王", 90),
            new Student(1, 2, "小强", 100),
            new Student(3, 1, "小红", 40),
            new Student(1, 2, "小黄", 100),
            new Student(2, 3, "小黑", 80),
            new Student(1, 2, "小军", 10),
            new Student(2, 3, "小乔", 80),
            new Student(3, 1, "小林", 90));
    //根据成绩进行分组。分不及格、及格、良好、优秀
    Map<Integer, Map<String, List<Student>>> map =
        studentStream.collect(
            Collectors.groupingBy(Student::getGradeId, Collectors.groupingBy(Main::grtGradeLevel)));
    //将map转为json格式
    Gson gson = new Gson();
    String json = gson.toJson(map);
    System.out.println(json);
    System.out.println("======================================================================");
    map.forEach((key, value) -> {
      System.out.println("第" + key + "年级");
      value.forEach((key1, value1) -> {
        System.out.println(key1 + ":" + value1);
      });
    });
  }
  public static String grtGradeLevel(Student student){
    int score = student.getScore();
    if (score < 60){
      return "不及格";
    }else if (score < 70){
      return "及格";
    }else if (score < 80){
      return "良好";
    }else {
      return "优秀";
    }
  }
}
