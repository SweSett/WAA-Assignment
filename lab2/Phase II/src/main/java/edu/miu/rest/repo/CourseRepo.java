package edu.miu.rest.repo;

import edu.miu.rest.entity.Course;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CourseRepo {

    private static List<Course> courses = new ArrayList<>();

    public CourseRepo(){
        Course c1 = new Course(1,"WAA", "CS545");
        Course c2 = new Course(2,"WAP","CS472");
        courses.add(c1);
        courses.add(c2);
    }

    public List<Course> findAll(){
        return  courses;
    }

    public void create(Course c){
        courses.add(c);
    }

    public  Course getCourseById(int id){
        for(Course c:courses){
            if(c.getId()== id)
                return c;
        }
        return  null;
    }

    public void update(int id, Course c){
        Course course = getCourseById(id);
        course.setName(c.getName());
        course.setCode(c.getCode());
    }

    public void delete(int id) {
        int index = 0;
        for (Course c : courses) {
            if (c.getId() == id) {
                courses.remove(index);
            }
            index++;
        }
     }

}
