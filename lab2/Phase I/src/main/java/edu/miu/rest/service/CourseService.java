package edu.miu.rest.service;

import edu.miu.rest.entity.Course;

import java.util.List;

public interface CourseService {
    List<Course> findAll();
    void create(Course course);

    void update(Course course,int id);

    void  delete(int id);
}
