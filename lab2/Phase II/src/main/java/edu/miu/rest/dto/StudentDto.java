package edu.miu.rest.dto;

import edu.miu.rest.entity.Course;
import edu.miu.rest.entity.Student;
import lombok.Data;

import java.util.List;
@Data
public class StudentDto {

    private int id;
    private String firstName;
    private String lastName;
    private String email;
    private String major;
    private String coursesTaken;
    private double gpa;

    private List<CourseDto> courseList ;

    public StudentDto toDto(Student student){
        StudentDto studentDto = new StudentDto();
        studentDto.setId(student.getId());
        studentDto.setFirstName(student.getFirstName());
        studentDto.setLastName(student.getLastName());
        studentDto.setEmail(student.getEmail());
        studentDto.setMajor(student.getMajor());
        studentDto.setCoursesTaken(student.getCoursesTaken());
        studentDto.setGpa(student.getGpa());
        return studentDto;

    }

    public Student toEntity(){
        Student student = new Student();
        student.setId(this.id);
        student.setFirstName(this.firstName);
        student.setLastName(this.lastName);
        student.setEmail(this.email);
        student.setMajor(this.major);
        student.setCoursesTaken(this.coursesTaken);
        student.setGpa(this.gpa);
        return student;
    }
}
