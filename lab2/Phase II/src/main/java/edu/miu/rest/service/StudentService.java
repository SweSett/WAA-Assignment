package edu.miu.rest.service;

import edu.miu.rest.dto.StudentDto;

import java.util.List;

public interface StudentService {

    List<StudentDto> findAll();

    void create(StudentDto dto);

    void delete(int id);

    void update(StudentDto course, int id);
}
