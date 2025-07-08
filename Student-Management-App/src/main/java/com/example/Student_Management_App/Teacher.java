package com.example.Student_Management_App;

public class Teacher {
    private int id;
    private String name;
    private int age;
    private int numbOfStudents;

    public Teacher() {
    }

    public Teacher(int id, String name, int age, int numbOfStudents) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.numbOfStudents = 0;
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getNumbOfStudents() {
        return numbOfStudents;
    }

    public void setNumbOfStudents(int numbOfStudents) {
        this.numbOfStudents = numbOfStudents;
    }
}
