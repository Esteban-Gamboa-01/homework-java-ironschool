package com.ironhack;

import java.util.ArrayList;
import java.util.List;

public class School {

    List<Teacher> teacherList = new ArrayList<>();
    List<Student> studentList = new ArrayList<>();
    List<Course> courseList = new ArrayList<>();

    public School(List<Teacher> teacherList, List<Student> studentList, List<Course> courseList) {
        this.teacherList = teacherList;
        this.studentList = studentList;
        this.courseList = courseList;
    }

    public boolean isValidStudentId(String value) {
        boolean result = false;
        for(Student s: getStudentList()){
            if(s.getStudentId().equals(value)){
                result = true;
            }
        }
        return result;
    }

    public boolean isValidCourseId(String value) {
        boolean result = false;
        for(Course c: getCourseList()){
            if(c.getCourseId().equals(value)){
                result = true;
            }
        }
        return result;
    }

    public boolean isValidTeacherId(String value) {
        boolean result = false;
        for(Teacher t: getTeacherList()){
            if(t.getTeacherId().equals(value)){
                result = true;
            }
        }
        return result;
    }

    public List<Teacher> getTeacherList() {
        return teacherList;
    }

    public void setTeacherList(List<Teacher> teacherList) {
        this.teacherList = teacherList;
    }

    public List<Student> getStudentList() {
        return studentList;
    }

    public void setStudentList(List<Student> studentList) {
        this.studentList = studentList;
    }

    public List<Course> getCourseList() {
        return courseList;
    }

    public void setCourseList(List<Course> courseList) {
        this.courseList = courseList;
    }
}
