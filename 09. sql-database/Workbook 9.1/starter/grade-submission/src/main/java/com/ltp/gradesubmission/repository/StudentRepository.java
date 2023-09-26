package com.ltp.gradesubmission.repository;

import com.ltp.gradesubmission.entity.Student;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Objects;

@Repository
public class StudentRepository {
    private final List<Student> students;

    public StudentRepository(List<Student> students) {
        this.students = students;
    }

    public Student saveStudent(Student student) {
        students.add(student);
        return student;
    }

    public List<Student> getAllStudents() {
        return students;
    }

    public Student getStudent(Long id) {
        return students.stream().filter(student -> Objects.equals(student.getId(), id)).findFirst().get();
    }

    public void deleteStudent(Long id) {
        Student deleteStudent = students.stream().filter(student -> Objects.equals(student.getId(), id)).findFirst().get();
        students.remove(deleteStudent);
    }
}