package edu.miu.rest.controller;

import edu.miu.rest.entity.Student;
import edu.miu.rest.entity.Course;
import edu.miu.rest.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {
    private  final StudentService studentService ;

    @Autowired
    public  StudentController(StudentService studentService){
        this.studentService = studentService;
    }
    @GetMapping
    public List<Student> findAllStudent(){
        return  studentService.findAll();
    }

    @GetMapping("/{id}")
    public List<Course> getCoursesByStudentId(@PathVariable int id){
        return studentService.getCourseByStudentId(id);
    }

    @GetMapping("/{major}")
    public List<Student> getStudentByMajor(@RequestParam(value = "major", required = true) String major){
        return studentService.getStudentByMajor(major);
    }

    @PostMapping
    public void createStudent(@RequestBody Student student){
        studentService.create(student);
    }

    @PutMapping("/{id}")
    public void updateStudent(@RequestBody Student student,@PathVariable int id){
        studentService.update(student,id);
    }

    @DeleteMapping("/{id}")
    public void deleteStudent(@PathVariable int id){
        studentService.delete(id);
    }
}
