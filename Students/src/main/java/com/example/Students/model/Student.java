package com.example.Students.model;

import java.util.ArrayList;
import java.util.List;

public class Student {
    public int id;
    public String name;
    public String age;
    public static List<Student> list;

    static {
        list = new ArrayList<>();
        list.add(new Student(1, "Tu", "19"));
        list.add(new Student(2, "Dat", "26"));
        list.add(new Student(3, "Hai", "23"));
        list.add(new Student(4, "Thang", "23"));
        list.add(new Student(5, "Thinh", "21"));
        list.add(new Student(6, "Anh", "25"));
        list.add(new Student(7, "Phuoc", "19"));
        list.add(new Student(8, "Son", "26"));


    }

    public Student(int id, String name, String age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public static List<Student> getList() {
        return list;
    }

    public static void setList(List<Student> list) {
        Student.list = list;
    }
}
