package edu.miu.rest.controller;

import edu.miu.rest.entity.Course;
import edu.miu.rest.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/courses")
@CrossOrigin(origins = "*")
public class CourseController {

    private final CourseService courseService;

   @Autowired // optional
   public CourseController(CourseService courseService){
       this.courseService=courseService;
   }

   // http://localhost:8080/courses
    @GetMapping
    public List<Course> findAllProducts() {
        return courseService.findAll();
    }




    @PostMapping
    public void create(@RequestBody Course course){
        courseService.create(course);
    }

    @PutMapping("/{id}")
    public void update(@RequestBody Course course,
                       @PathVariable int id){
        courseService.update(course,id);
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id){
        courseService.delete(id);
    }
}
