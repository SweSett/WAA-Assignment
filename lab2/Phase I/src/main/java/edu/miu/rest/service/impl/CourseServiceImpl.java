package edu.miu.rest.service.impl;


import edu.miu.rest.entity.Course;
import edu.miu.rest.repo.CourseRepo;
import edu.miu.rest.service.CourseService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class CourseServiceImpl implements CourseService {

    private final CourseRepo courseRepo;

    @Override
    public List<Course> findAll() {
        List<Course>  courses= courseRepo.findAll();
        return courses;
    }

    @Override
    public void create(Course course) {
        courseRepo.create(course);
    }

    @Override
    public void update(Course course, int id) {
        List<Course> courses = courseRepo.findAll();
        for(Course c : courses) {
            if (c.getId() == id) {
                c.setCode(course.getCode());
                c.setName(course.getName());
            }
        }
    }

    @Override
    public void delete(int id) {
        int index = 0;
        List<Course> courses = courseRepo.findAll();
        for(Course c : courses) {
            if (c.getId() == id) {
              courses.remove(index);
            }
            index++;
        }
    }
}
