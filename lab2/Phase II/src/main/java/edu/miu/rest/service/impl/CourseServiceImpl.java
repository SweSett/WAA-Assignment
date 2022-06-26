package edu.miu.rest.service.impl;

import edu.miu.rest.dto.CourseDto;
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
    public List<CourseDto> findAll() {
        var courses = courseRepo.findAll();
        var result = new ArrayList<CourseDto>();

        for (Course course : courses) {
            CourseDto dto = new CourseDto();
            var courseDto = dto.toDto(course);
            result.add(courseDto);
        }
        return result;
    }

    @Override
    public void create(CourseDto dto) {
       var entity = dto.toEntity();
        courseRepo.create(entity);
    }

    @Override
    public void delete(int id) {
       courseRepo.delete(id);
    }

    @Override
    public void update(CourseDto courseDto, int id) {
        var entity = courseDto.toEntity();
        courseRepo.update(id,entity);
    }


}
