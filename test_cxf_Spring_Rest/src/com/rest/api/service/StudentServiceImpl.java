package com.rest.api.service;

import com.rest.api.model.Student;

import java.util.ArrayList;
import java.util.List;

public class StudentServiceImpl implements IStudentService {
    @Override
    public Student query(long id) {
        Student student = new Student(id,"gao","555");
        return student;
    }

    @Override
    public List<Student> queryList(String name) {
        List<Student> students = new ArrayList<Student>();

        for(long i=0;i<3;i++){
            Student student = new Student(i,name + i ,"555");
            students.add(student);
        }

        return students;
    }
}
