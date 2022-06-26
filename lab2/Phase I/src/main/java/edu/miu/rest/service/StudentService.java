package edu.miu.rest.service;

import edu.miu.rest.entity.Student;
import edu.miu.rest.entity.Course;
import java.util.List;

public interface StudentService {
    List<Student> findAll();

    List<Course> getCourseByStudentId(int id);

    List<Student> getStudentByMajor(String major);
    void create(Student student);

    void update(Student student,int id);

    void  delete(int id);
}
