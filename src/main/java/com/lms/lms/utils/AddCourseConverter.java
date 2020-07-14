package com.lms.lms.utils;

import com.lms.lms.model.Course;
import com.lms.lms.model.dto.AddCourseDto;
import org.springframework.stereotype.Service;

@Service
public class AddCourseConverter implements Converter<AddCourseDto, Course>{

    @Override
    public Course entityToType(AddCourseDto entity) {
        Course course = new Course();
        course.setName(entity.getName());
        course.setEspb(entity.getEspb());
        course.setDescription(entity.getDescription());
        course.setAccessPassword(entity.getAccessPassword());
        course.setType(entity.getType());

        return course;
    }

    @Override
    public AddCourseDto typeToEntity(Course type) {
        AddCourseDto addCourseDto = new AddCourseDto();
        addCourseDto.setName(type.getName());
        addCourseDto.setEspb(type.getEspb());
        addCourseDto.setDescription(type.getDescription());
        addCourseDto.setAccessPassword(type.getAccessPassword());
        addCourseDto.setType(type.getType());

        return addCourseDto;
    }
}
