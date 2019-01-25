package com.company.Models;

public class Rating {

    private int id;
    private String grade;
    private int gradeNum;

    public Rating(int id, String grade, int gradeNum) {
        this.id = id;
        this.grade = grade;
        this.gradeNum = gradeNum;
    }

    public Rating() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public int getGradeNum() {
        return gradeNum;
    }

    public void setGradeNum(int gradeNum) {
        this.gradeNum = gradeNum;
    }
}
