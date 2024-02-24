package com.tunitechlabs.gestionetudiant.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentRepository stdRepo;
    @Override
    public List<Student> getAll() {
        return stdRepo.findAll();
    }

    @Override
    public Student getById(Long id) {
        Optional<Student> optional = stdRepo.findById(id);
        Student student;

        if (optional.isPresent()) {
            student = optional.get();
        } else {
            throw new RuntimeException("Student not found for id : " + id);
        }

        return student;
    }

    @Override
    public Student save(Student student) {
        return stdRepo.save(student);
    }

    @Override
    public void deleteById(Long id) {
        stdRepo.deleteById(id);
    }

    @Override
    @Transactional
    public void updateStudent(Long id, Student pStudent) {
        Student s = stdRepo.findById(id).orElseThrow(() ->
                new IllegalStateException("Student doesn't exist !")
        );

        s.setName(pStudent.getName());
//        s.setBirthDate(pStudent.getBirthDate());
//        s.setEmail(pStudent.getEmail());
        stdRepo.save(s);
    }


}
