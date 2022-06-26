package edu.miu.rest.service.impl;

import edu.miu.rest.entity.Course;
import edu.miu.rest.entity.Student;
import edu.miu.rest.repo.StudentRepo;
import edu.miu.rest.service.StudentService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class StudentServiceImpl implements  StudentService{

    private  final StudentRepo studentRepo;

    @Override
    public List<Student> findAll() {
        return studentRepo.findAll();
    }

    @Override
    public List<Course> getCourseByStudentId(int id) {
        return studentRepo.getCoursesByStudentId(id);
    }

    @Override
    public List<Student> getStudentByMajor(String major) {
        return studentRepo.getStudentByMajor(major);
    }

    @Override
    public void create(Student student) {
        studentRepo.create(student);
    }

    @Override
    public void update(Student student, int id) {
        studentRepo.update(id,student);
    }

    @Override
    public void delete(int id) {
        studentRepo.delete(id);
    }
}
