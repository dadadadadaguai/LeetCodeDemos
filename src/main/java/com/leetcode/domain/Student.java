package com.leetcode.domain;

public class Student {
  private int gradeId;
  private int classId;
  private String name;
  private int score;

  public Student(int gradeId, int classId, String name, int score) {
    this.gradeId = gradeId;
    this.classId = classId;
    this.name = name;
    this.score = score;
  }

  public int getGradeId() {
    return gradeId;
  }

  public int getClassId() {
    return classId;
  }

  public String getName() {
    return name;
  }

  public int getScore() {
    return score;
  }

  @Override
  public String toString() {
    return "Name:" + getName() + " " + "Score: " + getScore();
  }
}
