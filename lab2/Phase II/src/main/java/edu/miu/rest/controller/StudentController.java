package edu.miu.rest.controller;

import edu.miu.rest.dto.StudentDto;
import edu.miu.rest.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {
    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public List<StudentDto> getAllStudents(){
        return  studentService.findAll();
    }

    @PostMapping
    public void createStudents(StudentDto studentDto){
        studentService.create(studentDto);
    }

    @PutMapping("/{id}")
    public void updateStudent(@PathVariable int id,StudentDto studentDto){
        studentService.update(studentDto,id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id){
        studentService.delete(id);
    }
}
