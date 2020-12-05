package com.lms.lms.utils;

import com.lms.lms.model.Course;
import com.lms.lms.model.dto.CourseDto;
import org.springframework.stereotype.Service;

@Service
public class CourseConverter implements Converter<CourseDto, Course> {
    @Override
    public Course entityToType(CourseDto entity) {
        Course course = new Course();
        course.setName(entity.getName());
        course.setEspb(entity.getEspb());
        course.setDescription(entity.getDescription());
        course.setAccessPassword(entity.getAccessPassword());
        course.setType(entity.getType());
        course.setRating(entity.getRating());

        return course;
    }

    @Override
    public CourseDto typeToEntity(Course type) {
        CourseDto courseDto = new CourseDto();
        courseDto.setName(type.getName());
        courseDto.setEspb(type.getEspb());
        courseDto.setDescription(type.getDescription());
        courseDto.setAccessPassword(type.getAccessPassword());
        courseDto.setType(type.getType());
        courseDto.setRating(type.getRating());
        courseDto.setProfessorsFullName(type.getProfessor().getFirstName()+" "+type.getProfessor().getLastName());

        return courseDto;
    }
}
