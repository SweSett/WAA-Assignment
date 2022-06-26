package edu.miu.rest.service.impl;

import edu.miu.rest.dto.StudentDto;
import edu.miu.rest.entity.Student;
import edu.miu.rest.repo.StudentRepo;
import edu.miu.rest.service.StudentService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class StudentServiceImpl implements StudentService {
    private final StudentRepo studentRepo;
    @Override
    public List<StudentDto> findAll() {
        var students = studentRepo.findAll();
        var result = new ArrayList<StudentDto>();
        for(Student student : students){
            StudentDto studto = new StudentDto();
            var studentDto = studto.toDto(student);
            result.add(studentDto);
        }
        return result;

    }

    @Override
    public void create(StudentDto dto) {
       var studentEntity = dto.toEntity();
       studentRepo.create(studentEntity);
    }

    @Override
    public void delete(int id) {
        studentRepo.delete(id);
    }

    @Override
    public void update(StudentDto course, int id) {
        var studentEntity = course.toEntity();
        studentRepo.update(id,studentEntity);
    }
}
