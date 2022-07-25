package ru.hogwarts.school.service;

import org.springframework.stereotype.Service;
import ru.hogwarts.school.model.Faculty;
import ru.hogwarts.school.model.Student;
import ru.hogwarts.school.repository.StudentRepository;

import java.util.Collection;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }


    public Student getStudentById(Long id) {
        return studentRepository.findById(id).get();
    }

    public Student addStudent(Student student) {
        student.setId(0L);
        return studentRepository.save(student);
    }

    public Student editStudent(Student student) {
        return studentRepository.save(student);
    }

    public void deleteStudent(Long id) {
        studentRepository.deleteById(id);
    }

    public Collection<Student> getAllStudentsByAge(Long age) {
        return studentRepository.findByAge(age);
    }

    public Collection<Student> findByAgeBetween(Long min, Long max) {
        return studentRepository.findByAgeBetween(min, max);
    }

    public Collection<Student> findAllStudents() {
        return studentRepository.findAll();
    }

    public Faculty getStudentsFacultyByStudentsId(Long id) {
        return studentRepository.findById(id).get().getFaculty();
    }
}
