package com.example.Student_Management_App;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class StudentRepository {
    Map<Integer, Student> studentDb = new HashMap<>();
    Map<Integer, Teacher> teacherDb = new HashMap<>();
    Map<Integer, List<Integer>> teacherStudentDb = new HashMap<>();

    public Student getStudent(int id){
        return studentDb.get(id);
    }

    public Student getStudentByPathVariable(int id){
        return studentDb.get(id);
    }

    public void addStudent(Student student){
        studentDb.put(student.getId(), student);

    }

    public void addTeacher(Teacher teacher) {
        teacherDb.put(teacher.getId(), teacher);
    }

    public Teacher getTeacher(String name) {
        for(Integer teacherId : teacherDb.keySet()){
            if(teacherDb.get(teacherId).getName().equals(name)){
                return teacherDb.get(teacherId);
            }
        }
        return null;
    }

    public List<String> getAllStudents() {
            List<String> allStudents = new ArrayList<>();
            for(Integer student : studentDb.keySet()){
                allStudents.add(studentDb.get(student).getName());
            }
            return allStudents;
    }

    public void deleteTeacher(String name) {
        int teacherId = -1;
        for(Integer id : teacherDb.keySet()){
            if(teacherDb.get(id).getName().equals(name)){
                teacherId = id;
                break;
            }
        }

        if(teacherId != 1){
            teacherDb.remove(teacherId);
            teacherStudentDb.remove(teacherId);
        }
    }

    public void addTeacherStudentPair(Integer sId, Integer tId) {
        if(studentDb.containsKey(sId) && teacherDb.containsKey(tId)){
            if(!teacherStudentDb.containsKey(tId)){
                teacherStudentDb.put(tId, new ArrayList<>());
            }
            teacherStudentDb.get(tId).add(sId);
        }
    }

    public List<String> getStudentByTeacherId(Integer tId) {
        List<Integer> studentIdList = teacherStudentDb.get(tId);
        List<String> studentsList = new ArrayList<>();

        if(studentIdList != null) {
            for (Integer i : studentIdList) {
                studentsList.add(studentDb.get(i).getName());
            }
        }

        return  studentsList;

    }
}
