package com.tunitechlabs.gestionetudiant.student;

import java.util.List;

public interface StudentService {
    List<Student> getAll();
    Student getById(Long id);
    Student save(Student student);
    void deleteById(Long id);
    void updateStudent(Long id, Student pStudent);
}
