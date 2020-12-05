package com.lms.lms.service;

import com.lms.lms.model.Course;
import com.lms.lms.model.User;
import com.lms.lms.model.dto.AddCourseDto;
import com.lms.lms.model.dto.CourseDto;
import com.lms.lms.repository.CourseRepository;
import com.lms.lms.repository.UserRepository;
import com.lms.lms.utils.AddCourseConverter;
import com.lms.lms.utils.CourseConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CourseService {

    private final CourseRepository courseRepository;
    private final AddCourseConverter addCourseConverter;
    private final UserRepository userRepository;
    private final CourseConverter courseConverter;

    @Autowired
    public CourseService(CourseRepository courseRepository,
                         AddCourseConverter addCourseConverter,
                         UserRepository  userRepository,
                         CourseConverter courseConverter) {
        this.courseRepository = courseRepository;
        this.addCourseConverter = addCourseConverter;
        this.userRepository = userRepository;
        this.courseConverter = courseConverter;
    }

    public AddCourseDto addCourseDto(AddCourseDto addCourseDto) {
        Course course = addCourseConverter.entityToType(addCourseDto);

        User professor = userRepository.findById(addCourseDto.getProfessorId()).get();

        course.setProfessor(professor);

        course = courseRepository.save(course);

        return addCourseConverter.typeToEntity(course);
    }

    public List<CourseDto> getAllCourses(){
        List<Course> courses = courseRepository.findAll();

        List<CourseDto> courseDtos = new ArrayList<>();

        courses.forEach(course -> {
            CourseDto courseDto = courseConverter.typeToEntity(course);
            courseDtos.add(courseDto);
        });

        return courseDtos;
    }
}
